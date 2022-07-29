package com.data.service;

import com.data.entity.dec.DxpDecHead;
import com.data.entity.dec.MqDecCustDataLocal;
import com.data.entity.dec.MqDecCustReLocal;

import java.util.List;
import java.util.Map;

/**
 * @Description: 报关单service接口层
 * @Auther hx
 * @Date 2022-04-27 16:39
 */
public interface IDecService {

    /**
     * @Description: 报关单报文解析
     * @Auther hx
     * @Date 2022-04-27 16:41
     */
    void decAnalyzing(Map<String, Object> map, MqDecCustDataLocal mqDecCustDataLocal);

    /**
     * @Description: 报关单回执解析
     * @Auther  hx
     * @Date 2022-05-09 15:30
     */
    void decReAnalyzing(Map<String, Object> map, MqDecCustReLocal mqDecCustReLocal);

    /**
     * @Description 查询可更新的报关单数据
     * @Author huxi
     * @Date 2022/7/21 21:57
     */
    List<DxpDecHead> getDxpDecHead();

    /**
     * @Description 更新报关单字段
     * @Author huxi
     * @Date 2022/7/21 21:57
     */
    void updateEntryId(DxpDecHead dxpDecHead);
}
