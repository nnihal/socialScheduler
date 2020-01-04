package com.saritekin.socialscheduler;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InstagramLogin extends AppCompatActivity {

//    @BindView(R.id.login_button) Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button_instagram)
    public void login(){
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

}
