package org.gajaharan.mytutor.model;

import java.util.Map;

public interface Question {
    long tutorId();
    
    String title();

    Map<String, String> questionsWithValues();

    QuestionType type();
}
