package com.data.task;

import com.data.entity.dec.DxpDecHead;
import com.data.entity.dec.MqDecCustDataLocal;
import com.data.entity.dec.MqDecCustReLocal;
import com.data.mapper.dec.MqDecCustDataLocalMapper;
import com.data.mapper.dec.MqDecCustReLocalMapper;
import com.data.service.IDecService;
import com.data.util.PublicUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * 　* @Description: 报关报文解析定时任务入口
 * 　* @Author: ps
 * 　* @Date: 2022/4/25 0025 16:01
 */
@Component
@Slf4j
public class DecTask {

    @Autowired
    private IDecService decService;

    @Resource
    private MqDecCustDataLocalMapper mqDecCustDataLocalMapper;

    @Resource
    private MqDecCustReLocalMapper mqDecCustReLocalMapper;

    /**
     * 　* @Description: 报关报文
     * 　* @Author: ps
     * 　* @Date: 2022/4/25 0025 16:02
     */
//    @Scheduled(fixedDelay = 60000)
    public void analyzing() {
        // 查询待解析的报关报文
        List<MqDecCustDataLocal> list = mqDecCustDataLocalMapper.getXmlPath();

        // 拆分集
        List<List<MqDecCustDataLocal>> splitList = PublicUtils.splitList(list, 3600);

        try {
            CountDownLatch latch = new CountDownLatch(splitList.size());
            for (List<MqDecCustDataLocal> fileList : splitList) {
                // 开始解析报文
                this.decAnalyzing(fileList, latch);
            }
            latch.await();
        } catch (Exception e) {
            log.error("报关报文解析出错{}", e);
        }

    }

    /**
     * @Description: 报关单报文解析
     * @Auther hx
     * @Date 2022-04-27 16:55
     */
//    @Async("taskExecutor")
    public void decAnalyzing(List<MqDecCustDataLocal> fileList, CountDownLatch latch) {
        // 报关单报文开始解析
        for (MqDecCustDataLocal mqDecCustDataLocal : fileList) {
            // 读取报文
            Map<String, Object> map = PublicUtils.dxpMsg(mqDecCustDataLocal.getFileLocalPath());
            decService.decAnalyzing(map,mqDecCustDataLocal);
            mqDecCustDataLocalMapper.updateById(mqDecCustDataLocal);
        }
        latch.countDown();
    }

    /**
     * 　* @Description: 报关回执报文
     * 　* @Author: ps
     * 　* @Date: 2022/4/25 0025 16:02
     */
//    @Scheduled(fixedDelay = 60000)
    public void receiptAnalyzing() {

        // 查询报关回执报文
        List<MqDecCustReLocal> list = mqDecCustReLocalMapper.getXmlPath();

        // 拆分集
        List<List<MqDecCustReLocal>> splitList = PublicUtils.splitList(list, 3600);

        try {
            CountDownLatch latch = new CountDownLatch(splitList.size());
            for (List<MqDecCustReLocal> fileList : splitList) {
                // 开始解析报文
                this.decReAnalyzing(fileList, latch);
            }
            latch.await();
        } catch (Exception e) {
            log.error("报关回执报文解析出错{}", e);
        }

    }

    /**
     * @Description: 报关单回执报文解析
     * @Auther hx
     * @Date 2022-04-27 16:55
     */
//    @Async("taskExecutor")
    public void decReAnalyzing(List<MqDecCustReLocal> fileList, CountDownLatch latch) {
        // 报关单报文开始解析
        for (MqDecCustReLocal mqDecCustReLocal : fileList) {
            // 读取报文
            Map<String, Object> map = PublicUtils.dxpMsg(mqDecCustReLocal.getFileLocalPath());
            decService.decReAnalyzing(map,mqDecCustReLocal);
            mqDecCustReLocalMapper.updateById(mqDecCustReLocal);
        }
        latch.countDown();
    }


    /**
     * @Description 更新报关单字段
     * @Author huxi
     * @Date 2022/7/21 21:54
     */
//    @Scheduled(fixedDelay = 60000)
    public void updateEntryId() {

        // 查询报关单中报关单号为空，且回执中不为空的数据
        List<DxpDecHead> list = decService.getDxpDecHead();

        // 拆分集
        List<List<DxpDecHead>> splitList = PublicUtils.splitList(list, 2400);

        try {
            CountDownLatch latch = new CountDownLatch(splitList.size());
            for (List<DxpDecHead> dxpDecHeadList : splitList) {
                // 开始解析报文
                this.updateEntryId(dxpDecHeadList, latch);
            }
            latch.await();
        } catch (Exception e) {
            log.error("报关回执报文解析出错{}", e);
        }

    }

    /**
     * @Description 更新报关单字段
     * @Author huxi
     * @Date 2022/7/21 21:54
     */
//    @Async("taskExecutor")
    public void updateEntryId(List<DxpDecHead> dxpDecHeadList, CountDownLatch latch) {
        // 报关单报文开始解析
        for (DxpDecHead dxpDecHead : dxpDecHeadList) {

            decService.updateEntryId(dxpDecHead);
        }
        latch.countDown();
    }
}
