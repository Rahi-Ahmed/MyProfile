package com.chill.myprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton launchBt;
    static LinearLayout backgroundView, landscapeVw;
    SharedPreferences userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchBt = findViewById(R.id.launch_id);
        backgroundView = findViewById(R.id.main_view_id);
        landscapeVw = findViewById(R.id.land_layout);

        userPreferences = getSharedPreferences("configuration", MODE_PRIVATE);

        SharedPreferences userPreferences2 = getSharedPreferences("configuration", MODE_PRIVATE);
        int defaultBackground = userPreferences2.getInt("theme",0);
        backgroundView.setBackgroundResource(defaultBackground);

        launchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivityForResult(intent, Constant.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_CODE) {
            if (resultCode == Constant.RESULT_CODE) {
                String season = data.getStringExtra(Constant.SEASON_NAME);

                // set up switch statement here to change background
                switch (season){
                    case "Spring":
                        backgroundView.setBackgroundResource(R.drawable.spring2);
                        SharedPreferences.Editor edit = userPreferences.edit();
                        edit.putInt("theme", R.drawable.spring2);
                        edit.apply();
                        break;
                    case "Summer":
                        backgroundView.setBackgroundResource(R.drawable.summer2);
                        SharedPreferences.Editor edit2 = userPreferences.edit();
                        edit2.putInt("theme", R.drawable.summer2);
                        edit2.apply();
                        break;
                    case "Fall":
                        backgroundView.setBackgroundResource(R.drawable.fall2);
                        SharedPreferences.Editor edit3 = userPreferences.edit();
                        edit3.putInt("theme", R.drawable.fall2);
                        edit3.apply();

                        break;
                    case "Winter":
                        backgroundView.setBackgroundResource(R.drawable.winter);
                        SharedPreferences.Editor edit4 = userPreferences.edit();
                        edit4.putInt("theme", R.drawable.winter);
                        edit4.apply();
                        break;

                }

            }
        }
    }
}

