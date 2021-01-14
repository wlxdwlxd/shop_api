package com.fh.shop_api.api.dao;

import com.fh.shop_api.api.model.po.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeDao {

    @Select(" select * from shop_type where isDel=0")
    List<Type> getData();

    @Select(" select * from shop_type where pid=#{pid} ")
    List<Type> getDataByPid(Integer pid);

    void add(Type type);

    @Update("update shop_type set name=#{name},pid=#{pid},updateDate=now(),isDel=#{isDel} where id=#{id}")
    void update(Type type);
}
