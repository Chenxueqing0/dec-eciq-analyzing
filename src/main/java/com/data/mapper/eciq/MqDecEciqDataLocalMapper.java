package com.data.mapper.eciq;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.data.entity.eciq.MqDecEciqDataLocal;

import java.util.List;

/**
 * <p>
 * 货物申报报检申报 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface MqDecEciqDataLocalMapper extends BaseMapper<MqDecEciqDataLocal> {

    /**
    　* @Description: 查询带解析报检报文
    　* @Author: ps
    　* @Date: 2022/4/27 0027 10:04
    　*/
    List<MqDecEciqDataLocal> getXmlPath();

}
