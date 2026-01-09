package com.example.guesstheword;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameActivity extends AppCompatActivity {

    private List<String> words; // actual words (answers)
    private List<String> definitions; // matching definitions
    private int currentIndex = 0; // which word we are on

    private TextView txtTimer;
    private TextView definitionView;
    private EditText inputView;
    private TextView chosenLetterView;
    private TextView count;
    //private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String letter = getIntent().getStringExtra("letter");

        chosenLetterView = findViewById(R.id.chosenLetter);
        chosenLetterView.setText("every word starts with letter " + letter);

        definitionView = findViewById(R.id.definition);
        inputView = findViewById(R.id.textInput);

        inputView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // required but unused
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAnswer(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // required but unused
            }
        });


        count = findViewById(R.id.count);
        count.setText(currentIndex+"/10");

        //checkButton = findViewById(R.id.checkButton);

        // load and shuffle words
        HashMap<String, String> wordMap = WordBank.getWords(letter);
        List<Map.Entry<String, String>> entries = new ArrayList<>(wordMap.entrySet());
        Collections.shuffle(entries);

        // convert to two lists
        words = new ArrayList<>();
        definitions = new ArrayList<>();
        for (int i = 0; i < Math.min(10, entries.size()); i++) {
            words.add(entries.get(i).getKey());
            definitions.add(entries.get(i).getValue());
        }

        showCurrentDefinition();

        boolean infiniteTime = getIntent().getBooleanExtra(
                "infiniteTime", false);
        txtTimer = findViewById(R.id.txtTimer);
        if (infiniteTime == false) {
            txtTimer.setText("time remaining: infinite");
        }
        else {
            new CountDownTimer(60 * 1000, 1) {
                @Override
                public void onTick(long millisUntilFinished) {
                    txtTimer.setText("time remaining: "+millisUntilFinished/1000);
                }

                @Override
                public void onFinish() {
                    txtTimer.setText("time's up mf!");
                    inputView.setEnabled(false);
                    //checkButton.setEnabled(false);
                }
            }.start();

        }
    }

    private void showCurrentDefinition() {
        if (currentIndex < definitions.size()) {
            definitionView.setText(definitions.get(currentIndex));
            inputView.setText("");
        }
        else {
            definitionView.setText("game over! you finished all words.");
        }
    }

    /*public void check(View v) {
        if (currentIndex >= words.size()) return;

        String guess = inputView.getText().toString().trim().toUpperCase();
        String correct = words.get(currentIndex).toUpperCase();

        if (guess.equals(correct)) {
            Toast.makeText(this, "correct!", Toast.LENGTH_SHORT).show();
            currentIndex++;
            count.setText(currentIndex+"/10");
            showCurrentDefinition();
        }
        else {
            Toast.makeText(this, "incorrect.", Toast.LENGTH_SHORT).show();
        }
    }*/

    private void checkAnswer(String guessRaw) {
        if (currentIndex >= words.size()) {
            return;
        }

        String guess = guessRaw.trim().toUpperCase();
        String correct = words.get(currentIndex).toUpperCase();

        if (guess.equals(correct)) {
            Toast.makeText(this, "correct!", Toast.LENGTH_SHORT).show();

            currentIndex++;
            count.setText(currentIndex + "/10");

            showCurrentDefinition();
        }
    }

    public void back(View v) {
        finish();
    }
}
