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
 * 原产地证明项号关联关系表
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_ECO_REALATION")
public class DxpDecEcoRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * 海关统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;

    /**
     * 单据类型：Y14:原产地证明
     */
    @TableField("CERT_TYPE")
    private String certType;

    /**
     * 单据证书号
     */
    @TableField("ECO_CERT_NO")
    private String ecoCertNo;

    /**
     * 报关单商品项号
     */
    @TableField("DEC_G_NO")
    private String decGNo;

    /**
     * 原产地证书单证项号
     */
    @TableField("ECO_G_NO")
    private String ecoGNo;

    /**
     * 扩展字段
     */
    @TableField("EXTEND_FILED")
    private String extendFiled;

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
