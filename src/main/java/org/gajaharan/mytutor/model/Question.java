package org.gajaharan.mytutor.model;

import java.util.Map;

public interface Question {
    String title();

    Map<String, String> questionsWithValues();

    QuestionType type();
}
