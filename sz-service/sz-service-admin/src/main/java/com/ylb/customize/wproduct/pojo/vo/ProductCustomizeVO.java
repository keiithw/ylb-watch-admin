package com.ylb.customize.wproduct.pojo.vo;

import com.ylb.customize.waccessoriestype.pojo.vo.AccessoryTypeCustomizeVO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ProductCustomizeVO 是一个值对象，表示定制产品的详细信息。
 */
@Data
@Accessors(chain = true)
public class ProductCustomizeVO {
    /**
     * 配件二级标签
     */
    private Set<String> tags = new HashSet<>();
    /**
     * 配件类型列表
     */
    private List<AccessoryTypeCustomizeVO> accessoryTypes;
}