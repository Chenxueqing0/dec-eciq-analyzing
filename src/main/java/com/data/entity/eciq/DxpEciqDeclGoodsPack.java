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
 * 出入境包装信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_GOODS_PACK")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclGoodsPack implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 出入境包装信息ID
     */
    @TableField("PACK_ID")
    @XmlElement(name="PackId")
    private String packId;

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
     * 辅助包装材料长
     */
    @TableField("PACK_LENTH")
    @XmlElement(name="PackLenth")
    private String packLenth;

    /**
     * 辅助包装材料高
     */
    @TableField("PACK_HIGH")
    @XmlElement(name="PackHigh")
    private String packHigh;

    /**
     * 辅助包装材料宽
     */
    @TableField("PACK_WIDE")
    @XmlElement(name="PackWide")
    private String packWide;

    /**
     * 辅助包装材料种类
     */
    @TableField(exist = false)
    @XmlElement(name="PackTypeCode")
    private String packTypeCode;

    /**
     * 辅助包装材料种类（原代码）
     */
    @TableField("PACK_TYPE_CODE_OLD")
    private String packTypeCodeOld;

    /**
     * 辅助包装材料种类（新代码）
     */
    @TableField("PACK_TYPE_CODE_NEW")
    private String packTypeCodeNew;

    /**
     * 包装种类名称
     */
    @TableField("PACK_CATG_NAME")
    @XmlElement(name="PackCatgName")
    private String packCatgName;

    /**
     * 包装种类中文简称
     */
    @TableField("PACK_TYPE_SHORT")
    @XmlElement(name="PackTypeShort")
    private String packTypeShort;

    /**
     * 包装件数
     */
    @TableField("PACK_QTY")
    @XmlElement(name="PackQty")
    private String packQty;

    /**
     * 是否主要包装
     */
    @TableField("IS_MAIN_PACK")
    @XmlElement(name="IsMainPack")
    private String isMainPack;

    /**
     * 包装材料种类
     */
    @TableField("MAT_TYPE")
    @XmlElement(name="MatType")
    private String matType;

    /**
     * 加工厂家
     */
    @TableField("PROC_FACTORY")
    @XmlElement(name="ProcFactory")
    private String procFactory;

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
