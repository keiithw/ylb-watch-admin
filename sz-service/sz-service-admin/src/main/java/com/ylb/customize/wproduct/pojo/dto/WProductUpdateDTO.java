package com.ylb.customize.wproduct.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WProduct修改DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WProduct修改DTO")
public class WProductUpdateDTO {

    @Schema(description =  "id")
    private Integer id;

    @Schema(description =  "商品名称")
    private String name;

    @Schema(description =  "价格")
    private BigDecimal price;

    @Schema(description =  "正面图")
    private String photoFront;

    @Schema(description =  "背面图")
    private String photoBack;

}