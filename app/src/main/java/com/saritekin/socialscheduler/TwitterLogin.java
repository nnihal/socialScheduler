package com.saritekin.socialscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwitterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button_twitter)
    public void login(){
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
}
