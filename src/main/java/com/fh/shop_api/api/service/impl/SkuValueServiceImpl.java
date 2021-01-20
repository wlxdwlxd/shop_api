package com.fh.shop_api.api.service.impl;

import com.fh.shop_api.api.dao.SkuValueDao;
import com.fh.shop_api.api.model.po.SkuValue;
import com.fh.shop_api.api.service.SkuValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkuValueServiceImpl implements SkuValueService {

    @Resource
    private SkuValueDao skuValueDao;

    @Override
    public List<SkuValue> querySkuValue(Integer skuId) {
        return skuValueDao.querySkuValue(skuId);
    }

    @Override
    public void addSkuValue(SkuValue skuValue) {
        skuValueDao.addSkuValue(skuValue);
    }

    @Override
    public void deleteSku(Integer skuId) {
        skuValueDao.deleteSku(skuId);
    }

    @Override
    public void updateSku(SkuValue skuValue) {
        skuValueDao.updateSku(skuValue);
    }

    @Override
    public List<SkuValue> queryDataByAid(Integer aId) {
        return skuValueDao.queryDataByAid(aId);
    }
}
