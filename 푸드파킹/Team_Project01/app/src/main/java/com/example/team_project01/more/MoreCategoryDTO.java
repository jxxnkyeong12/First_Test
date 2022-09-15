package com.example.team_project01.more;

public class MoreCategoryDTO {
    private int img_more;
    private String tv_more;

    public MoreCategoryDTO(int img_more, String tv_more) {
        this.img_more = img_more;
        this.tv_more = tv_more;
    }

    public int getImg_more() {
        return img_more;
    }

    public void setImg_more(int img_more) {
        this.img_more = img_more;
    }

    public String getTv_more() {
        return tv_more;
    }

    public void setTv_more(String tv_more) {
        this.tv_more = tv_more;
    }
}
