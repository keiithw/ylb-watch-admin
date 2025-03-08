package com.ylb.customize.wproduct.controller;

import com.ylb.customize.director.CustomizeDirector;
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
import com.ylb.customize.wproduct.service.WProductService;
import com.ylb.customize.wproduct.pojo.dto.WProductCreateDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductUpdateDTO;
import com.ylb.customize.wproduct.pojo.dto.WProductListDTO;
import com.ylb.customize.wproduct.pojo.vo.WProductVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 商品 Controller
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Tag(name =  "商品")
@RestController
@RequestMapping("w-product")
@RequiredArgsConstructor
public class WProductController  {

    private final WProductService wProductService;
    private final CustomizeDirector customizeDirector;

    @GetMapping("/test")
    @SaCheckPermission(value = {})
    public ApiResult test() {
        return ApiResult.success(customizeDirector.getProductCustomizeVO(1));
    }

    @Operation(summary = "新增")
    @SaCheckPermission(value = "w.product.create")
    @PostMapping
    public ApiResult<Void> create(@RequestBody WProductCreateDTO dto) {
        wProductService.create(dto);
        return ApiResult.success();
    }

    @Operation(summary = "修改")
    @SaCheckPermission(value = "w.product.update")
    @PutMapping
    public ApiResult<Void> update(@RequestBody WProductUpdateDTO dto) {
        wProductService.update(dto);
        return ApiResult.success();
    }

    @Operation(summary = "删除")
    @SaCheckPermission(value = "w.product.remove")
    @DeleteMapping
    public ApiResult<Void> remove(@RequestBody SelectIdsDTO dto) {
        wProductService.remove(dto);
        return ApiResult.success();
    }

    @Operation(summary = "列表查询")
    @SaCheckPermission(value = "w.product.query_table")
    @GetMapping
    public ApiResult<PageResult<WProductVO>> list(WProductListDTO dto) {
        return ApiPageResult.success(wProductService.page(dto));
    }

    @Operation(summary = "详情")
    @SaCheckPermission(value = "w.product.query_table")
    @GetMapping("/{id}")
    public ApiResult<WProductVO> detail(@PathVariable Object id) {
        return ApiResult.success(wProductService.detail(id));
    }

    @Operation(summary = "导入")
    @Parameters({
      @Parameter(name = "file", description = "上传文件", schema = @Schema(type = "string", format = "binary"), required = true),
    })
    @SaCheckPermission(value = "w.product.import")
    @PostMapping("/import")
    public void importExcel(@ModelAttribute ImportExcelDTO dto) {
        wProductService.importExcel(dto);
    }

    @Operation(summary = "导出")
    @SaCheckPermission(value = "w.product.export")
    @PostMapping("/export")
    public void exportExcel(@RequestBody WProductListDTO dto, HttpServletResponse response) {
        wProductService.exportExcel(dto, response);
    }
}