package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 转关单集装箱商品信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class TrnContaGoods {

    /**
     * 集装箱号
     */
    @XmlElement(name = "ContaNo")
    private String contaNo;

    /**
     * 商品序号
     */
    @XmlElement(name = "GNo")
    private String gNo;

    /**
     * 商品件数
     */
    @XmlElement(name = "ContaGoodsCount")
    private String contaGoodsCount;

    /**
     * 商品重量
     */
    @XmlElement(name = "ContaGoodsWeight")
    private String contaGoodsWeight;


}
