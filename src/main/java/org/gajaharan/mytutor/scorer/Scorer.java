package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.Question;

public interface Scorer {
    boolean add(Question question);
    int totalScore();
}
