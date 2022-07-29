package com.data.mapper.dec;

import com.data.entity.dec.DxpDecTrnContaGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.data.entity.dec.DxpDecTrnContainer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 转关单集装箱商品信息 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecTrnContaGoodsMapper extends BaseMapper<DxpDecTrnContaGoods> {

    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:19
     */
    int batchInsert(@Param("list") List<DxpDecTrnContaGoods> dxpDecTrnContaGoodsList);
}
