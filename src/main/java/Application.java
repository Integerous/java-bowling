import domain.BowlingGame;
import domain.BowlingMatch;
import domain.Pins;
import domain.Player;
import domain.frame.FrameIndex;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int numberOfPlayers = InputView.askNumberOfPlayers();
        List<Player> players = new ArrayList<>();

        for (int index = 1; index <= numberOfPlayers; index++) {
            String playerName = InputView.askPlayerName(index);
            players.add(Player.from(playerName));
        }

        BowlingMatch bowlingMatch = BowlingMatch.start(players);
        OutputView.printBoard(bowlingMatch);

        while(!bowlingMatch.isOver()) {
            BowlingGame ongoingGame = bowlingMatch.getOngoingGame();
            Pins fallenPins = InputView.askFallenPins(ongoingGame);

            ongoingGame.play(fallenPins);
            OutputView.printBoard(bowlingMatch);
        }
    }
}
