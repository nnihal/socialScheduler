package com.saritekin.socialscheduler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostTest {

    private Post post = new Post();

    @Test
    public void get_set_Img_path() {
        post.setImg_path("test/image/path");
        assertEquals(post.getImg_path(), "test/image/path");
    }


    @Test
    public void get_set_Caption() {
        post.setCaption("test caption");
        assertEquals(post.getCaption(), "test caption");
    }


    @Test
    public void getTime() {
        post.setTime("09:00");
        assertEquals(post.getTime(), "09:00");
    }

    @Test
    public void get_set_Date() {
        post.setDate("21.01.2020");
        assertEquals(post.getDate(), "21.01.2020");
    }


    @Test
    public void getShare_on() {
        post.setShare_on("twitter");
        assertEquals(post.getShare_on(), "twitter");
    }
}