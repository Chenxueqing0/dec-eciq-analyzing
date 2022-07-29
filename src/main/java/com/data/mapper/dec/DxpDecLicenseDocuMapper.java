package com.data.mapper.dec;

import com.data.entity.dec.DxpDecContainer;
import com.data.entity.dec.DxpDecLicenseDocu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 报关单随附单证信息 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-04-27
 */
public interface DxpDecLicenseDocuMapper extends BaseMapper<DxpDecLicenseDocu> {
    /**
     * @Description: 批量插入
     * @Auther  hx
     * @Date 2022-04-29 9:19
     */
    int batchInsert(@Param("list") List<DxpDecLicenseDocu> dxpDecLicenseDocuList);
}
