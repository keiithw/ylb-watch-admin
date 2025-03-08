package com.ylb.customize.wproductaccessoriestype.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.sz.core.common.entity.PageQuery;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WProductAccessoriesType查询DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProductAccessoriesType查询DTO")
public class WProductAccessoriesTypeListDTO extends PageQuery {

    @Schema(description =  "画布id")
    private Integer productId;

    @Schema(description =  "配件类型id")
    private Integer accessoriesTypeId;

}