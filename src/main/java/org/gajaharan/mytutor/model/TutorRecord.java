package org.gajaharan.mytutor.model;

import java.util.List;

public record TutorRecord(long tutorId, List<Question> questions, int score) {
}
