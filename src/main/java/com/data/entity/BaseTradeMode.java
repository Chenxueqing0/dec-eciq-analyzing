package com.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 贸易方式代码
 * </p>
 *
 * @author ps
 * @since 2022-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BASE_TRADE_MODE")
public class BaseTradeMode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 监管方式代码
     */
    @TableField("CODE")
    private String code;

    /**
     * 监管方式全称
     */
    @TableField("NAME")
    private String name;

    /**
     * 报关代码（旧）
     */
    @TableField("DEC_CODE_OLD")
    private String decCodeOld;

    /**
     * 报检代码（旧）
     */
    @TableField("ECIQ_CODE_OLD")
    private String eciqCodeOld;


}
