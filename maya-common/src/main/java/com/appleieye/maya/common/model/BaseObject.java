package com.appleieye.maya.common.model;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author: wujianjun
 * @date: 2018-04-11
 * @description:
 */

public class BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;


    public BaseObject(){

    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj,new String[0]);

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,new String[0]);
    }

}
