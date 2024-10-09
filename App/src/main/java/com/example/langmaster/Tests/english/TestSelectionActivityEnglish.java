package com.example.langmaster.Tests.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.ComponentActivity;

import com.example.langmaster.R;


public class TestSelectionActivityEnglish extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selection_english);

        Button testSpeakingButton = findViewById(R.id.button_test_speaking);
        Button testWritingButton = findViewById(R.id.button_test_writing);
        Button testCorrectAnswerButton = findViewById(R.id.button_test_correct_answer);

        testSpeakingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Writing test page (TestWritingActivity)
                Intent intent = new Intent(TestSelectionActivityEnglish.this, TestSpeakingActivityEnglish.class);
                startActivity(intent);
            }
        });

        testWritingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Writing test page (TestWritingActivity)
                Intent intent = new Intent(TestSelectionActivityEnglish.this, TestWritingActivityEnglish.class);
                startActivity(intent);
            }
        });

        testCorrectAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Redirect user to the Correct Answer test page (TestCorrectAnswerActivity)
                Intent intent = new Intent(TestSelectionActivityEnglish.this, TestCorrectAnswerActivityEnglish.class);
                startActivity(intent);
            }
        });
    }
}
