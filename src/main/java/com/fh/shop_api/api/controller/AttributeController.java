package com.fh.shop_api.api.controller;

import com.fh.shop_api.api.model.po.Attribute;
import com.fh.shop_api.api.model.vo.AttributeVo;
import com.fh.shop_api.api.model.vo.BrandVo;
import com.fh.shop_api.api.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/attribute")
public class AttributeController {

    @Resource
    private AttributeService attributeService;

    @GetMapping("queryAttribute")
    public Map queryAttribute(){
        Map map = new HashMap();
        List<Attribute> list = attributeService.queryAttribute();
        map.put("code",200);
        map.put("message","成功");
        map.put("data",list);
        return map;
    }


    @GetMapping("queryAttByPage")
    public Map queryAttByPage(AttributeVo attributeVo){
        Map map = new HashMap();
        if (attributeVo.getSize()==null){
            map.put("code",500);
            map.put("message","参数不正确");
            map.put("data","");
        }
        if (attributeVo.getStart()==null){
            map.put("code",500);
            map.put("message","参数不正确");
            map.put("data","");
        }
        Map m = attributeService.queryAttByPage(attributeVo);
        map.put("code",200);
        map.put("message","成功");
        map.put("data",m);
        return map;
    }

    @PostMapping("addAttribute")
    public Map addAttribute(Attribute attribute){
        Map map = new HashMap();
        attributeService.addAttribute(attribute);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }

    @GetMapping("deleteAttribute")
    public Map deleteAttribute(Integer id){
        Map map = new HashMap();
        attributeService.deleteAttribute(id);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }

    @GetMapping("queryAttributeById")
    public Map queryAttributeById(Integer id){
        Map map = new HashMap();
        Attribute a = attributeService.queryAttributeById(id);
        map.put("data",a);
        return map;
    }


}
