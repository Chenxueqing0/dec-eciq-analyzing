package com.data.service;

import com.data.entity.dec.*;

import java.util.Map;

/**
 * @Description: 报关单记录service接口层
 * @Auther hx
 * @Date 2022-04-27 16:39
 */
public interface IDecRecordService {

    /**
     * @Description: 报关单解析记录
     * @Auther hx
     * @Date 2022-04-27 16:41
     */
    void saveRecord(DxpDecHead dxpDecHead, MqDecCustDataLocal mqDecCustDataLocal, DxpDecMsg dxpDecMsg);

    /**
     * @Description: 报关单回执更新海关编号
     * @Auther hx
     * @Date 2022-04-27 16:41
     */
    void updateRecord(DxpDecHead dxpDecHead);

    /**
     * @Description: 报关单回执记录
     * @Auther hx
     * @Date 2022-04-27 16:41
     */
    void saveReRecord(DxpDecResult dxpDecResult, MqDecCustReLocal mqDecCustReLocal, DxpDecMsg dxpDecMsg);

}
