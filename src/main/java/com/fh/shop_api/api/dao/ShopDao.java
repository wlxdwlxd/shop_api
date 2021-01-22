package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.Shop;
import com.fh.shop_api.api.model.vo.ShopVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopDao {

    @Insert("insert into shop_shop (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel)" +
            "values(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},now(),now(),'wlxd',0)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addShop(Shop shop);

    @Select("<script> select count(*) from shop_shop where 1=1  and isDel=0  </script>")
    Integer queryCount(ShopVo shopVo);

    @Select("<script>SELECT  ts.id,ts.name,ts.typeId,ts.title,ts.productdecs,ts.price,ts.stocks,ts.imgPath,tt.name as typeName,tb.name as brandName FROM shop_shop ts LEFT JOIN shop_brand tb ON ts.bandId=tb.id LEFT JOIN shop_type tt ON ts.typeId=tt.id WHERE ts.isDel=0 limit ${size*(start-1)},#{size}  </script>")
    List<Shop> queryShopByParam(ShopVo shopVo);

    @Update(" update shop_shop set isDel=1 where id=#{id} ")
    void deleteShop(Integer id);

    @Update(" update shop_shop set name=#{name},title=#{title},bandId=#{bandId},productdecs=#{productdecs}" +
            ",price=#{price},stocks=#{stocks},sortNum=#{sortNum} where id = #{id}")
    void updateShop(Shop shop);

    @Select(" select * from shop_shop where id=#{id}")
    Shop queryShopById(Integer id);
}
