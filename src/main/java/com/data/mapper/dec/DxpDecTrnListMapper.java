package com.data.mapper.dec;

import com.data.entity.dec.DxpDecList;
import com.data.entity.dec.DxpDecTrnList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 转关单表体 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecTrnListMapper extends BaseMapper<DxpDecTrnList> {

    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:21
     */
    int batchInsert(@Param("list") List<DxpDecTrnList> dxpDecTrnListList);
}
