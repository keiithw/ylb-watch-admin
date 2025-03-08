package com.ylb.customize.wproductaccessoriestype.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ylb.customize.wproductaccessoriestype.service.WProductAccessoriesTypeService;
import com.ylb.customize.wproductaccessoriestype.pojo.po.WProductAccessoriesType;
import com.ylb.customize.wproductaccessoriestype.mapper.WProductAccessoriesTypeMapper;
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
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeCreateDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeUpdateDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeListDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeImportDTO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.sz.excel.core.ExcelResult;
import java.io.OutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.sz.core.util.FileUtils;
import com.sz.excel.utils.ExcelUtils;
import lombok.SneakyThrows;
import com.ylb.customize.wproductaccessoriestype.pojo.vo.WProductAccessoriesTypeVO;

/**
 * <p>
 * 商品配件关联信息 服务实现类
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Service
@RequiredArgsConstructor
public class WProductAccessoriesTypeServiceImpl extends ServiceImpl<WProductAccessoriesTypeMapper, WProductAccessoriesType> implements WProductAccessoriesTypeService {
    @Override
    public void create(WProductAccessoriesTypeCreateDTO dto){
        WProductAccessoriesType wProductAccessoriesType = BeanCopyUtils.copy(dto, WProductAccessoriesType.class);
        save(wProductAccessoriesType);
    }

    @Override
    public void update(WProductAccessoriesTypeUpdateDTO dto){
        WProductAccessoriesType wProductAccessoriesType = BeanCopyUtils.copy(dto, WProductAccessoriesType.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(WProductAccessoriesType::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        saveOrUpdate(wProductAccessoriesType);
    }

    @Override
    public PageResult<WProductAccessoriesTypeVO> page(WProductAccessoriesTypeListDTO dto){
        Page<WProductAccessoriesTypeVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), WProductAccessoriesTypeVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<WProductAccessoriesTypeVO> list(WProductAccessoriesTypeListDTO dto){
        return listAs(buildQueryWrapper(dto), WProductAccessoriesTypeVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public WProductAccessoriesTypeVO detail(Object id){
        WProductAccessoriesType wProductAccessoriesType = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(wProductAccessoriesType);
        return BeanCopyUtils.copy(wProductAccessoriesType, WProductAccessoriesTypeVO.class);
    }

    @SneakyThrows
    @Override
    public void importExcel(ImportExcelDTO dto) {
        ExcelResult<WProductAccessoriesTypeImportDTO> excelResult = ExcelUtils.importExcel(dto.getFile().getInputStream(), WProductAccessoriesTypeImportDTO.class, true);
        List<WProductAccessoriesTypeImportDTO> list = excelResult.getList();
        List<String> errorList = excelResult.getErrorList();
        String analysis = excelResult.getAnalysis();
        System.out.println(" analysis : " + analysis);
        System.out.println(" isCover : " + dto.getIsCover());
    }

    @SneakyThrows
    @Override
    public void exportExcel(WProductAccessoriesTypeListDTO dto, HttpServletResponse response) {
        List<WProductAccessoriesTypeVO> list = list(dto);
        String fileName = "商品配件关联信息模板";
        OutputStream os = FileUtils.getOutputStream(response, fileName + ".xlsx");
        ExcelUtils.exportExcel(list, "商品配件关联信息", WProductAccessoriesTypeVO.class, os);
    }

    private static QueryWrapper buildQueryWrapper(WProductAccessoriesTypeListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(WProductAccessoriesType.class);
        if (Utils.isNotNull(dto.getProductId())) {
            wrapper.eq(WProductAccessoriesType::getProductId, dto.getProductId());
        }
        if (Utils.isNotNull(dto.getAccessoriesTypeId())) {
            wrapper.eq(WProductAccessoriesType::getAccessoriesTypeId, dto.getAccessoriesTypeId());
        }
        return wrapper;
    }
}