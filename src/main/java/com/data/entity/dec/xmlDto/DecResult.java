package com.data.entity.dec.xmlDto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报关回执
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlRootElement(name = "DEC_RESULT")
@XmlAccessorType(XmlAccessType.FIELD)
public class DecResult {

    @XmlElement(name = "CUS_CIQ_NO")
    private String cusCiqNo;

    /**
     * 海关编号
     */
    @XmlElement(name = "ENTRY_ID")
    private String entryId;

    /**
     * 通知时间
     */
    @XmlElement(name = "NOTICE_DATE")
    private String noticeDateStr;

    /**
     * 通道
     */
    @XmlElement(name = "CHANNEL")
    private String channel;

    /**
     * 备注
     */
    @XmlElement(name = "NOTE")
    private String note;

    /**
     * 主管海关
     */
    @XmlElement(name = "CUSTOM_MASTER")
    private String customMaster;

    @XmlElement(name = "I_E_DATE")
    private String iEDateStr;

    @XmlElement(name = "D_DATE")
    private String dDate;


}
