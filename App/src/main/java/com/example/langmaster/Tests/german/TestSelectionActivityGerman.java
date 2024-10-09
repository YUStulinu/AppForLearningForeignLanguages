package com.example.langmaster.Tests.german;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;

import com.example.langmaster.R;


public class TestSelectionActivityGerman extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selection_german);

        Button testSpeakingGermanButton = findViewById(R.id.button_test_speaking_german);
        Button testWritingGermanButton = findViewById(R.id.button_test_writing_german);
        Button testCorrectAnswerGermanButton = findViewById(R.id.button_test_correct_answer_german);

        testSpeakingGermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Writing test page (TestWritingActivity)
                Intent intent = new Intent(TestSelectionActivityGerman.this, TestSpeakingActivityGerman.class);
                startActivity(intent);
            }
        });

        testWritingGermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Writing test page (TestWritingActivity)
                Intent intent = new Intent(TestSelectionActivityGerman.this, TestWritingActivityGerman.class);
                startActivity(intent);
            }
        });

        testCorrectAnswerGermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Redirect user to the Correct Answer test page (TestCorrectAnswerActivity)
                Intent intent = new Intent(TestSelectionActivityGerman.this, TestCorrectAnswerActivityGerman.class);
                startActivity(intent);
            }
        });
    }
}
