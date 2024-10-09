package com.example.langmaster.Tests.french;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.langmaster.R;

public class TestCorrectAnswerActivityFrench extends AppCompatActivity {

    private ImageView imageViewQuestion;
    private Button buttonOptionFrench1;
    private Button buttonOptionFrench2;
    private Button buttonOptionFrench3;
    private Button buttonOptionFrench4;

    // Array pentru a stoca întrebările și variantele de răspuns
    private Question[] questions;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_correctanswer_french);

        // Inițializează elementele UI
        imageViewQuestion = findViewById(R.id.image_view_question_german);
        buttonOptionFrench1 = findViewById(R.id.button_option_german_1);
        buttonOptionFrench2 = findViewById(R.id.button_option_french_2);
        buttonOptionFrench3 = findViewById(R.id.button_option_french_3);
        buttonOptionFrench4 = findViewById(R.id.button_option_french_4);

        // Încarcă întrebările și variantele de răspuns
        loadQuestions();

        // Setează acțiunea de click pentru fiecare buton de opțiune
        buttonOptionFrench1.setOnClickListener(view -> checkAnswer(0));
        buttonOptionFrench2.setOnClickListener(view -> checkAnswer(1));
        buttonOptionFrench3.setOnClickListener(view -> checkAnswer(2));
        buttonOptionFrench4.setOnClickListener(view -> checkAnswer(3));
    }

    private void loadQuestions() {
        // Inițializează întrebările și variantele de răspuns
        questions = new Question[]{
                new Question(R.drawable.car, new String[]{"Vélo", "Bus", "Voiture", "Moto"}, 2),
                new Question(R.drawable.fish, new String[]{"Bouc", "Guenon", "Ours", "Poisson"}, 3),
                new Question(R.drawable.cheese, new String[]{"Fromage", "Lait", "Oeuf", "Beurre"}, 0),
                new Question(R.drawable.strawberry, new String[]{"Framboise", "Fraise", "Myrtille", "Mûre"}, 1),
                new Question(R.drawable.meat, new String[]{"Pomme de terre", "Oignon", "Viande", "Ail"}, 2),

        };

        // Inițializează indexul întrebării curente
        currentQuestionIndex = 0;

        // Afișează prima întrebare
        displayQuestion();
    }

    private void displayQuestion() {
        // Afișează imaginea întrebării și variantele de răspuns
        imageViewQuestion.setImageResource(questions[currentQuestionIndex].getImageResource());
        buttonOptionFrench1.setText(questions[currentQuestionIndex].getOption(0));
        buttonOptionFrench2.setText(questions[currentQuestionIndex].getOption(1));
        buttonOptionFrench3.setText(questions[currentQuestionIndex].getOption(2));
        buttonOptionFrench4.setText(questions[currentQuestionIndex].getOption(3));
    }

    private void checkAnswer(int selectedOptionIndex) {
        // Verifică dacă răspunsul este corect
        if (selectedOptionIndex == questions[currentQuestionIndex].getCorrectOptionIndex()) {
            // Răspunsul este corect
            // Schimbă culoarea butonului la verde pentru o secundă
            changeButtonColor(buttonOptionFrench1, android.R.color.holo_green_light);
            changeButtonColor(buttonOptionFrench2, android.R.color.holo_green_light);
            changeButtonColor(buttonOptionFrench3, android.R.color.holo_green_light);
            changeButtonColor(buttonOptionFrench4, android.R.color.holo_green_light);

            // Treci la următoarea întrebare
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                // Toate întrebările au fost rezolvate
                // Afișează un Toast cu mesajul "Testul s-a încheiat"
                Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();

                // Redirecționează utilizatorul către pagina de TestSelectionActivity
                startActivity(new Intent(this, TestSelectionActivityFrench.class));
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
                return buttonOptionFrench1;
            case 1:
                return buttonOptionFrench2;
            case 2:
                return buttonOptionFrench3;
            case 3:
                return buttonOptionFrench4;
            default:
                return null;
        }
    }
}

