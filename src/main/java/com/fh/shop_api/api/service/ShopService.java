package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.vo.ShopVo;

import java.util.Map;

public interface ShopService {
    void addShop(Shop shop);

    Map queryShop(ShopVo shopVo);
}
