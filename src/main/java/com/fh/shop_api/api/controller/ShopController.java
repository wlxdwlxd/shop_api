package com.fh.shop_api.api.controller;

import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.vo.ShopVo;
import com.fh.shop_api.api.service.ShopService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @PostMapping("addShop")
    public Map addShop(Shop shop){
        Map map = new HashMap();
        shopService.addShop(shop);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }

    @GetMapping("queryShop")
    public Map queryShop(ShopVo shopVo){
        Map map = new HashMap();
        if (shopVo.getSize()==null){
            map.put("code",500);
            map.put("message","参数错误");
            map.put("data",map);
        }
        if (shopVo.getStart()==null){
            map.put("code",500);
            map.put("message","参数错误");
            map.put("data",map);
        }
        Map m = shopService.queryShop(shopVo);
        map.put("code",200);
        map.put("message","成功");
        map.put("data",m);
        return map;
    }

}
