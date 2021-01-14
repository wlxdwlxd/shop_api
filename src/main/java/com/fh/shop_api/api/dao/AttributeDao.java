package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.Attribute;
import com.fh.shop_api.api.model.vo.AttributeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttributeDao {

    @Select(" select * from  shop_attribute")
    List<Attribute> queryAttribute();

    @Select("<script> select count(*) from shop_attribute  where 1=1  and idDel=0 </script>")
    Integer queryCount(AttributeVo attributeVo);

    @Select("<script> select * from shop_attribute  where 1=1  and idDel=0 " +
            " limit ${size*(start-1)},#{size} </script>")
    List<AttributeVo> queryAttByParam(AttributeVo attributeVo);

    @Insert("insert into shop_attribute(name,nameCH,typeId,type,isSKU,idDel,createDate,updateDate,author)" +
            " values(#{name},#{nameCH},#{typeId},#{type},#{isSKU},0,now(),now(),'wlxd')")
    void addAttribute(Attribute attribute);
}
