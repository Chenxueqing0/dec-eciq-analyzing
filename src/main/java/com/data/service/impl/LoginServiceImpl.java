package com.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.data.entity.BdUser;
import com.data.mapper.BdUserMapper;
import com.data.service.ILoginService;
import com.data.util.HeaUtil;
import com.data.util.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @Author: ps
 * @Description:
 * @Date: Created in 2021/10/11 9:43
 */
@Service("loginService")
@Slf4j
@Transactional(rollbackFor = {Exception.class})
public class LoginServiceImpl implements ILoginService {

    private static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI/hmjd0jWW5EBMD1nz2bsRNtKuaVJcmW3axGL4729cPtmQ23HQtZpSScEKG0zdBUv39MG/oWnVKL47WD5ntlZYrJChdqjvrZ3kDEJLXVVTmF9+pP1OffBL2ppcJ5rBo6dr1MqJOydk7APbMTK8iOH/APwm89yk2ViA3hhusR7LXAgMBAAECgYEAgD9nZubM4k8CtPBGzzwZn4Bj+lGl9NSL0lAo7egNHLU0rj74YdXWCbg9uA7VVfs0LpDwC8/gUYu+uGK1pU7QdaP4WxriaLBUV1mr/nXMkY7r7J7iywpd04DqbUM4A+cLcYWU71dXi5H3b27KH+mCNV/KifM8s/CfcAySjgx5xgECQQDBWw/ug+I+mB6uqSnDKQvjzXyfJWBG9J1Tke4fONH05ZJg0JYU8ES+CP2tC2VxxStMnbHEXZU13FIam1iq/DyxAkEAvn8gEBS8LbMPzZ94E35cYZd3QZEtanDALYCUPgatTgQJHlizVTxc+7p5RSWY1hguglr5CpdNi5MdXRA6a30qBwJAOBj5aFPvIgX0cOw3Z53TC0ak729inXN+6a4fDgPoNkscyuX5hR2odBIbt0blKbrwswvVdYlJLxU65OlJMmJ4IQJATDa4MTbagr4dGHswozvu4eyjfcwDi45IlOvYY2hwdcIPk+CQ/w0DdoMIea2tFBrgoK6c7KvUDn9xRAZ2GQMeiQJAcN73G3/KJpVHLkz4D52mSJvnIF1f44bP5qqVL3VHEj7/nMceuHNsxp0pYtwqBNHhuuMoY0oB+nPWXpCt03WYUw==";

    @Autowired(required = false)
    private BdUserMapper bdUserMapper;

    /**
    * @Author:chenxueqing
    * @Description: 登录接口
    * @Time:2022/7/4 12:33
    */
    @Override
    public BdUser checkLogin(Map<String, String> params) {
        String passwordDecrypt;
        String userName;
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            String usernameDecode = new String(base64Decoder.decodeBuffer(params.get("account")), "UTF-8");
            String passwordDecode = new String(base64Decoder.decodeBuffer(params.get("password")), "UTF-8");
            //私钥解密
            userName  = RSAUtil.decryptByPrivateKey(usernameDecode, PRIVATE_KEY);
            String passWord = RSAUtil.decryptByPrivateKey(passwordDecode, PRIVATE_KEY);
            //sha256加密
            passwordDecrypt = HeaUtil.sha256(passWord);
        }catch (Exception e){
            log.error("登录Rsa解密失败{}",e.getMessage());
            return null;
        }
        QueryWrapper<BdUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", userName)
                .eq("password",passwordDecrypt);
        //去数据库查 通过用户名密码 是否有数据
        BdUser bdUser = bdUserMapper.selectOne(wrapper);

        return bdUser;
    }

    /**
     * @Author:chenxueqing
     * @Description: 登录接口
     * @Time:2022/7/4 12:33
     */
    @Override
    public BdUser checkLoginTest(Map<String, String> params) {
        String password = params.get("password");
        String userName = params.get("account");
        //sha256加密
        try {
            password = HeaUtil.sha256(password);
        } catch (NoSuchAlgorithmException e) {
            log.error("客户端登录：密码sha256加密失败{}",e.getMessage());
            return null;
        }
        QueryWrapper<BdUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", userName)
                .eq("password",password);
        //去数据库查 通过用户名密码 是否有数据
        BdUser bdUser = bdUserMapper.selectOne(wrapper);

        return bdUser;
    }
}
