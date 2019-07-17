package domain.frame;

import domain.Pins;

public interface Frame {

    Frame fillFrame(Pins fallenPins);

    boolean isGameOver();

    FrameIndex getIndex();
}
