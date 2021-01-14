package com.fh.shop_api.api.service.impl;

import com.fh.shop_api.api.dao.BrandDao;
import com.fh.shop_api.api.model.po.Brand;
import com.fh.shop_api.api.model.vo.BrandVo;
import com.fh.shop_api.api.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    @Override
    public Map queryBrandByPage(BrandVo brandVo) {
        Map map = new HashMap();
        Integer count  = brandDao.queryCount(brandVo);
        map.put("count",count);
        List<BrandVo> list = brandDao.queryBrandByParam(brandVo);
        map.put("data",list);
        return map;
    }

    @Override
    public void addBrand(Brand brand) {
        brandDao.addBrand(brand);
    }

    @Override
    public void deleteBrand(Integer id) {
        brandDao.deleteBrand(id);
    }

    @Override
    public Brand queryBrandById(Integer id) {
        return brandDao.queryBrandById(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDao.updateBrand(brand);
    }
}
