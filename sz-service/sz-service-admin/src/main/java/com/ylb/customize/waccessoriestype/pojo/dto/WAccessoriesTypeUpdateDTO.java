package com.ylb.customize.waccessoriestype.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * WAccessoriesType修改DTO
 * </p>
 *
 * @author keith.wu
 * @since 2025-02-20
 */
@Data
@Schema(description = "WAccessoriesType修改DTO")
public class WAccessoriesTypeUpdateDTO {

    @Schema(description =  "id")
    private Integer id;

    @Schema(description =  "名称")
    private String name;

    @Schema(description =  "横坐标（像素）")
    private Integer x;

    @Schema(description =  "纵坐标")
    private Integer y;

}