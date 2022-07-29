package com.data.service;

import com.data.entity.eciq.MqDecEciqDataLocal;
import com.data.entity.eciq.MqDecEciqReLocal;

import java.util.Map;

/**
 * @Author: ps
 * @Description: 报检
 * @Date: Created in 2021/12/9 9:46
 * @params:
 * @return:
 */
public interface IEciqService {

    /**
     * @Author: ps
     * @Description: 开始解析检验检疫
     * @Date: Created in 2021/12/9 10:06
     * @params: [fileList, latch]
     * @return: void
     */
    void eciqAnalyzing(Map<String,Object> map, MqDecEciqDataLocal eciq);

    /**
     * @Author: ps
     * @Description: 开始解析检验检疫回执
     * @Date: Created in 2021/12/9 10:06
     * @params: [fileList, latch]
     * @return: void
     */
    void resultAnalyzing(Map<String,Object> map, MqDecEciqReLocal result);


}
