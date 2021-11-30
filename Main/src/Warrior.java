public class Warrior {
    protected int health;
    protected int attack;
    protected Warrior nextUnit;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public void setNextUnit(Warrior nextUnit) {
        this.nextUnit = nextUnit;
    }

    public Warrior getNextUnit() {
        return nextUnit;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage(int damage) {
        if (damage < 0) return 0;
        health -= damage;
        return damage;
    }

    public int attack(Warrior warriorDefender) {
        return warriorDefender.getDamage(attack);
    }
}