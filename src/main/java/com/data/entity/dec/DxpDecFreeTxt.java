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
 * 报关单附加信息
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DXP_DEC_FREE_TXT")
public class DxpDecFreeTxt implements Serializable {

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
     * 关联报关单号
     */
    @TableField("REL_ID")
    private String relId;

    /**
     * 关联备案号
     */
    @TableField("REL_MAN_NO")
    private String relManNo;

    /**
     * 监管仓号
     */
    @TableField("BON_NO")
    private String bonNo;

    /**
     * 报关员联系方式
     */
    @TableField("DEC_BP_NO")
    private String decBpNo;

    /**
     * 货场代码
     */
    @TableField("CUS_FIE")
    private String cusFie;

    /**
     * 报关员海关注册编码
     */
    @TableField("DEC_NO")
    private String decNo;

    /**
     * 其他
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
     * 唯一编号
     */
    @TableField("COP_MSG_ID")
    private String copMsgId;
}
