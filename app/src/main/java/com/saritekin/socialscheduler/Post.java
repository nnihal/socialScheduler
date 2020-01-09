package com.saritekin.socialscheduler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;
import java.util.Objects;


public class Post {
    private String key = "";
    private String img_path = "";
    private String caption = "";
    private String time = "";
    private String date = "";
    private String share_on = "";

    public Post(){}

    public Post(String key, String img_path, String caption, String time, String date, String share_on) {
        this.key = key;
        this.img_path = img_path;
        this.caption = caption;
        this.time = time;
        this.date = date;
        this.share_on = share_on;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImg_path() {
        return img_path;
    }

    public Bitmap getImg_path_as_bitmap() {return BitmapFactory.decodeFile(String.valueOf(img_path));}

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

    public HashMap<String, String> toMap(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("img_path", img_path);
        map.put("caption", caption);
        map.put("time", time);
        map.put("date", date);
        map.put("share_on", share_on);
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return img_path.equals(post.img_path) &&
                caption.equals(post.caption) &&
                time.equals(post.time) &&
                date.equals(post.date) &&
                share_on.equals(post.share_on);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img_path, caption, time, date, share_on);
    }

}
