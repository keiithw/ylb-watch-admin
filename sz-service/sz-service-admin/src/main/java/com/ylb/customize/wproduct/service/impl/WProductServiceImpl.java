package com.ylb.customize.wproduct.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ylb.customize.waccessories.service.WAccessoriesService;
import com.ylb.customize.wproduct.pojo.vo.ProductCustomizeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ylb.customize.wproduct.service.WProductService;
import com.ylb.customize.wproduct.pojo.po.WProduct;
import com.ylb.customize.wproduct.mapper.WProductMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.query.QueryChain;
import com.sz.core.common.enums.CommonResponseEnum;
import com.sz.core.util.PageUtils;
import com.sz.core.util.BeanCopyUtils;
import com.sz.core.util.Utils;
import com.sz.core.common.entity.PageResult;
import com.sz.core.common.entity.SelectIdsDTO;
import java.io.Serializable;
import java.util.List;
import com.ylb.customize.wproduct.pojo.dto.WProductCreateDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductUpdateDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductListDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductImportDTO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.sz.excel.core.ExcelResult;
import java.io.OutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.sz.core.util.FileUtils;
import com.sz.excel.utils.ExcelUtils;
import lombok.SneakyThrows;
import com.ylb.customize.wproduct.pojo.vo.WProductVO;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Service
@RequiredArgsConstructor
public class WProductServiceImpl extends ServiceImpl<WProductMapper, WProduct> implements WProductService {
    @Override
    public void create(WProductCreateDTO dto){
        WProduct wProduct = BeanCopyUtils.copy(dto, WProduct.class);
        save(wProduct);
    }

    @Override
    public void update(WProductUpdateDTO dto){
        WProduct wProduct = BeanCopyUtils.copy(dto, WProduct.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(WProduct::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        saveOrUpdate(wProduct);
    }

    @Override
    public PageResult<WProductVO> page(WProductListDTO dto){
        Page<WProductVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), WProductVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<WProductVO> list(WProductListDTO dto){
        return listAs(buildQueryWrapper(dto), WProductVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public WProductVO detail(Object id){
        WProduct wProduct = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(wProduct);
        return BeanCopyUtils.copy(wProduct, WProductVO.class);
    }

    @SneakyThrows
    @Override
    public void importExcel(ImportExcelDTO dto) {
        ExcelResult<WProductImportDTO> excelResult = ExcelUtils.importExcel(dto.getFile().getInputStream(), WProductImportDTO.class, true);
        List<WProductImportDTO> list = excelResult.getList();
        List<String> errorList = excelResult.getErrorList();
        String analysis = excelResult.getAnalysis();
        System.out.println(" analysis : " + analysis);
        System.out.println(" isCover : " + dto.getIsCover());
    }

    @SneakyThrows
    @Override
    public void exportExcel(WProductListDTO dto, HttpServletResponse response) {
        List<WProductVO> list = list(dto);
        String fileName = "商品模板";
        OutputStream os = FileUtils.getOutputStream(response, fileName + ".xlsx");
        ExcelUtils.exportExcel(list, "商品", WProductVO.class, os);
    }

    private static QueryWrapper buildQueryWrapper(WProductListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(WProduct.class);
        if (Utils.isNotNull(dto.getName())) {
            wrapper.like(WProduct::getName, dto.getName());
        }
        if (Utils.isNotNull(dto.getPrice())) {
            wrapper.eq(WProduct::getPrice, dto.getPrice());
        }
        if (Utils.isNotNull(dto.getPhotoFront())) {
            wrapper.eq(WProduct::getPhotoFront, dto.getPhotoFront());
        }
        if (Utils.isNotNull(dto.getPhotoBack())) {
            wrapper.eq(WProduct::getPhotoBack, dto.getPhotoBack());
        }
        return wrapper;
    }
}