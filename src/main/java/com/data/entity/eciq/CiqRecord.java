package com.data.entity.eciq;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 国口办下发报检报文记录表
 * </p>
 *
 * @author ps
 * @since 2022-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("statistical.CIQ_RECORD")
public class CiqRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 企业报检号
     */
    @TableField("ENT_DECL_NO")
    private String entDeclNo;

    /**
     * 报文存放地址
     */
    @TableField("XML_PATH")
    private String xmlPath;

    /**
     * 报检地
     */
    @TableField("ORG_CODE")
    private String orgCode;

    /**
     * 口岸机构
     */
    @TableField("INSP_ORG_CODE")
    private String inspOrgCode;

    /**
     * 报检单位代码
     */
    @TableField("DECL_REG_NO")
    private String declRegNo;

    /**
     * 收/发货人代码
     */
    @TableField("CONSIGN_CODE")
    private String consignCode;

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
