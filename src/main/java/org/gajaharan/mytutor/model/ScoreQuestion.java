package org.gajaharan.mytutor.model;

import java.util.Map;

public record ScoreQuestion(long tutorId, String title, Map<String, String> questionsWithValues,
                            QuestionType type) implements Question {
}
