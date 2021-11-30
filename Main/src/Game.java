import java.util.List;

public class Game {
    public static boolean fight(Warrior w1, Warrior w2) {
        boolean attacking = true;
        while (attacking) {
            if (w1.isAlive())
                w1.attack(w2);
            else attacking = false;
            if (w2.isAlive())
                w2.attack(w1);
            else attacking = false;
        }
        return w1.isAlive();
    }
}
