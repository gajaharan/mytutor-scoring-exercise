package org.gajaharan.mytutor.questionnaire;

import org.gajaharan.mytutor.model.Question;
import org.gajaharan.mytutor.model.ScoreQuestion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SingleChoiceQuestionnaireTest {
    private SingleChoiceQuestionnaire singleChoiceQuestionnaire = new SingleChoiceQuestionnaire();

    @Test
    public void findTheTotalScoreWhenNoQuestionIsSubmitted() {
        int expectedScore = 0;
        List<Question> questions = Collections.emptyList();
        int actualScore = singleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void findTheTotalScoreWhenOneQuestionIsSubmitted() {
        int expectedScore = 2;
        List<Question> questions = List.of(
                new ScoreQuestion(
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2")
                )
        );
        int actualScore = singleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void findTheTotalScoreWhenTwoQuestionIsSubmitted() {
        int expectedScore = 5;
        List<Question> questions = List.of(
                new ScoreQuestion(
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2")
                ),
                new ScoreQuestion(
                        "What is your fluent Language",
                        Map.of("English", "3")
                )
        );
        int actualScore = singleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }
}
