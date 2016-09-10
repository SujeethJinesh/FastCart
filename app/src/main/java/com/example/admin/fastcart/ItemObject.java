package com.example.admin.fastcart;

/**
 * Created by admin on 9/10/16.
 */
public class ItemObject {

    private String name;
    private String url;
    private String price;

    public ItemObject(String name, String url, String price) {
        this.name = name;
        this.url = url;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }
}
