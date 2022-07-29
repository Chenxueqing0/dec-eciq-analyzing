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
 * 检验检疫回执
 * </p>
 *
 * @author ps
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@XmlAccessorType(XmlAccessType.FIELD)
@TableName("DXP_ECIQ_DECL_RESULT")
public class DxpEciqDeclResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 企业报检号
     */
    @XmlElement(name="CusCiqNo")
    @TableField("CUS_CIQ_NO")
    private String cusCiqNo;

    /**
     * 检验检疫编号/检验检疫申请号
     */
    @XmlElement(name="EntDealNo")
    @TableField("ENT_DEAL_NO")
    private String entDealNo;

    /**
     * 电子底账数据号
     */
    @XmlElement(name="ClBlNo")
    @TableField("CL_BL_NO")
    private String clBlNo;

    @XmlElement(name="OperTime")
    @TableField(exist = false)
    private String operTimeStr;

    @TableField("OPER_TIME")
    private LocalDateTime operTime;

    /**
     * 代码
     */
    @XmlElement(name="RspCodes")
    @TableField("RSP_CODES")
    private String rspCodes;

    /**
     * 描述
     */
    @XmlElement(name="RspInfo")
    @TableField("RSP_INFO")
    private String rspInfo;

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
