package com.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 国别（地区）代码表
 * </p>
 *
 * @author ps
 * @since 2022-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BASE_COUNTRY_AREA")
public class BaseCountryArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 代码
     */
    @TableId("CODE")
    private String code;

    /**
     * 中文名称
     */
    @TableField("NAME_CH")
    private String nameCh;

    /**
     * 英文名称
     */
    @TableField("NAME_EN")
    private String nameEn;

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
