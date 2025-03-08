package com.ylb.customize.waccessoriestag.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WAccessoriesTag修改DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessoriesTag修改DTO")
public class WAccessoriesTagUpdateDTO {

    @Schema(description =  "id")
    private Integer id;

    @Schema(description =  "配件类型id")
    private Integer typeId;

    @Schema(description =  "标签名")
    private String tagName;

}