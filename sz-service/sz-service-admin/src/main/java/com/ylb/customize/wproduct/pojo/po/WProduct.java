package com.ylb.customize.wproduct.pojo.po;

import cn.idev.excel.annotation.ExcelProperty;
import com.mybatisflex.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.io.Serial;
import com.sz.mysql.EntityChangeListener;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* <p>
* 商品
* </p>
*
* @author keith.wu
* @since 2025-02-20
*/
@Data
@Table(value = "w_product", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "商品")
public class WProduct implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    @Schema(description ="id")
    private Integer id;

    @Schema(description ="商品名称")
    private String name;

    @Schema(description =  "商品子名称")
    private String subName;

    @Schema(description ="价格")
    private BigDecimal price;

    @Schema(description ="正面图")
    private String photoFront;

    @Schema(description ="背面图")
    private String photoBack;

    @Schema(description ="")
    private LocalDateTime createTime;

    @Schema(description ="")
    private LocalDateTime updateTime;

}