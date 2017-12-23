package com.lianxi.zy.myrookie.bean;

/**
 * Created by 杜梦豪 on 2017/12/23.
 */

public class EventPriceAndNum {
   public int price;
   public int num;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "EventPriceAndNum{" +
                "price=" + price +
                ", num=" + num +
                '}';
    }
}
