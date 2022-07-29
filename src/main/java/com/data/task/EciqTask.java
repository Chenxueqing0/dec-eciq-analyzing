package com.data.task;

import com.data.entity.eciq.MqDecEciqDataLocal;
import com.data.entity.eciq.MqDecEciqReLocal;
import com.data.mapper.eciq.MqDecEciqDataLocalMapper;
import com.data.mapper.eciq.MqDecEciqReLocalMapper;
import com.data.service.IEciqService;
import com.data.util.PublicUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
　* @Description: 报检报文解析定时任务入口
　* @Author: ps
　* @Date: 2022/4/25 0025 16:01
　*/
@Component
@Slf4j
public class EciqTask {

    @Autowired
    private IEciqService eciqService;

    @Resource
    MqDecEciqDataLocalMapper mqDecEciqDataLocalMapper;

    @Resource
    MqDecEciqReLocalMapper mqDecEciqReLocalMapper;

    /**
    　* @Description: 报检报文定时入口
    　* @Author: ps
    　* @Date: 2022/4/25 0025 16:02
    　*/
//    @Scheduled(fixedDelay = 60000)
    public void analyzing() {

        // 查询待解析的报检报文
        List<MqDecEciqDataLocal> list = mqDecEciqDataLocalMapper.getXmlPath();

        // 拆分集
        List<List<MqDecEciqDataLocal>> splitList = PublicUtils.splitList(list,3600);

        try{
            CountDownLatch latch = new CountDownLatch(splitList.size());
            for (List<MqDecEciqDataLocal> fileList : splitList) {
                // 开始解析报文
                this.eciqAnalyzing(fileList,latch);
            }
            latch.await();
        }catch (Exception e){
            log.error("检验检疫报文解析出错{}",e);
        }

    }

    /**
    　* @Description: 报检报文解析
    　* @Author: ps
    　* @Date: 2022/4/27 0027 10:12
    　*/
//    @Async("taskExecutor")
    public void eciqAnalyzing(List<MqDecEciqDataLocal> fileList, CountDownLatch latch) {
        // 报检报文开始解析
        for (MqDecEciqDataLocal eciq : fileList) {
            // 读取报文
            Map<String,Object> map = PublicUtils.dxpMsg(eciq.getFileLocalPath());
            eciqService.eciqAnalyzing(map,eciq);
            mqDecEciqDataLocalMapper.updateById(eciq);
        }
        latch.countDown();
    }

    /**
     　* @Description: 报检回执报文
     　* @Author: ps
     　* @Date: 2022/4/25 0025 16:02
     　*/
//    @Scheduled(fixedDelay = 60000)
    public void receiptAnalyzing() {
        // 查询待解析的报检回执报文
        List<MqDecEciqReLocal> list = mqDecEciqReLocalMapper.getXmlPath();

        // 拆分集
        List<List<MqDecEciqReLocal>> splitList = PublicUtils.splitList(list,3600);

        try{
            CountDownLatch latch = new CountDownLatch(splitList.size());
            for (List<MqDecEciqReLocal> fileList : splitList) {
                // 开始解析报文
                this.resultAnalyzing(fileList,latch);
            }
            latch.await();
        }catch (Exception e){
            log.error("检验检疫报文解析出错{}",e);
        }
    }

    /**
     　* @Description: 报检回执报文解析
     　* @Author: ps
     　* @Date: 2022/4/27 0027 10:12
     　*/
//    @Async("taskExecutor")
    public void resultAnalyzing(List<MqDecEciqReLocal> fileList, CountDownLatch latch) {
        // 报检报文开始解析
        for (MqDecEciqReLocal result : fileList) {
            // 读取报文
            Map<String,Object> map = PublicUtils.dxpMsg(result.getFileLocalPath());
            eciqService.resultAnalyzing(map,result);
            mqDecEciqReLocalMapper.updateById(result);
        }
        latch.countDown();
    }

    /**
     　* @Description: 报检回执报文
     　* @Author: ps
     　* @Date: 2022/4/25 0025 16:02
     　*/
//    @Scheduled(fixedDelay = 60000)
    public void test() {
        File f = new File("F:\\ps\\eciq\\2022-04-25");
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            String name = fs.getAbsolutePath();
            MqDecEciqDataLocal local = new MqDecEciqDataLocal();
            local.setId(Long.valueOf(i+1));
            local.setField1("0");
            local.setFileLocalPath(name);
            mqDecEciqDataLocalMapper.insert(local);
        }
    }

}
