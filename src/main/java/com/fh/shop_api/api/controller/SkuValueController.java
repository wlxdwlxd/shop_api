package com.fh.shop_api.api.controller;


import com.fh.shop_api.api.model.po.SkuValue;
import com.fh.shop_api.api.service.SkuValueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
