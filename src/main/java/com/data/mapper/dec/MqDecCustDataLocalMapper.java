package com.data.mapper.dec;

import com.data.entity.dec.MqDecCustDataLocal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 货物申报报关申报 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface MqDecCustDataLocalMapper extends BaseMapper<MqDecCustDataLocal> {

    /**
     * @Description: 查询待解析的报关单报文
     * @Auther hx
     * @Date 2022-04-27 16:55
     */
    List<MqDecCustDataLocal> getXmlPath();
}
