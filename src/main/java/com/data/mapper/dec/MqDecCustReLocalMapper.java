package com.data.mapper.dec;

import com.data.entity.dec.MqDecCustDataLocal;
import com.data.entity.dec.MqDecCustReLocal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 货物申报报关回执 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface MqDecCustReLocalMapper extends BaseMapper<MqDecCustReLocal> {

    /**
     * @Description: 查询待解析报关单回执报文
     * @Auther hx
     * @Date 2022-04-27 16:47
     */
    List<MqDecCustReLocal> getXmlPath();

}
