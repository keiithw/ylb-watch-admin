package com.ylb.customize.waccessoriestag.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WAccessoriesTag添加DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessoriesTag添加DTO")
public class WAccessoriesTagCreateDTO {

   @Schema(description =  "配件类型id")
   private Integer typeId;

   @Schema(description =  "标签名")
   private String tagName;

}