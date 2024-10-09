package com.example.langmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.example.langmaster.Tests.english.TestSelectionActivityEnglish;
import com.example.langmaster.Tests.french.TestSelectionActivityFrench;
import com.example.langmaster.Tests.german.TestSelectionActivityGerman;
import com.example.langmaster.account.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LanguageSelectionActivity extends ComponentActivity {

    private Button englishButton;
    private Button frenchButton;
    private Button germanButton;
    private FirebaseAuth auth;
    private Button button;
    private TextView textView;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        englishButton = findViewById(R.id.button_english);
        frenchButton = findViewById(R.id.button_french);
        germanButton = findViewById(R.id.button_german);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Test Selection page for English language
                Intent intent = new Intent(LanguageSelectionActivity.this, TestSelectionActivityEnglish.class);
                startActivity(intent);
            }
        });

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Test Selection page for French language
                Intent intent = new Intent(LanguageSelectionActivity.this, TestSelectionActivityFrench.class);
                startActivity(intent);
            }
        });

        germanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to the Test Selection page for German language
                Intent intent = new Intent(LanguageSelectionActivity.this, TestSelectionActivityGerman.class);
                startActivity(intent);
            }
        });
    }
}