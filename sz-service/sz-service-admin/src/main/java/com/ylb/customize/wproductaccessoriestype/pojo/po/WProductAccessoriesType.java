package com.ylb.customize.wproductaccessoriestype.pojo.po;

import com.mybatisflex.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.io.Serial;
import com.sz.mysql.EntityChangeListener;
import java.time.LocalDateTime;

/**
* <p>
* 商品配件关联信息
* </p>
*
* @author keith.wu
* @since 2025-02-20
*/
@Data
@Table(value = "w_product_accessories_type", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "商品配件关联信息")
public class WProductAccessoriesType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    @Schema(description ="")
    private Integer id;

    @Schema(description ="画布id")
    private Integer productId;

    @Schema(description ="配件类型id")
    private Integer accessoriesTypeId;

    @Schema(description ="")
    private LocalDateTime createTime;

    @Schema(description ="")
    private LocalDateTime updateTime;

}