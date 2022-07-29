package com.data.mapper.dec;

import com.data.entity.dec.DxpDecHead;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 报关单表头 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecHeadMapper extends BaseMapper<DxpDecHead> {

    /**
     * @Description 查询可更新的报关单数据
     * @Author huxi
     * @Date 2022/7/21 21:58
     */
    List<DxpDecHead> getDxpDecHead();

}
