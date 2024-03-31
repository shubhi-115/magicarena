package strategies.WinningStrategy;

import model.GameStatus;
import model.Player;

public class PlayerWinStrategy implements WinStrategy {
    @Override
    public GameStatus hasWin(Player player1, Player player2) {
        if(player1.getHealth() <= 0 || player2.getHealth() <= 0) {
            return GameStatus.END;
        }
        return GameStatus.PROGRESS;
    }
}
