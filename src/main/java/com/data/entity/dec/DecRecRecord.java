package com.data.entity.dec;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 国口办下发报关回执报文记录表
 * </p>
 *
 * @author ps
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("statistical.DEC_REC_RECORD")
public class DecRecRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 报关单统一编号
     */
    @TableField("SEQ_NO")
    private String seqNo;

    /**
     * 报文存放地址
     */
    @TableField("XML_PATH")
    private String xmlPath;

    /**
     * 报文节点里面的生成时间
     */
    @TableField("XML_CREAT_TIME")
    private LocalDateTime xmlCreatTime;

    /**
     * 插入时间
     */
    @TableField("INSERT_TIME")
    private LocalDateTime insertTime;


}
