package main.entryTypes;

import java.util.Comparator;

public class Esper extends Enemy {
    ;
    private String element;

    public Esper(String name, int entryNum, String locationMain, String locationZone, int level, String element, String stealItems, String wiki) {
        super(name, entryNum, locationMain, locationZone, level, stealItems, wiki);
        this.element = element;
    }

    public String getElement(){
        return this.element;
    }


    public void printEsper(){
        System.out.println(STR."");
        System.out.println(STR."Location: \{this.locationMain} - \{this.locationZone}");
        System.out.println(STR."Level \{this.level}\tElement: \{this.element}");
        System.out.println(STR."Can steal: \{this.stealItemStr}");
        System.out.println(STR."Wiki: \{this.wiki}");
    }
    @Override
    public String toString() {
        return STR."Name: \{this.name}" +
                STR."\nLocation: \{this.locationMain} - \{this.locationZone}" +
                STR."\nLevel \{this.level}\tElement: \{this.element}" +
                STR."\nCan steal: \{this.stealItemStr}" +
                STR."\nWiki: \{this.wiki}";
    }
}

// comparator classes
class EsperSortByLevel implements Comparator<Esper> {
    public int compare(Esper esper1, Esper esper2) {
        return esper1.getLevel() - esper2.getLevel();
    }
}