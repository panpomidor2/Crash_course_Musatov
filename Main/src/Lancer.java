public class Lancer extends Warrior {
    public Lancer() {
        super(50, 6);
    }

    public int attack(Warrior warriorDefender) {
        return warriorDefender.getNextUnit() != null ? warriorDefender.getNextUnit().getDamage(warriorDefender.getDamage(attack) / 2) : warriorDefender.getDamage(attack);
    }
}
