package com.data.entity.dec.xmlDto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 转关单表体
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class TrnList {


    /**
     * 进出境运输方式
     */
    @XmlElement(name = "TrafMode")
    private String trafMode;

    /**
     * 进出境运输工具编号
     */
    @XmlElement(name = "ShipId")
    private String shipId;

    /**
     * 进出境运输工具名称（船舶名称
     */
    @XmlElement(name = "ShipNameEn")
    private String shipNameEn;

    /**
     * 进出境运输工具航次
     */
    @XmlElement(name = "VoyageNo")
    private String voyageNo;

    /**
     * 提单号
     */
    @XmlElement(name = "BillNo")
    private String billNo;

    /**
     * 实际进出境日期
     */
    @XmlElement(name = "IEDate")
    private String iEDate;


}
