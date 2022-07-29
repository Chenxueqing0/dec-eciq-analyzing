package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * <p>
 * 报关单附加信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DecFreeTxt {


    /**
     * 关联报关单号
     */
    @XmlElement(name = "RelId")
    private String relId;

    /**
     * 关联备案号
     */
    @XmlElement(name = "RelManNo")
    private String relManNo;

    /**
     * 监管仓号
     */
    @XmlElement(name = "BonNo")
    private String bonNo;

    /**
     * 报关员联系方式
     */
    @XmlElement(name = "DecBpNo")
    private String decBpNo;

    /**
     * 货场代码
     */
    @XmlElement(name = "CusFie")
    private String cusFie;

    /**
     * 报关员海关注册编码
     */
    @XmlElement(name = "DecNo")
    private String decNo;

    /**
     * 其他
     */
    @XmlElement(name = "ExtendFiled")
    private String extendFiled;


}
