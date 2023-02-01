package com.chill.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity {

Spinner spin;
Button confirmBt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        spin = findViewById(R.id.dropdown_id);
        confirmBt = findViewById(R.id.set_season);


        ArrayAdapter<CharSequence> arrayAdapter =
                ArrayAdapter.createFromResource(this, R.array.seasons_array, android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //spinner.setSelection(ITME_INDEX)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                String userSelection = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        confirmBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constant.SEASON_NAME, spin.getSelectedItem().toString());
                setResult(Constant.RESULT_CODE,returnIntent);
                finish();


            }
        });
    }


}