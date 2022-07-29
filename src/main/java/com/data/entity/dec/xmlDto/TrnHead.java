package com.data.entity.dec.xmlDto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 转关单表头
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class TrnHead {


    /**
     * 转关单统一编号
     */
    @XmlElement(name = "TrnPreId")
    private String trnPreId;

    /**
     * 南方模式中的载货清单号
     */
    @XmlElement(name = "TransNo")
    private String transNo;

    /**
     * 转关申报单号
     */
    @XmlElement(name = "TurnNo")
    private String turnNo;

    /**
     * 境内运输方式
     */
    @XmlElement(name = "NativeTrafMode")
    private String nativeTrafMode;

    /**
     * 境内运输工具编号
     */
    @XmlElement(name = "TrafCustomsNo")
    private String trafCustomsNo;

    /**
     * 境内运输工具名称
     */
    @XmlElement(name = "NativeShipName")
    private String nativeShipName;

    /**
     * 境内运输工具航次
     */
    @XmlElement(name = "NativeVoyageNo")
    private String nativeVoyageNo;

    /**
     * 承运单位名称
     */
    @XmlElement(name = "ContractorName")
    private String contractorName;

    /**
     * 承运单位组织机构代码
     */
    @XmlElement(name = "ContractorCode")
    private String contractorCode;

    /**
     * 转关类型：1—转关提前； AA—出口二次转关
     */
    @XmlElement(name = "TransFlag")
    private String transFlag;

    /**
     * 预计运抵指运地时间
     */
    @XmlElement(name = "ValidTime")
    private String validTime;

    /**
     * 是否启用电子关锁标志
     */
    @XmlElement(name = "ESealFlag")
    private String eSealFlag;

    /**
     * 备注
     */
    @XmlElement(name = "Notes")
    private String notes;

    /**
     * 转关单类型：1代表无纸申报，0或空为普通有纸申报
     */
    @XmlElement(name = "TrnType")
    private String trnType;


    @XmlElement(name = "ApplCodeScc")
    private String applCodeScc;

}
