package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.vo.ShopVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopDao {

    @Insert("insert into shop_shop (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel)" +
            "values(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},now(),now(),'wlxd',0)")
    void addShop(Shop shop);

    @Select("<script> select count(*) from shop_shop where 1=1  and isDel=0  </script>")
    Integer queryCount(ShopVo shopVo);

    @Select("<script> select * from shop_shop where 1=1  and isDel=0 " +
            " limit ${size*(start-1)},#{size}  </script>")
    List<Shop> queryShopByParam(ShopVo shopVo);
}
