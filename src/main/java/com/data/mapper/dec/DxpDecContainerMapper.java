package com.data.mapper.dec;

import com.data.entity.dec.DxpDecContainer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.data.entity.dec.DxpDecList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 报关单集装箱信息 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecContainerMapper extends BaseMapper<DxpDecContainer> {
    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:19
     */
    int batchInsert(@Param("list") List<DxpDecContainer> dxpDecContainerList);
}
