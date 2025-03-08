package com.ylb.customize.waccessories.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * AccessoryCustomizeVO 是一个值对象，表示定制配件的详细信息。
 */
@Data
@Accessors(chain = true)
public class AccessoryCustomizeVO {
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

    /**
     * 配件二级标签名称。
     */
    private String accessoryTagName;
}