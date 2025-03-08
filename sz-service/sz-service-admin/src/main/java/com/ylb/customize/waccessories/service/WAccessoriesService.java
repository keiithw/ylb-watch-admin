package com.ylb.customize.waccessories.service;

import com.mybatisflex.core.service.IService;
import com.ylb.customize.waccessories.pojo.po.WAccessories;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.core.common.entity.PageResult;
import java.util.List;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesCreateDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesUpdateDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesListDTO;
import com.ylb.customize.waccessories.pojo.vo.WAccessoriesVO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.ylb.customize.wproduct.pojo.vo.ProductCustomizeVO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 配件 Service
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
public interface WAccessoriesService extends IService<WAccessories> {
    ProductCustomizeVO getAccessoryCustomizeList(Integer productId);

    void create(WAccessoriesCreateDTO dto);

    void update(WAccessoriesUpdateDTO dto);

    PageResult<WAccessoriesVO> page(WAccessoriesListDTO dto);

    List<WAccessoriesVO> list(WAccessoriesListDTO dto);

    void remove(SelectIdsDTO dto);

    WAccessoriesVO detail(Object id);

    void importExcel(ImportExcelDTO dto);

    void exportExcel(WAccessoriesListDTO dto, HttpServletResponse response);
}