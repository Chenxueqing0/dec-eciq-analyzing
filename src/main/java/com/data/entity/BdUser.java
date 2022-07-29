package com.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 大数据贸易用户表
 * </p>
 *
 * @author ps
 * @since 2022-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BD_USER")
public class BdUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 账号
     */
    @TableField("ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 企业名称
     */
    @TableField("COP_NAME")
    private String copName;

    /**
     * 统一社会信用代码
     */
    @TableField("COP_CODE_SCC")
    private String copCodeScc;

    /**
     * kafka服务器信息
     */
    @TableField("BROKER")
    private String broker;

    /**
     * 报关发送topic
     */
    @TableField("TC_SD_DEC")
    private String tcSdDec;

    /**
     * 报关回执发送topic
     */
    @TableField("TC_SD_DEC_REC")
    private String tcSdDecRec;

    /**
     * 报检发送topic
     */
    @TableField("TC_SD_CIQ")
    private String tcSdCiq;

    /**
     * 报检回执发送topic
     */
    @TableField("TC_SD_CIQ_REC")
    private String tcSdCiqRec;

    /**
     * 查验发送topic
     */
    @TableField("TC_SD_CHECK")
    private String tcSdCheck;

    /**
     * 报关接收topic
     */
    @TableField("TC_RX_DEC")
    private String tcRxDec;

    /**
     * 报关回执接收topic
     */
    @TableField("TC_RX_DEC_REC")
    private String tcRxDecRec;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private String createUser;

    /**
     * 级别 0：江苏省电子口岸  1：企业  2：平台  3：口岸
     */
    @JsonProperty("pLevel")
    @TableField("P_LEVEL")
    private String pLevel;

    /**
     * 查验回执发送topic
     */
    @TableField("TC_SD_CHECK_REC")
    private String tcSdCheckRec;

    @TableField(exist = false)
    private String token;
}
