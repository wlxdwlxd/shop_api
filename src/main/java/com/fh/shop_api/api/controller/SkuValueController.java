package com.fh.shop_api.api.controller;


import com.fh.shop_api.api.model.po.SkuValue;
import com.fh.shop_api.api.service.SkuValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/skuValue")
public class SkuValueController {

    @Resource
    private SkuValueService skuValueService;

    @GetMapping("querySkuValue")
    public Map querySkuValue(Integer skuId){
        Map map = new HashMap();
        List<SkuValue> list = skuValueService.querySkuValue(skuId);
        map.put("code",200);
        map.put("message","查询成功");
        map.put("data",list);
        return map;
    }

    @PostMapping("addSkuValue")
    public Map addSkuValue(SkuValue skuValue){
        Map map = new HashMap();
        skuValueService.addSkuValue(skuValue);
        map.put("code",200);
        map.put("message","新增成功");
        return map;
    }

    @GetMapping("deleteSku")
    public Map deleteSku(Integer skuId){
        Map map = new HashMap();
        skuValueService.deleteSku(skuId);
        map.put("code",200);
        map.put("message","删除成功");
        return map;
    }
}
