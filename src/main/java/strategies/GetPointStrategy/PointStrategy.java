package strategies.GetPointStrategy;

import model.Dice;
import model.Player;

public interface PointStrategy {
    int getPoint(Player player, Dice dice);
}
