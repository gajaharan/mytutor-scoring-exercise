package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.ScoreQuestion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

public class TutorScorerTest {
    private Scorer tutorScorer = new TutorScorer();

    @Test
    public void scorerProvidesTheTotalScoreZeroWhenContainingNoSingleChoiceQuestions() {
        int expectedScore = 0;
        tutorScorer.add(new ScoreQuestion(
                "How much overall tutoring experience do you have?",
                Collections.emptyMap()
        ));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void scorerProvidesTheTotalScoreZeroWhenContainingOneSingleChoiceQuestions() {
        int expectedScore = 2;
        tutorScorer.add(new ScoreQuestion(
                "How much overall tutoring experience do you have?",
                Map.of("3 or more", "2")
        ));
        int actualScore = tutorScorer.totalScore();
        Assertions.assertEquals(expectedScore, actualScore);
    }
}
