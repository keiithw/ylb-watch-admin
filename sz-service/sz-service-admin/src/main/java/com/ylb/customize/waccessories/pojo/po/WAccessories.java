package com.ylb.customize.waccessories.pojo.po;

import com.mybatisflex.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.io.Serial;
import com.sz.mysql.EntityChangeListener;
import java.time.LocalDateTime;

/**
* <p>
* 配件
* </p>
*
* @author keith.wu
* @since 2025-02-20
*/
@Data
@Table(value = "w_accessories", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "配件")
public class WAccessories implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    @Schema(description ="")
    private Integer id;

    @Schema(description ="配件类型id")
    private Integer accessoriesTypeId;

    @Schema(description ="标签")
    private Integer accessoriesTagId;

    @Schema(description ="配件名")
    private String name;

    @Schema(description ="图片地址")
    private String pictureUrl;

    @Schema(description ="是否默认")
    private Boolean isDefault;

    @Schema(description ="")
    private LocalDateTime createTime;

    @Schema(description ="")
    private LocalDateTime updateTime;

}