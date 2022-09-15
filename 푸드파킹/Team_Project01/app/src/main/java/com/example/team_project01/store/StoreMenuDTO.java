package com.example.team_project01.store;

public class StoreMenuDTO {
    private int imgv_menu_image;
    private String tv_menu_name, tv_menu_price;

    public StoreMenuDTO(int imgv_menu_image, String tv_menu_name, String tv_menu_price) {
        this.imgv_menu_image = imgv_menu_image;
        this.tv_menu_name = tv_menu_name;
        this.tv_menu_price = tv_menu_price;
    }

    public int getImgv_menu_image() {
        return imgv_menu_image;
    }

    public void setImgv_menu_image(int imgv_menu_image) {
        this.imgv_menu_image = imgv_menu_image;
    }

    public String getTv_menu_name() {
        return tv_menu_name;
    }

    public void setTv_menu_name(String tv_menu_name) {
        this.tv_menu_name = tv_menu_name;
    }

    public String getTv_menu_price() {
        return tv_menu_price;
    }

    public void setTv_menu_price(String tv_menu_price) {
        this.tv_menu_price = tv_menu_price;
    }
}