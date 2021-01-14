package com.fh.shop_api.api.service;

import com.fh.shop_api.api.model.po.Type;

import java.util.List;

public interface TypeService {
    List<Type> getData();

    List<Type> getDataByPid(Integer pid);

    void add(Type type);

    void update(Type type);
}
