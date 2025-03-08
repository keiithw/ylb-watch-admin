package com.ylb.customize.waccessories.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WAccessories导入DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessories导入DTO")
public class WAccessoriesImportDTO {

    @ExcelProperty(value = "配件类型id")
    @Schema(description =  "配件类型id")
    private Integer accessoriesTypeId;

    @ExcelProperty(value = "标签")
    @Schema(description =  "标签")
    private Integer accessoriesTagId;

    @ExcelProperty(value = "配件名")
    @Schema(description =  "配件名")
    private String name;

    @ExcelProperty(value = "图片地址")
    @Schema(description =  "图片地址")
    private String pictureUrl;

}