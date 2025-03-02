package ru.spbu.liubove.domain.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OpenQuestionCardTest {
    @Test
    @DisplayName("Объект правильно создается")
    void when_ObjectCreatedWithCorrectArguments_then_getQuestionWorksProperly() {
        String question = "Вежливо попросить что то сделать на английском";
        String expectedAnswer = "Would You like to do something?";
        OpenQuestionCard card = new OpenQuestionCard(question, expectedAnswer);
        assertEquals("Вежливо попросить что то сделать на английском", card.getQuestion());
    }

    @Test
    @DisplayName("Конструктор бросает исключение при передаче некорректных аргументов")
    void when_ObjectCreatedWithIncorrectArguments_then_ConstructorThrows() {
        String question = "Вежливо попросить что то сделать на английском";
        String expectedAnswer = "Would You like to do something?";
        assertThrows(NullPointerException.class, () -> new OpenQuestionCard(null, expectedAnswer));
        assertThrows(NullPointerException.class, () -> new OpenQuestionCard(question, null));
        assertThrows(IllegalArgumentException.class, () -> new OpenQuestionCard("   \t", expectedAnswer));
        assertThrows(IllegalArgumentException.class, () -> new OpenQuestionCard(question, "   \t"));
        assertThrows(IllegalArgumentException.class, () -> new OpenQuestionCard("X".repeat(300), expectedAnswer));
        assertThrows(IllegalArgumentException.class, () -> new OpenQuestionCard(question, "X".repeat(300)));
    }

    @Test
    @DisplayName("checkAnswer возвращает true при правильном ответе")
    void when_AnswerIsOk_then_checkAnswer_isTrue() {
        String question = "Вежливо попросить что то сделать на английском";
        String expectedAnswer = "Would You like to do something?";
        OpenQuestionCard card = new OpenQuestionCard(question, expectedAnswer);
        assertTrue(card.checkAnswer("Would You like to do something?"));
    }

    @Test
    @DisplayName("checkAnswer возвращает false при неправильном ответе")
    void when_AnswerIsNotOk_then_checkAnswer_isFalse() {
        String question = "Вежливо попросить что то сделать на английском";
        String expectedAnswer = "Would You like to do something?";
        OpenQuestionCard card = new OpenQuestionCard(question, expectedAnswer);
        assertFalse(card.checkAnswer("Do something now!!!"));
    }

    @Test
    @DisplayName("checkAnswer бросает исключение при передаче некорректных аргументов")
    void when_IncorrectArgumentsPassedToCheckAnswer_then_checkAnswerThrows() {
        String question = "Вежливо попросить что то сделать на английском";
        String expectedAnswer = "Would You like to do something?";
        OpenQuestionCard card = new OpenQuestionCard(question, expectedAnswer);
        assertThrows(NullPointerException.class, () -> card.checkAnswer(null));
        assertThrows(IllegalArgumentException.class, () -> card.checkAnswer("   \t"));
        assertThrows(IllegalArgumentException.class, () -> card.checkAnswer("X".repeat(300)));
    }
}