package org.gajaharan.mytutor.questionnaire;

import org.gajaharan.mytutor.model.Question;
import org.gajaharan.mytutor.model.QuestionType;

import java.util.Collection;
import java.util.List;

public class SingleChoiceQuestionnaire implements Questionnaire {
    @Override
    public int sum(final List<Question> questions) {
        return questions.stream()
                .filter(question -> question.type().equals(QuestionType.SINGLE_CHOICE))
                .map(question -> question.questionsWithValues().values())
                .flatMap(Collection::stream)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
