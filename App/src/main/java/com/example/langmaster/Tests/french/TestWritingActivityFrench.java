package com.example.langmaster.Tests.french;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import com.example.langmaster.R;


public class TestWritingActivityFrench extends ComponentActivity {

    private TextView phraseTextView;
    private EditText repondreEditText;
    private Button verifierReponseButton;
    private TextView reponseIncorrecteTextView;

    private String[] sentences = {
            "Le chat est ___ la table.",
            "Je suis intéressé ___ apprendre de nouvelles langues.",
            "Il a sauté ___ la rivière.",
            "Tu ne peux dormir que ___ nuit.",
            "J'attends ici ___ dix minutes.",
            "Allons ___ théâtre !",
            "Je travaille ici ___ 2012.",
            "L'homme est debout ___ la voiture.",
            "Tu as l'air beau ___ la lumière du soleil.",
            "Ils ont voyagé ___ Europe."
    };

    private String[] answers = {"sur", "à", "dans", "la", "pour", "à", "depuis", "par", "sous", "sur"};

    private int currentSentenceIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_writing_french);

        phraseTextView = findViewById(R.id.phrase_text_view);
        repondreEditText = findViewById(R.id.repondre_edit_text);
        verifierReponseButton = findViewById(R.id.verifier_reponse_button);
        reponseIncorrecteTextView = findViewById(R.id.reponse_incorrecte_text_view);

        displayNextSentence();

        verifierReponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayNextSentence() {
        if (currentSentenceIndex < sentences.length) {
            phraseTextView.setText(sentences[currentSentenceIndex]);
            reponseIncorrecteTextView.setVisibility(View.GONE);
            repondreEditText.setText("");
        } else {
            // Testul s-a încheiat
            Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TestSelectionActivityFrench.class);
            startActivity(intent);
            finish();
        }
    }

    private void checkAnswer() {
        String userAnswer = repondreEditText.getText().toString().trim();
        String correctAnswer = answers[currentSentenceIndex];

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            // Răspunsul este corect, trecem la următoarea propoziție
            currentSentenceIndex++;
            displayNextSentence();
        } else {
            // Răspunsul este incorect, afișăm un mesaj
            reponseIncorrecteTextView.setVisibility(View.VISIBLE);
        }
    }
}
