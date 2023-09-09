package org.gajaharan.mytutor.model;

import java.util.Map;

public class ScoreQuestion implements Question {
    private String title;
    private Map<String, String> questionsWithValues;
    private QuestionType type;

    public ScoreQuestion(String title, Map<String, String> questionsWithValues, QuestionType type) {
        this.title = title;
        this.questionsWithValues = questionsWithValues;
        this.type = type;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Map<String, String> questionsWithValues() {
        return questionsWithValues;
    }

    @Override
    public QuestionType type() {
        return type;
    }
}
