package com.ylb.customize.wproduct.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WProduct导入DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProduct导入DTO")
public class WProductImportDTO {

    @ExcelProperty(value = "商品名称")
    @Schema(description =  "商品名称")
    private String name;

    @ExcelProperty(value = "价格")
    @Schema(description =  "价格")
    private BigDecimal price;

    @ExcelProperty(value = "正面图")
    @Schema(description =  "正面图")
    private String photoFront;

    @ExcelProperty(value = "背面图")
    @Schema(description =  "背面图")
    private String photoBack;

}