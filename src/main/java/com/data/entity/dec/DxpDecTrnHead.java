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
 * 转关单表头
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_TRN_HEAD")
public class DxpDecTrnHead implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 转关单统一编号
     */
    @TableField("TRN_PRE_ID")
    private String trnPreId;

    /**
     * 南方模式中的载货清单号
     */
    @TableField("TRANS_NO")
    private String transNo;

    /**
     * 转关申报单号
     */
    @TableField("TURN_NO")
    private String turnNo;

    /**
     * 境内运输方式
     */
    @TableField("NATIVE_TRAF_MODE")
    private String nativeTrafMode;

    /**
     * 境内运输工具编号
     */
    @TableField("TRAF_CUSTOMS_NO")
    private String trafCustomsNo;

    /**
     * 境内运输工具名称
     */
    @TableField("NATIVE_SHIP_NAME")
    private String nativeShipName;

    /**
     * 境内运输工具航次
     */
    @TableField("NATIVE_VOYAGE_NO")
    private String nativeVoyageNo;

    /**
     * 承运单位名称
     */
    @TableField("CONTRACTOR_NAME")
    private String contractorName;

    /**
     * 承运单位组织机构代码
     */
    @TableField("CONTRACTOR_CODE")
    private String contractorCode;

    /**
     * 转关类型：1—转关提前； AA—出口二次转关
     */
    @TableField("TRANS_FLAG")
    private String transFlag;

    /**
     * 预计运抵指运地时间
     */
    @TableField("VALID_TIME")
    private String validTime;

    /**
     * 是否启用电子关锁标志
     */
    @TableField("E_SEAL_FLAG")
    private String eSealFlag;

    /**
     * 备注
     */
    @TableField("NOTES")
    private String notes;

    /**
     * 转关单类型：1代表无纸申报，0或空为普通有纸申报
     */
    @TableField("TRN_TYPE")
    private String trnType;

    @TableField("APPL_CODE_SCC")
    private String applCodeScc;

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
     * 扩展字段
     */
    @TableField("FIELD6")
    private String field6;

    /**
     * 扩展字段
     */
    @TableField("FIELD7")
    private String field7;

    /**
     * 扩展字段
     */
    @TableField("FIELD8")
    private String field8;

    /**
     * 扩展字段
     */
    @TableField("FIELD9")
    private String field9;

    /**
     * 扩展字段
     */
    @TableField("FIELD10")
    private String field10;

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
