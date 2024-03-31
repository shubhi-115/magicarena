package Controller;

import exception.PlayerNotSetException;
import model.Game;
import model.GameStatus;
import model.Player;

public class GameController {
    public Game createGame(Player player1, Player player2) throws PlayerNotSetException {
        Game game = Game.create()
                .setFirstPlayer(player1)
                .setSecondPlayer(player2)
                .build();

        return game;
    }
    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
}
