package com.example.guesstheword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox limitTime;

    boolean infiniteTime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        limitTime = findViewById(R.id.limitTime);
        limitTime.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
            infiniteTime = isChecked;
        });
    }

    public void handleButtonClick(View v) {
        Intent i = new Intent(this, GameActivity.class);

        if(v.getId() == R.id.letter_a) {
            i.putExtra("letter", "A");
        }
        else if(v.getId() == R.id.letter_b) {
            i.putExtra("letter", "B");
        }

        i.putExtra("infiniteTime", infiniteTime);
        startActivity(i);
    }


}