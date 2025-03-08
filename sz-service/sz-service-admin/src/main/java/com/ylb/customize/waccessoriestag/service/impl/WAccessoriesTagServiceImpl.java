package com.ylb.customize.waccessoriestag.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ylb.customize.waccessoriestag.service.WAccessoriesTagService;
import com.ylb.customize.waccessoriestag.pojo.po.WAccessoriesTag;
import com.ylb.customize.waccessoriestag.mapper.WAccessoriesTagMapper;
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
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagCreateDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagUpdateDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagListDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagImportDTO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.sz.excel.core.ExcelResult;
import java.io.OutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.sz.core.util.FileUtils;
import com.sz.excel.utils.ExcelUtils;
import lombok.SneakyThrows;
import com.ylb.customize.waccessoriestag.pojo.vo.WAccessoriesTagVO;

/**
 * <p>
 * 配件二级标签 服务实现类
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Service
@RequiredArgsConstructor
public class WAccessoriesTagServiceImpl extends ServiceImpl<WAccessoriesTagMapper, WAccessoriesTag> implements WAccessoriesTagService {
    @Override
    public void create(WAccessoriesTagCreateDTO dto){
        WAccessoriesTag wAccessoriesTag = BeanCopyUtils.copy(dto, WAccessoriesTag.class);
        save(wAccessoriesTag);
    }

    @Override
    public void update(WAccessoriesTagUpdateDTO dto){
        WAccessoriesTag wAccessoriesTag = BeanCopyUtils.copy(dto, WAccessoriesTag.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(WAccessoriesTag::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        saveOrUpdate(wAccessoriesTag);
    }

    @Override
    public PageResult<WAccessoriesTagVO> page(WAccessoriesTagListDTO dto){
        Page<WAccessoriesTagVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), WAccessoriesTagVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<WAccessoriesTagVO> list(WAccessoriesTagListDTO dto){
        return listAs(buildQueryWrapper(dto), WAccessoriesTagVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public WAccessoriesTagVO detail(Object id){
        WAccessoriesTag wAccessoriesTag = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(wAccessoriesTag);
        return BeanCopyUtils.copy(wAccessoriesTag, WAccessoriesTagVO.class);
    }

    @SneakyThrows
    @Override
    public void importExcel(ImportExcelDTO dto) {
        ExcelResult<WAccessoriesTagImportDTO> excelResult = ExcelUtils.importExcel(dto.getFile().getInputStream(), WAccessoriesTagImportDTO.class, true);
        List<WAccessoriesTagImportDTO> list = excelResult.getList();
        List<String> errorList = excelResult.getErrorList();
        String analysis = excelResult.getAnalysis();
        System.out.println(" analysis : " + analysis);
        System.out.println(" isCover : " + dto.getIsCover());
    }

    @SneakyThrows
    @Override
    public void exportExcel(WAccessoriesTagListDTO dto, HttpServletResponse response) {
        List<WAccessoriesTagVO> list = list(dto);
        String fileName = "配件二级标签模板";
        OutputStream os = FileUtils.getOutputStream(response, fileName + ".xlsx");
        ExcelUtils.exportExcel(list, "配件二级标签", WAccessoriesTagVO.class, os);
    }

    private static QueryWrapper buildQueryWrapper(WAccessoriesTagListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(WAccessoriesTag.class);
        if (Utils.isNotNull(dto.getTypeId())) {
            wrapper.eq(WAccessoriesTag::getTypeId, dto.getTypeId());
        }
        if (Utils.isNotNull(dto.getTagName())) {
            wrapper.like(WAccessoriesTag::getTagName, dto.getTagName());
        }
        return wrapper;
    }
}