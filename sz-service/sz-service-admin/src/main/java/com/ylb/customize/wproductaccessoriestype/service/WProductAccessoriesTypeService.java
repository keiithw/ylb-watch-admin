package com.ylb.customize.wproductaccessoriestype.service;

import com.mybatisflex.core.service.IService;
import com.ylb.customize.wproductaccessoriestype.pojo.po.WProductAccessoriesType;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.core.common.entity.PageResult;
import java.util.List;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeCreateDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeUpdateDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeListDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.vo.WProductAccessoriesTypeVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 商品配件关联信息 Service
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
public interface WProductAccessoriesTypeService extends IService<WProductAccessoriesType> {

    void create(WProductAccessoriesTypeCreateDTO dto);

    void update(WProductAccessoriesTypeUpdateDTO dto);

    PageResult<WProductAccessoriesTypeVO> page(WProductAccessoriesTypeListDTO dto);

    List<WProductAccessoriesTypeVO> list(WProductAccessoriesTypeListDTO dto);

    void remove(SelectIdsDTO dto);

    WProductAccessoriesTypeVO detail(Object id);

    void importExcel(ImportExcelDTO dto);

    void exportExcel(WProductAccessoriesTypeListDTO dto, HttpServletResponse response);
}