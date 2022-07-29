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
 * 报关单集装箱信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_CONTAINER")
public class DxpDecContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 海关统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;

    /**
     * 集装箱号
     */
    @TableField("CONTAINER_ID")
    private String containerId;

    /**
     * 集装箱规格
     */
    @TableField("CONTAINER_MD")
    private String containerMd;

    /**
     * 集装箱自重
     */
    @TableField("CONTAINER_WT")
    private String containerWt;

    /**
     * 扩展字段
     */
    @TableField("FIELD1")
    private String field1;

    /**
     * 扩展字段
     */
    @TableField("FIELD2")
    private String field2;

    /**
     * 扩展字段
     */
    @TableField("FIELD3")
    private String field3;

    /**
     * 扩展字段
     */
    @TableField("FIELD4")
    private String field4;

    /**
     * 扩展字段
     */
    @TableField("FIELD5")
    private String field5;

    /**
     * 入库时间
     */
    @TableField("REALTIME")
    private LocalDateTime realtime;

    /**
     * 集装箱规格(旧代码)
     */
    @TableField("CONTAINER_MD_OLD")
    private String containerMdOld;
    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;

}
