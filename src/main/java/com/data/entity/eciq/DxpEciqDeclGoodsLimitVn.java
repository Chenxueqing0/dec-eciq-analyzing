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
 * 出入境许可证VIN信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_GOODS_LIMIT_VN")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclGoodsLimitVn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 出入境许可证VIN信息ID
     */
    @TableField("LIMIT_VIN_ID")
    @XmlElement(name="LimitVinId")
    private String limitVinId;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    @XmlElement(name="EntDeclNo")
    private String entDeclNo;

    /**
     * 出入境许可证ID
     */
    @TableField("LIMIT_ID")
    @XmlElement(name="LimitId")
    private String limitId;

    /**
     * 许可证类别代码
     */
    @TableField("LIC_TYPE_CODE")
    @XmlElement(name="LicTypeCode")
    private String licTypeCode;

    /**
     * 许可证编号
     */
    @TableField("LICENCE_NO")
    @XmlElement(name="LicenceNo")
    private String licenceNo;

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
     * VIN序号
     */
    @TableField("VIN_NO")
    @XmlElement(name="VinNo")
    private String vinNo;

    /**
     * 提/运单日期
     */
    @TableField(exist = false)
    @XmlElement(name="BillLadDate")
    private String billLadDateStr;

    /**
     * 提/运单日期
     */
    @TableField("BILL_LAD_DATE")
    private LocalDateTime billLadDate;

    /**
     * 质量保质期
     */
    @TableField("QUALITY_QGP")
    @XmlElement(name="QualityQgp")
    private String qualityQgp;

    /**
     * 发动机号或电机号
     */
    @TableField("MOTOR_NO")
    @XmlElement(name="MotorNo")
    private String motorNo;

    /**
     * 车辆识别代码（VIN）
     */
    @TableField("VIN_CODE")
    @XmlElement(name="VinCode")
    private String vinCode;

    /**
     * 底盘(车架)号
     */
    @TableField("CHASSIS_NO")
    @XmlElement(name="ChassisNo")
    private String chassisNo;

    /**
     * 发票所列数量
     */
    @TableField("INVOICE_NUM")
    @XmlElement(name="InvoiceNum")
    private String invoiceNum;

    /**
     * 单价
     */
    @TableField("PRICE_PER_UNIT")
    @XmlElement(name="PricePerUnit")
    private String pricePerUnit;

    /**
     * 品名（中文名称）
     */
    @TableField("PROD_CNNM")
    @XmlElement(name="ProdCnnm")
    private String prodCnnm;

    /**
     * 品名（英文名称）
     */
    @TableField("PROD_ENNM")
    @XmlElement(name="ProdEnnm")
    private String prodEnnm;

    /**
     * 型号(英文)
     */
    @TableField("MODEL_EN")
    @XmlElement(name="ModelEn")
    private String modelEn;

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
