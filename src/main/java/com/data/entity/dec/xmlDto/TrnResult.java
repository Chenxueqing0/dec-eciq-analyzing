package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 转关单回执
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@XmlRootElement(name="TRN_RESULT")
@Data
public class TrnResult {

    /**
     * 报关单数据中心统一编号
     */
    @XmlElement(name = "CUS_CIQ_NO")
    private String cusCiqNo;

    /**
     * 转关单统一编号
     */
    @XmlElement(name = "SP_TRN_SEQ_NO")
    private String spTrnSeqNo;

    /**
     * 转关申报单编号
     */
    @XmlElement(name = "TRANS_DCL_NO")
    private String transDclNo;

    /**
     * 提运单号
     */
    @XmlElement(name = "BILL_NO")
    private String billNo;

    /**
     * 回执通知日期
     */
    @XmlElement(name = "RESULT_NTC_DATE")
    private String resultNtcDate;

    /**
     * 处理结果
     */
    @XmlElement(name = "PROC_RESULT")
    private String procResult;

    /**
     * 备注
     */
    @XmlElement(name = "NOTE")
    private String note;


}
