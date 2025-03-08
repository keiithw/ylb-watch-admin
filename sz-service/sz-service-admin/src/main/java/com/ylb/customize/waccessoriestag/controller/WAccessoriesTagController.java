package com.ylb.customize.waccessoriestag.controller;

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
import com.ylb.customize.waccessoriestag.service.WAccessoriesTagService;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagCreateDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagUpdateDTO;
import com.ylb.customize.waccessoriestag.pojo.dto.WAccessoriesTagListDTO;
import com.ylb.customize.waccessoriestag.pojo.vo.WAccessoriesTagVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 配件二级标签 Controller
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Tag(name =  "配件二级标签")
@RestController
@RequestMapping("w-accessories-tag")
@RequiredArgsConstructor
public class WAccessoriesTagController  {

    private final WAccessoriesTagService wAccessoriesTagService;

    @Operation(summary = "新增")
    @SaCheckPermission(value = "w.accessories.tag.create")
    @PostMapping
    public ApiResult<Void> create(@RequestBody WAccessoriesTagCreateDTO dto) {
        wAccessoriesTagService.create(dto);
        return ApiResult.success();
    }

    @Operation(summary = "修改")
    @SaCheckPermission(value = "w.accessories.tag.update")
    @PutMapping
    public ApiResult<Void> update(@RequestBody WAccessoriesTagUpdateDTO dto) {
        wAccessoriesTagService.update(dto);
        return ApiResult.success();
    }

    @Operation(summary = "删除")
    @SaCheckPermission(value = "w.accessories.tag.remove")
    @DeleteMapping
    public ApiResult<Void> remove(@RequestBody SelectIdsDTO dto) {
        wAccessoriesTagService.remove(dto);
        return ApiResult.success();
    }

    @Operation(summary = "列表查询")
    @SaCheckPermission(value = "w.accessories.tag.query_table")
    @GetMapping
    public ApiResult<PageResult<WAccessoriesTagVO>> list(WAccessoriesTagListDTO dto) {
        return ApiPageResult.success(wAccessoriesTagService.page(dto));
    }

    @Operation(summary = "详情")
    @SaCheckPermission(value = "w.accessories.tag.query_table")
    @GetMapping("/{id}")
    public ApiResult<WAccessoriesTagVO> detail(@PathVariable Object id) {
        return ApiResult.success(wAccessoriesTagService.detail(id));
    }

    @Operation(summary = "导入")
    @Parameters({
      @Parameter(name = "file", description = "上传文件", schema = @Schema(type = "string", format = "binary"), required = true),
    })
    @SaCheckPermission(value = "w.accessories.tag.import")
    @PostMapping("/import")
    public void importExcel(@ModelAttribute ImportExcelDTO dto) {
        wAccessoriesTagService.importExcel(dto);
    }

    @Operation(summary = "导出")
    @SaCheckPermission(value = "w.accessories.tag.export")
    @PostMapping("/export")
    public void exportExcel(@RequestBody WAccessoriesTagListDTO dto, HttpServletResponse response) {
        wAccessoriesTagService.exportExcel(dto, response);
    }
}