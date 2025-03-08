package com.ylb.customize.waccessories.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ylb.customize.waccessories.pojo.po.AccessoriesCustomizePO;
import com.ylb.customize.waccessories.pojo.vo.AccessoryCustomizeVO;
import com.ylb.customize.waccessoriestype.pojo.vo.AccessoryTypeCustomizeVO;
import com.ylb.customize.wproduct.pojo.vo.ProductCustomizeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.ylb.customize.waccessories.service.WAccessoriesService;
import com.ylb.customize.waccessories.pojo.po.WAccessories;
import com.ylb.customize.waccessories.mapper.WAccessoriesMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.sz.core.common.enums.CommonResponseEnum;
import com.sz.core.util.PageUtils;
import com.sz.core.util.BeanCopyUtils;
import com.sz.core.util.Utils;
import com.sz.core.common.entity.PageResult;
import com.sz.core.common.entity.SelectIdsDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesCreateDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesUpdateDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesListDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesImportDTO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.sz.excel.core.ExcelResult;
import java.io.OutputStream;

import jakarta.servlet.http.HttpServletResponse;
import com.sz.core.util.FileUtils;
import com.sz.excel.utils.ExcelUtils;
import lombok.SneakyThrows;
import com.ylb.customize.waccessories.pojo.vo.WAccessoriesVO;

/**
 * <p>
 * 配件 服务实现类
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WAccessoriesServiceImpl extends ServiceImpl<WAccessoriesMapper, WAccessories> implements WAccessoriesService {
    /**
     * 获取配件定制列表
     */
    @Override
    public ProductCustomizeVO getAccessoryCustomizeList(Integer productId) {
        log.info("获取配件定制列表,productId:{}", productId);
        //获得原始数据
        List<AccessoriesCustomizePO> accessoriesCustomizeList = mapper.getAccessoriesCustomizeList(productId);
        ProductCustomizeVO result = new ProductCustomizeVO();
        if (CollectionUtil.isEmpty(accessoriesCustomizeList)) {
            return result.setAccessoryTypes(new ArrayList<>());
        }
        //聚合配件类型
        HashMap<Integer, AccessoryTypeCustomizeVO> accessoryTypeMap = new HashMap<>();
        for (AccessoriesCustomizePO po : accessoriesCustomizeList) {
            AccessoryTypeCustomizeVO accessoryTypeCustomizeVO = accessoryTypeMap.computeIfAbsent(po.getAccessoriesTypeId(), k -> {
                //配件类型信息设置
                AccessoryTypeCustomizeVO vo = new AccessoryTypeCustomizeVO()
                        .setAccessoriesTypeId(po.getAccessoriesTypeId())
                        .setAccessoriesTypeName(po.getAccessoriesTypeName())
                        .setPositionX(po.getPositionX())
                        .setPositionY(po.getPositionY())
                        .setAccessories(new ArrayList<>());
                return vo;
            });
            //添加分类所属配件
            accessoryTypeCustomizeVO.getAccessories().add(new AccessoryCustomizeVO()
                    .setAccessoryTagName(po.getTagName())
                    .setAccessoryId(po.getAccessoryId())
                    .setAccessoryPictureUrl(po.getAccessoryPictureUrl())
                    .setIsDefault(po.getIsDefault()));
            result.getTags().add(po.getTagName());
        }
        return result.setAccessoryTypes(new ArrayList<>(accessoryTypeMap.values()));
    }

    @Override
    public void create(WAccessoriesCreateDTO dto){
        WAccessories wAccessories = BeanCopyUtils.copy(dto, WAccessories.class);
        save(wAccessories);
    }

    @Override
    public void update(WAccessoriesUpdateDTO dto){
        WAccessories wAccessories = BeanCopyUtils.copy(dto, WAccessories.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(WAccessories::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        saveOrUpdate(wAccessories);
    }

    @Override
    public PageResult<WAccessoriesVO> page(WAccessoriesListDTO dto){
        Page<WAccessoriesVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), WAccessoriesVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<WAccessoriesVO> list(WAccessoriesListDTO dto){
        return listAs(buildQueryWrapper(dto), WAccessoriesVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public WAccessoriesVO detail(Object id){
        WAccessories wAccessories = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(wAccessories);
        return BeanCopyUtils.copy(wAccessories, WAccessoriesVO.class);
    }

    @SneakyThrows
    @Override
    public void importExcel(ImportExcelDTO dto) {
        ExcelResult<WAccessoriesImportDTO> excelResult = ExcelUtils.importExcel(dto.getFile().getInputStream(), WAccessoriesImportDTO.class, true);
        List<WAccessoriesImportDTO> list = excelResult.getList();
        List<String> errorList = excelResult.getErrorList();
        String analysis = excelResult.getAnalysis();
        System.out.println(" analysis : " + analysis);
        System.out.println(" isCover : " + dto.getIsCover());
    }

    @SneakyThrows
    @Override
    public void exportExcel(WAccessoriesListDTO dto, HttpServletResponse response) {
        List<WAccessoriesVO> list = list(dto);
        String fileName = "配件模板";
        OutputStream os = FileUtils.getOutputStream(response, fileName + ".xlsx");
        ExcelUtils.exportExcel(list, "配件", WAccessoriesVO.class, os);
    }

    private static QueryWrapper buildQueryWrapper(WAccessoriesListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(WAccessories.class);
        if (Utils.isNotNull(dto.getAccessoriesTypeId())) {
            wrapper.eq(WAccessories::getAccessoriesTypeId, dto.getAccessoriesTypeId());
        }
        if (Utils.isNotNull(dto.getAccessoriesTagId())) {
            wrapper.eq(WAccessories::getAccessoriesTagId, dto.getAccessoriesTagId());
        }
        if (Utils.isNotNull(dto.getName())) {
            wrapper.like(WAccessories::getName, dto.getName());
        }
        if (Utils.isNotNull(dto.getPictureUrl())) {
            wrapper.eq(WAccessories::getPictureUrl, dto.getPictureUrl());
        }
        return wrapper;
    }
}