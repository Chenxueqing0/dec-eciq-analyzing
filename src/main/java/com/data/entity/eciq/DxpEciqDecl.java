package com.data.entity.eciq;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 出入境报检基本信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDecl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    @XmlElement(name="EntDeclNo")
    private String entDeclNo;

    /**
     * 企业UUID
     */
    @TableField("ENT_UUID")
    @XmlElement(name="EntUuid")
    private String entUuid;

    /**
     * 贸易方式代码
     */
    @XmlElement(name="TradeModeCode")
    @TableField("TRADE_MODE_CODE")
    private String tradeModeCode;

    /**
     * 合同号
     */
    @XmlElement(name="ContractNo")
    @TableField("CONTRACT_NO")
    private String contractNo;

    /**
     * 标记及号码
     */
    @TableField("MARK_NO")
    @XmlElement(name="MarkNo")
    private String markNo;

    /**
     * 贸易国别代码
     */
    @TableField(exist = false)
    @XmlElement(name="TradeCountryCode")
    private String tradeCountryCode;

    /**
     * 贸易国别代码（原代码）
     */
    @TableField("TRADE_COUNTRY_CODE_OLD")
    private String tradeCountryCodeOld;

    /**
     * 贸易国别代码（新代码）
     */
    @TableField("TRADE_COUNTRY_CODE_NEW")
    private String tradeCountryCodeNew;

    /**
     * 启运国家代码
     */
    @TableField(exist = false)
    @XmlElement(name="DespCtryCode")
    private String despCtryCode;

    /**
     * 启运国家代码（原代码）
     */
    @TableField("DESP_CTRY_CODE_OLD")
    private String despCtryCodeOld;

    /**
     * 启运国家代码（新代码）
     */
    @TableField("DESP_CTRY_CODE_NEW")
    private String despCtryCodeNew;

    /**
     * 运输方式代码（原代码）
     */
    @TableField("TRANS_MODE_CODE_OLD")
    @XmlElement(name="TransModeCode")
    private String transModeCodeOld;

    /**
     * 运输方式代码（新代码）
     */
    @TableField("TRANS_MODE_CODE_NEW")
    @XmlElement(name="TransModeCode")
    private String transModeCodeNew;

    /**
     * 启运口岸代码
     */
    @TableField("DESP_PORT_CODE")
    @XmlElement(name="DespPortCode")
    private String despPortCode;

    /**
     * 经停口岸代码
     */
    @TableField("PORT_STOP_CODE")
    @XmlElement(name="PortStopCode")
    private String portStopCode;

    /**
     * 入境口岸代码
     */
    @TableField("ENTY_PORT_CODE")
    @XmlElement(name="EntyPortCode")
    private String entyPortCode;

    /**
     * 到货日期
     */
    @TableField(exist = false)
    @XmlElement(name="GdsArvlDate")
    private String gdsArvlDateStr;

    /**
     * 到货日期
     */
    @TableField("GDS_ARVL_DATE")
    private LocalDateTime gdsArvlDate;

    /**
     * 存放地点
     */
    @TableField("GOODS_PLACE")
    @XmlElement(name="GoodsPlace")
    private String goodsPlace;

    /**
     * 目的地代码
     */
    @TableField("DEST_CODE")
    @XmlElement(name="DestCode")
    private String destCode;

    /**
     * 索赔截止日期
     */
    @TableField(exist = false)
    @XmlElement(name="CounterClaim")
    private String counterClaimStr;

    /**
     * 索赔截止日期
     */
    @TableField("COUNTER_CLAIM")
    private LocalDateTime counterClaim;

    /**
     * 提/运单号
     */
    @TableField("BILL_LAD_NO")
    @XmlElement(name="BillLadNo")
    private String billLadNo;

    /**
     * 提货单号
     */
    @TableField("DELIVERY_ORDER")
    @XmlElement(name="DeliveryOrder")
    private String deliveryOrder;

    /**
     * 口岸机构
     */
    @TableField("INSP_ORG_CODE")
    @XmlElement(name="InspOrgCode")
    private String inspOrgCode;

    /**
     * 报关海关代码
     */
    @TableField("DECL_CUSTM")
    @XmlElement(name="DeclCustm")
    private String declCustm;

    /**
     * 特种业务标识
     */
    @TableField("SPEC_DECL_FLAG")
    @XmlElement(name="SpecDeclFlag")
    private String specDeclFlag;

    /**
     * 目的机构代码
     */
    @TableField("PURP_ORG_CODE")
    @XmlElement(name="PurpOrgCode")
    private String purpOrgCode;

    /**
     * 申请单证代码串
     */
    @TableField("APP_CERT_CODE")
    @XmlElement(name="AppCertCode")
    private String appCertCode;

    /**
     * 申请单证正本数
     */
    @TableField("APPL_ORI")
    @XmlElement(name="ApplOri")
    private String applOri;

    /**
     * 申请单证副本数
     */
    @TableField("APPL_COPY_QUAN")
    @XmlElement(name="ApplCopyQuan")
    private String applCopyQuan;

    /**
     * 海关注册号
     */
    @TableField("CUSTM_REG_NO")
    @XmlElement(name="CustmRegNo")
    private String custmRegNo;

    /**
     * 报检员证号
     */
    @TableField("DECL_PERSN_CERT_NO")
    @XmlElement(name="DeclPersnCertNo")
    private String declPersnCertNo;

    /**
     * 报检员姓名
     */
    @TableField("DECL_PERSON_NAME")
    @XmlElement(name="DeclPersonName")
    private String declPersonName;

    /**
     * 报检单位名称
     */
    @TableField("DECL_REG_NAME")
    @XmlElement(name="DeclRegName")
    private String declRegName;

    /**
     * 报检单位联系人
     */
    @TableField("CONTACTPERSON")
    @XmlElement(name="Contactperson")
    private String contactperson;

    /**
     * 报检联系人电话
     */
    @TableField("CONT_TEL")
    @XmlElement(name="ContTel")
    private String contTel;

    /**
     * 收货人代码
     */
    @TableField("CONSIGNEE_CODE")
    @XmlElement(name="ConsigneeCode")
    private String consigneeCode;

    /**
     * 收货人名称（中文）
     */
    @TableField("CONSIGNEE_CNAME")
    @XmlElement(name="ConsigneeCname")
    private String consigneeCname;

    /**
     * 收货人名称（外文）
     */
    @TableField("CONSIGNEE_ENAME")
    @XmlElement(name="ConsigneeEname")
    private String consigneeEname;

    /**
     * 发货人名称（中文）
     */
    @TableField("CONSIGNOR_CNAME")
    @XmlElement(name="ConsignorCname")
    private String consignorCname;

    /**
     * 报检类别代码
     */
    @TableField("DECL_CODE")
    @XmlElement(name="DeclCode")
    private String declCode;

    /**
     * 报检日期
     */
    @TableField(exist = false)
    @XmlElement(name="DeclDate")
    private String declDateStr;

    /**
     * 报检日期
     */
    @TableField("DECL_DATE")
    private LocalDateTime declDate;

    /**
     * 特殊通关模式
     */
    @TableField("SPEC_PASS_FLAG")
    @XmlElement(name="SpecPassFlag")
    private String specPassFlag;

    /**
     * 入境：启运日期 出境：发货日期
     */
    @TableField(exist = false)
    @XmlElement(name="DespDate")
    private String despDateStr;

    /**
     * 入境：启运日期 出境：发货日期
     */
    @TableField("DESP_DATE")
    private LocalDateTime despDate;

    /**
     * 随附单据名称串
     */
    @TableField("ATTA_COLLECT_NAME")
    @XmlElement(name="AttaCollectName")
    private String attaCollectName;

    /**
     * 货物总值（美元）
     */
    @TableField("TOTAL_VAL_US")
    @XmlElement(name="TotalValUs")
    private String totalValUs;

    /**
     * 货物总值（人民币）
     */
    @TableField("TOTAL_VAL_CN")
    @XmlElement(name="TotalValCn")
    private String totalValCn;

    /**
     * 集装箱适载核销状态
     */
    @TableField("CONT_CANCEL_FLAG")
    @XmlElement(name="ContCancelFlag")
    private String contCancelFlag;

    /**
     * 申请单证名称
     */
    @TableField("APP_CERT_NAME")
    @XmlElement(name="AppCertName")
    private String appCertName;

    /**
     * 报检单位代码
     */
    @TableField("DECL_REG_NO")
    @XmlElement(name="DeclRegNo")
    private String declRegNo;

    /**
     * 运输工具名称
     */
    @TableField("CONVYNCE_NAME")
    @XmlElement(name="ConvynceName")
    private String convynceName;

    /**
     * 运输工具号码
     */
    @TableField("TRANS_MEAN_NO")
    @XmlElement(name="TransMeanNo")
    private String transMeanNo;

    /**
     * 卸毕日期
     */
    @TableField("CMPL_DSCHRG_DT")
    @XmlElement(name="CmplDschrgDt")
    private String cmplDschrgDt;

    /**
     * 关联报检号
     */
    @TableField("CORRELATION_DECL_NO")
    @XmlElement(name="CorrelationDeclNo")
    private String correlationDeclNo;

    /**
     * 关联理由
     */
    @TableField("CORRELATION_REASON_FLAG")
    @XmlElement(name="CorrelationReasonFlag")
    private String correlationReasonFlag;

    /**
     * 特殊检验检疫要求
     */
    @TableField("SPECL_INSP_QURA_RE")
    @XmlElement(name="SpeclInspQuraRe")
    private String speclInspQuraRe;

    /**
     * 发货人地址
     */
    @TableField("CONSIGNOR_ADDR")
    @XmlElement(name="ConsignorAddr")
    private String consignorAddr;

    /**
     * 到达口岸代码
     */
    @TableField(exist = false)
    @XmlElement(name="ArrivPortCode")
    private String arrivPortCode;

    /**
     * 到达口岸代码（原代码）
     */
    @TableField("ARRIV_PORT_CODE_OLD")
    private String arrivPortCodeOld;

    /**
     * 到达口岸代码（新代码）
     */
    @TableField("ARRIV_PORT_CODE_NEW")
    private String arrivPortCodeNew;

    /**
     * 收货人地址
     */
    @TableField("CONSIGNEE_ADDR")
    @XmlElement(name="ConsigneeAddr")
    private String consigneeAddr;

    /**
     * 发货人代码
     */
    @TableField("CONSIGNOR_CODE")
    @XmlElement(name="ConsignorCode")
    private String consignorCode;

    /**
     * 疫情代码
     */
    @TableField("SITUATION_CODE")
    @XmlElement(name="SituationCode")
    private String situationCode;

    /**
     * 疫情级别
     */
    @TableField("SITUATION_LEVEL")
    @XmlElement(name="SituationLevel")
    private String situationLevel;

    /**
     * 发货人名称（外文）
     */
    @TableField("CONSIGNOR_ENAME")
    @XmlElement(name="ConsignorEname")
    private String consignorEname;

    /**
     * 出入境类别
     */
    @TableField("APL_KIND")
    @XmlElement(name="AplKind")
    private String aplKind;

    /**
     * 分运单号
     */
    @TableField("SPLIT_BILL_LAD_NO")
    @XmlElement(name="SplitBillLadNo")
    private String splitBillLadNo;

    /**
     * 报检地
     */
    @TableField("ORG_CODE")
    @XmlElement(name="OrgCode")
    private String orgCode;

    /**
     * 领证地
     */
    @TableField("VSA_ORG_CODE")
    @XmlElement(name="VsaOrgCode")
    private String vsaOrgCode;

    /**
     * 原集装箱标识
     */
    @TableField("ORIG_BOX_FLAG")
    @XmlElement(name="OrigBoxFlag")
    private String origBoxFlag;

    /**
     * 软件商类型
     */
    @TableField("SOFT_TYPE")
    @XmlElement(name="SoftType")
    private String softType;

    /**
     * 企业组织机构代码
     */
    @TableField("TECH_REG_CODE")
    @XmlElement(name="techRegCode")
    private String techRegCode;

    /**
     * 报检单ID
     */
    @TableField("DECL_ID")
    @XmlElement(name="DeclId")
    private String declId;

    /**
     * 通讯账号名称
     */
    @TableField("SPARE1")
    @XmlElement(name="spare1")
    private String spare1;

    /**
     * 通讯账号密码
     */
    @TableField("SPARE2")
    @XmlElement(name="spare2")
    private String spare2;

    /**
     * 通讯账号认证方式
     */
    @TableField("SPARE3")
    @XmlElement(name="spare3")
    private String spare3;

    /**
     * 通讯证书ID
     */
    @TableField("SPARE4")
    @XmlElement(name="spare4")
    private String spare4;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    /**
     * 检验检疫编号
     */
    @TableField("INSP_NO")
    private String inspNo;

    /**
     * E号
     */
    @TableField("INSP_NO_E")
    private String inspNoE;

    /**
     * 电子底账数据号
     */
    @TableField("CL_BL_NO")
    private String clBlNo;

    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
