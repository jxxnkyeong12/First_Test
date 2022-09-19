package com.example.team_project01.list;

public class ListDTO {
    private int imag_store_imag;
    private String tv_category, tv_store_name, tv_point, tv_location;

    public ListDTO(int imag_store_imag, String tv_category, String tv_store_name, String tv_point, String tv_location) {
        this.imag_store_imag = imag_store_imag;
        this.tv_category = tv_category;
        this.tv_store_name = tv_store_name;
        this.tv_point = tv_point;
        this.tv_location = tv_location;
    }

    public int getImag_store_imag() {
        return imag_store_imag;
    }

    public void setImag_store_imag(int imag_store_imag) {
        this.imag_store_imag = imag_store_imag;
    }

    public String getTv_category() {
        return tv_category;
    }

    public void setTv_category(String tv_category) {
        this.tv_category = tv_category;
    }

    public String getTv_store_name() {
        return tv_store_name;
    }

    public void setTv_store_name(String tv_store_name) {
        this.tv_store_name = tv_store_name;
    }

    public String getTv_point() {
        return tv_point;
    }

    public void setTv_point(String tv_point) {
        this.tv_point = tv_point;
    }

    public String getTv_location() {
        return tv_location;
    }

    public void setTv_location(String tv_location) {
        this.tv_location = tv_location;
    }
}
