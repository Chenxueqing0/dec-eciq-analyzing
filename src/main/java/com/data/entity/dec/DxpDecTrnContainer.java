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
 * 转关单集装箱
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_TRN_CONTAINER")
public class DxpDecTrnContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    @TableField("TRN_PRE_ID")
    private String trnPreId;

    /**
     * 集装箱号
     */
    @TableField("CONTA_NO")
    private String contaNo;

    /**
     * 集装箱序号
     */
    @TableField("CONTA_SN")
    private String contaSn;

    /**
     * 集装箱规格
     */
    @TableField("CONTA_MODEL")
    private String contaModel;

    /**
     * 电子关锁号
     */
    @TableField("SEAL_NO")
    private String sealNo;

    /**
     * 境内运输工具名称
     */
    @TableField("TRANS_NAME")
    private String transName;

    /**
     * 运输工具实际重量
     */
    @TableField("TRANS_WEIGHT")
    private String transWeight;

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
     * 集装箱规格（旧代码）
     */
    @TableField("CONTA_MODEL_OLD")
    private String contaModelOld;

    /**
     * 报关单统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;
    /**
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
