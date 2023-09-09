package org.gajaharan.mytutor.questionnaire;

import org.gajaharan.mytutor.model.Question;

import java.util.List;

public interface Questionnaire {
    int sum(final List<Question> questions);
}
