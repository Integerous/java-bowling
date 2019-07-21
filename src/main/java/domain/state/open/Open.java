package domain.state.open;

import domain.Score;
import domain.state.State;

abstract class Open implements State {

    @Override
    public boolean isClosed() {
        return Boolean.FALSE;
    }

    @Override
    public Score getScore() {
        return Score.of(0, 0);
    }
}
