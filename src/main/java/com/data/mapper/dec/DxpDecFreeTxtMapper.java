package com.data.mapper.dec;

import com.data.entity.dec.DxpDecFreeTxt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.data.entity.dec.DxpDecLicenseDocu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 报关单附加信息 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecFreeTxtMapper extends BaseMapper<DxpDecFreeTxt> {
    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:19
     */
    int batchInsert(@Param("list") List<DxpDecFreeTxt> dxpDecFreeTxtList);

}
