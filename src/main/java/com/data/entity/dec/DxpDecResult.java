package com.data.entity.dec;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 报关回执
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_RESULT")
public class DxpDecResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    @TableField("CUS_CIQ_NO")
    private String cusCiqNo;

    /**
     * 海关编号
     */
    @TableField("ENTRY_ID")
    private String entryId;

    /**
     * 通知时间
     */
    @TableField("NOTICE_DATE")
    private LocalDateTime noticeDate;

    /**
     * 通道
     */
    @TableField("CHANNEL")
    private String channel;

    /**
     * 备注
     */
    @TableField("NOTE")
    private String note;

    /**
     * 主管海关
     */
    @TableField("CUSTOM_MASTER")
    private String customMaster;

    @TableField("I_E_DATE")
    private LocalDateTime iEDate;

    @TableField("D_DATE")
    private String dDate;

    @TableField("FIELD1")
    private String field1;

    @TableField("FIELD2")
    private String field2;

    @TableField("FIELD3")
    private String field3;

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
