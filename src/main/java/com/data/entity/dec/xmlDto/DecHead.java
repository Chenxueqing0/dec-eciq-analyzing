package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * <p>
 * 报关单表头
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DecHead {


    /**
     * 报关单统一编号
     */
    @XmlElement(name = "SeqNo")
    private String seqNo;

    /**
     * 进出口标志
     */
    @XmlElement(name = "IEFlag")
    private String iEFlag;

    /**
     * 单据类型：属地报关SD；
     */
    @XmlElement(name = "Type")
    private String type;

    /**
     * 申报单位代码
     */
    @XmlElement(name = "agentCode")
    private String agentCode;

    /**
     * 申报单位名称
     */
    @XmlElement(name = "AgentName")
    private String agentName;

    /**
     * 外汇核销单号
     */
    @XmlElement(name = "ApprNo")
    private String apprNo;

    /**
     * 提单号
     */
    @XmlElement(name = "BillNo")
    private String billNo;

    /**
     * 合同号
     */
    @XmlElement(name = "ContrNo")
    private String contrNo;

    /**
     * 主管海关
     */
    @XmlElement(name = "CustomMaster")
    private String customMaster;

    /**
     * 征免性质
     */
    @XmlElement(name = "CutMode")
    private String cutMode;

    /**
     * 装货港
     */
    @XmlElement(name = "DistinatePort")
    private String distinatePort;

    /**
     * 境内目的地
     */
    @XmlElement(name = "DistrictCode")
    private String districtCode;

    /**
     * 运费币制
     */
    @XmlElement(name = "FeeCurr")
    private String feeCurr;

    /**
     * 运费标记
     */
    @XmlElement(name = "FeeMark")
    private String feeMark;

    /**
     * 运费／率
     */
    @XmlElement(name = "FeeRate")
    private String feeRate;

    /**
     * 毛重
     */
    @XmlElement(name = "GrossWet")
    private String grossWet;

    /**
     * 进出日期
     */
    @XmlElement(name = "IEDate")
    private String iEDateStr;

    /**
     * 进出口岸
     */
    @XmlElement(name = "IEPort")
    private String iEPort;

    /**
     * 内销比率11
     */
    @XmlElement(name = "InRatio")
    private String inRatio;

    /**
     * 保险费币制
     */
    @XmlElement(name = "InsurCurr")
    private String insurCurr;

    /**
     * 保险费标记
     */
    @XmlElement(name = "InsurMark")
    private String insurMark;

    /**
     * 保险费／率
     */
    @XmlElement(name = "InsurRate")
    private String insurRate;

    /**
     * 许可证编号
     */
    @XmlElement(name = "LicenseNo")
    private String licenseNo;

    /**
     * 备案号
     */
    @XmlElement(name = "ManualNo")
    private String manualNo;

    /**
     * 净重
     */
    @XmlElement(name = "NetWt")
    private String netWt;

    /**
     * 备注
     */
    @XmlElement(name = "NoteS")
    private String noteS;

    /**
     * 杂费币制
     */
    @XmlElement(name = "OtherCurr")
    private String otherCurr;

    /**
     * 杂费标志
     */
    @XmlElement(name = "OtherMark")
    private String otherMark;

    /**
     * 杂费／率
     */
    @XmlElement(name = "OtherRate")
    private String otherRate;

    /**
     * 货主单位代码
     */
    @XmlElement(name = "OwnerCode")
    private String ownerCode;

    /**
     * 货主单位名称,消费使用单位/生产销售单位
     */
    @XmlElement(name = "OwnerName")
    private String ownerName;

    /**
     * 件数
     */
    @XmlElement(name = "PackNo")
    private String packNo;

    /**
     * 征税比例
     */
    @XmlElement(name = "PayWay")
    private String payWay;

    /**
     * 纳税单位
     */
    @XmlElement(name = "PaymentMark")
    private String paymentMark;

    /**
     * 经营单位编号
     */
    @XmlElement(name = "TradeCode")
    private String tradeCode;

    /**
     * 启运国
     */
    @XmlElement(name = "TradeCountry")
    private String tradeCountry;

    /**
     * 贸易方式
     */
    @XmlElement(name = "TradeMode")
    private String tradeMode;

    /**
     * 经营单位名称,收发货人
     */
    @XmlElement(name = "TradeName")
    private String tradeName;

    /**
     * 运输方式代码
     */
    @XmlElement(name = "TrafMode")
    private String trafMode;

    /**
     * 运输工具代码及名称
     */
    @XmlElement(name = "TrafName")
    private String trafName;

    /**
     * 成交方式
     */
    @XmlElement(name = "TransMode")
    private String transMode;

    /**
     * 包装种类
     */
    @XmlElement(name = "WrapType")
    private String wrapType;

    /**
     * 海关编号
     */
    @XmlElement(name = "EntryId")
    private String entryId;

    /**
     * 预录入编号
     */
    @XmlElement(name = "PreEntryId")
    private String preEntryId;

    /**
     * 录入单位名称;首次进行暂存操作的企业
     */
    @XmlElement(name = "CopName")
    private String copName;

    /**
     * 录入单位代码;首次进行暂存操作的IC卡企业组织机构编码
     */
    @XmlElement(name = "CopCode")
    private String copCode;

    /**
     * 报关单类型
     */
    @XmlElement(name = "EntryType")
    private String entryType;

    /**
     * 首次进行暂存操作的系统时间
     */
    @XmlElement(name = "InputDate")
    private String inputDateStr;

    /**
     * 录入员IC卡号
     */
    @XmlElement(name = "TypistNo")
    private String typistNo;

    /**
     * 录入员姓名
     */
    @XmlElement(name = "InputerName")
    private String inputerName;

    /**
     * 报关/转关关系标志。0：一般报关；1：转关运输提前报关
     */
    @XmlElement(name = "DeclTrnRel")
    private String declTrnRel;

    /**
     * 担保验放:1:是；0否
     */
    @XmlElement(name = "ChkSurety")
    private String chkSurety;

    /**
     * 自贸区特有的类型：1：普通备案清单2：先进区后报关3：分送集报备案清单4；分送集报报关单
     */
    @XmlElement(name = "BillType")
    private String billType;

    /**
     * 申报单位统一代码
     */
    @XmlElement(name = "AgentCodeScc")
    private String agentCodeScc;

    /**
     * 货主单位统一代码
     */
    @XmlElement(name = "OwnerCodeScc")
    private String ownerCodeScc;

    /**
     * 经营单位统一代码
     */
    @XmlElement(name = "TradeCodeScc")
    private String tradeCodeScc;

    /**
     * 录入单位统一代码;首次进行暂存操作的IC卡企业组织机构编码和18位统一编码（统一编码可空）
     */
    @XmlElement(name = "CopCodeScc")
    private String copCodeScc;

    /**
     * 1-勾选 0-未选1、特殊关系确认2、价格影响确认3、支付特许权使用费确认
     */
    @XmlElement(name = "PromiseItmes")
    private String promiseItmes;

    /**
     * 贸易国别
     */
    @XmlElement(name = "TradeAreaCode")
    private String tradeAreaCode;

    /**
     * 查验分流:1:表示是查验分流；0:表示不是查验分流
     */
    @XmlElement(name = "CheckFlow")
    private String checkFlow;

    /**
     * 航次号
     */
    @XmlElement(name = "VoyNo")
    private String voyNo;


}
