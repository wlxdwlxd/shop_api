package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.vo.ShopVo;

import java.util.Map;

public interface ShopService {
    void addShop(Shop shop,String attr,String sku);

    Map queryShop(ShopVo shopVo);

    void deleteShop(Integer id);

    void updateShop(Shop shop);

    Shop queryShopById(Integer id);
}
