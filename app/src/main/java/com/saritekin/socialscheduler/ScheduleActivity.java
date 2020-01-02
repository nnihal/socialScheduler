package com.saritekin.socialscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @OnClick(R.id.add_button)
    public void create_post(){
        Intent intent = new Intent(this, CreatePost.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.paylas:
                return true;

            case R.id.ayarlar:
                return true;

            case R.id.gonder:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
