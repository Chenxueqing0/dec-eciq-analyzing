package com.data.mapper.dec;

import com.data.entity.dec.DxpDecContainer;
import com.data.entity.dec.DxpDecTrnContainer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 转关单集装箱 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecTrnContainerMapper extends BaseMapper<DxpDecTrnContainer> {

    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:19
     */
    int batchInsert(@Param("list") List<DxpDecTrnContainer> dxpDecTrnContainerList);
}
