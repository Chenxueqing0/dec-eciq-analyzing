package com.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 运输方式代码
 * </p>
 *
 * @author ps
 * @since 2022-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BASE_TRAF_MODE")
public class BaseTrafMode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运输方式代码
     */
    @TableField("CODE")
    private String code;

    /**
     * 中文名称
     */
    @TableField("NAME")
    private String name;


}
