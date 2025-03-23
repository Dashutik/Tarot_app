package com.example.tarot_beta;

public class Victorina {
    private String question;
    private String[] answerOptions;
    private int correctAnswer;

    public Victorina(String question, String[] answerOptions, int correctAnswer) {
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}