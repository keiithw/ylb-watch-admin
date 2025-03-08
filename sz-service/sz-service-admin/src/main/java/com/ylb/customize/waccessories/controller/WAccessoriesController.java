package com.ylb.customize.waccessories.controller;

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
import com.ylb.customize.waccessories.service.WAccessoriesService;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesCreateDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesUpdateDTO;
import com.ylb.customize.waccessories.pojo.dto.WAccessoriesListDTO;
import com.ylb.customize.waccessories.pojo.vo.WAccessoriesVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 配件 Controller
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Tag(name =  "配件")
@RestController
@RequestMapping("w-accessories")
@RequiredArgsConstructor
public class WAccessoriesController  {

    private final WAccessoriesService wAccessoriesService;

    @Operation(summary = "新增")
    @SaCheckPermission(value = "w.accessories.create")
    @PostMapping
    public ApiResult<Void> create(@RequestBody WAccessoriesCreateDTO dto) {
        wAccessoriesService.create(dto);
        return ApiResult.success();
    }

    @Operation(summary = "修改")
    @SaCheckPermission(value = "w.accessories.update")
    @PutMapping
    public ApiResult<Void> update(@RequestBody WAccessoriesUpdateDTO dto) {
        wAccessoriesService.update(dto);
        return ApiResult.success();
    }

    @Operation(summary = "删除")
    @SaCheckPermission(value = "w.accessories.remove")
    @DeleteMapping
    public ApiResult<Void> remove(@RequestBody SelectIdsDTO dto) {
        wAccessoriesService.remove(dto);
        return ApiResult.success();
    }

    @Operation(summary = "列表查询")
    @SaCheckPermission(value = "w.accessories.query_table")
    @GetMapping
    public ApiResult<PageResult<WAccessoriesVO>> list(WAccessoriesListDTO dto) {
        return ApiPageResult.success(wAccessoriesService.page(dto));
    }

    @Operation(summary = "详情")
    @SaCheckPermission(value = "w.accessories.query_table")
    @GetMapping("/{id}")
    public ApiResult<WAccessoriesVO> detail(@PathVariable Object id) {
        return ApiResult.success(wAccessoriesService.detail(id));
    }

    @Operation(summary = "导入")
    @Parameters({
      @Parameter(name = "file", description = "上传文件", schema = @Schema(type = "string", format = "binary"), required = true),
    })
    @SaCheckPermission(value = "w.accessories.import")
    @PostMapping("/import")
    public void importExcel(@ModelAttribute ImportExcelDTO dto) {
        wAccessoriesService.importExcel(dto);
    }

    @Operation(summary = "导出")
    @SaCheckPermission(value = "w.accessories.export")
    @PostMapping("/export")
    public void exportExcel(@RequestBody WAccessoriesListDTO dto, HttpServletResponse response) {
        wAccessoriesService.exportExcel(dto, response);
    }
}