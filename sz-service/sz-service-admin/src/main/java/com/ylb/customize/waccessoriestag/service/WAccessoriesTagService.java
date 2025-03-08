package com.ylb.customize.waccessoriestag.service;

import com.mybatisflex.core.service.IService;
import com.ylb.customize.waccessoriestag.pojo.po.WAccessoriesTag;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.core.common.entity.PageResult;
import java.util.List;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagCreateDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagUpdateDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagListDTO;
import com.ylb.customize.waccessoriestag.pojo.vo.WAccessoriesTagVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 配件二级标签 Service
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
public interface WAccessoriesTagService extends IService<WAccessoriesTag> {

    void create(WAccessoriesTagCreateDTO dto);

    void update(WAccessoriesTagUpdateDTO dto);

    PageResult<WAccessoriesTagVO> page(WAccessoriesTagListDTO dto);

    List<WAccessoriesTagVO> list(WAccessoriesTagListDTO dto);

    void remove(SelectIdsDTO dto);

    WAccessoriesTagVO detail(Object id);

    void importExcel(ImportExcelDTO dto);

    void exportExcel(WAccessoriesTagListDTO dto, HttpServletResponse response);
}