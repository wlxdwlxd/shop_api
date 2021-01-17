package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.SkuValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkuValueDao {


    @Select(" select * from shop_attribute_value where attrId=#{skuId}")
    List<SkuValue> querySkuValue(Integer skuId);
}
