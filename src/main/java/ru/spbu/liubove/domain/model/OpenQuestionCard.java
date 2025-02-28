package ru.spbu.liubove.domain.model;

public class OpenQuestionCard {
    private final String question;
    private final String expectedAnswer;

    private static void validateString(String argument) {
        if (argument == null) {
            throw new NullPointerException("String must not be null");
        }
        if (argument.isBlank() || argument.length() > 255) {
            throw new IllegalArgumentException("String has inappropriate length");
        }
    }

    public OpenQuestionCard(String question, String expectedAnswer) {
        validateString(question);
        validateString(expectedAnswer);
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean checkAnswer(String answer) {
        validateString(answer);
        return answer.equals(expectedAnswer);
    }
}