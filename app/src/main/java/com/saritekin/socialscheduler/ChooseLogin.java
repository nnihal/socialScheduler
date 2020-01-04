package com.saritekin.socialscheduler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        // "login","no" means default string value is "no", so if you didn't set yes after login, it will be no as default
        if(preferences.getString("login_twitter", "no").equals("yes")|| preferences.getString("login_instagram", "no").equals("yes")){
            Intent intent = new Intent(this, ScheduleActivity.class);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_choose_login);
            ButterKnife.bind(this);
        }

    }

    @OnClick(R.id.twitter_button)
    public void with_twitter(){
        SharedPreferences.Editor editor = (SharedPreferences.Editor) PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor.putString("login_twitter", "yes");
        editor.commit();
        Intent intent = new Intent(this, TwitterLogin.class);
        startActivity(intent);
    }

    @OnClick(R.id.instagram_button)
    public void with_Instagram(){
        SharedPreferences.Editor editor = (SharedPreferences.Editor) PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor.putString("login_instagram", "yes");
        editor.commit();
        Intent intent = new Intent(this, InstagramLogin.class);
        startActivity(intent);
    }
}
