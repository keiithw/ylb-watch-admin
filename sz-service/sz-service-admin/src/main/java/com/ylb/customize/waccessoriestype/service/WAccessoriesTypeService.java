package com.ylb.customize.waccessoriestype.service;

import com.mybatisflex.core.service.IService;
import com.ylb.customize.waccessoriestype.pojo.po.WAccessoriesType;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.core.common.entity.PageResult;
import java.util.List;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeCreateDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeUpdateDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeListDTO;
import com.ylb.customize.waccessoriestype.pojo.vo.WAccessoriesTypeVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 配件类型 Service
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
public interface WAccessoriesTypeService extends IService<WAccessoriesType> {

    void create(WAccessoriesTypeCreateDTO dto);

    void update(WAccessoriesTypeUpdateDTO dto);

    PageResult<WAccessoriesTypeVO> page(WAccessoriesTypeListDTO dto);

    List<WAccessoriesTypeVO> list(WAccessoriesTypeListDTO dto);

    void remove(SelectIdsDTO dto);

    WAccessoriesTypeVO detail(Object id);

    void importExcel(ImportExcelDTO dto);

    void exportExcel(WAccessoriesTypeListDTO dto, HttpServletResponse response);
}