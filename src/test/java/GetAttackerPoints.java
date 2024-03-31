import model.Dice;
import model.Player;
import org.junit.Test;
import strategies.GetPointStrategy.AttackStrategy;

import java.util.HashSet;
import java.util.Set;

public class GetAttackerPoints {
    @Test
    public void getAttackerPointTest() throws Exception {
        Player player1 = Player.create()
                .setAttack(100)
                .setHealth(800)
                .setStrength(90)
                .setName("player1")
                .build();
        Set<Integer> st = new HashSet<>();
        st.add(100*1);
        st.add(100*2);
        st.add(100*3);
        st.add(100*4);
        st.add(100*5);
        st.add(100*6);
        AttackStrategy attackStrategy = new AttackStrategy();
        int attackerPoints = attackStrategy.getPoint(player1, new Dice());
        if (!st.contains(attackerPoints)){
            throw new Exception("getAttackerPointTest get failed!");
        }
}
}
