package com.example.langmaster.Tests.german;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import com.example.langmaster.R;


public class TestWritingActivityGerman extends ComponentActivity {

    private TextView sentenceGermanTextView;
    private EditText answerGermanEditText;
    private Button checkAnswerGermanButton;
    private TextView incorrectAnswerGermanTextView;

    private String[] sentences = {
            "Die Katze ist ___ dem Tisch.",
            "Ich interessiere mich ___ das Lernen neuer Sprachen.",
            "Er sprang ___ den Fluss.",
            "Man kann nur ___ Nacht schlafen.",
            "Ich warte hier schon ___ zehn Minuten.",
            "Lass uns ___ das Theater gehen!",
            "Ich arbeite hier ___ 2012.",
            "Der Mann steht ___ dem Auto.",
            "Du siehst schön aus ___ dem Sonnenlicht.",
            "Sie reisten durch ___ Europa."
    };

    private String[] answers = {"auf", "für", "über", "in", "seit", "zum", "seit", "bei", "unter", "durch"};


    private int currentSentenceIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_writing_german);

        sentenceGermanTextView = findViewById(R.id.satz_text_view);
        answerGermanEditText = findViewById(R.id.antwort_edit_text);
        checkAnswerGermanButton = findViewById(R.id.korrekte_antwort_button);
        incorrectAnswerGermanTextView = findViewById(R.id.falsche_antwort_text_view);

        displayNextSentence();

        checkAnswerGermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayNextSentence() {
        if (currentSentenceIndex < sentences.length) {
            sentenceGermanTextView.setText(sentences[currentSentenceIndex]);
            incorrectAnswerGermanTextView.setVisibility(View.GONE);
            answerGermanEditText.setText("");
        } else {
            // Testul s-a încheiat
            Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TestSelectionActivityGerman.class);
            startActivity(intent);
            finish();
        }
    }

    private void checkAnswer() {
        String userAnswer = answerGermanEditText.getText().toString().trim();
        String correctAnswer = answers[currentSentenceIndex];

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            // Răspunsul este corect, trecem la următoarea propoziție
            currentSentenceIndex++;
            displayNextSentence();
        } else {
            // Răspunsul este incorect, afișăm un mesaj
            incorrectAnswerGermanTextView.setVisibility(View.VISIBLE);
        }
    }
}
