public class Defender extends Warrior{
    protected int defence;

    public Defender() {
        super(60, 3);
        this.defence = 2;
    }

    public int getDamage(int damage){
        return damage > defence ? super.getDamage(damage - defence) : 0;
    }
}
