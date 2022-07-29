package com.data.entity.dec.xmlDto;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Description: 报关单报文信息
 * @Auther hx
 * @Date 2022-04-28 9:33
 */
@Data
@XmlRootElement(name = "DecMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class DecMessage {


    /**
     * 报关单表头
     */
    @XmlElement(name = "DecHead")
    private DecHead decHead;

    /**
     * 报关单表体
     */
    @XmlElement(name = "DecLists")
    private DecListList decLists;

    /**
     * 报关单集装箱信息
     */
    @XmlElement(name = "DecContainers")
    private DecContainerList decContainers;

    /**
     * 报关单随附单证信息
     */
    @XmlElement(name = "DecLicenseDocus")
    private DecLicenseDocuList decLicenseDocus;

    /**
     * 附加信息
     */
    @XmlElement(name = "DecFreeTxt")
    private List<DecFreeTxt> decFreeTxts;

    /**
     * 电子随附单据关联关系
     */
    @XmlElement(name = "EdocRealation")
    private List<EdocRelation> edocRelations;

    /**
     * 原产地证明项号关联关系
     */
    @XmlElement(name = "EcoRelation")
    private List<EcoRelation> ecoRelations;

    /**
     * 转关单表头
     */
    @XmlElement(name = "TrnHead")
    private TrnHead trnHead;

    /**
     * 转关单表体（提运单信息）
     */
    @XmlElement(name = "TrnList")
    private List<TrnList> trnLists;

    /**
     * 转关单集装箱信息
     */
    @XmlElement(name = "TrnContainers")
    private TrnContainerList trnContainers;

    /**
     * 转关单集装箱和商品关系列表
     */
    @XmlElement(name = "TrnContaGoodsList")
    private TrnContaGoodsList trnContaGoods;

}
