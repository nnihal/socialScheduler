package com.saritekin.socialscheduler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.annotations.SerializedName;


public class Post {

    @SerializedName("img_path")
    private String img_path;
    @SerializedName("caption")
    private String caption;
    @SerializedName("time")
    private String time;
    @SerializedName("date")
    private String date;
    @SerializedName("share_on")
    private String share_on;

    public Post(){}

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

    public void to_List(){
//        return ({"img_path": getImg_path(), "caption": getCaption()});
    }
}
