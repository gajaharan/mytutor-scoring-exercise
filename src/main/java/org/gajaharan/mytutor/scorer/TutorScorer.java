package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.Question;

import java.util.ArrayList;
import java.util.List;

public class TutorScorer implements Scorer{
    private List<Question> questions = new ArrayList<>();

    @Override
    public boolean add(Question question) {
        return questions.add(question);
    }

    @Override
    public int totalScore() {
        return 0;
    }
}
