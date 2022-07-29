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
 * 电子随附单据关联关系表
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_EDOC_REALATION")
public class DxpDecEdocRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    /**
     * 海关统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;

    /**
     * 文件名、随附单据编号（命名规则是：
     */
    @TableField("EDOC_ID")
    private String edocId;

    /**
     * 随附单证类别
     */
    @TableField("EDOC_CODE")
    private String edocCode;

    /**
     * 随附单据格式类型
     */
    @TableField("EDOC_FOMAT_TYPE")
    private String edocFomatType;

    /**
     * 操作说明（重传原因）
     */
    @TableField("OP_NOTE")
    private String opNote;

    /**
     * 随附单据文件企业名
     */
    @TableField("EDOC_COP_ID")
    private String edocCopId;

    /**
     * 所属单位海关编号
     */
    @TableField("EDOC_OWNER_CODE")
    private String edocOwnerCode;

    /**
     * 签名单位代码
     */
    @TableField("SIGN_UNIT")
    private String signUnit;

    /**
     * 签名时间
     */
    @TableField("SIGN_TIME")
    private String signTime;

    /**
     * 所属单位名称
     */
    @TableField("EDOC_OWNER_NAME")
    private String edocOwnerName;

    /**
     * 随附单据文件大小
     */
    @TableField("EDOC_SIZE")
    private String edocSize;

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
