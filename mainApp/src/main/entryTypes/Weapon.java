package main.entryTypes;

public class Weapon extends Equipment {

    private int damage;
    public Weapon(String name, String location, int entryNum, String type, String element, String notes, boolean isChecked, boolean bazaar, boolean treasure, boolean inShop, int damage) {
        super(name, location, entryNum, type, element, notes, isChecked, bazaar, treasure, inShop);
        this.damage = damage;
    }

    // TODO format toString
    @Override
    public String toString() {
        return String.format("--%s--", getTitle()) +
                String.format("\n\tType: %s", getType());
    }
}
