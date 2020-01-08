package com.saritekin.socialscheduler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleActivity extends AppCompatActivity {

    public static HashSet<Post> posts = new HashSet<>();
    PostAdapter adapter;

    @BindView(R.id.schedule_listview)
    ListView listView;
//    List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String report = "";
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (preferences.getString("login_twitter", "no").equals("yes")) {
            report = report + "login_twitter = yes \n";
        } else if (preferences.getString("login_twitter", "no").equals("no")) {
            report = report + "login_twitter = no \n";
        }
        if (preferences.getString("login_instagram", "no").equals("yes")) {
            report = report + "login_instagram = yes \n";

        } else if (preferences.getString("login_instagram", "no").equals("no")) {
            report = report + "login_instagram = no \n";
        }
        Toast.makeText(this, report, Toast.LENGTH_LONG).show();

        getDataFromFirebase();
        List<Post> postsList = new ArrayList<>();
        postsList.clear();
        postsList.addAll(posts);

        setContentView(R.layout.activity_schedule);

        ButterKnife.bind(this);

        Log.d("TAG_TEST", "SETTING ADAPTER DATA: " + posts);

        adapter = new PostAdapter(this, postsList);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @OnClick(R.id.add_button)
    public void create_post() {
        Intent intent = new Intent(this, CreatePost.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.settings:
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getDataFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users/" + User.id + "/posts");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot p : dataSnapshot.getChildren()) {
                    posts.add(p.getValue(Post.class));
                }
                adapter.getPosts().clear();
                adapter.getPosts().addAll(posts);
                adapter.notifyDataSetChanged();
                Log.d("TAG_TEST", "onDataChange: " + posts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}