package com.sunhao.entity;

import java.io.Serializable;

/**
 * 项目名称：redistest
 * 类 名 称：Goods
 * 类 描 述：TODO
 * 创建时间：2019/12/6 2:33 下午
 * 创 建 人：sunhao
 */
public class Goods implements Serializable {

    private  int id;
    private  String name;
    private  double price;
    private  int bfb;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bfb=" + bfb +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBfb() {
        return bfb;
    }

    public void setBfb(int bfb) {
        this.bfb = bfb;
    }
}
