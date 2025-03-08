package com.ylb.customize.waccessoriestag.pojo.po;

import com.mybatisflex.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.io.Serial;
import com.sz.mysql.EntityChangeListener;
import java.time.LocalDateTime;

/**
* <p>
* 配件二级标签
* </p>
*
* @author keith.wu
* @since 2025-02-20
*/
@Data
@Table(value = "w_accessories_tag", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "配件二级标签")
public class WAccessoriesTag implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    @Schema(description ="id")
    private Integer id;

    @Schema(description ="配件类型id")
    private Integer typeId;

    @Schema(description ="标签名")
    private String tagName;

    @Schema(description ="")
    private LocalDateTime createTime;

    @Schema(description ="")
    private LocalDateTime updateTime;

}