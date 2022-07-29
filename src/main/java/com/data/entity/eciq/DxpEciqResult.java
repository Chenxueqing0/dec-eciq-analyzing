package com.data.entity.eciq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description: TODO
 * @Author: ps
 * @Date: 2022/4/29 002915:46
 */
@XmlRootElement(name="Ciqresult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DxpEciqResult extends DxpEciqDeclResult{


}
