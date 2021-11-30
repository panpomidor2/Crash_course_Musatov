import java.util.List;

public class Battle {
    public Battle() {
    }

    public static boolean fight(List<Warrior> army1, List<Warrior> army2) {
        while (army1.size() != 0 && army2.size() != 0) {
            if (Game.fight(army1.get(0), army2.get(0))) {
                army2.remove(0);
            } else
                army1.remove(0);
        }
        return army1.size() > 0;
    }
}
