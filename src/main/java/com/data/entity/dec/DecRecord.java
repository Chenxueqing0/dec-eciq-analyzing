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
 * 国口办下发报关报文记录表
 * </p>
 *
 * @author ps
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("statistical.DEC_RECORD")
public class DecRecord implements Serializable {

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
     * 主管海关
     */
    @TableField("CUSTOM_MASTER")
    private String customMaster;

    /**
     * 进出口岸
     */
    @TableField("I_E_PORT")
    private String iEPort;

    /**
     * 申报单位代码
     */
    @TableField("AGENT_CODE_SCC")
    private String agentCodeScc;

    /**
     * 经营单位统一代码   境内收发货人统一代码
     */
    @TableField("TRADE_CODE_SCC")
    private String tradeCodeScc;

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

    /**
     * 海关编号
     */
    @TableField("ENTRY_ID")
    private String entryId;

    /**
     * 更新海关编号时间
     */
    @TableField("UPDATE_ENTRY_TIME")
    private LocalDateTime updateEntryTime;


}
