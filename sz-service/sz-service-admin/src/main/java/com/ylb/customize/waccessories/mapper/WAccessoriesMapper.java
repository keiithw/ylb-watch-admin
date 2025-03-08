package com.ylb.customize.waccessories.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ylb.customize.waccessories.pojo.po.AccessoriesCustomizePO;
import com.ylb.customize.waccessories.pojo.po.WAccessories;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* <p>
* 配件 Mapper 接口
* </p>
*
* @author keith.wu
* @since 2025-02-20
*/
public interface WAccessoriesMapper extends BaseMapper<WAccessories> {
    List<AccessoriesCustomizePO> getAccessoriesCustomizeList(@Param("productId")Integer productId);
}