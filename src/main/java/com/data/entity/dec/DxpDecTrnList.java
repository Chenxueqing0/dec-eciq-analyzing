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
 * 转关单表体
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_TRN_LIST")
public class DxpDecTrnList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    @TableField("TRN_PRE_ID")
    private String trnPreId;

    /**
     * 进出境运输方式
     */
    @TableField("TRAF_MODE")
    private String trafMode;

    /**
     * 进出境运输工具编号
     */
    @TableField("SHIP_ID")
    private String shipId;

    /**
     * 进出境运输工具名称（船舶名称
     */
    @TableField("SHIP_NAME_EN")
    private String shipNameEn;

    /**
     * 进出境运输工具航次
     */
    @TableField("VOYAGE_NO")
    private String voyageNo;

    /**
     * 提单号
     */
    @TableField("BILL_NO")
    private String billNo;

    /**
     * 实际进出境日期
     */
    @TableField("I_E_DATE")
    private String iEDate;

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
