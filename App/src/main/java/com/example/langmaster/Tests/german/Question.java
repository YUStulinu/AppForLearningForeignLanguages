package com.example.langmaster.Tests.german;

public class Question {
    private int imageResource; // Resursa imaginii întrebării
    private String[] options; // Variantele de răspuns
    private int correctOptionIndex; // Indexul variantei de răspuns corect

    public Question(int imageResource, String[] options, int correctOptionIndex) {
        this.imageResource = imageResource;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getOption(int index) {
        return options[index];
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
