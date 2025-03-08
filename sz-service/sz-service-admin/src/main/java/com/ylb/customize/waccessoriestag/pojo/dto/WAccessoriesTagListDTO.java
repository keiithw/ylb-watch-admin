package com.ylb.customize.waccessoriestag.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.sz.core.common.entity.PageQuery;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * <p>
 * WAccessoriesTag查询DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessoriesTag查询DTO")
public class WAccessoriesTagListDTO extends PageQuery {

    @Schema(description =  "配件类型id")
    private Integer typeId;

    @Schema(description =  "标签名")
    private String tagName;

}