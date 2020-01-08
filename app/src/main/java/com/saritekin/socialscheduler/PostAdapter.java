package com.saritekin.socialscheduler;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private List<Post> posts;

    private LayoutInflater inflater;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.layout_listview_post_template, null);
        ImageView img = rowView.findViewById(R.id.imageView_personpic);
        TextView time_date = rowView.findViewById(R.id.textView_time_date);
        TextView caption = rowView.findViewById(R.id.textView_caption);
        TextView platform = rowView.findViewById(R.id.textView_platform);
        Post post = posts.get(position);
        img.setImageBitmap(post.getImg_path_as_bitmap());
        Log.d("TAG_TEST", "onDataChange: " + posts);
        time_date.setText(post.getDate());
        caption.setText(post.getCaption());
        platform.setText(post.getShare_on());

        return rowView;
    }

    public List<Post> getPosts() {
        return posts;
    }
}