package com.example.langmaster.Tests.german;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.langmaster.R;

public class TestCorrectAnswerActivityGerman extends AppCompatActivity {

    private ImageView imageViewQuestion;
    private Button buttonGermanOption1;
    private Button buttonGermanOption2;
    private Button buttonGermanOption3;
    private Button buttonGermanOption4;

    // Array pentru a stoca întrebările și variantele de răspuns
    private Question[] questions;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_correctanswer_german);

        // Inițializează elementele UI
        imageViewQuestion = findViewById(R.id.image_view_question_german);
        buttonGermanOption1 = findViewById(R.id.button_option_german_1);
        buttonGermanOption2 = findViewById(R.id.button_option_german_2);
        buttonGermanOption3 = findViewById(R.id.button_option_german_3);
        buttonGermanOption4 = findViewById(R.id.button_option_german_4);

        // Încarcă întrebările și variantele de răspuns
        loadQuestions();

        // Setează acțiunea de click pentru fiecare buton de opțiune
        buttonGermanOption1.setOnClickListener(view -> checkAnswer(0));
        buttonGermanOption2.setOnClickListener(view -> checkAnswer(1));
        buttonGermanOption3.setOnClickListener(view -> checkAnswer(2));
        buttonGermanOption4.setOnClickListener(view -> checkAnswer(3));
    }

    private void loadQuestions() {
        // Inițializează întrebările și variantele de răspuns
        questions = new Question[]{
                new Question(R.drawable.car, new String[]{"Fahrrad", "Bus", "Auto", "Motorrad"}, 2),
                new Question(R.drawable.fish, new String[]{"Ziege", "Affe", "Tragen", "Fisch"}, 3),
                new Question(R.drawable.cheese, new String[]{"Käse", "Milch", "Ei", "Butter"}, 0),
                new Question(R.drawable.strawberry, new String[]{"Himbeere", "Erdbeere", "Blaubeere", "Brombeere"}, 1),
                new Question(R.drawable.meat, new String[]{"Kartoffel", "Zwiebel", "Fleisch", "Knoblauch"}, 2),

        };

        // Inițializează indexul întrebării curente
        currentQuestionIndex = 0;

        // Afișează prima întrebare
        displayQuestion();
    }

    private void displayQuestion() {
        // Afișează imaginea întrebării și variantele de răspuns
        imageViewQuestion.setImageResource(questions[currentQuestionIndex].getImageResource());
        buttonGermanOption1.setText(questions[currentQuestionIndex].getOption(0));
        buttonGermanOption2.setText(questions[currentQuestionIndex].getOption(1));
        buttonGermanOption3.setText(questions[currentQuestionIndex].getOption(2));
        buttonGermanOption4.setText(questions[currentQuestionIndex].getOption(3));
    }

    private void checkAnswer(int selectedOptionIndex) {
        // Verifică dacă răspunsul este corect
        if (selectedOptionIndex == questions[currentQuestionIndex].getCorrectOptionIndex()) {
            // Răspunsul este corect
            // Schimbă culoarea butonului la verde pentru o secundă
            changeButtonColor(buttonGermanOption1, android.R.color.holo_green_light);
            changeButtonColor(buttonGermanOption2, android.R.color.holo_green_light);
            changeButtonColor(buttonGermanOption3, android.R.color.holo_green_light);
            changeButtonColor(buttonGermanOption4, android.R.color.holo_green_light);

            // Treci la următoarea întrebare
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                // Toate întrebările au fost rezolvate
                // Afișează un Toast cu mesajul "Testul s-a încheiat"
                Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();

                // Redirecționează utilizatorul către pagina de TestSelectionActivity
                startActivity(new Intent(this, TestSelectionActivityGerman.class));
                finish();
            }
        } else {
            // Răspunsul este greșit
            // Schimbă culoarea butonului la roșu pentru o secundă
            changeButtonColor(getSelectedButton(selectedOptionIndex), android.R.color.holo_red_light);
        }
    }

    private void changeButtonColor(Button button, int colorResource) {
        button.setBackgroundColor(getResources().getColor(colorResource));
        // Aplică culoarea inițială după o secundă
        button.postDelayed(() -> button.setBackgroundColor(getResources().getColor(android.R.color.transparent)), 1000);
    }

    private Button getSelectedButton(int selectedOptionIndex) {
        switch (selectedOptionIndex) {
            case 0:
                return buttonGermanOption1;
            case 1:
                return buttonGermanOption2;
            case 2:
                return buttonGermanOption3;
            case 3:
                return buttonGermanOption4;
            default:
                return null;
        }
    }
}

