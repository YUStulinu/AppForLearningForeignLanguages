package com.example.langmaster.Tests.english;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;

import com.example.langmaster.R;

import java.util.ArrayList;
import java.util.List;

public class TestSpeakingActivityEnglish extends ComponentActivity {

    private SpeechRecognizer speechRecognizer;
    private boolean isListening = false;
    private List<String> wordList;
    private int currentWordIndex = 0;

    private TextView textViewWord;
    private TextView textViewResult;
    private Button buttonNext;

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permisiunea a fost acordată, putem inițializa SpeechRecognizer
                    initializeSpeechRecognizer();
                } else {
                    // Permisiunea a fost refuzată, poți gestiona acest caz în funcție de necesități
                    Toast.makeText(this, "Permisiunea pentru microfon a fost refuzată", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_speaking_english);

        textViewWord = findViewById(R.id.text_view_word);
        textViewResult = findViewById(R.id.text_view_result);
        buttonNext = findViewById(R.id.button_next);

        // Lista cuvintelor de test
        wordList =
                new ArrayList<String>() {{
                    add(".");
                    add("car");
                    add("rainbow");
                    add("flower");
                    add("banana");
                    add("water");
                }};

        Button startButton = findViewById(R.id.button_start_test);
        startButton.setOnClickListener(v -> {
            if (!isListening) {
                startListening();
            } else {
                stopListening();
            }
        });

        buttonNext.setOnClickListener(v -> {
            // Trecem la următorul cuvânt
            if (currentWordIndex < wordList.size() - 1) {
                currentWordIndex++;
                textViewWord.setText(wordList.get(currentWordIndex));
                textViewResult.setText("");
            } else {
                // Dacă am ajuns la sfârșitul listei, putem afișa un mesaj sau acționa în alt mod
                Toast.makeText(this, "Testul s-a încheiat", Toast.LENGTH_SHORT).show();
            }
        });

        // Verificăm și solicităm permisiunea pentru utilizarea microfonului
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
        ) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO);
        } else {
            // Dacă permisiunea este deja acordată, putem inițializa SpeechRecognizer
            initializeSpeechRecognizer();
        }
    }

    private void initializeSpeechRecognizer() {
        // Inițializăm SpeechRecognizer
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {}

            @Override
            public void onBeginningOfSpeech() {}

            @Override
            public void onRmsChanged(float rmsdB) {}

            @Override
            public void onBufferReceived(byte[] buffer) {}

            @Override
            public void onEndOfSpeech() {}

            @Override
            public void onError(int error) {}

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matches != null && !matches.isEmpty()) {
                    String spokenText = matches.get(0);
                    int correctPercentage = calculateCorrectPercentage(spokenText, wordList.get(currentWordIndex));
                    textViewResult.setText("Pronunție corectă: " + correctPercentage + "%");
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {}

            @Override
            public void onEvent(int eventType, Bundle params) {}
        });
    }

    private void startListening() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        );
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
        speechRecognizer.startListening(intent);
        isListening = true;
    }

    private void stopListening() {
        speechRecognizer.stopListening();
        isListening = false;
    }

    private int calculateCorrectPercentage(String spokenText, String expectedWord) {
        // Calculăm distanța Levenshtein între cele două șiruri
        int distance = levenshteinDistance(spokenText.toLowerCase(), expectedWord.toLowerCase());

        // Calculăm lungimea maximă dintre cele două șiruri
        int maxLength = Math.max(spokenText.length(), expectedWord.length());

        // Calculăm procentul de similaritate bazat pe distanța Levenshtein
        double similarityPercentage = ((maxLength - distance) / (double) maxLength) * 100;

        // Returnăm procentul de similaritate ca întreg
        return (int) similarityPercentage;
    }

    // Funcție pentru calcularea distanței Levenshtein între două șiruri
    private int levenshteinDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] d = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            d[0][j] = j;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                int cost = (s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1;
                d[i][j] = Math.min(
                        Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1),
                        d[i - 1][j - 1] + cost
                );
            }
        }

        return d[m][n];
    }
}
