package com.saritekin.socialscheduler;

import android.graphics.Bitmap;


public class Post {
    private Bitmap img;
    private String caption;
    private String time;
    private String date;
    private String share_on;

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShare_on() {
        return share_on;
    }

    public void setShare_on(String share_on) {
        this.share_on = share_on;
    }
}
