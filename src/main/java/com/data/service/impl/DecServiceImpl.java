package com.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.data.entity.*;
import com.data.entity.dec.*;
import com.data.entity.dec.xmlDto.*;
import com.data.mapper.dec.*;
import com.data.service.IDecRecordService;
import com.data.service.IDecService;
import com.data.service.IPublicService;
import com.data.util.DateFormatUtils;
import com.data.util.PublicUtils;
import com.data.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 　* @Description: 报关报文解析
 * 　* @Author: ps
 * 　* @Date: 2022/4/26 0026 9:42
 */
@Service("decService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class DecServiceImpl implements IDecService {


    @Resource
    private DxpDecMsgMapper dxpDecMsgMapper;

    @Resource
    private DxpDecContainerMapper dxpDecContainerMapper;

    @Resource
    private DxpDecEcoRealationMapper dxpDecEcoRealationMapper;

    @Resource
    private DxpDecEdocRealationMapper dxpDecEdocRealationMapper;

    @Resource
    private DxpDecFreeTxtMapper dxpDecFreeTxtMapper;

    @Resource
    private DxpDecHeadMapper dxpDecHeadMapper;

    @Resource
    private DxpDecLicenseDocuMapper dxpDecLicenseDocuMapper;

    @Resource
    private DxpDecListMapper dxpDecListMapper;

    @Resource
    private DxpDecTrnContaGoodsMapper dxpDecTrnContaGoodsMapper;

    @Resource
    private DxpDecTrnContainerMapper dxpDecTrnContainerMapper;

    @Resource
    private DxpDecTrnHeadMapper dxpDecTrnHeadMapper;

    @Resource
    private DxpDecTrnListMapper dxpDecTrnListMapper;

    @Autowired
    private IPublicService publicService;

    @Autowired
    private IDecRecordService decRecordService;

    @Resource
    private DxpDecResultMapper dxpDecResultMapper;

    @Value("${bakPath}")
    private String bakPath;

    /**
     * @Description: 报关单报文解析
     * @Auther hx
     * @Date 2022-04-27 16:41
     */
    @Override
    public void decAnalyzing(Map<String, Object> map, MqDecCustDataLocal mqDecCustDataLocal) {
        DxpDecMsg dxpDecMsg = JSON.parseObject(JSON.toJSONString(map), DxpDecMsg.class);

        // 具体业务报文解析
        String data = (String) map.get("data");
        DecMessage decMessage = null;
        try {
            decMessage = (DecMessage) XmlUtil.convertXmlToObject(DecMessage.class, data);
            if (null == decMessage) {
                log.error("报关业务报文DecMessage为空");
                return;
            }
            DecHead decHead = decMessage.getDecHead();
            DecListList decListList = decMessage.getDecLists();
            DecContainerList decContainerList = decMessage.getDecContainers();
            DecLicenseDocuList decLicenseDocuList = decMessage.getDecLicenseDocus();
            List<DecFreeTxt> decFreeTxtList = decMessage.getDecFreeTxts();
            List<EdocRelation> edocRelationList = decMessage.getEdocRelations();
            List<EcoRelation> ecoRelationList = decMessage.getEcoRelations();
            TrnHead trnHead = decMessage.getTrnHead();
            List<TrnList> trnListList = decMessage.getTrnLists();
            TrnContainerList trnContainerList = decMessage.getTrnContainers();
            TrnContaGoodsList trnContaGoodsList = decMessage.getTrnContaGoods();

            /**************************报关单表头**********************/
            DxpDecHead dxpDecHead = new DxpDecHead();

            BeanUtils.copyProperties(decHead, dxpDecHead);
            dxpDecHead.setId(UUID.randomUUID().toString());
            dxpDecHead.setIEDate(DateFormatUtils.strToLocalDateTime(decHead.getIEDateStr()));
            dxpDecHead.setInputDate(DateFormatUtils.strToDateTimeDefine(decHead.getInputDateStr(), DateFormatUtils.DTF_YYYYMMDD_HHMMSS));
            dxpDecHead.setCopMsgId(dxpDecMsg.getCopMsgId());
            saveDxpDecHead(dxpDecHead);

            /***********************报关单表体***********************/
            if (null != decListList) {
                saveDxpDecList(decListList, dxpDecHead,dxpDecMsg.getCopMsgId());
            }

            /**********************集装箱信息**********************/
            if (null != decContainerList) {
                saveDxpDecContainer(decContainerList, dxpDecHead,dxpDecMsg.getCopMsgId());
            }

            /**********************报关单随附单证信息**********************/
            if (null != decLicenseDocuList) {
                saveDxpDecLicenseDocu(decLicenseDocuList, dxpDecHead,dxpDecMsg.getCopMsgId());
            }

            /**********************报关单附加信息**********************/
            if (!CollectionUtils.isEmpty(decFreeTxtList)) {
                saveDxpDecFreeTxt(decFreeTxtList, dxpDecHead,dxpDecMsg.getCopMsgId());
            }

            /**********************电子随附单据关联关系表**********************/
            if (!CollectionUtils.isEmpty(edocRelationList)) {
                saveDxpDecEdocRelation(edocRelationList, dxpDecHead,dxpDecMsg.getCopMsgId());
            }

            /**********************原产地证明项号关联关系表**********************/
            if (!CollectionUtils.isEmpty(ecoRelationList)) {
                saveDxpDecEcoRelation(ecoRelationList, dxpDecHead,dxpDecMsg.getCopMsgId());
            }

            /**********************转关单表头**********************/
            DxpDecTrnHead dxpDecTrnHead = new DxpDecTrnHead();
            if (null != trnHead) {
                BeanUtils.copyProperties(trnHead, dxpDecTrnHead);
                dxpDecTrnHead.setId(UUID.randomUUID().toString());
                dxpDecTrnHead.setSeqNo(dxpDecHead.getSeqNo());
                dxpDecTrnHead.setCopMsgId(dxpDecMsg.getCopMsgId());
                dxpDecTrnHeadMapper.insert(dxpDecTrnHead);
            }

            /**********************转关单表体**********************/
            if (!CollectionUtils.isEmpty(trnListList)) {
                saveDxpDecTrnList(trnListList, dxpDecTrnHead,dxpDecMsg.getCopMsgId());
            }

            /**********************转关单集装箱**********************/
            if (null != trnContainerList) {
                saveDxpDecTrnContainer(trnContainerList, dxpDecTrnHead,dxpDecMsg.getCopMsgId());
            }

            /**********************转关单集装箱商品信息**********************/
            if (null != trnContaGoodsList) {
                saveDxpDecTrnContaGoods(trnContaGoodsList, dxpDecTrnHead,dxpDecMsg.getCopMsgId());
            }


            //将报文标识改为已处理并
            mqDecCustDataLocal.setField1("1");
            //移走文件
            PublicUtils.moveFile(mqDecCustDataLocal.getFileLocalPath(), bakPath, "SUCCESS", "DEC");
            //保存报文信息
            dxpDecMsg.setId(UUID.randomUUID().toString());
            dxpDecMsgMapper.insert(dxpDecMsg);

            //报关单记录表
            decRecordService.saveRecord(dxpDecHead, mqDecCustDataLocal, dxpDecMsg);
        } catch (Exception e) {
            log.error("报关业务报文DecMessage:{}解析出错{}",mqDecCustDataLocal.getFileLocalPath(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            mqDecCustDataLocal.setField1("2");
            PublicUtils.moveFile(mqDecCustDataLocal.getFileLocalPath(), bakPath, "ERROR", "DEC");
        }

    }

    /**
     * @Description: 报关单回执解析
     * @Auther hx
     * @Date 2022-05-09 16:18
     */
    @Override
    public void decReAnalyzing(Map<String, Object> map, MqDecCustReLocal mqDecCustReLocal) {
        DxpDecMsg dxpDecMsg = JSON.parseObject(JSON.toJSONString(map), DxpDecMsg.class);

        // 具体回执报文解析
        String data = (String) map.get("data");
        DecResult decResult = null;
        try {
            decResult = (DecResult) XmlUtil.convertXmlToObject(DecResult.class, data);
            DxpDecResult dxpDecResult = new DxpDecResult();
            BeanUtils.copyProperties(decResult, dxpDecResult);
            //预录入统一编号
            String cusCiqNo = decResult.getCusCiqNo();
            /*//查询报关单信息：判断报关单数据是否已入库
            //如未入库，则先不处理
            QueryWrapper<DxpDecHead> queryWrapper = new QueryWrapper<DxpDecHead>();
            queryWrapper.eq("SEQ_NO", cusCiqNo);
            List<DxpDecHead> list = dxpDecHeadMapper.selectList(queryWrapper);
            if (null == list && list.size() == 0) {
                return;
            }

            DxpDecHead dxpDecHead = list.get(0);*/
            //保存回执报文信息
            dxpDecResult.setId(UUID.randomUUID().toString());
            dxpDecResult.setNoticeDate(DateFormatUtils.strToLocalDateTime(decResult.getNoticeDateStr()));
            dxpDecResult.setIEDate(DateFormatUtils.strToLocalDateTime(decResult.getIEDateStr()));
            dxpDecResult.setCopMsgId(dxpDecMsg.getCopMsgId());
            dxpDecResultMapper.insert(dxpDecResult);

            /*//回执报关单编号不为空 且 报关单业务数据中报关单号为空 才做更新
            if (StringUtils.isNotBlank(dxpDecResult.getEntryId())&&StringUtils.isBlank(dxpDecHead.getEntryId())) {
                //更新海关编号entryId
                dxpDecHead.setEntryId(dxpDecResult.getEntryId());
                decRecordService.updateRecord(dxpDecHead);
            }

            LocalDateTime noticeDate = DateFormatUtils.strToLocalDateTime(decResult.getNoticeDateStr());

            //更新报关单状态，以及时间
            switch (dxpDecResult.getChannel()) {
                case "R":
                    //状态为结关：更新结关时间
                    if (null != noticeDate) {
                        dxpDecHead.setClearanceDate(noticeDate);
                    }
                    dxpDecHead.setUpdateTime(LocalDateTime.now());
                    break;
                case "C":
                    //查验：更新查验时间
                    if (null != noticeDate) {
                        dxpDecHead.setCheckDate(noticeDate);
                    }
                    break;
                case "P":
                    //放行：更新放行时间
                    if (null != noticeDate) {
                        dxpDecHead.setReleaseDate(noticeDate);
                    }
                    dxpDecHead.setUpdateTime(LocalDateTime.now());
                    break;
                default:
                    break;
            }
            dxpDecHeadMapper.updateById(dxpDecHead);*/

            mqDecCustReLocal.setField1("1");
            //移走文件
            PublicUtils.moveFile(mqDecCustReLocal.getFileLocalPath(), bakPath, "SUCCESS", "RESULT");
            //保存报文信息
            dxpDecMsg.setId(UUID.randomUUID().toString());
            dxpDecMsgMapper.insert(dxpDecMsg);
            decRecordService.saveReRecord(dxpDecResult,mqDecCustReLocal,dxpDecMsg);

        } catch (Exception e) {
            log.error("报关回执报文DxpDecResult：{}解析出错{}",mqDecCustReLocal.getFileLocalPath(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            mqDecCustReLocal.setField1("2");
            PublicUtils.moveFile(mqDecCustReLocal.getFileLocalPath(), bakPath, "ERROR", "RESULT");
        }

    }

    /**
     * @Description 查询可更新的报关单数据
     * @Author huxi
     * @Date 2022/7/21 21:58
     */
    @Override
    public List<DxpDecHead> getDxpDecHead() {
        List<DxpDecHead> dxpDecHeadList = dxpDecHeadMapper.getDxpDecHead();
        return dxpDecHeadList;
    }

    /**
     * @Description 更新报关单字段
     * @Author huxi
     * @Date 2022/7/21 21:57
     */
    @Override
    public void updateEntryId(DxpDecHead dxpDecHead) {
        //更新海关编号entryId
        dxpDecHeadMapper.updateById(dxpDecHead);
        //更新记录表中额 海关编号entryId以及更新时间
        decRecordService.updateRecord(dxpDecHead);
    }

    /**
     * @Description: 转关单回执解析
     * @Auther hx
     * @Date 2022-05-10 17:23
     */
    public void decTrnReAnalyzing(Map<String, Object> map, MqDecCustReLocal mqDecCustReLocal) {
        DxpDecMsg dxpDecMsg = JSON.parseObject(JSON.toJSONString(map), DxpDecMsg.class);

        //保存报文信息
        dxpDecMsg.setId(UUID.randomUUID().toString());
        dxpDecMsgMapper.insert(dxpDecMsg);
        // 具体回执报文解析
        String data = (String) map.get("data");
        TrnResult trnResult = null;
        try {
            trnResult = (TrnResult) XmlUtil.convertXmlToObject(TrnResult.class, data);
            //转关单统一编号
            String spTrnSeqNo = trnResult.getSpTrnSeqNo();
            //查询转关单信息：判断转关单数据是否已入库
            //如未入库，则先不处理
            QueryWrapper<DxpDecTrnHead> queryWrapper = new QueryWrapper<DxpDecTrnHead>();
            queryWrapper.eq("TRN_PRE_ID", spTrnSeqNo);
            List<DxpDecTrnHead> list = dxpDecTrnHeadMapper.selectList(queryWrapper);
            if (null != list && list.size() > 0) {
                DxpDecTrnHead dxpDecTrnHead = list.get(0);
                //保存回执报文信息
                //
                //

                if (StringUtils.isNotBlank(trnResult.getTransDclNo())) {
                    //更新海关编号entryId
                    dxpDecTrnHead.setTurnNo(trnResult.getTransDclNo());
                }
                dxpDecTrnHeadMapper.updateById(dxpDecTrnHead);

                mqDecCustReLocal.setField1("1");
                //移走文件
                PublicUtils.moveFile(mqDecCustReLocal.getFileLocalPath(), bakPath, "SUCCESS", "RESULT");
            }
        } catch (Exception e) {
            log.error("转关单回执报文TrnResult解析出错{}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            mqDecCustReLocal.setField1("2");
            PublicUtils.moveFile(mqDecCustReLocal.getFileLocalPath(), bakPath, "ERROR", "RESULT");
        }


    }

    /**
     * @Description: 报关单表头
     * @Auther hx
     * @Date 2022-05-10 15:07
     */
    private void saveDxpDecHead( DxpDecHead dxpDecHead) {
        //运启国
        BaseCountryArea tradeCountry = publicService.getCountry(dxpDecHead.getTradeCountry(), "2");
        //新代码
        dxpDecHead.setTradeCountry(null == tradeCountry ? "" : tradeCountry.getCode());
        //旧代码
        dxpDecHead.setTradeCountryOld(null == tradeCountry ? "" : tradeCountry.getDecCodeOld());

        //贸易国别
        BaseCountryArea tradeAreaCode = publicService.getCountry(dxpDecHead.getTradeAreaCode(), "2");
        //新代码
        dxpDecHead.setTradeAreaCode(null == tradeAreaCode ? "" : tradeAreaCode.getCode());
        //旧代码
        dxpDecHead.setTradeAreaCodeOld(null == tradeAreaCode ? "" : tradeAreaCode.getDecCodeOld());

        // 装货港
        BasePort distinatePort = publicService.getBasePort(dxpDecHead.getDistinatePort(), "2");
        //新代码
        dxpDecHead.setDistinatePort(null == distinatePort ? "" : distinatePort.getCode());
        //旧代码
        dxpDecHead.setDistinatePortOld(null == distinatePort ? "" : distinatePort.getDecCodeOld());

        // 包装种类
        BasePackType wrapType = publicService.getBasePackType(dxpDecHead.getWrapType(), "2");
        //新代码
        dxpDecHead.setWrapType(null == wrapType ? "" : wrapType.getCode());
        //旧代码
        dxpDecHead.setWrapTypeOld(null == wrapType ? "" : wrapType.getDecCodeOld());

        // 运费币制
        BaseCurrency feeCurr = publicService.getCurr(dxpDecHead.getFeeCurr(), "2");
        //新代码
        dxpDecHead.setFeeCurr(null == feeCurr ? "" : feeCurr.getCode());
        //旧代码
        dxpDecHead.setFeeCurrOld(null == feeCurr ? "" : feeCurr.getDecCodeOld());

        // 保险费币制
        BaseCurrency insurCurr = publicService.getCurr(dxpDecHead.getInsurCurr(), "2");
        //新代码
        dxpDecHead.setInsurCurr(null == insurCurr ? "" : insurCurr.getCode());
        //旧代码
        dxpDecHead.setInsurCurrOld(null == insurCurr ? "" : insurCurr.getDecCodeOld());

        // 杂费币制
        BaseCurrency otherCurr = publicService.getCurr(dxpDecHead.getOtherCurr(), "2");
        //新代码
        dxpDecHead.setOtherCurr(null == otherCurr ? "" : otherCurr.getCode());
        //旧代码
        dxpDecHead.setOtherCurrOld(null == otherCurr ? "" : otherCurr.getDecCodeOld());

        dxpDecHeadMapper.insert(dxpDecHead);
    }

    /**
     * @Description: 报关单表体
     * @Auther hx
     * @Date 2022-05-10 15:10
     */
    private void saveDxpDecList(DecListList decListList, DxpDecHead dxpDecHead,String copMsgId) {

        List<DecList> decLists = decListList.getDecList();
        List<DxpDecList> dxpDecListList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(decLists)) {
            for (DecList decList : decLists) {
                DxpDecList dxpDecList = new DxpDecList();
                BeanUtils.copyProperties(decList, dxpDecList);
                dxpDecList.setSeqNo(dxpDecHead.getSeqNo());
                dxpDecList.setId(UUID.randomUUID().toString());
                //原产地
                BaseCountryArea originCountry = publicService.getCountry(dxpDecList.getOriginCountry(), "2");
                dxpDecList.setOriginCountry(null == originCountry ? "" : originCountry.getCode());
                dxpDecList.setOriginCountryOld(null == originCountry ? "" : originCountry.getDecCodeOld());

                //最终目的国
                BaseCountryArea destinationCountry = publicService.getCountry(dxpDecList.getDestinationCountry(), "2");
                dxpDecList.setDestinationCountry(null == destinationCountry ? "" : destinationCountry.getCode());
                dxpDecList.setDestinationCountryOld(null == destinationCountry ? "" : destinationCountry.getDecCodeOld());

                // 成交币制
                BaseCurrency tradeCurr = publicService.getCurr(dxpDecList.getTradeCurr(), "2");
                dxpDecList.setTradeCurr(null == tradeCurr ? "" : tradeCurr.getCode());
                dxpDecList.setTradeCurrOld(null == tradeCurr ? "" : tradeCurr.getDecCodeOld());

                dxpDecList.setCopMsgId(copMsgId);
                dxpDecListList.add(dxpDecList);
            }
            dxpDecListMapper.batchInsert(dxpDecListList);
        }
    }

    /**
     * @Description: 集装箱信息
     * @Auther hx
     * @Date 2022-05-10 15:14
     */
    private void saveDxpDecContainer(DecContainerList decContainerList, DxpDecHead dxpDecHead,String copMsgId) {
        List<Container> containers = decContainerList.getContainer();
        List<DxpDecContainer> dxpDecContainerList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(containers)) {
            for (Container container : containers) {
                DxpDecContainer dxpDecContainer = new DxpDecContainer();
                BeanUtils.copyProperties(container, dxpDecContainer);
                dxpDecContainer.setSeqNo(dxpDecHead.getSeqNo());
                dxpDecContainer.setId(UUID.randomUUID().toString());

                //集装箱规格
                BaseContainerType containerMd = publicService.getContainerType(dxpDecContainer.getContainerMd(), "2");
                dxpDecContainer.setContainerMd(null == containerMd ? "" : containerMd.getCode());
                dxpDecContainer.setContainerMdOld(null == containerMd ? "" : containerMd.getDecCodeOld());

                dxpDecContainer.setCopMsgId(copMsgId);
                dxpDecContainerList.add(dxpDecContainer);
            }
            dxpDecContainerMapper.batchInsert(dxpDecContainerList);
        }
    }

    /**
     * @Description: 报关单随附单证信息
     * @Auther hx
     * @Date 2022-05-10 15:17
     */
    private void saveDxpDecLicenseDocu(DecLicenseDocuList decLicenseDocuList, DxpDecHead dxpDecHead,String copMsgId) {
        List<LicenseDocu> licenseDocus = decLicenseDocuList.getLicenseDocu();
        List<DxpDecLicenseDocu> dxpDecLicenseDocuList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(licenseDocus)) {
            for (LicenseDocu licenseDocu : licenseDocus) {
                DxpDecLicenseDocu dxpDecLicenseDocu = new DxpDecLicenseDocu();
                BeanUtils.copyProperties(licenseDocu, dxpDecLicenseDocu);
                dxpDecLicenseDocu.setSeqNo(dxpDecHead.getSeqNo());
                dxpDecLicenseDocu.setId(UUID.randomUUID().toString());
                dxpDecLicenseDocu.setCopMsgId(copMsgId);
                dxpDecLicenseDocuList.add(dxpDecLicenseDocu);
            }
            dxpDecLicenseDocuMapper.batchInsert(dxpDecLicenseDocuList);
        }
    }

    /**
     * @Description: 报关单附加信息
     * @Auther hx
     * @Date 2022-05-10 15:20
     */
    private void saveDxpDecFreeTxt(List<DecFreeTxt> decFreeTxtList, DxpDecHead dxpDecHead,String copMsgId) {
        List<DxpDecFreeTxt> dxpDecFreeTxtList = new ArrayList<>();
        for (DecFreeTxt decFreeTxt : decFreeTxtList) {
            DxpDecFreeTxt dxpDecFreeTxt = new DxpDecFreeTxt();
            BeanUtils.copyProperties(decFreeTxt, dxpDecFreeTxt);
            dxpDecFreeTxt.setSeqNo(dxpDecHead.getSeqNo());
            dxpDecFreeTxt.setId(UUID.randomUUID().toString());
            dxpDecFreeTxt.setCopMsgId(copMsgId);
            dxpDecFreeTxtList.add(dxpDecFreeTxt);
        }
        dxpDecFreeTxtMapper.batchInsert(dxpDecFreeTxtList);
    }

    /**
     * @Description: 电子随附单据关联关系表
     * @Auther hx
     * @Date 2022-05-10 15:20
     */
    private void saveDxpDecEdocRelation(List<EdocRelation> edocRelationList, DxpDecHead dxpDecHead,String copMsgId) {
        List<DxpDecEdocRelation> dxpDecEdocRelationList = new ArrayList<>();
        for (EdocRelation edocRelation : edocRelationList) {
            DxpDecEdocRelation dxpDecEdocRelation = new DxpDecEdocRelation();
            BeanUtils.copyProperties(edocRelation, dxpDecEdocRelation);
            dxpDecEdocRelation.setSeqNo(dxpDecHead.getSeqNo());
            dxpDecEdocRelation.setId(UUID.randomUUID().toString());
            dxpDecEdocRelation.setCopMsgId(copMsgId);
            dxpDecEdocRelationList.add(dxpDecEdocRelation);
        }
        dxpDecEdocRealationMapper.batchInsert(dxpDecEdocRelationList);
    }

    /**
     * @Description: 原产地证明项号关联关系表
     * @Auther hx
     * @Date 2022-05-10 15:20
     */
    private void saveDxpDecEcoRelation(List<EcoRelation> ecoRelationList, DxpDecHead dxpDecHead,String copMsgId) {
        List<DxpDecEcoRelation> dxpDecEcoRelationList = new ArrayList<>();
        for (EcoRelation ecoRelation : ecoRelationList) {
            DxpDecEcoRelation dxpDecEcoRelation = new DxpDecEcoRelation();
            BeanUtils.copyProperties(ecoRelation, dxpDecEcoRelation);
            dxpDecEcoRelation.setSeqNo(dxpDecHead.getSeqNo());
            dxpDecEcoRelation.setId(UUID.randomUUID().toString());
            dxpDecEcoRelation.setCopMsgId(copMsgId);
            dxpDecEcoRelationList.add(dxpDecEcoRelation);
        }
        dxpDecEcoRealationMapper.batchInsert(dxpDecEcoRelationList);
    }

    /**
     * @Description: 转关单表体
     * @Auther hx
     * @Date 2022-05-10 15:32
     */
    private void saveDxpDecTrnList(List<TrnList> trnListList, DxpDecTrnHead dxpDecTrnHead,String copMsgId) {
        List<DxpDecTrnList> dxpDecTrnListList = new ArrayList<>();
        for (TrnList trnList : trnListList) {
            DxpDecTrnList dxpDecTrnList = new DxpDecTrnList();
            BeanUtils.copyProperties(trnList, dxpDecTrnList);
            dxpDecTrnList.setTrnPreId(dxpDecTrnHead.getTrnPreId());
            dxpDecTrnList.setId(UUID.randomUUID().toString());
            dxpDecTrnList.setSeqNo(dxpDecTrnHead.getSeqNo());
            dxpDecTrnList.setCopMsgId(copMsgId);
            dxpDecTrnListList.add(dxpDecTrnList);
        }
        dxpDecTrnListMapper.batchInsert(dxpDecTrnListList);
    }

    /**
     * @Description: 转关单集装箱
     * @Auther hx
     * @Date 2022-05-10 15:32
     */
    private void saveDxpDecTrnContainer(TrnContainerList trnContainerList, DxpDecTrnHead dxpDecTrnHead,String copMsgId) {
        List<TrnContainer> trnContainers = trnContainerList.getTrnContainer();
        List<DxpDecTrnContainer> dxpDecTrnContainerList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(trnContainers)) {
            for (TrnContainer trnContainer : trnContainers) {
                DxpDecTrnContainer dxpDecTrnContainer = new DxpDecTrnContainer();
                BeanUtils.copyProperties(trnContainer, dxpDecTrnContainer);
                dxpDecTrnContainer.setTrnPreId(dxpDecTrnHead.getTrnPreId());
                dxpDecTrnContainer.setSeqNo(dxpDecTrnHead.getSeqNo());
                dxpDecTrnContainer.setId(UUID.randomUUID().toString());
                //集装箱规格
                BaseContainerType contaModel = publicService.getContainerType(dxpDecTrnContainer.getContaModel(), "2");
                dxpDecTrnContainer.setContaModel(null == contaModel ? "" : contaModel.getCode());
                dxpDecTrnContainer.setContaModelOld(null == contaModel ? "" : contaModel.getDecCodeOld());

                dxpDecTrnContainer.setCopMsgId(copMsgId);
                dxpDecTrnContainerList.add(dxpDecTrnContainer);
            }
            dxpDecTrnContainerMapper.batchInsert(dxpDecTrnContainerList);
        }
    }

    /**
     * @Description: 转关单集装箱商品信息
     * @Auther hx
     * @Date 2022-05-10 15:32
     */
    private void saveDxpDecTrnContaGoods(TrnContaGoodsList trnContaGoodsList, DxpDecTrnHead dxpDecTrnHead,String copMsgId) {
        List<TrnContaGoods> trnContaGoods = trnContaGoodsList.getTrnContaGoods();
        List<DxpDecTrnContaGoods> dxpDecTrnContaGoodsList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(trnContaGoods)) {
            for (TrnContaGoods tcgs : trnContaGoods) {
                DxpDecTrnContaGoods dxpDecTrnContaGoods = new DxpDecTrnContaGoods();
                BeanUtils.copyProperties(tcgs, dxpDecTrnContaGoods);
                dxpDecTrnContaGoods.setTrnPreId(dxpDecTrnHead.getTrnPreId());
                dxpDecTrnContaGoods.setSeqNo(dxpDecTrnHead.getSeqNo());
                dxpDecTrnContaGoods.setId(UUID.randomUUID().toString());
                dxpDecTrnContaGoods.setCopMsgId(copMsgId);
                dxpDecTrnContaGoodsList.add(dxpDecTrnContaGoods);
            }
            dxpDecTrnContaGoodsMapper.batchInsert(dxpDecTrnContaGoodsList);
        }
    }


}
