package com.ylb.customize.wproductaccessoriestype.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WProductAccessoriesType添加DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProductAccessoriesType添加DTO")
public class WProductAccessoriesTypeCreateDTO {

   @Schema(description =  "画布id")
   private Integer productId;

   @Schema(description =  "配件类型id")
   private Integer accessoriesTypeId;

}