package com.domain;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.domain
 * @author wangzhenxin
 * @date 2017-10-16 10:10
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Map;

/**
 * @author wangzhenxin
 * @ClassName Test
 * @Description 类描述
 * @date 2017-10-16
 */
public class Test {
    private Long Id;
    private String Name;
    private Customer customer;
    private Map<Object,Object> map;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Test(Long id) {
        Id = id;
    }

    public Test(Long id, String name) {
        Id = id;
        Name = name;
    }

    public Test(Customer customer, String name) {
        this.customer = customer;
        Name = name;
    }

    public Test() {

    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }
}
