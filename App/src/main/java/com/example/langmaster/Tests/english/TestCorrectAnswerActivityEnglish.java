package com.example.langmaster.Tests.english;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.langmaster.R;

public class TestCorrectAnswerActivityEnglish extends AppCompatActivity {

    private ImageView imageViewQuestion;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;

    // Array pentru a stoca întrebările și variantele de răspuns
    private Question[] questions;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_correctanswer_english);

        // Inițializează elementele UI
        imageViewQuestion = findViewById(R.id.image_view_question);
        buttonOption1 = findViewById(R.id.button_option1);
        buttonOption2 = findViewById(R.id.button_option2);
        buttonOption3 = findViewById(R.id.button_option3);
        buttonOption4 = findViewById(R.id.button_option4);


        // Încarcă întrebările și variantele de răspuns
        loadQuestions();

        // Setează acțiunea de click pentru fiecare buton de opțiune
        buttonOption1.setOnClickListener(view -> checkAnswer(0));
        buttonOption2.setOnClickListener(view -> checkAnswer(1));
        buttonOption3.setOnClickListener(view -> checkAnswer(2));
        buttonOption4.setOnClickListener(view -> checkAnswer(3));
    }

    private void loadQuestions() {
        // Inițializează întrebările și variantele de răspuns
        questions = new Question[]{
                new Question(R.drawable.car, new String[]{"Bicycle", "Bus", "Car", "Motorcycle"}, 2),
                new Question(R.drawable.fish, new String[]{"Goat", "Monkey", "Bear", "Fish"}, 3),
                new Question(R.drawable.cheese, new String[]{"Cheese", "Milk", "Egg", "Butter"}, 0),
                new Question(R.drawable.strawberry, new String[]{"Raspberry", "Strawberry", "Blueberry", "Blackberry"}, 1),
                new Question(R.drawable.meat, new String[]{"Potato", "Onion", "Meat", "Garlic"}, 2),

        };

        // Inițializează indexul întrebării curente
        currentQuestionIndex = 0;

        // Afișează prima întrebare
        displayQuestion();
    }

    private void displayQuestion() {
        // Afișează imaginea întrebării și variantele de răspuns
        imageViewQuestion.setImageResource(questions[currentQuestionIndex].getImageResource());
        buttonOption1.setText(questions[currentQuestionIndex].getOption(0));
        buttonOption2.setText(questions[currentQuestionIndex].getOption(1));
        buttonOption3.setText(questions[currentQuestionIndex].getOption(2));
        buttonOption4.setText(questions[currentQuestionIndex].getOption(3));
    }

    private void checkAnswer(int selectedOptionIndex) {
        // Verifică dacă răspunsul este corect
        if (selectedOptionIndex == questions[currentQuestionIndex].getCorrectOptionIndex()) {
            // Răspunsul este corect
            // Schimbă culoarea butonului la verde pentru o secundă
            changeButtonColor(buttonOption1, android.R.color.holo_green_light);
            changeButtonColor(buttonOption2, android.R.color.holo_green_light);
            changeButtonColor(buttonOption3, android.R.color.holo_green_light);
            changeButtonColor(buttonOption4, android.R.color.holo_green_light);


            // Treci la următoarea întrebare
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                // Toate întrebările au fost rezolvate
                // Afișează un Toast cu mesajul "Testul s-a încheiat"
                Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();

                // Redirecționează utilizatorul către pagina de TestSelectionActivity
                startActivity(new Intent(this, TestSelectionActivityEnglish.class));
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
                return buttonOption1;
            case 1:
                return buttonOption2;
            case 2:
                return buttonOption3;
            case 3:
                return buttonOption4;
            default:
                return null;
        }
    }
}

