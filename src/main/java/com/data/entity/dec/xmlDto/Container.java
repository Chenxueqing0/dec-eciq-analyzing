package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * <p>
 * 报关单集装箱信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Container {

    /**
     * 集装箱号
     */
    @XmlElement(name = "ContainerId")
    private String containerId;

    /**
     * 集装箱规格
     */
    @XmlElement(name = "ContainerMd")
    private String containerMd;

    /**
     * 集装箱自重
     */
    @XmlElement(name = "ContainerWt")
    private String containerWt;


}
