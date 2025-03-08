package com.ylb.customize.waccessoriestype.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ylb.customize.waccessoriestype.service.WAccessoriesTypeService;
import com.ylb.customize.waccessoriestype.pojo.po.WAccessoriesType;
import com.ylb.customize.waccessoriestype.mapper.WAccessoriesTypeMapper;
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
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeCreateDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeUpdateDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeListDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeImportDTO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.sz.excel.core.ExcelResult;
import java.io.OutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.sz.core.util.FileUtils;
import com.sz.excel.utils.ExcelUtils;
import lombok.SneakyThrows;
import com.ylb.customize.waccessoriestype.pojo.vo.WAccessoriesTypeVO;

/**
 * <p>
 * 配件类型 服务实现类
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Service
@RequiredArgsConstructor
public class WAccessoriesTypeServiceImpl extends ServiceImpl<WAccessoriesTypeMapper, WAccessoriesType> implements WAccessoriesTypeService {
    @Override
    public void create(WAccessoriesTypeCreateDTO dto){
        WAccessoriesType wAccessoriesType = BeanCopyUtils.copy(dto, WAccessoriesType.class);
        save(wAccessoriesType);
    }

    @Override
    public void update(WAccessoriesTypeUpdateDTO dto){
        WAccessoriesType wAccessoriesType = BeanCopyUtils.copy(dto, WAccessoriesType.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(WAccessoriesType::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        saveOrUpdate(wAccessoriesType);
    }

    @Override
    public PageResult<WAccessoriesTypeVO> page(WAccessoriesTypeListDTO dto){
        Page<WAccessoriesTypeVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), WAccessoriesTypeVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<WAccessoriesTypeVO> list(WAccessoriesTypeListDTO dto){
        return listAs(buildQueryWrapper(dto), WAccessoriesTypeVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public WAccessoriesTypeVO detail(Object id){
        WAccessoriesType wAccessoriesType = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(wAccessoriesType);
        return BeanCopyUtils.copy(wAccessoriesType, WAccessoriesTypeVO.class);
    }

    @SneakyThrows
    @Override
    public void importExcel(ImportExcelDTO dto) {
        ExcelResult<WAccessoriesTypeImportDTO> excelResult = ExcelUtils.importExcel(dto.getFile().getInputStream(), WAccessoriesTypeImportDTO.class, true);
        List<WAccessoriesTypeImportDTO> list = excelResult.getList();
        List<String> errorList = excelResult.getErrorList();
        String analysis = excelResult.getAnalysis();
        System.out.println(" analysis : " + analysis);
        System.out.println(" isCover : " + dto.getIsCover());
    }

    @SneakyThrows
    @Override
    public void exportExcel(WAccessoriesTypeListDTO dto, HttpServletResponse response) {
        List<WAccessoriesTypeVO> list = list(dto);
        String fileName = "配件类型模板";
        OutputStream os = FileUtils.getOutputStream(response, fileName + ".xlsx");
        ExcelUtils.exportExcel(list, "配件类型", WAccessoriesTypeVO.class, os);
    }

    private static QueryWrapper buildQueryWrapper(WAccessoriesTypeListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(WAccessoriesType.class);
        if (Utils.isNotNull(dto.getName())) {
            wrapper.like(WAccessoriesType::getName, dto.getName());
        }
        if (Utils.isNotNull(dto.getX())) {
            wrapper.eq(WAccessoriesType::getX, dto.getX());
        }
        if (Utils.isNotNull(dto.getY())) {
            wrapper.eq(WAccessoriesType::getY, dto.getY());
        }
        return wrapper;
    }
}