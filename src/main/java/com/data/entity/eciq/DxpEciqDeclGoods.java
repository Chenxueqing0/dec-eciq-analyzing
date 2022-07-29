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
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 出入境货物产品信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_GOODS")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclGoods implements Serializable {

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
     * 单价
     */
    @TableField("PRICE_PER_UNIT")
    @XmlElement(name="PricePerUnit")
    private String pricePerUnit;

    /**
     * HS编号
     */
    @TableField("PROD_HS_CODE")
    @XmlElement(name="ProdHsCode")
    private String prodHsCode;

    /**
     * HS编码描述
     */
    @TableField("HS_CODE_DESC")
    @XmlElement(name="HsCodeDesc")
    private String hsCodeDesc;

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
    @TableField("WT_MEAS_UNIT")
    @XmlElement(name="WtMeasUnit")
    private String wtMeasUnit;

    /**
     * 备用一
     */
    @TableField("BY1")
    @XmlElement(name="By1")
    private String by1;

    /**
     * 备用二
     */
    @TableField("BY2")
    @XmlElement(name="By2")
    private String by2;

    /**
     * CIQ代码
     */
    @TableField("CIQ_CODE")
    @XmlElement(name="CiqCode")
    private String ciqCode;

    /**
     * CIQ名称
     */
    @TableField("CIQ_NAME")
    @XmlElement(name="CiqName")
    private String ciqName;

    /**
     * 币种代码
     */
    @TableField(exist = false)
    @XmlElement(name="Currency")
    private String currency;

    /**
     * 币种代码（原代码）
     */
    @TableField("CURRENCY_OLD")
    private String currencyOld;

    /**
     * 币种代码（新代码）
     */
    @TableField("CURRENCY_NEW")
    private String currencyNew;

    /**
     * 危险货物名称
     */
    @TableField("DANG_NAME")
    @XmlElement(name="DangName")
    private String dangName;

    /**
     * 申报货物名称（中文）
     */
    @TableField("DECL_GOODS_CNAME")
    @XmlElement(name="DeclGoodsCname")
    private String declGoodsCname;

    /**
     * 申报货物名称（外文）
     */
    @TableField("DECL_GOODS_ENAME")
    @XmlElement(name="DeclGoodsEname")
    private String declGoodsEname;

    /**
     * 境外生产企业名称
     */
    @TableField("ENG_MAN_ENT_CNM")
    @XmlElement(name="EngManEntCnm")
    private String engManEntCnm;

    /**
     * 货物属性代码
     */
    @TableField("GOODS_ATTR")
    @XmlElement(name="GoodsAttr")
    private String goodsAttr;

    /**
     * 货物品牌
     */
    @TableField("GOODS_BRAND")
    @XmlElement(name="GoodsBrand")
    private String goodsBrand;

    /**
     * 货物型号
     */
    @TableField("GOODS_MODEL")
    @XmlElement(name="GoodsModel")
    private String goodsModel;

    /**
     * 货物规格
     */
    @TableField("GOODS_SPEC")
    @XmlElement(name="GoodsSpec")
    private String goodsSpec;

    /**
     * 货物总值
     */
    @TableField("GOODS_TOTAL_VAL")
    @XmlElement(name="GoodsTotalVal")
    private String goodsTotalVal;

    /**
     * 检验检疫类别
     */
    @TableField("INSP_TYPE")
    @XmlElement(name="InspType")
    private String inspType;

    /**
     * 生产单位名称
     */
    @TableField("MNUFCTR_REG_NAME")
    @XmlElement(name="MnufctrRegName")
    private String mnufctrRegName;

    /**
     * 生产单位注册号
     */
    @TableField("MNUFCTR_REG_NO")
    @XmlElement(name="MnufctrRegNo")
    private String mnufctrRegNo;

    /**
     * 非危险化学品
     */
    @TableField("NO_DANG_FLAG")
    @XmlElement(name="NoDangFlag")
    private String noDangFlag;

    /**
     * 原产国/地区
     */
    @TableField(exist = false)
    @XmlElement(name="OriCtryCode")
    private String oriCtryCode;

    /**
     * 原产国/地区（原代码）
     */
    @TableField("ORI_CTRY_CODE_OLD")
    private String oriCtryCodeOld;

    /**
     * 原产国/地区（新代码）
     */
    @TableField("ORI_CTRY_CODE_NEW")
    private String oriCtryCodeNew;

    /**
     * 原产地区代码
     */
    @TableField(exist = false)
    @XmlElement(name="OrigPlaceCode")
    private String origPlaceCode;

    /**
     * 原产地区代码（原代码）
     */
    @TableField("ORIG_PLACE_CODE_OLD")
    private String origPlaceCodeOld;

    /**
     * 原产地区代码（新代码）
     */
    @TableField("ORIG_PLACE_CODE_NEW")
    private String origPlaceCodeNew;

    /**
     * 危包规格
     */
    @TableField("PACK_SPEC")
    @XmlElement(name="PackSpec")
    private String packSpec;

    /**
     * 危包类别
     */
    @TableField("PACK_TYPE")
    @XmlElement(name="PackType")
    private String packType;

    /**
     * 生产批号
     */
    @TableField("PROD_BATCH_NO")
    @XmlElement(name="ProdBatchNo")
    private String prodBatchNo;

    /**
     * 产品保质期
     */
    @TableField("PROD_QGP")
    @XmlElement(name="ProdQgp")
    private String prodQgp;

    /**
     * 产品有效期
     */
    @TableField("PROD_VALID_DT")
    @XmlElement(name="ProdValidDt")
    private String prodValidDt;

    /**
     * 生产日期
     */
    @TableField("PRODUCE_DATE")
    @XmlElement(name="ProduceDate")
    private String produceDate;

    /**
     * 用途代码
     */
    @TableField("PURPOSE")
    @XmlElement(name="Purpose")
    private String purpose;

    /**
     * 标准数量
     */
    @TableField("STD_QTY")
    @XmlElement(name="StdQty")
    private String stdQty;

    /**
     * 标准数量单位
     */
    @TableField("STD_QTY_UNIT_CODE")
    @XmlElement(name="StdQtyUnitCode")
    private String stdQtyUnitCode;

    /**
     * 标准重量
     */
    @TableField("STD_WEIGHT")
    @XmlElement(name="StdWeight")
    private String stdWeight;

    /**
     * 标准重量单位
     */
    @TableField("STD_WEIGHT_UNIT_CODE")
    @XmlElement(name="StdWeightUnitCode")
    private String stdWeightUnitCode;

    /**
     * 成份/原料/组份
     */
    @TableField("STUFF")
    @XmlElement(name="Stuff")
    private String stuff;

    /**
     * UN编码
     */
    @TableField("UN_CODE")
    @XmlElement(name="UnCode")
    private String unCode;

    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    @TableField(exist = false)
    @XmlElement(name = "ITF_DCL_IO_DECL_GOODS_CONT")
    private List<DxpEciqDeclGoodsCont> dxpEciqDeclGoodsContList = new ArrayList<>();

    @TableField(exist = false)
    @XmlElement(name = "ITF_DCL_IO_DECL_GOODS_LIMIT")
    private List<DxpEciqDeclGoodsLimit> dxpEciqDeclGoodsLimitList = new ArrayList<>();

    @TableField(exist = false)
    @XmlElement(name = "ITF_DCL_IO_DECL_GOODS_PACK")
    private List<DxpEciqDeclGoodsPack> dxpEciqDeclGoodsPackList = new ArrayList<>();


}
