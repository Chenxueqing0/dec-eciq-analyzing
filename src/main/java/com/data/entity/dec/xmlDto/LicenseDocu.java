package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 报关单随附单证信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class LicenseDocu {


    /**
     * 单证代码
     */
    @XmlElement(name = "DocuCode")
    private String docuCode;

    /**
     * 单证编号
     */
    @XmlElement(name = "CertCode")
    private String certCode;


}
