package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.SkuValue;

import java.util.List;

public interface SkuValueService {
    List<SkuValue> querySkuValue(Integer skuId);
}
