package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.SkuValue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SkuValueDao {


    @Select(" select * from shop_attribute_value where 1=1 and attrId=#{skuId} and isDel=0")
    List<SkuValue> querySkuValue(Integer skuId);

    @Insert(" insert into shop_attribute_value (name,nameCH,attrId,isDel) values(#{name},#{nameCH},#{attrId},0)")
    void addSkuValue(SkuValue skuValue);

    @Delete(" update  shop_attribute_value set isDel=1 where id=#{skuId}")
    void deleteSku(Integer skuId);

    @Update(" update shop_attribute_value set name=#{name},nameCH=#{nameCH},attrId=#{attrId},isDel=0 where id=#{id}")
    void updateSku(SkuValue skuValue);
}
