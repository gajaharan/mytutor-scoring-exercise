package org.gajaharan.mytutor.scorer;

import org.gajaharan.mytutor.model.Question;

public interface Scorer {
    boolean add(final Question question);

    int totalScore();
}
