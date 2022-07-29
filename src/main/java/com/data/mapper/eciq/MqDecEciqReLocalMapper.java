package com.data.mapper.eciq;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.data.entity.eciq.MqDecEciqReLocal;

import java.util.List;

/**
 * <p>
 * 货物申报报关回执 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface MqDecEciqReLocalMapper extends BaseMapper<MqDecEciqReLocal> {

    /**
     　* @Description: 查询带解析报检回执报文
     　* @Author: ps
     　* @Date: 2022/4/27 0027 10:04
     　*/
    List<MqDecEciqReLocal> getXmlPath();
}
