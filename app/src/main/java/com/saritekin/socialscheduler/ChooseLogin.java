package com.saritekin.socialscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.twitter_button)
    public void with_twitter(){
        Intent intent = new Intent(this, TwitterLogin.class);
        startActivity(intent);
    }

    @OnClick(R.id.instagram_button)
    public void with_Instagram(){
        Intent intent = new Intent(this, InstagramLogin.class);
        startActivity(intent);
    }
}
