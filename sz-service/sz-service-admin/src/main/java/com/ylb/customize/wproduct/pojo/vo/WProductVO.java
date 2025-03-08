package com.ylb.customize.wproduct.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WProduct返回vo
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProduct返回vo")
public class WProductVO {

    @ExcelIgnore
    @Schema(description =  "id")
    private Integer id;

    @ExcelProperty(value = "商品名称")
    @Schema(description =  "商品名称")
    private String name;

    @ExcelProperty(value = "商品子名称")
    @Schema(description =  "商品子名称")
    private String subName;

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