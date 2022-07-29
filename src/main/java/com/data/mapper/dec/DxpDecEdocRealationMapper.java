package com.data.mapper.dec;

import com.data.entity.dec.DxpDecContainer;
import com.data.entity.dec.DxpDecEdocRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 电子随附单据关联关系表 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecEdocRealationMapper extends BaseMapper<DxpDecEdocRelation> {

    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:19
     */
    int batchInsert(@Param("list") List<DxpDecEdocRelation> dxpDecEdocRelationList);
}
