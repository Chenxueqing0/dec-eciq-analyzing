package com.data.entity.dec.xmlDto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

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
public class TrnContaGoodsList {

    @XmlElement(name = "TrnContaGoods")
    private List<TrnContaGoods> trnContaGoods;
}
