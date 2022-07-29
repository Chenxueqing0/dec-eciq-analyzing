package com.data.entity.dec.xmlDto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * <p>
 * 报关单表体
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DecList {


    /**
     * 归类标志
     */
    @XmlElement(name = "ClassMark")
    private String classMark;

    /**
     * 商品编号
     */
    @XmlElement(name = "CodeTs")
    private String codeTs;

    /**
     * 备案序号
     */
    @XmlElement(name = "ContrItem")
    private String contrItem;

    /**
     * 申报单价
     */
    @XmlElement(name = "DeclPrice")
    private String declPrice;

    /**
     * 征减免税方式
     */
    @XmlElement(name = "DutyMode")
    private String dutyMode;

    /**
     * 申报计量单位与法定单位比例因子
     */
    @XmlElement(name = "Factor")
    private String factor;

    /**
     * 商品规格、型号
     */
    @XmlElement(name = "GModel")
    private String gModel;

    /**
     * 商品名称
     */
    @XmlElement(name = "GName")
    private String gName;

    /**
     * 商品序号
     */
    @XmlElement(name = "GNo")
    private String gNo;

    /**
     * 原产地
     */
    @XmlElement(name = "OriginCountry")
    private String originCountry;

    /**
     * 成交币制
     */
    @XmlElement(name = "TradeCurr")
    private String tradeCurr;

    /**
     * 申报总价
     */
    @XmlElement(name = "DeclTotal")
    private String declTotal;

    /**
     * 申报数量（成交计量单位）
     */
    @XmlElement(name = "GQty")
    private String gQty;

    /**
     * 第一法定数量
     */
    @XmlElement(name = "FirstQty")
    private String firstQty;

    /**
     * 第二法定数量
     */
    @XmlElement(name = "SecondQty")
    private String secondQty;

    /**
     * 申报计量单位
     */
    @XmlElement(name = "GUnit")
    private String gUnit;

    /**
     * 第一计量单位
     */
    @XmlElement(name = "FirstUnit")
    private String firstUnit;

    /**
     * 第二计量单位
     */
    @XmlElement(name = "SecondUnit")
    private String secondUnit;

    /**
     * 用途/生产厂家
     */
    @XmlElement(name = "UseTo")
    private String useTo;

    /**
     * 工缴费
     */
    @XmlElement(name = "WorkUsd")
    private String workUsd;

    /**
     * 货号
     */
    @XmlElement(name = "ExgNo")
    private String exgNo;

    /**
     * 版本号
     */
    @XmlElement(name = "ExgVersion")
    private String exgVersion;

    /**
     * 最终目的国（地区）
     */
    @XmlElement(name = "DestinationCountry")
    private String destinationCountry;


}
