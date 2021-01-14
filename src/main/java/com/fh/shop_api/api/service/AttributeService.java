package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.Attribute;
import com.fh.shop_api.api.model.vo.AttributeVo;

import java.util.List;
import java.util.Map;

public interface AttributeService {
    List<Attribute> queryAttribute();

    Map queryAttByPage(AttributeVo attributeVo);

    void addAttribute(Attribute attribute);

}
