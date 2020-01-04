package com.saritekin.socialscheduler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScheduleActivity.getDataFromFirebase();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        // "login","no" means default string value is "no", so if you didn't set yes after login, it will be no as default
        if(preferences.getString("login_twitter", "no").equals("yes") || preferences.getString("login_instagram", "no").equals("yes")){
            Intent intent = new Intent(this, ScheduleActivity.class);
            startActivity(intent);

        }
        else{
            String report = "";
            setContentView(R.layout.activity_choose_login);
            ButterKnife.bind(this);
            if(preferences.getString("login_twitter", "no").equals("yes")){
                report = report + "login_twitter = yes \n";
            } else if (preferences.getString("login_twitter", "no").equals("no")){
                report = report + "login_twitter = no \n";
            }
            if(preferences.getString("login_instagram", "no").equals("yes")){
                report = report + "login_instagram = yes \n";

            } else if (preferences.getString("login_instagram", "no").equals("no")){
                report = report + "login_instagram = no \n";
            }
            Toast.makeText(this,report, Toast.LENGTH_LONG).show( );
        }

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
