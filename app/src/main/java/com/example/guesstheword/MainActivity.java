package com.example.guesstheword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleButtonClick(View v) {
        Intent i = new Intent(this, GameActivity.class);

        if(v.getId() == R.id.letter_a) {
            i.putExtra("letter", "A");
        }
        else if(v.getId() == R.id.letter_b) {
            i.putExtra("letter", "B");
        }
        startActivity(i);
    }


}