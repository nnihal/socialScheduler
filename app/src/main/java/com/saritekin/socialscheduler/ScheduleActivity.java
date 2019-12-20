package com.saritekin.socialscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ScheduleActivity extends AppCompatActivity {


    @BindView(R.id.schedule_listview) ListView listView;
    List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
//        Post post1 = new Post();
//        posts.add(post1);
//        Post post2 = new Post();
//        posts.add(post2);
        if (!posts.isEmpty()) {
            PostAdapter adapter = new PostAdapter(this, posts);
            listView.setAdapter(adapter);
        }
    }
}
