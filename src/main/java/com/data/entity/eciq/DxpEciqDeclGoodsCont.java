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
 * 出入境货物与集装箱关联信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_GOODS_CONT")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclGoodsCont implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 出入境货物与集装箱关联ID
     */
    @TableField("GOODS_CONT_ID")
    @XmlElement(name="GoodsContId")
    private String goodsContId;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    @XmlElement(name="EntDeclNo")
    private String entDeclNo;

    /**
     * 货物ID
     */
    @TableField("GOODS_ID")
    @XmlElement(name="GoodsId")
    private String goodsId;

    /**
     * 货物序号
     */
    @TableField("GOODS_NO")
    @XmlElement(name="GoodsNo")
    private String goodsNo;

    /**
     * 集装箱规格代码
     */
    @TableField(exist = false)
    @XmlElement(name="CntnrModeCode")
    private String cntnrModeCode;

    /**
     * 集装箱规格代码（原代码）
     */
    @TableField("CNTNR_MODE_CODE_OLD")
    private String cntnrModeCodeOld;

    /**
     * 集装箱规格代码（新代码）
     */
    @TableField("CNTNR_MODE_CODE_NEW")
    private String cntnrModeCodeNew;

    /**
     * 集装箱号码
     */
    @TableField("CONT_CODE")
    @XmlElement(name="ContCode")
    private String contCode;

    /**
     * HS编号
     */
    @TableField("PROD_HS_CODE")
    @XmlElement(name="ProdHsCode")
    private String prodHsCode;

    /**
     * 数量
     */
    @TableField("QTY")
    @XmlElement(name="Qty")
    private String qty;

    /**
     * 数量计量单位
     */
    @TableField("QTY_MEAS_UNIT")
    @XmlElement(name="QtyMeasUnit")
    private String qtyMeasUnit;

    /**
     * 重量
     */
    @TableField("WEIGHT")
    @XmlElement(name="Weight")
    private String weight;

    /**
     * 重量计量单位
     */
    @TableField("WT_UNIT_CODE")
    @XmlElement(name="WtUnitCode")
    private String wtUnitCode;

    /**
     * 标准计量单位
     */
    @TableField("STD_MEAS_UNIT")
    @XmlElement(name="StdMeasUnit")
    private String stdMeasUnit;

    /**
     * 标准计量单位数量
     */
    @TableField("STD_MEAS_UNIT_QYT")
    @XmlElement(name="StdMeasUnitQyt")
    private String stdMeasUnitQyt;

    /**
     * 运输工具类型代码
     */
    @TableField("TRANS_MEANS_TYPE")
    @XmlElement(name="TransMeansType")
    private String transMeansType;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
