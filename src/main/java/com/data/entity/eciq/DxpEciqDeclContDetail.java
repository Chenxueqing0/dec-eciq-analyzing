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
 * 出入境集装箱号明细
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_CONT_DETAIL")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclContDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 集装箱号明细表ID
     */
    @TableField("CONT_DT_ID")
    @XmlElement(name="")
    private String contDtId;

    /**
     * 出入境集装箱信息ID
     */
    @TableField("CONT_ID")
    @XmlElement(name="")
    private String contId;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    @XmlElement(name="EntDeclNo")
    private String entDeclNo;

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
     * 拼箱标识
     */
    @TableField("LCL_FLAG")
    @XmlElement(name="LclFlag")
    private String lclFlag;

    /**
     * 集装箱箱号串
     */
    @TableField("CONT_NO")
    @XmlElement(name="ContNo")
    private String contNo;

    /**
     * 序号
     */
    @TableField("SEQ_NO")
    @XmlElement(name="SeqNo")
    private String seqNo;

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
