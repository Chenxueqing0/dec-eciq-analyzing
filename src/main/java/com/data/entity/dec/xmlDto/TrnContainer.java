package com.data.entity.dec.xmlDto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 转关单集装箱
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class TrnContainer {


    /**
     * 集装箱号
     */
    @XmlElement(name = "ContaNo")
    private String contaNo;

    /**
     * 集装箱序号
     */
    @XmlElement(name = "ContaSn")
    private String contaSn;

    /**
     * 集装箱规格
     */
    @XmlElement(name = "ContaModel")
    private String contaModel;

    /**
     * 电子关锁号
     */
    @XmlElement(name = "SealNo")
    private String sealNo;

    /**
     * 境内运输工具名称
     */
    @XmlElement(name = "TransName")
    private String transName;

    /**
     * 运输工具实际重量
     */
    @XmlElement(name = "TransWeight")
    private String transWeight;


}
