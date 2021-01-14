package com.fh.shop_api.api.service.impl;

import com.fh.shop_api.api.dao.TypeDao;
import com.fh.shop_api.api.model.po.Type;
import com.fh.shop_api.api.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;

    @Override
    public List<Type> getData() {
        return typeDao.getData();
    }

    @Override
    public List<Type> getDataByPid(Integer pid) {
        return typeDao.getDataByPid(pid);
    }

    @Override
    public void add(Type type) {
        typeDao.add(type);
    }

    @Override
    public void update(Type type) {
        typeDao.update(type);
    }


}
