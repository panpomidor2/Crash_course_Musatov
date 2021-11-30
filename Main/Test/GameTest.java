import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void fight() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        var result1 = Game.fight(chuck, bruce);
        var result2 = Game.fight(dave, carl);

        assertTrue(result1, "Chuck should have won");
        assertFalse(result2, "Dave should have lost");

        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    void addUnits() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(10, 1);
        army2.addUnits(10, 2);
        assertEquals(10, army1.getArmyList().size());
        assertEquals(10, army2.getArmyList().size());
        for (Warrior warrior : army1.getArmyList()) {
            assertNotNull(warrior);
        }
        for (Warrior warrior : army2.getArmyList()) {
            assertNotNull(warrior);
        }
        boolean res = Battle.fight(army1.getArmyList(), army2.getArmyList());
        assertFalse(res);
        res = Battle.fight(army2.getArmyList(), army1.getArmyList());
        assertTrue(res);
    }

    @Test
    void fightDefender() {
        class Dave extends Warrior {
            public Dave() {
                super(60, 2);
            }
        }
        var chuck = new Warrior();
        var bob = new Defender();
        var tom = new Defender();
        var tod = new Defender();
        var mike = new Knight();
        var dave = new Dave();

        var result1 = Game.fight(chuck, bob);
        var result2 = Game.fight(tom, mike);
        var result3 = Game.fight(tod, dave);

        assertFalse(result1, "Bob should have won");
        assertFalse(result2, "Mike should have  won");
        assertTrue(result3, "Tod should have won");

        assertFalse(chuck.isAlive());
        assertTrue(bob.isAlive());
        assertTrue(tod.isAlive());
        assertEquals(60, tod.getHealth());
    }


    @Test
    void fightVampire() {
        var jim = new Knight();
        var bruce = new Defender();
        var chuck = new Vampire();
        var dave = new Vampire();

        var result1 = Game.fight(bruce, chuck);
        var result2 = Game.fight(jim, dave);

        assertTrue(result1, "Bruce should have won");
        assertTrue(result2, "Jim should have lost");

        assertFalse(chuck.isAlive());
        assertTrue(bruce.isAlive());
        assertTrue(jim.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    void fightLancer() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(1, 5);
        army2.addUnits(1,1);
        army2.addUnits(1,2);

        var result1 = Battle.fight(army1.getArmyList(), army2.getArmyList());
        assertFalse(result1, "Second army should have won");
    }
}