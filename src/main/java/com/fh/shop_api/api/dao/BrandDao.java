package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.Brand;
import com.fh.shop_api.api.model.vo.BrandVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BrandDao {

    @Select("<script> select count(*) from shop_brand where 1=1  and isDel=0 " +
            " <if test='name !=null'> and name like '%${name}%' </if>" +
            "</script>")
    Integer queryCount(BrandVo brandVo);

    @Select("<script> select * from shop_brand where 1=1  and isDel=0 " +
            " <if test='name !=null'> and name like '%${name}%' </if>" +
            " limit ${size*(start-1)},#{size}  </script>")
    List<BrandVo> queryBrandByParam(BrandVo brandVo);

    @Insert("insert into shop_brand(name,bandE,imgPath,bandDesc,ord,isDel,createDate,updateDate,author)" +
            " values(#{name},#{bandE},#{imgPath},#{bandDesc},#{ord},#{isDel},now(),now(),'wlxd')")
    void addBrand(Brand brand);

    @Update(" update shop_brand set isDel=1 where id=#{id} ")
    void deleteBrand(Integer id);

    @Select(" select * from shop_brand where id=#{id}")
    Brand queryBrandById(Integer id);

    @Update("update shop_brand set name=#{name},bandE=#{bandE},imgPath=#{imgPath}" +
            ",bandDesc=#{bandDesc},ord=#{ord},isDel=#{isDel},createDate=now()," +
            " updateDate=now(),author='wlxd' where id=#{id}")
    void updateBrand(Brand brand);

    @Select(" select * from shop_brand where 1=1  and isDel=0")
    List<Brand> queryBrand();
}
