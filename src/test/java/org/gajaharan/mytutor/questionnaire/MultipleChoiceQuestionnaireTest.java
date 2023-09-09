package org.gajaharan.mytutor.questionnaire;

import org.gajaharan.mytutor.model.Question;
import org.gajaharan.mytutor.model.QuestionType;
import org.gajaharan.mytutor.model.ScoreQuestion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MultipleChoiceQuestionnaireTest {
    private MultipleChoiceQuestionnaire multipleChoiceQuestionnaire = new MultipleChoiceQuestionnaire();

    @Test
    public void findTheTotalScoreWhenNoQuestionIsSubmitted() {
        int expectedScore = 0;
        List<Question> questions = Collections.emptyList();
        int actualScore = multipleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void findTheTotalScoreWhenOneQuestionIsSubmitted() {
        int expectedScore = 3;
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "What kind of tutoring experience do you have?",
                        Map.of("Online tutoring", "1", "Home schooling", "1", "After school club", "1"),
                        QuestionType.MULTIPLE_CHOICE
                )
        );
        int actualScore = multipleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void findTheTotalScoreWhenTwoQuestionIsSubmitted() {
        int expectedScore = 8;
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "What kind of tutoring experience do you have?",
                        Map.of("Online tutoring", "1", "Home schooling", "1", "After school club", "1"),
                        QuestionType.MULTIPLE_CHOICE
                ),
                new ScoreQuestion(
                        1,
                        "What is your field of expertise?",
                        Map.of("Information Technology and Computing", "2", "Mathematics", "3"),
                        QuestionType.MULTIPLE_CHOICE
                )
        );
        int actualScore = multipleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void theTotalScoreIsZeroWhenOneMultipleQuestionIsSubmitted() {
        int expectedScore = 0;
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2"),
                        QuestionType.SINGLE_CHOICE
                )
        );
        int actualScore = multipleChoiceQuestionnaire.sum(questions);
        Assertions.assertEquals(expectedScore, actualScore);
    }
}
