package com.saritekin.socialscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleActivity extends AppCompatActivity {

    public static List<Post> posts = new ArrayList<>();

    @BindView(R.id.schedule_listview) ListView listView;
//    List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);


        if (!posts.isEmpty()) {
            PostAdapter adapter = new PostAdapter(this, posts);
            listView.setAdapter(adapter);
        }
    }

    @OnClick(R.id.add_button)
    public void create_post(){
        Intent intent = new Intent(this, CreatePost.class);
        startActivity(intent);
    }
}
