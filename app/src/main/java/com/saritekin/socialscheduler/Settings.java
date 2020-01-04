package com.saritekin.socialscheduler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
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

        switch_twitter.setChecked(preferences.getString("login_twitter", "no").equals("yes"));
        switch_instagram.setChecked(preferences.getString("login_instagram", "no").equals("yes"));

        switch_twitter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
                if (isChecked) {
                    Intent intent = new Intent(Settings.this, TwitterLogin.class);
                    startActivity(intent);
                } else {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("login_twitter", "no");
                    editor.apply();
                }
            }

        });

        switch_instagram.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
                if (isChecked) {
                    Intent intent = new Intent(Settings.this, InstagramLogin.class);
                    startActivity(intent);
                } else {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("login_instagram", "no");
                    editor.apply();
                }
            }

        });
    }
}
