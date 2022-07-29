package com.data.entity.dec;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 货物申报报关回执
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("MQ_DEC_CUST_RE_LOCAL")
public class MqDecCustReLocal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private Long id;

    /**
     * 消息ID
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;

    /**
     * 报文类型
     */
    @TableField("MSG_TYPE")
    private String msgType;

    /**
     * 报文创建时间
     */
    @TableField("MSG_CREATE_TIME")
    private String msgCreateTime;

    /**
     * 备份文件本地存储路径
     */
    @TableField("FILE_LOCAL_PATH")
    private String fileLocalPath;

    /**
     * 报文处理标记  0：未处理  1：已处理 3:异常
     */
    @TableField("DEAL_FLAG")
    private String dealFlag;

    /**
     * 报文处理时间
     */
    @TableField("DEAL_TIME")
    private String dealTime;

    /**
     * 扩展字段1
     */
    @TableField("FIELD1")
    private String field1;

    /**
     * 扩展字段2
     */
    @TableField("FIELD2")
    private String field2;

    /**
     * 扩展字段3
     */
    @TableField("FIELD3")
    private String field3;

    /**
     * 扩展字段4
     */
    @TableField("FIELD4")
    private String field4;

    /**
     * 扩展字段5
     */
    @TableField("FIELD5")
    private String field5;

    /**
     * 时间戳
     */
    @TableField("REAL_TIME")
    private LocalDateTime realTime;


}
