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
 * 出入境随附单据信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_ATT")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclAtt implements Serializable {

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
     * 随附单据信息
     */
    @TableField("ATT_ID")
    @XmlElement(name="AttId")
    private String attId;

    /**
     * 随附单据类别代码
     */
    @TableField("ATT_DOC_TYPE_CODE")
    @XmlElement(name="AttDocTypeCode")
    private String attDocTypeCode;

    /**
     * 随附单据编号
     */
    @TableField("ATT_DOC_NO")
    @XmlElement(name="AttDocNo")
    private String attDocNo;

    /**
     * 随附单据名称
     */
    @TableField("ATT_DOC_NAME")
    @XmlElement(name="AttDocName")
    private String attDocName;

    /**
     * 随附单据核销货物序号
     */
    @TableField("ATT_DOC_WRTOF_DETAIL_NO")
    @XmlElement(name="AttDocWrtofDetailNo")
    private String attDocWrtofDetailNo;

    /**
     * 随附单据核销数量
     */
    @TableField("ATT_DOC_WRTOF_QTY")
    @XmlElement(name="AttDocWrtofQty")
    private String attDocWrtofQty;

    /**
     * 随附单据核销后明细余量
     */
    @TableField("ATT_DOC_DETAIL_LEFT")
    @XmlElement(name="AttDocDetailLeft")
    private String attDocDetailLeft;

    /**
     * 随附单据核销后余量
     */
    @TableField("ATT_DOC_WRTOF_LEFT")
    @XmlElement(name="AttDocWrtofLeft")
    private String attDocWrtofLeft;

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
