package com.saritekin.socialscheduler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private List<Post> posts;

    private LayoutInflater inflater;

    private DatabaseReference mDatabase;


    public PostAdapter(Activity activity, List<Post> posts) {
        this.posts = posts;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.layout_listview_post_template, null);
        ImageView img = rowView.findViewById(R.id.imageView_personpic);
        TextView time_date = rowView.findViewById(R.id.textView_time_date);
        TextView caption = rowView.findViewById(R.id.textView_caption);
        TextView platform = rowView.findViewById(R.id.textView_platform);
        Button delete_button = rowView.findViewById(R.id.delete_btn);
        Post post = posts.get(position);
        img.setImageBitmap(post.getImg_path_as_bitmap());
        Log.d("TAG_TEST", "onDataChange: " + posts);
        time_date.setText(post.getTime() + " " + post.getDate());
        caption.setText(post.getCaption());
        platform.setText(post.getShare_on());
//        delete_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDatabase = FirebaseDatabase.getInstance().getReference();
//                mDatabase.child("users").child(User.id).child("posts").child(post.getKey()).removeValue();
//                posts.remove(posts.remove(position));
//            }
//        });
        return rowView;
    }

    public List<Post> getPosts() {
        return posts;
    }
}