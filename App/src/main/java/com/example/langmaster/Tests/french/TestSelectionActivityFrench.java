package com.example.langmaster.Tests.french;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;

import com.example.langmaster.R;


public class TestSelectionActivityFrench extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selection_french);

        Button testSpeakingButtonFrench = findViewById(R.id.button_test_speaking_french);
        Button testWritingButtonFrench = findViewById(R.id.button_test_writing_french);
        Button testCorrectAnswerButtonFrench = findViewById(R.id.button_test_correct_answer_french);

        testSpeakingButtonFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Writing test page (TestWritingActivity)
                Intent intent = new Intent(TestSelectionActivityFrench.this, TestSpeakingActivityFrench.class);
                startActivity(intent);
            }
        });

        testWritingButtonFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Writing test page (TestWritingActivity)
                Intent intent = new Intent(TestSelectionActivityFrench.this, TestWritingActivityFrench.class);
                startActivity(intent);
            }
        });

        testCorrectAnswerButtonFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Redirect user to the Correct Answer test page (TestCorrectAnswerActivity)
                Intent intent = new Intent(TestSelectionActivityFrench.this, TestCorrectAnswerActivityFrench.class);
                startActivity(intent);
            }
        });
    }
}
