package com.data.mapper;

import com.data.entity.BdUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 大数据贸易用户表 Mapper 接口
 * </p>
 *
 * @author ps
 * @since 2022-07-11
 */
public interface BdUserMapper extends BaseMapper<BdUser> {

    /**
     * @Description: 修改密码
     * @Author: xuyang
     * @Date: 2022/7/14  11:27
     */
    int updatePasById(@Param("bdUser") BdUser bdUser);
}
