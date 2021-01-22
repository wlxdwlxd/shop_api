package com.fh.shop_api.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.shop_api.api.dao.ShopDao;
import com.fh.shop_api.api.dao.ShopSkuDao;
import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.po.ShopSku;
import com.fh.shop_api.api.model.vo.BrandVo;
import com.fh.shop_api.api.model.vo.ShopVo;
import com.fh.shop_api.api.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;

    @Resource
    private ShopSkuDao shopSkuDao;

    @Override
    @Transactional
    public void addShop(Shop shop,String attr,String sku) {
        //返回主键
        shopDao.addShop(shop);
        //声明属性数据的对象
        List<ShopSku> skList = new ArrayList<>();
        //批量新增
        //将attr的json数组字符串 转为json数组对象
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i <objects.size() ; i++) {
            ShopSku ss = new ShopSku();
            ss.setProId(shop.getId());
            ss.setAttrData(objects.get(i).toString());
            //放入集合
            skList.add(ss);
        }

        //将sku的json数组字符串 转为json数组对象
        JSONArray objects1 = JSONObject.parseArray(sku);
        for (int i = 0; i <objects1.size() ; i++) {
            JSONObject dataJs = (JSONObject) objects1.get(i);
            ShopSku ss = new ShopSku();
            ss.setProId(shop.getId());
            ss.setPrice(dataJs.getDouble("pricess"));
            ss.setStorcks(dataJs.getInteger("storcks"));
            dataJs.remove("price");
            dataJs.remove("storck");
            ss.setAttrData(objects1.get(i).toString());
            skList.add(ss);
        }
        //批量新增
        shopSkuDao.adds(skList);
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

    @Override
    public void deleteShop(Integer id) {
        shopDao.deleteShop(id);
    }

    @Override
    public void updateShop(Shop shop) {
        shopDao.updateShop(shop);
    }

    @Override
    public Shop queryShopById(Integer id) {
        return shopDao.queryShopById(id);
    }
}
