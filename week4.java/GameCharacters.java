// File: GameCharacters.java

// Base class
abstract class GameCharacter {
    protected String name;

    public GameCharacter(String name) {
        this.name = name;
    }

    public abstract String attack();
}

// Subclass: Warrior
class Warrior extends GameCharacter {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public String attack() {
        return name + " attacks with a sword for melee damage!";
    }
}

// Subclass: Archer
class Archer extends GameCharacter {
    private int arrowCount;

    public Archer(String name, int arrowCount) {
        super(name);
        this.arrowCount = arrowCount;
    }

    @Override
    public String attack() {
        if (arrowCount > 0) {
            arrowCount--;
            return name + " shoots an arrow! Arrows left: " + arrowCount;
        } else {
            return name + " has no arrows left!";
        }
    }
}

// Subclass: Mage
class Mage extends GameCharacter {
    private int mana;

    public Mage(String name, int mana) {
        super(name);
        this.mana = mana;
    }

    @Override
    public String attack() {
        if (mana >= 10) {
            mana -= 10;
            return name + " casts a fireball! Mana left: " + mana;
        } else {
            return name + " doesn't have enough mana!";
        }
    }
}

// Demo class
public class GameCharacters {
    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Thor"),
            new Archer("Legolas", 3),
            new Mage("Gandalf", 25)
        };

        // Demonstrate polymorphism
        for (GameCharacter character : characters) {
            System.out.println(character.attack());
        }

        System.out.println(((Archer)characters[1]).attack());
        System.out.println(((Mage)characters[2]).attack());
    }
}

