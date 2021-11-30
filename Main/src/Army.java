import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Warrior> armyList = new ArrayList<>();

    public Army() {
    }

    public List<Warrior> getArmyList() {
        return armyList;
    }

    public List<Warrior> addUnits(int count, int classOfWarriors) {
        int i;
        for (i = 0; i < count; i++) {
            armyList.add(chooseClassOfWarrior(classOfWarriors));
            if (this.armyList.size() > 1)
                this.armyList.get(this.armyList.size() - 2).setNextUnit(armyList.get(this.armyList.size() - 1));
        }
        System.out.println("Успешно добавлено " + i + " " + chooseClassOfWarrior(classOfWarriors).getClass().getTypeName() + "s");
        System.out.println("Общее количетсво воинов в армии: " + armyList.size());
        return armyList;
    }

    public Warrior chooseClassOfWarrior(int classOfWarriors) {
        return switch (classOfWarriors) {
            case 1 -> new Warrior();
            case 2 -> new Knight();
            case 3 -> new Defender();
            case 4 -> new Vampire();
            case 5 -> new Lancer();
            default -> null;
        };
    }
}
