package strategies.WinningStrategy;

import model.GameStatus;
import model.Player;

public interface WinStrategy {
    GameStatus hasWin(Player player1, Player player2);
}
