package com.ylb.customize.wproductaccessoriestype.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import com.sz.core.common.entity.ApiPageResult;
import com.sz.core.common.entity.ApiResult;
import com.sz.core.common.constant.GlobalConstant;
import com.sz.core.common.entity.PageResult;
import com.sz.core.common.entity.SelectIdsDTO;
import com.ylb.customize.wproductaccessoriestype.service.WProductAccessoriesTypeService;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeCreateDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeUpdateDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.dto.WProductAccessoriesTypeListDTO;
import com.ylb.customize.wproductaccessoriestype.pojo.vo.WProductAccessoriesTypeVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 商品配件关联信息 Controller
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Tag(name =  "商品配件关联信息")
@RestController
@RequestMapping("w-product-accessories-type")
@RequiredArgsConstructor
public class WProductAccessoriesTypeController  {

    private final WProductAccessoriesTypeService wProductAccessoriesTypeService;

    @Operation(summary = "新增")
    @SaCheckPermission(value = "w.product.accessories.type.create")
    @PostMapping
    public ApiResult<Void> create(@RequestBody WProductAccessoriesTypeCreateDTO dto) {
        wProductAccessoriesTypeService.create(dto);
        return ApiResult.success();
    }

    @Operation(summary = "修改")
    @SaCheckPermission(value = "w.product.accessories.type.update")
    @PutMapping
    public ApiResult<Void> update(@RequestBody WProductAccessoriesTypeUpdateDTO dto) {
        wProductAccessoriesTypeService.update(dto);
        return ApiResult.success();
    }

    @Operation(summary = "删除")
    @SaCheckPermission(value = "w.product.accessories.type.remove")
    @DeleteMapping
    public ApiResult<Void> remove(@RequestBody SelectIdsDTO dto) {
        wProductAccessoriesTypeService.remove(dto);
        return ApiResult.success();
    }

    @Operation(summary = "列表查询")
    @SaCheckPermission(value = "w.product.accessories.type.query_table")
    @GetMapping
    public ApiResult<PageResult<WProductAccessoriesTypeVO>> list(WProductAccessoriesTypeListDTO dto) {
        return ApiPageResult.success(wProductAccessoriesTypeService.page(dto));
    }

    @Operation(summary = "详情")
    @SaCheckPermission(value = "w.product.accessories.type.query_table")
    @GetMapping("/{id}")
    public ApiResult<WProductAccessoriesTypeVO> detail(@PathVariable Object id) {
        return ApiResult.success(wProductAccessoriesTypeService.detail(id));
    }

    @Operation(summary = "导入")
    @Parameters({
      @Parameter(name = "file", description = "上传文件", schema = @Schema(type = "string", format = "binary"), required = true),
    })
    @SaCheckPermission(value = "w.product.accessories.type.import")
    @PostMapping("/import")
    public void importExcel(@ModelAttribute ImportExcelDTO dto) {
        wProductAccessoriesTypeService.importExcel(dto);
    }

    @Operation(summary = "导出")
    @SaCheckPermission(value = "w.product.accessories.type.export")
    @PostMapping("/export")
    public void exportExcel(@RequestBody WProductAccessoriesTypeListDTO dto, HttpServletResponse response) {
        wProductAccessoriesTypeService.exportExcel(dto, response);
    }
}