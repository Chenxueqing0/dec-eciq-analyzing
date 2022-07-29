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
 * 报关单表体
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_LIST")
public class DxpDecList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 海关统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;

    /**
     * 归类标志
     */
    @TableField("CLASS_MARK")
    private String classMark;

    /**
     * 商品编号
     */
    @TableField("CODE_TS")
    private String codeTs;

    /**
     * 备案序号
     */
    @TableField("CONTR_ITEM")
    private String contrItem;

    /**
     * 申报单价
     */
    @TableField("DECL_PRICE")
    private String declPrice;

    /**
     * 征减免税方式
     */
    @TableField("DUTY_MODE")
    private String dutyMode;

    /**
     * 申报计量单位与法定单位比例因子
     */
    @TableField("FACTOR")
    private String factor;

    /**
     * 商品规格、型号
     */
    @TableField("G_MODEL")
    private String gModel;

    /**
     * 商品名称
     */
    @TableField("G_NAME")
    private String gName;

    /**
     * 商品序号
     */
    @TableField("G_NO")
    private String gNo;

    /**
     * 原产地
     */
    @TableField("ORIGIN_COUNTRY")
    private String originCountry;

    /**
     * 成交币制
     */
    @TableField("TRADE_CURR")
    private String tradeCurr;

    /**
     * 申报总价
     */
    @TableField("DECL_TOTAL")
    private String declTotal;

    /**
     * 申报数量（成交计量单位）
     */
    @TableField("G_QTY")
    private String gQty;

    /**
     * 第一法定数量
     */
    @TableField("FIRST_QTY")
    private String firstQty;

    /**
     * 第二法定数量
     */
    @TableField("SECOND_QTY")
    private String secondQty;

    /**
     * 申报计量单位
     */
    @TableField("G_UNIT")
    private String gUnit;

    /**
     * 第一计量单位
     */
    @TableField("FIRST_UNIT")
    private String firstUnit;

    /**
     * 第二计量单位
     */
    @TableField("SECOND_UNIT")
    private String secondUnit;

    /**
     * 用途/生产厂家
     */
    @TableField("USE_TO")
    private String useTo;

    /**
     * 工缴费
     */
    @TableField("WORK_USD")
    private String workUsd;

    /**
     * 货号
     */
    @TableField("EXG_NO")
    private String exgNo;

    /**
     * 版本号
     */
    @TableField("EXG_VERSION")
    private String exgVersion;

    /**
     * 最终目的国（地区）
     */
    @TableField("DESTINATION_COUNTRY")
    private String destinationCountry;

    /**
     * 扩展字段
     */
    @TableField("FIELD1")
    private String field1;

    /**
     * 扩展字段
     */
    @TableField("FIELD2")
    private String field2;

    /**
     * 扩展字段
     */
    @TableField("FIELD3")
    private String field3;

    /**
     * 扩展字段
     */
    @TableField("FIELD4")
    private String field4;

    /**
     * 扩展字段
     */
    @TableField("FIELD5")
    private String field5;

    /**
     * 扩展字段
     */
    @TableField("FIELD6")
    private String field6;

    /**
     * 扩展字段
     */
    @TableField("FIELD7")
    private String field7;

    /**
     * 扩展字段
     */
    @TableField("FIELD8")
    private String field8;

    /**
     * 扩展字段
     */
    @TableField("FIELD9")
    private String field9;

    /**
     * 扩展字段
     */
    @TableField("FIELD10")
    private String field10;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    /**
     * 原产地（旧代码）
     */
    @TableField("ORIGIN_COUNTRY_OLD")
    private String originCountryOld;

    /**
     * 成交币制（旧代码）
     */
    @TableField("TRADE_CURR_OLD")
    private String tradeCurrOld;

    /**
     * 最终目的国（地区）（旧代码）
     */
    @TableField("DESTINATION_COUNTRY_OLD")
    private String destinationCountryOld;
    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
