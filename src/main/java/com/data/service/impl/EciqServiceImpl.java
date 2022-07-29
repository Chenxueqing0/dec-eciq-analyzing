package com.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.data.entity.*;
import com.data.entity.eciq.*;
import com.data.mapper.eciq.*;
import com.data.service.IEciqService;
import com.data.service.IPublicService;
import com.data.util.DateFormatUtils;
import com.data.util.PublicUtils;
import com.data.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
　* @Description: 报检报文解析
　* @Author: ps
　* @Date: 2022/4/26 0026 9:42
　*/
@Service("eciqService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class EciqServiceImpl implements IEciqService {

    @Value("${bakPath}")
    private String bakPath;

    @Autowired
    private IPublicService publicService;

    @Resource
    private DxpEciqMsgMapper dxpEciqMsgMapper;

    @Resource
    private DxpEciqDeclMapper dxpEciqDeclMapper;

    @Resource
    private DxpEciqDeclAttMapper dxpEciqDeclAttMapper;

    @Resource
    private DxpEciqDeclGoodsMapper dxpEciqDeclGoodsMapper;

    @Resource
    private DxpEciqDeclGoodsPackMapper dxpEciqDeclGoodsPackMapper;

    @Resource
    private DxpEciqDeclGoodsContMapper dxpEciqDeclGoodsContMapper;

    @Resource
    private DxpEciqDeclGoodsLimitMapper dxpEciqDeclGoodsLimitMapper;

    @Resource
    private DxpEciqDeclGoodsLimitVnMapper dxpEciqDeclGoodsLimitVnMapper;

    @Resource
    private DxpEciqDeclLimitMapper dxpEciqDeclLimitMapper;

    @Resource
    private DxpEciqDeclUserMapper dxpEciqDeclUserMapper;

    @Resource
    private DxpEciqDeclMarkLobMapper dxpEciqDeclMarkLobMapper;

    @Resource
    private DxpEciqDeclContMapper dxpEciqDeclContMapper;

    @Resource
    private DxpEciqDeclContDetailMapper dxpEciqDeclContDetailMapper;

    @Resource
    DxpEciqDeclResultMapper dxpEciqDeclResultMapper;

    @Resource
    CiqRecordMapper ciqRecordMapper;

    @Resource
    CiqRecRecordMapper ciqRecRecordMapper;

    @Override
    public void eciqAnalyzing(Map<String,Object> map,MqDecEciqDataLocal eciq) {
        DxpEciqMsg dxpEciqMsg = JSON.parseObject(JSON.toJSONString(map), DxpEciqMsg.class);
        dxpEciqMsg.setId(UUID.randomUUID().toString().replaceAll("-",""));
        dxpEciqMsgMapper.insert(dxpEciqMsg);

        // 具体业务报文解析
        String xmlString = (String) map.get("data");
        // 报文路径
        String path = (String) map.get("path");

        // 将xml转换为对象
        DxpEciqMain dxpEciqMain = null;
        try {
            dxpEciqMain = PublicUtils.xml2JavaBean(xmlString, DxpEciqMain.class,"UTF-8");
        } catch (Exception e) {
            log.error("检验检疫报文{}转换为实体类报错：{}",path,e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            // 复制报文到备份目录
            PublicUtils.moveFile(eciq.getFileLocalPath(),bakPath,"ERROR","ECIQ");
            eciq.setField1("2");
            return;
        }

        try{
            // 出入境报检基本信息
            this.declInsert(dxpEciqMain.getDxpEciqDecl(),dxpEciqMsg.getCopMsgId());

            // 出入境随附单据信息
            for(DxpEciqDeclAtt dxpEciqDeclAtt : dxpEciqMain.getDxpEciqDeclAttList()){
                dxpEciqDeclAtt.setId(UUID.randomUUID().toString().replaceAll("-",""));
                dxpEciqDeclAtt.setCopMsgId(dxpEciqMsg.getCopMsgId());
                dxpEciqDeclAttMapper.insert(dxpEciqDeclAtt);
            }
            // 出入境货物产品信息
            this.declGoodsInsert(dxpEciqMain.getDxpEciqDeclGoodsList(),dxpEciqMsg.getCopMsgId());

            // 企业资质信息
            for(DxpEciqDeclLimit declLimit : dxpEciqMain.getDxpEciqDeclLimitList()){
                declLimit.setId(UUID.randomUUID().toString().replaceAll("-",""));
                declLimit.setCopMsgId(dxpEciqMsg.getCopMsgId());
                dxpEciqDeclLimitMapper.insert(declLimit);
            }

            // 出入境使用人信息
            for(DxpEciqDeclUser dxpEciqDeclUser : dxpEciqMain.getDxpEciqDeclUserList()){
                dxpEciqDeclUser.setId(UUID.randomUUID().toString().replaceAll("-",""));
                dxpEciqDeclUser.setCopMsgId(dxpEciqMsg.getCopMsgId());
                dxpEciqDeclUserMapper.insert(dxpEciqDeclUser);
            }

            // 出入境报检标记号码附件
            for(DxpEciqDeclMarkLob declMarkLob : dxpEciqMain.getDxpEciqDeclMarkLobList()){
                declMarkLob.setId(UUID.randomUUID().toString().replaceAll("-",""));
                declMarkLob.setCopMsgId(dxpEciqMsg.getCopMsgId());
                dxpEciqDeclMarkLobMapper.insert(declMarkLob);
            }

            // 出入境集装箱信息
            for(DxpEciqDeclCont declCont : dxpEciqMain.getDxpEciqDeclContList()){
                declCont.setId(UUID.randomUUID().toString().replaceAll("-",""));
                declCont.setCopMsgId(dxpEciqMsg.getCopMsgId());
                // 集装箱规格代码 cntnrModeCode
                BaseContainerType baseConType = publicService.getContainerType(declCont.getCntnrModeCode(),"1");
                declCont.setCntnrModeCodeOld(baseConType == null ? declCont.getCntnrModeCode() : baseConType.getEciqCodeOld());
                declCont.setCntnrModeCodeNew(baseConType == null ? null : baseConType.getCode());
                dxpEciqDeclContMapper.insert(declCont);

                // 出入境集装箱号明细
                for(DxpEciqDeclContDetail declContDetail : declCont.getDxpEciqDeclContDetailList()){
                    declContDetail.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    declContDetail.setCopMsgId(dxpEciqMsg.getCopMsgId());
                    baseConType = publicService.getContainerType(declContDetail.getCntnrModeCode(),"1");
                    declContDetail.setCntnrModeCodeOld(baseConType == null ? declContDetail.getCntnrModeCode() : baseConType.getEciqCodeOld());
                    declContDetail.setCntnrModeCodeNew(baseConType == null ? null : baseConType.getCode());
                    dxpEciqDeclContDetailMapper.insert(declContDetail);
                }
            }

            // 保存一份到记录表中以便数据推送使用
            CiqRecord ciqRecord = new CiqRecord();
            ciqRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
            ciqRecord.setEntDeclNo(dxpEciqMain.getDxpEciqDecl().getEntDeclNo());
            ciqRecord.setXmlPath(eciq.getFileLocalPath());
            ciqRecord.setOrgCode(dxpEciqMain.getDxpEciqDecl().getOrgCode());
            ciqRecord.setInspOrgCode(dxpEciqMain.getDxpEciqDecl().getInspOrgCode());
            ciqRecord.setDeclRegNo(dxpEciqMain.getDxpEciqDecl().getDeclRegNo());
            if("E".equals(dxpEciqMain.getDxpEciqDecl().getAplKind())){
                ciqRecord.setConsignCode(dxpEciqMain.getDxpEciqDecl().getConsignorCode());
            }else{
                ciqRecord.setConsignCode(dxpEciqMain.getDxpEciqDecl().getConsigneeCode());
            }
            ciqRecord.setXmlCreatTime(dxpEciqMsg.getXmlCreatTime());
            ciqRecordMapper.insert(ciqRecord);

            PublicUtils.moveFile(eciq.getFileLocalPath(),bakPath,"SUCCESS","ECIQ");
            eciq.setField1("1");
        }catch (Exception e){
            e.printStackTrace();
            log.error("检验检疫报文{}数据入库报错：{}",path,e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            PublicUtils.moveFile(eciq.getFileLocalPath(),bakPath,"ERROR","ECIQ");
            eciq.setField1("2");
        }
    }

    /**
     　* @Description: 出入境报检基本信息
     　* @Author: ps
     　* @Date: 2022/5/11 0011 16:07
     　*/
    private void declGoodsInsert(List<DxpEciqDeclGoods> dxpEciqDeclGoodsList,String copMsgId) throws Exception{
        for(DxpEciqDeclGoods declGoods : dxpEciqDeclGoodsList){
            declGoods.setId(UUID.randomUUID().toString().replaceAll("-",""));
            declGoods.setCopMsgId(copMsgId);
            // 币种代码
            BaseCurrency baseCurr = publicService.getCurr(declGoods.getCurrency(),"1");
            declGoods.setCurrencyOld(baseCurr == null ? declGoods.getCurrency() : baseCurr.getEciqCodeOld());
            declGoods.setCurrencyNew(baseCurr == null ? null : baseCurr.getCode());
            // 原产国/地区  oriCtryCode
            BaseCountryArea tradeCountry = publicService.getCountry(declGoods.getOriCtryCode(),"1");
            declGoods.setOriCtryCodeOld(tradeCountry == null ? declGoods.getOriCtryCode() : tradeCountry.getEciqCodeOld());
            declGoods.setOriCtryCodeNew(tradeCountry == null ? null : tradeCountry.getCode());
            // 原产地区代码   origPlaceCode
            tradeCountry = publicService.getCountry(declGoods.getOrigPlaceCode(),"1");
            declGoods.setOrigPlaceCodeOld(tradeCountry == null ? declGoods.getOrigPlaceCode() : tradeCountry.getEciqCodeOld());
            declGoods.setOrigPlaceCodeNew(tradeCountry == null ? null : tradeCountry.getCode());

            dxpEciqDeclGoodsMapper.insert(declGoods);

            // 出入境包装信息
            for(DxpEciqDeclGoodsPack declGoodsPack : declGoods.getDxpEciqDeclGoodsPackList()){
                declGoodsPack.setId(UUID.randomUUID().toString().replaceAll("-",""));
                // 辅助包装材料种类
                BasePackType basePackType = publicService.getBasePackType(declGoodsPack.getPackTypeCode(),"1");
                declGoodsPack.setPackTypeCodeOld(basePackType == null ? declGoodsPack.getPackTypeCode() : basePackType.getEciqCodeOld());
                declGoodsPack.setPackTypeCodeNew(basePackType == null ? null : basePackType.getCode());
                dxpEciqDeclGoodsPackMapper.insert(declGoodsPack);
            }

            // 出入境货物与集装箱关联信息
            for(DxpEciqDeclGoodsCont declGoodsCont : declGoods.getDxpEciqDeclGoodsContList()){
                declGoodsCont.setId(UUID.randomUUID().toString().replaceAll("-",""));
                // 集装箱规格代码 cntnrModeCode
                BaseContainerType baseConType = publicService.getContainerType(declGoodsCont.getCntnrModeCode(),"1");
                declGoodsCont.setCntnrModeCodeOld(baseConType == null ? declGoodsCont.getCntnrModeCode(): baseConType.getEciqCodeOld());
                declGoodsCont.setCntnrModeCodeNew(baseConType == null ? null : baseConType.getCode());
                dxpEciqDeclGoodsContMapper.insert(declGoodsCont);
            }

            // 出入境许可证信息
            for(DxpEciqDeclGoodsLimit declGoodsLimit : declGoods.getDxpEciqDeclGoodsLimitList()){
                declGoodsLimit.setId(UUID.randomUUID().toString().replaceAll("-",""));
                dxpEciqDeclGoodsLimitMapper.insert(declGoodsLimit);

                // 出入境许可证VIN信息
                for(DxpEciqDeclGoodsLimitVn declGoodsLimitVn : declGoodsLimit.getDxpEciqDeclGoodsLimitVnList()){
                    declGoodsLimitVn.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    declGoodsLimitVn.setBillLadDate(DateFormatUtils.strToLocalDateTime(declGoodsLimitVn.getBillLadDateStr()));
                    dxpEciqDeclGoodsLimitVnMapper.insert(declGoodsLimitVn);
                }
            }
        }
    }

    /**
    　* @Description: 出入境报检基本信息
    　* @Author: ps
    　* @Date: 2022/5/11 0011 16:07
    　*/
    private void declInsert(DxpEciqDecl dxpEciqDecl,String copMsgId) throws Exception{
        dxpEciqDecl.setId(UUID.randomUUID().toString().replaceAll("-",""));
        dxpEciqDecl.setCopMsgId(copMsgId);
        // 贸易国别代码
        BaseCountryArea tradeCountry = publicService.getCountry(dxpEciqDecl.getTradeCountryCode(),"1");
        dxpEciqDecl.setTradeCountryCodeOld(tradeCountry == null ? dxpEciqDecl.getTradeCountryCode() : tradeCountry.getEciqCodeOld());
        dxpEciqDecl.setTradeCountryCodeNew(tradeCountry == null ? null : tradeCountry.getCode());
        // 启运国家代码
        BaseCountryArea despCtry = publicService.getCountry(dxpEciqDecl.getDespCtryCode(),"1");
        dxpEciqDecl.setDespCtryCodeOld(despCtry == null ? dxpEciqDecl.getDespCtryCode() : despCtry.getEciqCodeOld());
        dxpEciqDecl.setDespCtryCodeNew(despCtry == null ? null : despCtry.getCode());
        // arrivPortCode  到达口岸代码
        BasePort basePort = publicService.getBasePort(dxpEciqDecl.getArrivPortCode(),"1");
        dxpEciqDecl.setArrivPortCodeOld(basePort == null ? dxpEciqDecl.getArrivPortCode(): basePort.getEciqCodeOld());
        dxpEciqDecl.setArrivPortCodeNew(basePort == null ? null: basePort.getCode());
        // gdsArvlDate  到货日期
        dxpEciqDecl.setGdsArvlDate(DateFormatUtils.strToLocalDateTime(dxpEciqDecl.getGdsArvlDateStr()));
        // counterClaim  索赔截止日期
        dxpEciqDecl.setGdsArvlDate(DateFormatUtils.strToLocalDateTime(dxpEciqDecl.getCounterClaimStr()));
        // declDate  报检日期
        dxpEciqDecl.setDeclDate(DateFormatUtils.strToLocalDateTime(dxpEciqDecl.getDeclDateStr()));
        // despDate  入境：启运日期 出境：发货日期
        dxpEciqDecl.setDespDate(DateFormatUtils.strToLocalDateTime(dxpEciqDecl.getDespDateStr()));

        dxpEciqDeclMapper.insert(dxpEciqDecl);
    }

    /**
     * @Author: ps
     * @Description: 开始解析检验检疫回执
     * @Date: Created in 2021/12/9 10:06
     * @params: [fileList, latch]
     * @return: void
     */
    @Override
    public void resultAnalyzing(Map<String, Object> map, MqDecEciqReLocal result) {
        DxpEciqMsg dxpEciqMsg = JSON.parseObject(JSON.toJSONString(map), DxpEciqMsg.class);

        // 具体回执报文解析
        String data = (String) map.get("data");

        try {
            DxpEciqResult dxpEciqResult = (DxpEciqResult) XmlUtil.convertXmlToObject(DxpEciqResult.class, data);
            /*// 查询检验检疫数据是否存在
            // 如未入库，则先不处理
            QueryWrapper<DxpEciqDecl> queryWrapper = new QueryWrapper<DxpEciqDecl>();
            queryWrapper.eq("ENT_DECL_NO", dxpEciqResult.getCusCiqNo());
            List<DxpEciqDecl> list = dxpEciqDeclMapper.selectList(queryWrapper);
            if(list == null || list.size() == 0){
                return;
            }*/

            // 报文头保存
            dxpEciqMsg.setId(UUID.randomUUID().toString().replaceAll("-",""));
            dxpEciqMsgMapper.insert(dxpEciqMsg);

            // 回执保存
            dxpEciqResult.setId(UUID.randomUUID().toString().replaceAll("-",""));
            dxpEciqResult.setOperTime(DateFormatUtils.strToLocalDateTime(dxpEciqResult.getOperTimeStr()));
            dxpEciqDeclResultMapper.insert(dxpEciqResult);


            /*DxpEciqDecl dxpEciqDecl = list.get(0);
            switch (dxpEciqResult.getRspCodes()){
                case "1000":
                    // 检验检疫申请号
                    dxpEciqDecl.setInspNoE(dxpEciqResult.getEntDealNo());
                    break;
                case "1100":
                    // 检验检疫编号
                    dxpEciqDecl.setInspNo(dxpEciqResult.getEntDealNo());
                    break;
                case "1300":
                    // 检验检疫编号
                    dxpEciqDecl.setInspNo(dxpEciqResult.getEntDealNo());
                    break;
            }
            // 电子底账数据号
            if(StringUtils.isNotBlank(dxpEciqResult.getClBlNo())){
                dxpEciqDecl.setClBlNo(dxpEciqResult.getClBlNo().substring(0,15));
            }
            dxpEciqDeclMapper.updateById(dxpEciqDecl);*/

            // 保存一份到记录表中以便数据推送使用
            CiqRecRecord ciqRecRecord = new CiqRecRecord();
            ciqRecRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
            ciqRecRecord.setXmlPath(result.getFileLocalPath());
            ciqRecRecord.setEntDeclNo(dxpEciqResult.getEntDealNo());
            ciqRecRecord.setXmlCreatTime(dxpEciqMsg.getXmlCreatTime());
            ciqRecRecordMapper.insert(ciqRecRecord);

            // 复制报文到备份目录
            PublicUtils.moveFile(result.getFileLocalPath(),bakPath,"SUCCESS","ECIQ_RESULT");
            result.setField1("1");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("检验检疫回执报文{}数据入库报错：{}",map.get("path"),e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            // 复制报文到备份目录
            PublicUtils.moveFile(result.getFileLocalPath(),bakPath,"ERROR","ECIQ_RESULT");
            result.setField1("2");
        }
    }
}
