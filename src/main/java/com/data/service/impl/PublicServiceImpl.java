package com.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.data.entity.*;
import com.data.mapper.*;
import com.data.service.IPublicService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 　* @Description: 公共
 * 　* @Author: ps
 * 　* @Date: 2022/4/26 0026 9:42
 *
 */
@Service("publicService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PublicServiceImpl implements IPublicService {

    @Resource
    private BaseCountryAreaMapper baseCountryAreaMapper;

    @Resource
    private BaseCurrencyMapper baseCurrencyMapper;

    @Resource
    private BaseContainerTypeMapper baseContainerTypeMapper;

    @Resource
    private BasePackTypeMapper basePackTypeMapper;

    @Resource
    private BasePortMapper basePortMapper;

    @Resource
    private BaseTradeModeMapper baseTradeModeMapper;

    /**
     * 　* @Description: 获取国别（地区）代码
     * 　* @Author: ps
     * 　* @Date: 2022/5/5 0005 11:19
     *
     */
    @Override
    public BaseCountryArea getCountry(String code, String type) {
        if(StringUtils.isBlank(code)){
            return null;
        }
        QueryWrapper<BaseCountryArea> queryWrapper = new QueryWrapper<BaseCountryArea>();
        if ("1".equals(type)) {
            //报检
            queryWrapper.eq("CODE", code).or().eq("ECIQ_CODE_OLD", code);
        } else {
            //报关
            queryWrapper.eq("CODE", code).or().eq("DEC_CODE_OLD", code);
        }
        List<BaseCountryArea> list = baseCountryAreaMapper.selectList(queryWrapper);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 　* @Description: 获取货币代码
     * 　* @Author: ps
     * 　* @Date: 2022/5/5 0005 11:19
     *
     */
    @Override
    public BaseCurrency getCurr(String code, String type) {
        if(StringUtils.isBlank(code)){
            return null;
        }
        QueryWrapper<BaseCurrency> queryWrapper = new QueryWrapper<BaseCurrency>();
        if ("1".equals(type)) {
            //报检
            queryWrapper.eq("CODE", code).or().eq("ECIQ_CODE_OLD", code);
        } else {
            //报关
            queryWrapper.eq("CODE", code).or().eq("DEC_CODE_OLD", code);
        }
        List<BaseCurrency> list = baseCurrencyMapper.selectList(queryWrapper);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 　* @Description: 获取集装箱规格信息
     * 　* @Author: ps
     * 　* @Date: 2022/5/5 0005 11:19
     *
     */
    @Override
    public BaseContainerType getContainerType(String code, String type) {
        if(StringUtils.isBlank(code)){
            return null;
        }
        QueryWrapper<BaseContainerType> queryWrapper = new QueryWrapper<BaseContainerType>();
        if ("1".equals(type)) {
            //报检
            queryWrapper.eq("CODE", code).or().eq("ECIQ_CODE_OLD", code);
        } else {
            //报关
            queryWrapper.eq("CODE", code).or().eq("DEC_CODE_OLD", code);
        }
        List<BaseContainerType> list = baseContainerTypeMapper.selectList(queryWrapper);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 　* @Description: 获取包装种类代码
     * 　* @Author: ps
     * 　* @Date: 2022/5/5 0005 11:19
     *
     */
    @Override
    public BasePackType getBasePackType(String code, String type) {
        if(StringUtils.isBlank(code)){
            return null;
        }
        QueryWrapper<BasePackType> queryWrapper = new QueryWrapper<BasePackType>();
        if ("1".equals(type)) {
            //报检
            queryWrapper.eq("CODE", code).or().eq("ECIQ_CODE_OLD", code);
        } else {
            //报关
            queryWrapper.eq("CODE", code).or().eq("DEC_CODE_OLD", code);
        }
        List<BasePackType> list = basePackTypeMapper.selectList(queryWrapper);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 　* @Description: 获取港口代码
     * 　* @Author: ps
     * 　* @Date: 2022/5/5 0005 11:19
     *
     */
    @Override
    public BasePort getBasePort(String code, String type) {
        if(StringUtils.isBlank(code)){
            return null;
        }
        QueryWrapper<BasePort> queryWrapper = new QueryWrapper<BasePort>();
        if ("1".equals(type)) {
            //报检
            queryWrapper.eq("CODE", code).or().eq("ECIQ_CODE_OLD", code);
        } else {
            //报关
            queryWrapper.eq("CODE", code).or().eq("DEC_CODE_OLD", code);
        }
        List<BasePort> list = basePortMapper.selectList(queryWrapper);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 　* @Description: 获取贸易方式代码
     * 　* @Author: ps
     * 　* @Date: 2022/5/5 0005 11:19
     *
     */
    @Override
    public BaseTradeMode getBaseTradeMode(String code, String type) {
        if(StringUtils.isBlank(code)){
            return null;
        }
        QueryWrapper<BaseTradeMode> queryWrapper = new QueryWrapper<BaseTradeMode>();
        if ("1".equals(type)) {
            //报检
            queryWrapper.eq("CODE", code).or().eq("ECIQ_CODE_OLD", code);
        } else {
            //报关
            queryWrapper.eq("CODE", code).or().eq("DEC_CODE_OLD", code);
        }
        List<BaseTradeMode> list = baseTradeModeMapper.selectList(queryWrapper);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
