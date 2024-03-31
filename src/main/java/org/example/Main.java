package org.example;

import Controller.GameController;
import exception.*;
import model.Game;
import model.GameStatus;
import model.Player;
import model.PlayerStatus;

public class Main {
    public static void printResult(Player player) {
        if(player.getPlayerStatus().equals(PlayerStatus.LOSER)) {
            System.out.println(player.getName() + " Lost the Game!");
        } else {
            System.out.println(player.getName() + " Won the Game!");
        }
    }
    public static void main(String[] args) throws
            PlayerNotSetException,
            HealthAttributeNotSetException,
            StrengthAttributeNotSetException,
            NameAttributeNotSetException,
            AttackAttributeNotSetException
    {
        System.out.println("Game Started");

        Player player1 = Player.create()
                .setAttack(100)
                .setHealth(800)
                .setStrength(90)
                .setName("player1")
                .build();

        Player player2 = Player.create()
                .setAttack(120)
                .setHealth(1000)
                .setStrength(86)
                .setName("player2")
                .build();

        GameController gameController = new GameController();
        Game game = gameController.createGame(player1, player2);
        while(gameController.getGameStatus(game).equals(GameStatus.PROGRESS)) {
            gameController.makeMove(game);
        }
        printResult(player1);
        printResult(player2);


        System.out.println("Game Finished");
    }
}