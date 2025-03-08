package com.ylb.customize.wproduct.controller.api;

import com.sz.core.common.entity.ApiResult;
import com.sz.core.common.entity.PageResult;
import com.ylb.customize.wproduct.pojo.dto.WProductListDTO;
import com.ylb.customize.wproduct.pojo.vo.ProductCustomizeVO;
import com.ylb.customize.wproduct.pojo.vo.WProductVO;
import com.ylb.customize.wproduct.service.WProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final WProductService productService;

    @GetMapping("/list")
    public ApiResult<List<WProductVO>> list(WProductListDTO dto) {
        return ApiResult.success(productService.list(dto));
    }

    @GetMapping("/customizePage/{productId}")
    public ApiResult<ProductCustomizeVO> customizePage(@PathVariable String productId) {

        return null;
    }
}
