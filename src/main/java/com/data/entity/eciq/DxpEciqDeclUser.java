package com.data.entity.eciq;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 出入境使用人信息
 * </p>
 *
 * @author ps
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_DECL_USER")
@XmlAccessorType(XmlAccessType.FIELD)
public class DxpEciqDeclUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    @XmlElement(name="EntDeclNo")
    private String entDeclNo;

    /**
     * 出入境使用人ID
     */
    @TableField("USER_ID")
    @XmlElement(name="UserId")
    private String userId;

    /**
     * 使用人代码
     */
    @TableField("CONSUMER_USR_CODE")
    @XmlElement(name="ConsumerUsrCode")
    private String consumerUsrCode;

    /**
     * 使用人名称
     */
    @TableField("USER_NAME")
    @XmlElement(name="UserName")
    private String userName;

    /**
     * 使用单位联系人
     */
    @TableField("USE_ORG_PERSON_CODE")
    @XmlElement(name="UseOrgPersonCode")
    private String useOrgPersonCode;

    /**
     * 使用单位联系电话
     */
    @TableField("USE_ORG_PERSON_TEL")
    @XmlElement(name="UseOrgPersonTel")
    private String useOrgPersonTel;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
