package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.ShopSku;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopSkuDao {

    @Insert("<script>insert into shop_shop_sku (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  </foreach> </script>")
    void adds(List<ShopSku> list);
}
