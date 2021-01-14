package com.fh.shop_api.api.service.impl;

import com.fh.shop_api.api.dao.AttributeDao;
import com.fh.shop_api.api.model.po.Attribute;
import com.fh.shop_api.api.model.vo.AttributeVo;
import com.fh.shop_api.api.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Resource
    private AttributeDao attributeDao;

    @Override
    public List<Attribute> queryAttribute() {

        return attributeDao.queryAttribute();
    }

    @Override
    public Map queryAttByPage(AttributeVo attributeVo) {
        Map map = new HashMap();
        Integer count = attributeDao.queryCount(attributeVo);
        map.put("count",count);
        List<AttributeVo> list = attributeDao.queryAttByParam(attributeVo);
        map.put("data",list);
        return map;
    }

    @Override
    public void addAttribute(Attribute attribute) {
        attributeDao.addAttribute(attribute);
    }

    @Override
    public void deleteAttribute(Integer id) {
        attributeDao.deleteAttribute(id);
    }

    @Override
    public Attribute queryAttributeById(Integer id) {
        return attributeDao.queryAttributeById(id);
    }

    @Override
    public void updateAttributeById(Attribute attribute) {
        attributeDao.updateAttributeById(attribute);
    }
}
