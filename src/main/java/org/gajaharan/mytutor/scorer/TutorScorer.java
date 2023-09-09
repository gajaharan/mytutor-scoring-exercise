package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.Question;
import org.gajaharan.mytutor.questionnaire.Questionnaire;

import java.util.ArrayList;
import java.util.List;

public class TutorScorer implements Scorer {
    final private List<Question> questions = new ArrayList<>();
    final private List<Questionnaire> questionnaires;

    public TutorScorer(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    @Override
    public boolean add(final Question question) {
        return questions.add(question);
    }

    @Override
    public int totalScore() {
        return questionnaires.stream()
                .map(questionnaire -> questionnaire.sum(questions))
                .reduce(0, Integer::sum);
    }
}
