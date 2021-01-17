package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.SkuValue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SkuValueDao {


    @Select(" select * from shop_attribute_value where attrId=#{skuId}")
    List<SkuValue> querySkuValue(Integer skuId);

    @Insert(" insert into shop_attribute_value (name,nameCH,attrId) values(#{name},#{nameCH},#{attrId})")
    void addSkuValue(SkuValue skuValue);

    @Delete(" delete from shop_attribute_value where id=#{skuId}")
    void deleteSku(Integer skuId);

    @Update(" update shop_attribute_value set name=#{name},nameCH=#{nameCH},attrId=#{attrId} where id=#{id}")
    void updateSku(SkuValue skuValue);
}
