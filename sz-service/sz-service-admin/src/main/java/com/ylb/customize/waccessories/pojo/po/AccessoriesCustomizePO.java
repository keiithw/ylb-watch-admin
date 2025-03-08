package com.ylb.customize.waccessories.pojo.po;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * AccessoriesCustomizePO 是一个值对象，表示定制配件的详细信息。
 */
@Data
@Accessors(chain = true)
public class AccessoriesCustomizePO {
    /**
     * 配件类型的唯一标识符。
     */
    private Integer accessoriesTypeId;

    /**
     * 配件类型名称。
     */
    private String accessoriesTypeName;

    /**
     * 配件类型在 X 轴上的位置。
     */
    private Integer positionX;

    /**
     * 配件类型在 Y 轴上的位置。
     */
    private Integer positionY;

    /**
     * 标签名称。
     */
    private String tagName;

    /**
     * 配件的唯一标识符。
     */
    private Integer accessoryId;

    /**
     * 配件名称。
     */
    private String accessoryName;

    /**
     * 配件图片的 URL。
     */
    private String accessoryPictureUrl;

    /**
     * 是否为默认配件。
     */
    private Boolean isDefault;
}
