package model;

import exception.PlayerNotSetException;
import strategies.WinningStrategy.PlayerWinStrategy;
import strategies.WinningStrategy.WinStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private GameStatus gameStatus;
    private int lastPlayerIndex;

    private WinStrategy winStrategy;

    private Game() {
        this.players = new ArrayList<>();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void makeMove() {
        this.lastPlayerIndex = 1 - lastPlayerIndex;

        Player attacker = players.get(lastPlayerIndex);
        Player defender = players.get(1 - lastPlayerIndex);

        int attackPoints = attacker.getAttackPoints();
        int defendPoints = defender.getDefendPoints();

        System.out.println("--------------------------------------------------------");
        System.out.println("Attacker Points: " + attackPoints);
        System.out.println("Defender Points: " + defendPoints);

        int remainingHealth = defender.getHealth();
        int damage = attackPoints - defendPoints;

        System.out.println("Damage: " + Math.max(damage, 0));
        if(damage > 0) {
            defender.setHealth(remainingHealth - damage);
        }

        System.out.println("Attacker Health: " + attacker.getHealth());
        System.out.println("Defender Health: " + defender.getHealth());

        gameStatus = winStrategy.hasWin(attacker, defender);

        if(gameStatus.equals(GameStatus.END)) {
            setPlayerStatus(attacker);
            setPlayerStatus(defender);
        }
        System.out.println("--------------------------------------------------------");
    }

    public void setPlayerStatus(Player player) {
        if(player.getHealth() <= 0) {
            player.setPlayerStatus(PlayerStatus.LOSER);
        } else {
            player.setPlayerStatus(PlayerStatus.WINNER);
        }
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
            if(player1 == null || player2 == null) {
                throw new PlayerNotSetException("Player not Set");
            }

            Game game = new Game();

            game.gameStatus = GameStatus.PROGRESS;
            if(player1.getHealth() < player2.getHealth()) {
                game.players = List.of(player1, player2);
            } else {
                game.players = List.of(player2, player1);
            }
            game.lastPlayerIndex = 0;
            game.winStrategy = new PlayerWinStrategy();
            return game;
        }

    }
}
