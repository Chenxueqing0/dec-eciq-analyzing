package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 电子随附单据关联关系表
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class EdocRelation {


    /**
     * 文件名、随附单据编号（命名规则是：
     */
    @XmlElement(name = "EdocId")
    private String edocId;

    /**
     * 随附单证类别
     */
    @XmlElement(name = "EdocCode")
    private String edocCode;

    /**
     * 随附单据格式类型
     */
    @XmlElement(name = "EdocFomatType")
    private String edocFomatType;

    /**
     * 操作说明（重传原因）
     */
    @XmlElement(name = "OpNote")
    private String opNote;

    /**
     * 随附单据文件企业名
     */
    @XmlElement(name = "EdocCopId")
    private String edocCopId;

    /**
     * 所属单位海关编号
     */
    @XmlElement(name = "EdocOwnerCode")
    private String edocOwnerCode;

    /**
     * 签名单位代码
     */
    @XmlElement(name = "SignUnit")
    private String signUnit;

    /**
     * 签名时间
     */
    @XmlElement(name = "SignTime")
    private String signTime;

    /**
     * 所属单位名称
     */
    @XmlElement(name = "EdocOwnerName")
    private String edocOwnerName;

    /**
     * 随附单据文件大小
     */
    @XmlElement(name = "EdocSize")
    private String edocSize;


}
