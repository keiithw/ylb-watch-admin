package com.ylb.customize.waccessoriestype.pojo.vo;

import com.ylb.customize.waccessories.pojo.vo.AccessoryCustomizeVO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AccessoryTypeCustomizeVO {
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
     * 配件列表。
     */
    private List<AccessoryCustomizeVO> accessories;
}