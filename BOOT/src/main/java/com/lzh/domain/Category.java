package com.lzh.domain;

import java.util.Set;

public class Category {

    private String cid;
    private String name;
    private Set<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' + '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
