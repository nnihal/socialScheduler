package com.saritekin.socialscheduler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class Post {

    private String img_path;
    private String caption;
    private String time;
    private String date;
    private String share_on;

    public Post(){}

    public Post(String img_path, String caption, String time, String date, String share_on) {
        this.img_path = img_path;
        this.caption = caption;
        this.time = time;
        this.date = date;
        this.share_on = share_on;
    }

    public Bitmap getImg_path() {
        return BitmapFactory.decodeFile(String.valueOf(img_path));
    }

    public void setImg_path(String img_path) { this.img_path = img_path; }

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

    public String toString(){
        return "Post{img_path='"+img_path+"', caption='" + caption + "', time='" + time + "', date='"+ date+ "', share_on='"+ share_on + "'}";
    }
}
