public class Vampire extends Warrior {
    protected int vampirism;

    public Vampire() {
        super(40, 4);
        this.vampirism = 50;
    }

    public int attack(Warrior warriorDefender) {
        int damage = super.attack(warriorDefender);
        healing(damage);
        return damage;
    }

    private void healing(int damage) {
        health += damage * vampirism / 100;
    }
}
