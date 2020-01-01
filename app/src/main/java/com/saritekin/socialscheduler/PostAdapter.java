package com.saritekin.socialscheduler;

import android.app.Activity;
import android.content.Context;
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
        this.posts = ScheduleActivity.posts;
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
        TextView date = rowView.findViewById(R.id.textView_date);
        TextView time = rowView.findViewById(R.id.textView_time);
        Post post = posts.get(position);
        img.setImageBitmap(post.getImg_path());
        date.setText(post.getDate());
        time.setText(post.getTime());

        return rowView;
    }

}