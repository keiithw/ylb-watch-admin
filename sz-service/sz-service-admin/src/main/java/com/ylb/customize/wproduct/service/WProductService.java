package com.ylb.customize.wproduct.service;

import com.mybatisflex.core.service.IService;
import com.ylb.customize.wproduct.pojo.po.WProduct;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.core.common.entity.PageResult;
import java.util.List;
import com.ylb.customize.wproduct.pojo.dto.WProductCreateDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductUpdateDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductListDTO;
import com.ylb.customize.wproduct.pojo.vo.ProductCustomizeVO;
import com.ylb.customize.wproduct.pojo.vo.WProductVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 商品 Service
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
public interface WProductService extends IService<WProduct> {


    void create(WProductCreateDTO dto);

    void update(WProductUpdateDTO dto);

    PageResult<WProductVO> page(WProductListDTO dto);

    List<WProductVO> list(WProductListDTO dto);

    void remove(SelectIdsDTO dto);

    WProductVO detail(Object id);

    void importExcel(ImportExcelDTO dto);

    void exportExcel(WProductListDTO dto, HttpServletResponse response);
}