package com.ylb.customize.waccessoriestype.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WAccessoriesType导入DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessoriesType导入DTO")
public class WAccessoriesTypeImportDTO {

    @ExcelProperty(value = "名称")
    @Schema(description =  "名称")
    private String name;

    @ExcelProperty(value = "横坐标（像素）")
    @Schema(description =  "横坐标（像素）")
    private Integer x;

    @ExcelProperty(value = "纵坐标")
    @Schema(description =  "纵坐标")
    private Integer y;

}