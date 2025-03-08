package com.ylb.customize.wproductaccessoriestype.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WProductAccessoriesType返回vo
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProductAccessoriesType返回vo")
public class WProductAccessoriesTypeVO {

    @ExcelIgnore
    @Schema(description =  "")
    private Integer id;

    @ExcelProperty(value = "画布id")
    @Schema(description =  "画布id")
    private Integer productId;

    @ExcelProperty(value = "配件类型id")
    @Schema(description =  "配件类型id")
    private Integer accessoriesTypeId;

}