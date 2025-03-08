package com.ylb.customize.wproductaccessoriestype.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WProductAccessoriesType导入DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProductAccessoriesType导入DTO")
public class WProductAccessoriesTypeImportDTO {

    @ExcelProperty(value = "画布id")
    @Schema(description =  "画布id")
    private Integer productId;

    @ExcelProperty(value = "配件类型id")
    @Schema(description =  "配件类型id")
    private Integer accessoriesTypeId;

}