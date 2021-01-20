package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.SkuValue;

import java.util.List;

public interface SkuValueService {
    List<SkuValue> querySkuValue(Integer skuId);

    void addSkuValue(SkuValue skuValue);

    void deleteSku(Integer skuId);

    void updateSku(SkuValue skuValue);

    List<SkuValue> queryDataByAid(Integer aId);
}
