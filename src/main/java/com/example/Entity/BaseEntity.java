package com.example.Entity;

/**
 * Created by Administrator on 2018/8/6.
 */
public class BaseEntity {
    int page=1;

    int size=2;

    String sidx="id";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
