import model.Game;
import model.Player;
import org.junit.Test;

public class MakeMove {
    @Test
    public void MakeMoveTest() throws Exception {
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

             Game game = Game.create()
                     .setFirstPlayer(player1)
                     .setSecondPlayer(player2)
                     .build();
             game.makeMove();
            }

}
