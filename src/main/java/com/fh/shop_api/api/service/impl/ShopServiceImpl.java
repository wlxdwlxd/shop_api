package com.fh.shop_api.api.service.impl;

import com.fh.shop_api.api.dao.ShopDao;
import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.vo.BrandVo;
import com.fh.shop_api.api.model.vo.ShopVo;
import com.fh.shop_api.api.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;

    @Override
    public void addShop(Shop shop) {
        shopDao.addShop(shop);
    }

    @Override
    public Map queryShop(ShopVo shopVo) {
        Map map = new HashMap();
        Integer count  = shopDao.queryCount(shopVo);
        map.put("count",count);
        List<Shop> list = shopDao.queryShopByParam(shopVo);
        map.put("data",list);
        return map;
    }
}
