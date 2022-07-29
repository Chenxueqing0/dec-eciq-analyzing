package com.data.service;

import com.data.entity.*;


/**
 * @Author: ps
 * @Description: 水运装载舱单
 * @Date: Created in 2021/12/9 9:46
 * @params:
 * @return:
 */
public interface IPublicService {

    /**
    　* @Description: 获取国别（地区）代码
    　* @Author: ps
    　* @Date: 2022/5/5 0005 11:11
    　*/
    BaseCountryArea getCountry(String code,String type);

    /**
     * @Description: 获取货币代码
     * @Auther  hx
     * @Date 2022-05-07 15:41
     */
    BaseCurrency getCurr(String code,String type);

    /**
     * @Description: 获取集装箱规格信息
     * @Auther  hx
     * @Date 2022-05-07 15:41
     */
    BaseContainerType getContainerType(String code, String type);

    /**
     * @Description: 获取包装种类代码
     * @Auther  hx
     * @Date 2022-05-07 15:41
     */
    BasePackType getBasePackType(String code, String type);

    /**
     * @Description: 获取港口代码
     * @Auther  hx
     * @Date 2022-05-07 15:41
     */
    BasePort getBasePort(String code, String type);

    /**
     * @Description: 获取贸易方式代码
     * @Auther  hx
     * @Date 2022-05-07 15:41
     */
    BaseTradeMode getBaseTradeMode(String code, String type);

}
