package strategies.GetPointStrategy;

import model.Dice;
import model.Player;

public class AttackStrategy implements PointStrategy {
    @Override
    public int getPoint(Player player, Dice dice) {
        return player.getAttack() * dice.diceRoll();
    }
}
