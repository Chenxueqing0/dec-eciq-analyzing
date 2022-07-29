package com.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.data.entity.dec.*;
import com.data.mapper.DecRecRecordMapper;
import com.data.mapper.DecRecordMapper;
import com.data.service.IDecRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.management.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 　* @Description: 报关单记录
 * 　* @Author: ps
 * 　* @Date: 2022/4/26 0026 9:42
 *
 */
@Service("decRecordService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class DecRecordServiceImpl implements IDecRecordService {

    @Resource
    private DecRecordMapper decRecordMapper;

    @Resource
    private DecRecRecordMapper decRecRecordMapper ;

    /**
     * @Description: 报关单下发数据记录
     * @Auther  hx
     * @Date 2022-07-15 14:16
     */
    @Override
    public void saveRecord(DxpDecHead dxpDecHead, MqDecCustDataLocal mqDecCustDataLocal, DxpDecMsg dxpDecMsg) {
        DecRecord decRecord = new DecRecord();
        decRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
        decRecord.setSeqNo(dxpDecHead.getSeqNo());
        decRecord.setXmlPath(mqDecCustDataLocal.getFileLocalPath());
        decRecord.setCustomMaster(dxpDecHead.getCustomMaster());
        decRecord.setIEPort(dxpDecHead.getIEPort());
        decRecord.setAgentCodeScc(dxpDecHead.getAgentCodeScc());
        decRecord.setTradeCodeScc(dxpDecHead.getTradeCodeScc());
        decRecord.setXmlCreatTime(dxpDecMsg.getXmlCreatTime());
        if(StringUtils.isNotBlank(dxpDecHead.getEntryId())){
            decRecord.setEntryId(dxpDecHead.getEntryId());
            decRecord.setUpdateEntryTime(LocalDateTime.now());
        }
        decRecordMapper.insert(decRecord);
    }

    /**
     * @Description: 修改记录表
     * @Auther  hx
     * @Date 2022-07-15 14:16
     */
    @Override
    public void updateRecord(DxpDecHead dxpDecHead) {
        QueryWrapper<DecRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("SEQ_NO", dxpDecHead.getSeqNo());
        List<DecRecord> decRecordList = decRecordMapper.selectList(queryWrapper);
        if(null != decRecordList && decRecordList.size()>0){
            DecRecord decRecord = decRecordList.get(0);
            decRecord.setEntryId(dxpDecHead.getEntryId());
            decRecord.setUpdateEntryTime(LocalDateTime.now());
            decRecordMapper.updateById(decRecord);
        }

    }

    /**
     * @Description: 报关单回执下发记录表
     * @Auther  hx
     * @Date 2022-07-15 14:17
     */
    @Override
    public void saveReRecord(DxpDecResult dxpDecResult, MqDecCustReLocal mqDecCustReLocal, DxpDecMsg dxpDecMsg) {
        DecRecRecord decRecRecord = new DecRecRecord();
        decRecRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
        decRecRecord.setSeqNo(dxpDecResult.getCusCiqNo());
        decRecRecord.setXmlPath(mqDecCustReLocal.getFileLocalPath());
        decRecRecord.setXmlCreatTime(dxpDecMsg.getXmlCreatTime());
        decRecRecordMapper.insert(decRecRecord);
    }
}
