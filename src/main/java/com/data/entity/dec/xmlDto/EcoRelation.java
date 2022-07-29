package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 原产地证明项号关联关系表
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class EcoRelation {


    /**
     * 单据类型：Y14:原产地证明
     */
    @XmlElement(name = "CertType")
    private String certType;

    /**
     * 单据证书号
     */
    @XmlElement(name = "EcoCertNo")
    private String ecoCertNo;

    /**
     * 报关单商品项号
     */
    @XmlElement(name = "DecGNo")
    private String decGNo;

    /**
     * 原产地证书单证项号
     */
    @XmlElement(name = "EcoGNo")
    private String ecoGNo;

    /**
     * 扩展字段
     */
    @XmlElement(name = "ExtendFiled")
    private String extendFiled;


}
