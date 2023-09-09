package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.ScoreQuestion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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
}
