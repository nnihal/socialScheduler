package com.saritekin.socialscheduler;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

public class CreatePost extends AppCompatActivity {

    private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static int RESULT_LOAD_IMAGE = 1;
    private static int POST_REQUEST = 200;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private Post post = new Post();

    private DatabaseReference mDatabase;

    @BindView(R.id.in_date) EditText txtDate;
    @BindView(R.id.in_time) EditText txtTime;

    @Nullable
    @BindView(R.id.textView_platform) EditText txtPlatform;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            post.setImg_path(picturePath);
        }
    }


    @OnClick(R.id.add_image_button)
    public void load_img(){
        if (EasyPermissions.hasPermissions(this, galleryPermissions)) {
            Intent intent = new Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, RESULT_LOAD_IMAGE);
        } else {
            EasyPermissions.requestPermissions(this, "Access for storage",
                    101, galleryPermissions);
        }

    }

    @OnClick(R.id.btn_date)
    public void choose_date(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) -> {
                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    post.setDate(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                },
                mYear, mMonth, mDay);


        datePickerDialog.show();
//        post.setDate(datePickerDialog.toString());
    }

    @OnClick(R.id.btn_time)
    public void choose_time(){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime.setText(hourOfDay + ":" + minute);
                        post.setTime(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
//        post.setTime(timePickerDialog.toString());
    }

    @OnClick(R.id.share_on_twitter)
    public void share_twitter(){
        post.setShare_on("twitter");
//        ScheduleActivity.posts.add(post);
        // save to firebase realtime database
//        post.setCaption("captionik");
        post.setCaption(txtPlatform.getText().toString());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String key = mDatabase.push().getKey();
        post.setKey(key);
        mDatabase.child("users").child(User.id).child("posts").child(key).setValue(post.toMap());

        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.share_on_instagram)
    public void share_instagram(){
        post.setShare_on("instagram");
        post.setCaption(txtPlatform.getText().toString());
//        ScheduleActivity.posts.add(post);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String key = mDatabase.push().getKey();
        mDatabase.child("users").child(User.id).child("posts").child(key).setValue(post.toMap());
        post.setKey(key);
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

}
