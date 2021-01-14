package com.fh.shop_api.api.controller;

import com.fh.shop_api.api.model.po.Type;
import com.fh.shop_api.api.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class TypeController {

    @Resource
    private TypeService typeService;


    @GetMapping("getData")
    public Map getData(){
        Map map = new HashMap();
        List<Type> list = typeService.getData();
        map.put("code",200);
        map.put("message","查询成功");
        map.put("data",list);
        return map;
    }

    @GetMapping("getDataByPid")
    public Map getDataByPid(Integer pid){
        Map map = new HashMap();
        List<Type> list = typeService.getDataByPid(pid);
        map.put("code",200);
        map.put("message","查询成功");
        map.put("data",list);
        return map;
    }

    @PostMapping("add")
    public Map add(Type type){
        Map map = new HashMap();
        typeService.add(type);
        map.put("code",200);
        map.put("message","新增成功");
        map.put("data",type.getId());
        return map;
    }

    @PostMapping("update")
    public Map update(Type type){
        Map map = new HashMap();
        typeService.update(type);
        map.put("code",200);
        map.put("message","修改成功");
        return map;
    }

}
