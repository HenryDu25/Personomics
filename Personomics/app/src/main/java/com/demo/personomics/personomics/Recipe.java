package com.demo.personomics.personomics;

/**
 * Created by umeshkhanna on 2016-11-18.
 */

public class Recipe {
    private String name;
    private int picNum;
    private String url;

    public Recipe(String n, int p, String u) {
        name = n;
        picNum = p;
        url = u;
    }

    public String getName() {
        return name;
    }

    public int getPicNum() {
        return picNum;
    }

    public String getUrl() {
        return url;
    }
}
