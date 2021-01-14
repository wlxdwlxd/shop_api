package com.fh.shop_api.api.model.vo;

import com.fh.shop_api.api.model.po.Attribute;

public class AttributeVo extends Attribute {

    private Integer start;

    private Integer size;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
