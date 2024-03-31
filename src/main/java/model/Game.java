package model;
import java.util.List;
import java.util.ArrayList;
import exception.PlayerNotSetException;
public class Game {
    private List<Player> players;
    private GameStatus gameStatus;
    private int lastPlayerIndex;
    private Game() {
        this.players = new ArrayList<>();
    }
    public static Builder create() {
        return new Builder();
    }
    public static class Builder {
        private Player player1;
        private Player player2;

        public Builder setFirstPlayer(Player player1) {
            this.player1 = player1;
            return this;
        }

        public Builder setSecondPlayer(Player player2) {
            this.player2 = player2;
            return this;
        }

        public Game build() throws PlayerNotSetException {
            if (player1 == null || player2 == null) {
                throw new PlayerNotSetException("Player not Set");
            }

            Game game = new Game();

            return game;
        }
    }
}
