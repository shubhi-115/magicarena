import model.Dice;
import model.Player;
import org.junit.Test;
import strategies.GetPointStrategy.DefendStrategy;

import java.util.HashSet;
import java.util.Set;

public class GetDefenderPoints {
    @Test
    public void getDefenderPointTest() throws Exception {
        Player player1 = Player.create()
                .setAttack(100)
                .setHealth(800)
                .setStrength(90)
                .setName("player1")
                .build();
        Set<Integer> st = new HashSet<>();
        st.add(90*1);
        st.add(90*2);
        st.add(90*3);
        st.add(90*4);
        st.add(90*5);
        st.add(90*6);
        DefendStrategy defenderStrategy = new DefendStrategy();
        int defenderPoints = defenderStrategy.getPoint(player1, new Dice());
        if (!st.contains(defenderPoints)){
            throw new Exception("getDefenderPointTest get failed!");
        }
    }
}
