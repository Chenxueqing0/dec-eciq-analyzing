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
 * 企业资质信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_LIMIT")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclLimit implements Serializable {

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
     * 企业资质信息ID
     */
    @TableField("DECL_LIMIT_ID")
    @XmlElement(name="DeclLimitId")
    private String declLimitId;

    /**
     * 企业资质编号
     */
    @TableField("ENT_QUALIF_NO")
    @XmlElement(name="EntQualifNo")
    private String entQualifNo;

    /**
     * 企业资质类别代码
     */
    @TableField("ENT_QUALIF_TYPE_CODE")
    @XmlElement(name="EntQualifTypeCode")
    private String entQualifTypeCode;

    /**
     * 企业资质类别名称
     */
    @TableField("ENT_QUALIF_NAME")
    @XmlElement(name="EntQualifName")
    private String entQualifName;

    /**
     * 操作时间
     */
    @TableField("OPER_TIME")
    @XmlElement(name="OperTime")
    private String operTime;

    /**
     * 企业组织机构代码
     */
    @TableField("ENT_ORG_CODE")
    @XmlElement(name="EntOrgCode")
    private String entOrgCode;

    /**
     * 归档标志
     */
    @TableField("FALG_ARCHIVE")
    @XmlElement(name="FalgArchive")
    private String falgArchive;

    /**
     * 企业名称
     */
    @TableField("ENT_NAME")
    @XmlElement(name="EntName")
    private String entName;

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
