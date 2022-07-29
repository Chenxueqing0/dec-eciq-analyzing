package com.data.controller;

import com.data.entity.BdUser;
import com.data.service.ILoginService;
import com.data.util.RSAUtil;
import com.data.util.ResultObject;
import com.data.util.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: ps
 * @Description:
 * @Date: Created in 2021/10/11 9:33
 */
@RestController
@Slf4j
@RequestMapping(value = "/loginController")
public class LoginController {

    private static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI/hmjd0jWW5EBMD1nz2bsRNtKuaVJcmW3axGL4729cPtmQ23HQtZpSScEKG0zdBUv39MG/oWnVKL47WD5ntlZYrJChdqjvrZ3kDEJLXVVTmF9+pP1OffBL2ppcJ5rBo6dr1MqJOydk7APbMTK8iOH/APwm89yk2ViA3hhusR7LXAgMBAAECgYEAgD9nZubM4k8CtPBGzzwZn4Bj+lGl9NSL0lAo7egNHLU0rj74YdXWCbg9uA7VVfs0LpDwC8/gUYu+uGK1pU7QdaP4WxriaLBUV1mr/nXMkY7r7J7iywpd04DqbUM4A+cLcYWU71dXi5H3b27KH+mCNV/KifM8s/CfcAySjgx5xgECQQDBWw/ug+I+mB6uqSnDKQvjzXyfJWBG9J1Tke4fONH05ZJg0JYU8ES+CP2tC2VxxStMnbHEXZU13FIam1iq/DyxAkEAvn8gEBS8LbMPzZ94E35cYZd3QZEtanDALYCUPgatTgQJHlizVTxc+7p5RSWY1hguglr5CpdNi5MdXRA6a30qBwJAOBj5aFPvIgX0cOw3Z53TC0ak729inXN+6a4fDgPoNkscyuX5hR2odBIbt0blKbrwswvVdYlJLxU65OlJMmJ4IQJATDa4MTbagr4dGHswozvu4eyjfcwDi45IlOvYY2hwdcIPk+CQ/w0DdoMIea2tFBrgoK6c7KvUDn9xRAZ2GQMeiQJAcN73G3/KJpVHLkz4D52mSJvnIF1f44bP5qqVL3VHEj7/nMceuHNsxp0pYtwqBNHhuuMoY0oB+nPWXpCt03WYUw==";

    @Autowired
    private ILoginService loginService;

    /**
    * @Author:chenxueqing
    * @Description: 登录接口
    * @Time:2022/7/4 11:28
    */
    @PostMapping("/login")
    public ResultObject login(@RequestBody Map<String,String> params,HttpSession session) {
        ResultObject result = ResultObject.createInstance();

        if(StringUtils.isEmpty(params.get("account")) || StringUtils.isEmpty(params.get("password")) || StringUtils.isEmpty(params.get("verification"))){
            result.setSuccess(false);
            result.setMessage("参数不能为空！");
            return result;
        }

        //从session获取验证码 和传过来验证码进行比对
        String verifyCode = String.valueOf(session.getAttribute("verifyCode"));
        //rsa加密传过来 对验证码进行解密
        String verification = null;
        String verificationDecrypt = null;
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            verification = new String(base64Decoder.decodeBuffer(params.get("verification")),"UTF-8");
        } catch (IOException e) {
            log.error("Base解码失败{}",e.getMessage());
            result.setSuccess(false);
            result.setMessage("登录失败！");
            return result;
        }
        try {
            verificationDecrypt = RSAUtil.decryptByPrivateKey(verification,PRIVATE_KEY);
        }catch (Exception e){
            log.error("Rsa解密验证码失败{}",e.getMessage());
            result.setSuccess(false);
            result.setMessage("登录失败！");
            return result;
        }

        if (!verifyCode.equalsIgnoreCase(verificationDecrypt)){
            result.setSuccess(false);
            result.setMessage("验证码错误！");
            return result;
        }

        BdUser bdUser = this.loginCom(params,session,"1");
        if(null == bdUser){
            result.setSuccess(false);
            result.setMessage("账号密码错误！");
            return result;
        }
        result.setMessage(bdUser.getToken());
        result.setSuccess(true);
        return result;
    }

    /**
     * @Author:chenxueqing
     * @Description: 登录接口
     * @Time:2022/7/4 11:28
     */
    @PostMapping("/test")
    public String test(@RequestBody Map<String,String> params,HttpSession session) {
        String s2 = null;
        String ss = "S/k1IdJtnUTGCaHvGOptf2/HsyuNYA2tO0lXNRmYEf65/tTkp5NWVBGkPczbbXBF1/AxTJI0kkPIa06tcWjY0mRaXU+0rFd9P6PMEVlNCwJDGCTuXMhruP/g7+AswyJPW1oI7dZBs7rmkkq4nxpkF2pWpu4gUo0mk9FMDqmD63w=";
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            String s1 = new String(base64Decoder.decodeBuffer(ss),"UTF-8");

            s2 = RSAUtil.decryptByPrivateKey(s1,PRIVATE_KEY);
            System.out.println(s2);
        } catch (Exception e) {
            log.error(e.getMessage());
            return e.toString();
        }
        return s2;
    }

    /**
    　* @Description: 客户端登录接口
    　* @Author: ps
    　* @Date: 2022/7/5 0005 17:09
    　*/
    @PostMapping("/clientLogin")
    public Map<String,Object> clientLogin(@RequestBody Map<String,String> params,HttpSession session) {
        Map<String,Object> resultMap = new HashMap<>();
        if(StringUtils.isEmpty(params.get("account")) || StringUtils.isEmpty(params.get("password"))){
            resultMap.put("success","false");
            resultMap.put("message","账号密码不能为空！");
            return resultMap;
        }

        BdUser bdUser = this.loginCom(params,session,"2");
        if(null == bdUser){
            resultMap.put("success","false");
            resultMap.put("message","账号密码错误！");
            return resultMap;
        }

        resultMap.put("success","true");
        resultMap.put("message","登录成功！");
        resultMap.put("token",bdUser.getToken());
        resultMap.put("userId",bdUser.getId());
        // 这边的发送等于客户端的接收
        List<Object> dataList = new ArrayList<>();
        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("tcSdDec",bdUser.getTcRxDec());
        dataMap.put("tcSdDecRec",bdUser.getTcRxDecRec());
        dataMap.put("tcRxDec",bdUser.getTcSdDec());
        dataMap.put("tcRxDecRec",bdUser.getTcSdDecRec());
        dataMap.put("tcRxCiq",bdUser.getTcSdCiq());
        dataMap.put("tcRxCiqRec",bdUser.getTcSdCiqRec());
        dataMap.put("tcRxCheck",bdUser.getTcSdCheck());
        dataMap.put("tcRxCheckRec",bdUser.getTcSdCheckRec());
        dataMap.put("broker",bdUser.getBroker());
        dataList.add(dataMap);
        resultMap.put("data",dataList);

        return resultMap;
    }

    /**
    　* @Description: 公共登录方法
    　* @Author: ps
    　* @Date: 2022/7/5 0005 17:40
    　*/
    private BdUser loginCom(Map<String,String> params,HttpSession session,String flag){
        BdUser bdUser = null;
        if("1".equals(flag)){
            bdUser = loginService.checkLogin(params);
        }else{
            bdUser = loginService.checkLoginTest(params);
        }

        if(null == bdUser){
            return null;
        }

        StringBuffer tokenbuffer = new StringBuffer();
        tokenbuffer.append(bdUser.getAccount()).append("/").append(bdUser.getPLevel());
        String token = Base64.getEncoder().encodeToString(tokenbuffer.toString().getBytes(StandardCharsets.UTF_8));
        session.setAttribute("token", token);
        session.setAttribute("account",bdUser.getAccount());
        session.setAttribute("copName",bdUser.getCopName());
        session.setAttribute("copCodeScc",bdUser.getCopCodeScc());
        session.setAttribute("pLevel",bdUser.getPLevel());
        session.setAttribute("createUser",bdUser.getCreateUser());
        bdUser.setToken(token);
        return bdUser;
    }

    /**
    　* @Description: 验证码生成
    　* @Author: ps
    　* @Date: 2022/7/4 0004 11:04
    　*/
    @RequestMapping(value = "/getImageUrl")
    public void getImageUrl(HttpSession session, HttpServletRequest request,
                            HttpServletResponse response) {

        int w = 200, h = 80;
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute("verifyCode", verifyCode);
        ServletOutputStream responseOutputStream;
        try {
            response.setContentType("image/png");
            responseOutputStream = response.getOutputStream();
            VerifyCodeUtils.outputImage(w, h, responseOutputStream, verifyCode);
            responseOutputStream.flush();
            responseOutputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * @Description: 账号登出
     * @Author: xuyang
     * @Date: 2022/7/20  10:58
     */
    @PostMapping(value = "/logout")
    public ResultObject logout(HttpSession session) {
        ResultObject result = ResultObject.createInstance();
        //清除session
        session.invalidate();
        return result;
    }

}
