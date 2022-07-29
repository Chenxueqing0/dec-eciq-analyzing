package com.data.entity.eciq;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报检报文传输信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_ECIQ_MSG")
public class DxpEciqMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;

    /**
     * 发送方id
     */
    @TableField("SENDER_ID")
    private String senderId;

    /**
     * 接收方id
     */
    @TableField("RECEIVER_ID")
    private String receiverId;

    /**
     * 报文创建时间
     */
    @TableField("XML_CREAT_TIME")
    private LocalDateTime xmlCreatTime;

    /**
     * 报文类型
     */
    @TableField("MSG_TYPE")
    private String msgType;

    @TableField("FILE_NAME")
    private String fileName;

    @TableField("IC_CARD")
    private String icCard;

    @TableField("BIZ_KEY")
    private String bizKey;

    /**
     * 入库时间
     */
    @TableField("CREAT_TIME")
    private LocalDateTime creatTime;


}
