package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.Brand;
import com.fh.shop_api.api.model.vo.BrandVo;

import java.util.Map;

public interface BrandService {
    Map queryBrandByPage(BrandVo brandVo);

    void addBrand(Brand brand);

    void deleteBrand(Integer id);

    Brand queryBrandById(Integer id);

    void updateBrand(Brand brand);
}
