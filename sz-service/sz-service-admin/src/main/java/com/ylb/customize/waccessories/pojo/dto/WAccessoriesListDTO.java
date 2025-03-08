package com.ylb.customize.waccessories.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.sz.core.common.entity.PageQuery;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WAccessories查询DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessories查询DTO")
public class WAccessoriesListDTO extends PageQuery {

    @Schema(description =  "配件类型id")
    private Integer accessoriesTypeId;

    @Schema(description =  "标签")
    private Integer accessoriesTagId;

    @Schema(description =  "配件名")
    private String name;

    @Schema(description =  "图片地址")
    private String pictureUrl;

}