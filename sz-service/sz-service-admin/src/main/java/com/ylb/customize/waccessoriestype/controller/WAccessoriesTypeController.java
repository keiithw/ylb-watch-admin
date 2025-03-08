package com.ylb.customize.waccessoriestype.controller;

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
import com.ylb.customize.waccessoriestype.service.WAccessoriesTypeService;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeCreateDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeUpdateDTO;
import com.ylb.customize.waccessoriestype.pojo.dto.WAccessoriesTypeListDTO;
import com.ylb.customize.waccessoriestype.pojo.vo.WAccessoriesTypeVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 配件类型 Controller
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Tag(name =  "配件类型")
@RestController
@RequestMapping("w-accessories-type")
@RequiredArgsConstructor
public class WAccessoriesTypeController  {

    private final WAccessoriesTypeService wAccessoriesTypeService;

    @Operation(summary = "新增")
    @SaCheckPermission(value = "w.accessories.type.create")
    @PostMapping
    public ApiResult<Void> create(@RequestBody WAccessoriesTypeCreateDTO dto) {
        wAccessoriesTypeService.create(dto);
        return ApiResult.success();
    }

    @Operation(summary = "修改")
    @SaCheckPermission(value = "w.accessories.type.update")
    @PutMapping
    public ApiResult<Void> update(@RequestBody WAccessoriesTypeUpdateDTO dto) {
        wAccessoriesTypeService.update(dto);
        return ApiResult.success();
    }

    @Operation(summary = "删除")
    @SaCheckPermission(value = "w.accessories.type.remove")
    @DeleteMapping
    public ApiResult<Void> remove(@RequestBody SelectIdsDTO dto) {
        wAccessoriesTypeService.remove(dto);
        return ApiResult.success();
    }

    @Operation(summary = "列表查询")
    @SaCheckPermission(value = "w.accessories.type.query_table")
    @GetMapping
    public ApiResult<PageResult<WAccessoriesTypeVO>> list(WAccessoriesTypeListDTO dto) {
        return ApiPageResult.success(wAccessoriesTypeService.page(dto));
    }

    @Operation(summary = "详情")
    @SaCheckPermission(value = "w.accessories.type.query_table")
    @GetMapping("/{id}")
    public ApiResult<WAccessoriesTypeVO> detail(@PathVariable Object id) {
        return ApiResult.success(wAccessoriesTypeService.detail(id));
    }

    @Operation(summary = "导入")
    @Parameters({
      @Parameter(name = "file", description = "上传文件", schema = @Schema(type = "string", format = "binary"), required = true),
    })
    @SaCheckPermission(value = "w.accessories.type.import")
    @PostMapping("/import")
    public void importExcel(@ModelAttribute ImportExcelDTO dto) {
        wAccessoriesTypeService.importExcel(dto);
    }

    @Operation(summary = "导出")
    @SaCheckPermission(value = "w.accessories.type.export")
    @PostMapping("/export")
    public void exportExcel(@RequestBody WAccessoriesTypeListDTO dto, HttpServletResponse response) {
        wAccessoriesTypeService.exportExcel(dto, response);
    }
}