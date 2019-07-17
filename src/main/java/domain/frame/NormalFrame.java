package domain.frame;

import domain.Pins;
import domain.state.StandBy;
import domain.state.State;

public class NormalFrame implements Frame {

    private FrameIndex index;
    private State state;
    private Frame nextFrame;

    private NormalFrame(FrameIndex index) {
        this.index = index;
        this.state = new StandBy();
    }

    public static NormalFrame of(FrameIndex index) {
        return new NormalFrame(index);
    }

    @Override
    public Frame fillFrame(Pins fallenPins) {
        state = state.update(fallenPins);
        if (state.isClosed()) {
            this.nextFrame = generateNextFrame();
            return nextFrame;
        }
        return this;
    }

    Frame generateNextFrame() {
        if (this.index.isSecondToLastIndex()) {
            return FinalFrame.of();
        }
        return NormalFrame.of(index.increment());
    }

    FrameIndex getIndex() {
        return index;
    }
}