package com.example.langmaster.Tests.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;

import com.example.langmaster.R;


public class TestWritingActivityEnglish extends ComponentActivity {

    private TextView sentenceTextView;
    private EditText answerEditText;
    private Button checkAnswerButton;
    private TextView incorrectAnswerTextView;

    private String[] sentences = {
            "The cat is ___ the table.",
            "I am interested ___ learning new languages.",
            "He jumped ___ the river.",
            "You can only sleep ___ night.",
            "I have been waiting here ___ ten minutes.",
            "Let's go ___ the theatre!",
            "I'm working here ___ 2012.",
            "The man is standing ___ the car.",
            "You look beautiful ___ the sunlight.",
            "They traveled ___ Europe."
    };

    private String[] answers = {"on", "in", "into", "at", "for", "to", "since", "by", "under", "over"};

    private int currentSentenceIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_writing_english);

        sentenceTextView = findViewById(R.id.sentence_text_view);
        answerEditText = findViewById(R.id.answer_edit_text);
        checkAnswerButton = findViewById(R.id.check_answer_button);
        incorrectAnswerTextView = findViewById(R.id.incorrect_answer_text_view);

        displayNextSentence();

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayNextSentence() {
        if (currentSentenceIndex < sentences.length) {
            sentenceTextView.setText(sentences[currentSentenceIndex]);
            incorrectAnswerTextView.setVisibility(View.GONE);
            answerEditText.setText("");
        } else {
            // Testul s-a încheiat
            Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TestSelectionActivityEnglish.class);
            startActivity(intent);
            finish();
        }
    }

    private void checkAnswer() {
        String userAnswer = answerEditText.getText().toString().trim();
        String correctAnswer = answers[currentSentenceIndex];

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            // Răspunsul este corect, trecem la următoarea propoziție
            currentSentenceIndex++;
            displayNextSentence();
        } else {
            // Răspunsul este incorect, afișăm un mesaj
            incorrectAnswerTextView.setVisibility(View.VISIBLE);
        }
    }
}
