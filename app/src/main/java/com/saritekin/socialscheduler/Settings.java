package com.saritekin.socialscheduler;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Settings extends AppCompatActivity {

    @BindView(R.id.switch_instagram) Switch switch_instagram;
    @BindView(R.id.switch_twitter) Switch switch_twitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        // "login","no" means default string value is "no", so if you didn't set yes after login, it will be no as default
        if(preferences.getString("login_twitter", "no").equals("yes")){
            switch_twitter.setChecked(true);
        } else if (preferences.getString("login_twitter", "no").equals("no")){
            switch_twitter.setChecked(false);
        }
        if(preferences.getString("login_instagram", "no").equals("yes")){
            switch_instagram.setChecked(true);
        } else if (preferences.getString("login_instagram", "no").equals("no")){
            switch_instagram.setChecked(false);
        }

        if (!switch_twitter.isChecked()){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("login_instagram", "no");
            editor.apply();
        }
        if (!switch_twitter.isChecked()){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("login_twitter", "no");
            editor.apply();
        }
    }
}
