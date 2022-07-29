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
 * 出入境报检标记号码附件
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_MARK_LOB")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclMarkLob implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 标记号码ID
     */
    @TableField("MARK_ID")
    @XmlElement(name="MarkId")
    private String markId;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    @XmlElement(name="EntDeclNo")
    private String entDeclNo;

    /**
     * 附件名称
     */
    @TableField("ATTACH_NAME")
    @XmlElement(name="AttachName")
    private String attachName;

    /**
     * 附件类型
     */
    @TableField("ATTACH_TYPE")
    @XmlElement(name="AttachType")
    private String attachType;

    /**
     * 附件路径
     */
    @TableField(exist = false)
    @XmlElement(name="Attachment")
    private String attachment;

    /**
     * 附件路径
     */
    @TableField("ATTACHMENT_PATH")
    private String attachmentPath;

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
