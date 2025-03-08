package com.ylb.customize.director;

import com.ylb.customize.waccessories.service.WAccessoriesService;
import com.ylb.customize.wproduct.pojo.vo.ProductCustomizeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomizeDirector {
    private final WAccessoriesService accessoriesService;

    public ProductCustomizeVO getProductCustomizeVO(Integer productId) {
        return accessoriesService.getAccessoryCustomizeList(productId);
    }
}
