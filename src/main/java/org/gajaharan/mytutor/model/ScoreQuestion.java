package org.gajaharan.mytutor.model;

import java.util.Map;

public class ScoreQuestion implements Question {
    private String title;
    private Map<String, String> questionsWithValues;

    public ScoreQuestion(String title, Map<String, String> questionsWithValues) {
        this.title = title;
        this.questionsWithValues = questionsWithValues;
    }
    @Override
    public String title() {
        return title;
    }

    @Override
    public Map<String, String> questionsWithValues() {
        return questionsWithValues;
    }
}
