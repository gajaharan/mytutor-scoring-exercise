package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.Question;
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
                1,
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
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2"),
                        QuestionType.SINGLE_CHOICE
                )
        );
        tutorScorer = new TutorScorer(questionnaires);
        questions.forEach(question -> tutorScorer.add(question));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreWhenContainingOneMultipleChoiceQuestions() {
        int expectedScore = 3;
        List<Questionnaire> questionnaires = List.of(new MultipleChoiceQuestionnaire());
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "What kind of tutoring experience do you have?",
                        Map.of("Online tutoring", "1", "Home schooling", "1", "After school club", "1"),
                        QuestionType.MULTIPLE_CHOICE
                )
        );
        tutorScorer = new TutorScorer(questionnaires);
        questions.forEach(question -> tutorScorer.add(question));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreWhenContainingTwoSingleChoiceQuestions() {
        int expectedScore = 5;
        List<Questionnaire> questionnaires = List.of(new SingleChoiceQuestionnaire());
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2"),
                        QuestionType.SINGLE_CHOICE
                ),
                new ScoreQuestion(
                        1,
                        "What is your fluent Language",
                        Map.of("English", "3"),
                        QuestionType.SINGLE_CHOICE
                )
        );
        tutorScorer = new TutorScorer(questionnaires);
        questions.forEach(question -> tutorScorer.add(question));
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
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2"),
                        QuestionType.SINGLE_CHOICE
                ),
                new ScoreQuestion(
                        1,
                        "What kind of tutoring experience do you have?",
                        Map.of("Online tutoring", "1", "Home schooling", "1", "After school club", "1"),
                        QuestionType.MULTIPLE_CHOICE
                )
        );
        tutorScorer = new TutorScorer(questionnaires);
        questions.forEach(question -> tutorScorer.add(question));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreWhenContainingTwoSingleChoiceQuestionsTwoMultipleChoiceQuestion() {
        int expectedScore = 13;
        List<Questionnaire> questionnaires = List.of(
                new SingleChoiceQuestionnaire(),
                new MultipleChoiceQuestionnaire()
        );
        List<Question> questions = List.of(
                new ScoreQuestion(
                        1,
                        "How much overall tutoring experience do you have?",
                        Map.of("3 or more", "2"),
                        QuestionType.SINGLE_CHOICE
                ),
                new ScoreQuestion(
                        1,
                        "What is your fluent Language",
                        Map.of("English", "3"),
                        QuestionType.SINGLE_CHOICE
                ),
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
        tutorScorer = new TutorScorer(questionnaires);
        questions.forEach(question -> tutorScorer.add(question));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }
}
