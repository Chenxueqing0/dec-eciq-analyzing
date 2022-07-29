package com.data.service;

import com.data.entity.BdUser;

import java.util.Map;

/**
 * @Author: ps
 * @Description:
 * @Date: Created in 2021/10/11 9:43
 */
public interface ILoginService {

    /**
    * @Author:chenxueqing
    * @Description: 登录接口
    * @Time:2022/7/4 12:32
    */
    BdUser checkLogin(Map<String, String> params);

    /**
     * @Author:chenxueqing
     * @Description: 登录接口测试
     * @Time:2022/7/4 12:32
     */
    BdUser checkLoginTest(Map<String, String> params);
}
