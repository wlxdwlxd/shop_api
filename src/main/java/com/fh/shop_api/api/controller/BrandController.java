package com.fh.shop_api.api.controller;

import com.fh.shop_api.api.model.po.Brand;
import com.fh.shop_api.api.model.vo.BrandVo;
import com.fh.shop_api.api.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping("queryBrandByPage")
    public Map queryBrandByPage(BrandVo brandVo){
        Map map = new HashMap();
        if (brandVo.getSize()==null){
            map.put("code",500);
            map.put("message","参数不符合要求");
            map.put("data","");
            return map;
        }
        if (brandVo.getStart()==null){
            map.put("code",500);
            map.put("message","参数不符合要求");
            map.put("data","");
            return map;
        }
        Map m = brandService.queryBrandByPage(brandVo);
        map.put("code",200);
        map.put("message","成功");
        map.put("data",m);
        return map;
    }

    @GetMapping("queryBrand")
    public Map queryBrand(){
        Map map = new HashMap();
        List<Brand> list = brandService.queryBrand();
        map.put("code",200);
        map.put("message","成功");
        map.put("data",list);
        return map;
    }

    @PostMapping("addBrand")
    public Map addBrand(Brand brand){
        Map map = new HashMap();
        brandService.addBrand(brand);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }

    @GetMapping("deleteBrand")
    public Map deleteBrand(Integer id){
        Map map = new HashMap();
        brandService.deleteBrand(id);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }

    @GetMapping("queryBrandById")
    public Map queryBrandById(Integer id){
        Map map = new HashMap();
        Brand brand = brandService.queryBrandById(id);
        map.put("data",brand);
        return map;
    }

    @PostMapping("updateBrand")
    public Map updateBrand(Brand brand){
        Map map = new HashMap();
        brandService.updateBrand(brand);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }
}
