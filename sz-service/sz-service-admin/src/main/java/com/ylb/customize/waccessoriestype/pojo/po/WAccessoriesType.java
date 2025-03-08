package com.ylb.customize.waccessoriestype.pojo.po;

import com.mybatisflex.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.io.Serial;
import com.sz.mysql.EntityChangeListener;
import java.time.LocalDateTime;

/**
* <p>
* 配件类型
* </p>
*
* @author keith.wu
* @since 2025-02-20
*/
@Data
@Table(value = "w_accessories_type", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "配件类型")
public class WAccessoriesType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    @Schema(description ="id")
    private Integer id;

    @Schema(description ="名称")
    private String name;

    @Schema(description ="横坐标（像素）")
    private Integer x;

    @Schema(description ="纵坐标")
    private Integer y;

    @Schema(description ="")
    private LocalDateTime createTime;

    @Schema(description ="配件类型")
    private LocalDateTime updateTime;

}