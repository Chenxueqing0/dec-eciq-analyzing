package com.data.entity.eciq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: ps
 * @Date: 2022/4/29 002915:46
 */
@XmlRootElement(name="EEntDeclIo")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DxpEciqMain {

    @XmlElement(name = "ITF_DCL_IO_DECL")
    private DxpEciqDecl dxpEciqDecl;

    @XmlElement(name = "ITF_DCL_IO_DECL_ATT")
    private List<DxpEciqDeclAtt> dxpEciqDeclAttList = new ArrayList<>();

    @XmlElement(name = "ITF_DCL_IO_DECL_GOODS")
    private List<DxpEciqDeclGoods> dxpEciqDeclGoodsList = new ArrayList<>();

    @XmlElement(name = "ITF_DCL_IO_DECL_LIMIT")
    private List<DxpEciqDeclLimit> dxpEciqDeclLimitList = new ArrayList<>();

    @XmlElement(name = "ITF_DCL_IO_DECL_USER")
    private List<DxpEciqDeclUser> dxpEciqDeclUserList = new ArrayList<>();

    @XmlElement(name = "ITF_DCL_MARK_LOB")
    private List<DxpEciqDeclMarkLob> dxpEciqDeclMarkLobList = new ArrayList<>();

    @XmlElement(name = "ITF_DCL_IO_DECL_CONT")
    private List<DxpEciqDeclCont> dxpEciqDeclContList = new ArrayList<>();
}
