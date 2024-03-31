package strategies.GetPointStrategy;

import model.Dice;
import model.Player;

public class DefendStrategy implements PointStrategy {
    @Override
    public int getPoint(Player player, Dice dice) {
        return player.getStrength() * dice.diceRoll();
    }
}
