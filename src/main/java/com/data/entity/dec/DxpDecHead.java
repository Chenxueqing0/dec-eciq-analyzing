package com.data.entity.dec;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 报关单表头
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_HEAD")
public class DxpDecHead implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 报关单统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;

    /**
     * 进出口标志
     */
    @TableField("I_E_FLAG")
    private String iEFlag;

    /**
     * 单据类型：属地报关SD；
     */
    @TableField("TYPE")
    private String type;

    /**
     * 申报单位代码
     */
    @TableField("AGENT_CODE")
    private String agentCode;

    /**
     * 申报单位名称
     */
    @TableField("AGENT_NAME")
    private String agentName;

    /**
     * 外汇核销单号
     */
    @TableField("APPR_NO")
    private String apprNo;

    /**
     * 提单号
     */
    @TableField("BILL_NO")
    private String billNo;

    /**
     * 合同号
     */
    @TableField("CONTR_NO")
    private String contrNo;

    /**
     * 主管海关
     */
    @TableField("CUSTOM_MASTER")
    private String customMaster;

    /**
     * 征免性质
     */
    @TableField("CUT_MODE")
    private String cutMode;

    /**
     * 装货港
     */
    @TableField("DISTINATE_PORT")
    private String distinatePort;

    /**
     * 境内目的地
     */
    @TableField("DISTRICT_CODE")
    private String districtCode;

    /**
     * 运费币制
     */
    @TableField("FEE_CURR")
    private String feeCurr;

    /**
     * 运费标记
     */
    @TableField("FEE_MARK")
    private String feeMark;

    /**
     * 运费／率
     */
    @TableField("FEE_RATE")
    private String feeRate;

    /**
     * 毛重
     */
    @TableField("GROSS_WET")
    private String grossWet;

    /**
     * 进出日期
     */
    @TableField("I_E_DATE")
    private LocalDateTime iEDate;

    /**
     * 进出口岸
     */
    @TableField("I_E_PORT")
    private String iEPort;

    /**
     * 内销比率11
     */
    @TableField("IN_RATIO")
    private String inRatio;

    /**
     * 保险费币制
     */
    @TableField("INSUR_CURR")
    private String insurCurr;

    /**
     * 保险费标记
     */
    @TableField("INSUR_MARK")
    private String insurMark;

    /**
     * 保险费／率
     */
    @TableField("INSUR_RATE")
    private String insurRate;

    /**
     * 许可证编号
     */
    @TableField("LICENSE_NO")
    private String licenseNo;

    /**
     * 备案号
     */
    @TableField("MANUAL_NO")
    private String manualNo;

    /**
     * 净重
     */
    @TableField("NET_WT")
    private String netWt;

    /**
     * 备注
     */
    @TableField("NOTE_S")
    private String noteS;

    /**
     * 杂费币制
     */
    @TableField("OTHER_CURR")
    private String otherCurr;

    /**
     * 杂费标志
     */
    @TableField("OTHER_MARK")
    private String otherMark;

    /**
     * 杂费／率
     */
    @TableField("OTHER_RATE")
    private String otherRate;

    /**
     * 货主单位代码
     */
    @TableField("OWNER_CODE")
    private String ownerCode;

    /**
     * 货主单位名称,消费使用单位/生产销售单位
     */
    @TableField("OWNER_NAME")
    private String ownerName;

    /**
     * 件数
     */
    @TableField("PACK_NO")
    private String packNo;

    /**
     * 征税比例
     */
    @TableField("PAY_WAY")
    private String payWay;

    /**
     * 纳税单位
     */
    @TableField("PAYMENT_MARK")
    private String paymentMark;

    /**
     * 经营单位编号
     */
    @TableField("TRADE_CODE")
    private String tradeCode;

    /**
     * 启运国
     */
    @TableField("TRADE_COUNTRY")
    private String tradeCountry;

    /**
     * 贸易方式
     */
    @TableField("TRADE_MODE")
    private String tradeMode;

    /**
     * 经营单位名称,收发货人
     */
    @TableField("TRADE_NAME")
    private String tradeName;

    /**
     * 运输方式代码
     */
    @TableField("TRAF_MODE")
    private String trafMode;

    /**
     * 运输工具代码及名称
     */
    @TableField("TRAF_NAME")
    private String trafName;

    /**
     * 成交方式
     */
    @TableField("TRANS_MODE")
    private String transMode;

    /**
     * 包装种类
     */
    @TableField("WRAP_TYPE")
    private String wrapType;

    /**
     * 海关编号
     */
    @TableField("ENTRY_ID")
    private String entryId;

    /**
     * 预录入编号
     */
    @TableField("PRE_ENTRY_ID")
    private String preEntryId;

    /**
     * 录入单位名称;首次进行暂存操作的企业
     */
    @TableField("COP_NAME")
    private String copName;

    /**
     * 录入单位代码;首次进行暂存操作的IC卡企业组织机构编码
     */
    @TableField("COP_CODE")
    private String copCode;

    /**
     * 报关单类型
     */
    @TableField("ENTRY_TYPE")
    private String entryType;

    /**
     * 首次进行暂存操作的系统时间
     */
    @TableField("INPUT_DATE")
    private LocalDateTime inputDate;

    /**
     * 录入员IC卡号
     */
    @TableField("TYPIST_NO")
    private String typistNo;

    /**
     * 录入员姓名
     */
    @TableField("INPUTER_NAME")
    private String inputerName;

    /**
     * 报关/转关关系标志。0：一般报关；1：转关运输提前报关
     */
    @TableField("DECL_TRN_REL")
    private String declTrnRel;

    /**
     * 担保验放:1:是；0否
     */
    @TableField("CHK_SURETY")
    private String chkSurety;

    /**
     * 自贸区特有的类型：1：普通备案清单2：先进区后报关3：分送集报备案清单4；分送集报报关单
     */
    @TableField("BILL_TYPE")
    private String billType;

    /**
     * 申报单位统一代码
     */
    @TableField("AGENT_CODE_SCC")
    private String agentCodeScc;

    /**
     * 货主单位统一代码
     */
    @TableField("OWNER_CODE_SCC")
    private String ownerCodeScc;

    /**
     * 经营单位统一代码
     */
    @TableField("TRADE_CODE_SCC")
    private String tradeCodeScc;

    /**
     * 录入单位统一代码;首次进行暂存操作的IC卡企业组织机构编码和18位统一编码（统一编码可空）
     */
    @TableField("COP_CODE_SCC")
    private String copCodeScc;

    /**
     * 1-勾选 0-未选1、特殊关系确认2、价格影响确认3、支付特许权使用费确认
     */
    @TableField("PROMISE_ITMES")
    private String promiseItmes;

    /**
     * 贸易国别
     */
    @TableField("TRADE_AREA_CODE")
    private String tradeAreaCode;

    /**
     * 查验分流:1:表示是查验分流；0:表示不是查验分流
     */
    @TableField("CHECK_FLOW")
    private String checkFlow;

    /**
     * 航次号
     */
    @TableField("VOY_NO")
    private String voyNo;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    /**
     * 结关日期
     */
    @TableField("CLEARANCE_DATE")
    private LocalDateTime clearanceDate;

    /**
     * 放行日期
     */
    @TableField("RELEASE_DATE")
    private LocalDateTime releaseDate;

    /**
     * 更新放行结关日期的时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 查验日期
     */
    @TableField("CHECK_DATE")
    private LocalDateTime checkDate;

    @TableField("FIELD1")
    private String field1;

    @TableField("FIELD2")
    private String field2;

    @TableField("FIELD3")
    private String field3;

    @TableField("FIELD4")
    private String field4;

    @TableField("FIELD5")
    private String field5;

    @TableField("FIELD6")
    private String field6;

    @TableField("FIELD7")
    private String field7;

    @TableField("FIELD8")
    private String field8;

    @TableField("FIELD9")
    private String field9;

    @TableField("FIELD10")
    private String field10;

    /**
     * 启运国(旧代码)
     */
    @TableField("TRADE_COUNTRY_OLD")
    private String tradeCountryOld;

    /**
     * 贸易国别(旧代码)
     */
    @TableField("TRADE_AREA_CODE_OLD")
    private String tradeAreaCodeOld;

    /**
     * 装货港(旧代码)
     */
    @TableField("DISTINATE_PORT_OLD")
    private String distinatePortOld;

    /**
     * 包装种类(旧代码)
     */
    @TableField("WRAP_TYPE_OLD")
    private String wrapTypeOld;

    /**
     * 运费币制(旧代码)
     */
    @TableField("FEE_CURR_OLD")
    private String feeCurrOld;

    /**
     * 保险费币制(旧代码)
     */
    @TableField("INSUR_CURR_OLD")
    private String insurCurrOld;

    /**
     * 杂费币制(旧代码)
     */
    @TableField("OTHER_CURR_OLD")
    private String otherCurrOld;

    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
