package com.ylb.customize.waccessoriestag.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WAccessoriesTag导入DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessoriesTag导入DTO")
public class WAccessoriesTagImportDTO {

    @ExcelProperty(value = "配件类型id")
    @Schema(description =  "配件类型id")
    private Integer typeId;

    @ExcelProperty(value = "标签名")
    @Schema(description =  "标签名")
    private String tagName;

}