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
 * 出入境许可证信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_GOODS_LIMIT")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclGoodsLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 出入境许可证ID
     */
    @TableField("LIMIT_ID")
    @XmlElement(name="LimitId")
    private String limitId;

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
     * 许可证类别名称
     */
    @TableField("LIC_NAME")
    @XmlElement(name="LicName")
    private String licName;

    /**
     * 许可证核销明细序号
     */
    @TableField("LIC_WRTOF_DETAIL_NO")
    @XmlElement(name="LicWrtofDetailNo")
    private String licWrtofDetailNo;

    /**
     * 许可证核销数量
     */
    @TableField("LIC_WRTOF_QTY")
    @XmlElement(name="LicWrtofQty")
    private String licWrtofQty;

    /**
     * 许可证核销明细余量
     */
    @TableField("LIC_DETAIL_LEFT")
    @XmlElement(name="LicDetailLeft")
    private String licDetailLeft;

    /**
     * 许可证核销后余量
     */
    @TableField("LIC_WRTOF_LEFT")
    @XmlElement(name="LicWrtofLeft")
    private String licWrtofLeft;

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

    @TableField(exist = false)
    @XmlElement(name = "ITF_DCL_IO_DECL_GOODS_LIMIT_VN")
    private List<DxpEciqDeclGoodsLimitVn> dxpEciqDeclGoodsLimitVnList = new ArrayList<>();

}
