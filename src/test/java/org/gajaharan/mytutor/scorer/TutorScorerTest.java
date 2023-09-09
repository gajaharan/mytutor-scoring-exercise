package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.QuestionType;
import org.gajaharan.mytutor.model.ScoreQuestion;
import org.gajaharan.mytutor.questionnaire.MultipleChoiceQuestionnaire;
import org.gajaharan.mytutor.questionnaire.Questionnaire;
import org.gajaharan.mytutor.questionnaire.SingleChoiceQuestionnaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TutorScorerTest {
    private Scorer tutorScorer;

    @Test
    public void scorerProvidesTheTotalScoreZeroWhenContainingNoSingleChoiceQuestions() {
        int expectedScore = 0;
        List<Questionnaire> questionnaires = List.of(new SingleChoiceQuestionnaire());
        tutorScorer = new TutorScorer(questionnaires);
        tutorScorer.add(new ScoreQuestion(
                "How much overall tutoring experience do you have?",
                Collections.emptyMap(),
                QuestionType.SINGLE_CHOICE
        ));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreWhenContainingOneSingleChoiceQuestions() {
        int expectedScore = 2;
        List<Questionnaire> questionnaires = List.of(new SingleChoiceQuestionnaire());
        tutorScorer = new TutorScorer(questionnaires);
        tutorScorer.add(new ScoreQuestion(
                "How much overall tutoring experience do you have?",
                Map.of("3 or more", "2"),
                QuestionType.SINGLE_CHOICE
        ));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreWhenContainingTwoSingleChoiceQuestions() {
        int expectedScore = 5;
        List<Questionnaire> questionnaires = List.of(new SingleChoiceQuestionnaire());
        tutorScorer = new TutorScorer(questionnaires);
        tutorScorer.add(new ScoreQuestion(
                "How much overall tutoring experience do you have?",
                Map.of("3 or more", "2"),
                QuestionType.SINGLE_CHOICE
        ));
        tutorScorer.add(new ScoreQuestion(
                "What is your fluent Language",
                Map.of("English", "3"),
                QuestionType.SINGLE_CHOICE
        ));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreWhenContainingOneSingleChoiceQuestionsOneMultipleChoiceQuestion() {
        int expectedScore = 5;
        List<Questionnaire> questionnaires = List.of(
                new SingleChoiceQuestionnaire(),
                new MultipleChoiceQuestionnaire()
        );
        tutorScorer = new TutorScorer(questionnaires);
        tutorScorer.add(new ScoreQuestion(
                "How much overall tutoring experience do you have?",
                Map.of("3 or more", "2"),
                QuestionType.SINGLE_CHOICE
        ));
        tutorScorer.add(new ScoreQuestion(
                "What kind of tutoring experience do you have?",
                Map.of("Online tutoring", "1", "Home schooling", "1", "After school club", "1"),
                QuestionType.MULTIPLE_CHOICE
        ));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }
}
