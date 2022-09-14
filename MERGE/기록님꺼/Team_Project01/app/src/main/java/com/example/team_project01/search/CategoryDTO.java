package com.example.team_project01.search;

public class CategoryDTO {
    private String tv_category1, tv_category2;
    private int imgv_category1, imgv_category2;

    public CategoryDTO(String tv_category1, String tv_category2, int imgv_category1, int imgv_category2) {
        this.tv_category1 = tv_category1;
        this.tv_category2 = tv_category2;
        this.imgv_category1 = imgv_category1;
        this.imgv_category2 = imgv_category2;
    }

    public String getTv_category1() {
        return tv_category1;
    }

    public void setTv_category1(String tv_category1) {
        this.tv_category1 = tv_category1;
    }

    public String getTv_category2() {
        return tv_category2;
    }

    public void setTv_category2(String tv_category2) {
        this.tv_category2 = tv_category2;
    }

    public int getImgv_category1() {
        return imgv_category1;
    }

    public void setImgv_category1(int imgv_category1) {
        this.imgv_category1 = imgv_category1;
    }

    public int getImgv_category2() {
        return imgv_category2;
    }

    public void setImgv_category2(int imgv_category2) {
        this.imgv_category2 = imgv_category2;
    }
}