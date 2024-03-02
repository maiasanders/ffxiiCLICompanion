package main.entryTypes;

import java.util.Comparator;

public class RareGame extends Enemy {
    private int entryNum;
    private String[] drops;
    private String[] poach;
    private boolean isTrophy(){
        return this.drops[0].contains("Trophy");
    }
    private int rarity;
    private String rarityStars(){
        String stars = "";
        for (int i = 0; i < this.rarity; i++){
            stars += "☆";
        }
        return stars;
    }

    public RareGame(String name, int entryNum, int rarity, String locationMain, String locationZone, int level, String drops, String stealItems, String poach, String wiki) {
        super(name, entryNum, locationMain, locationZone, level, stealItems, wiki);
        this.rarity = rarity;
        this.drops = drops.split(", ");
        if (poach.length() > 0) {
            this.poach = poach.split(", ");
        } else {
            this.poach = new String[0];
        }
    }


    @Override
    public String toString() {
        String output = STR."Name: \{this.name}" +
                STR."\nLevel: \{level}" +
                STR."\nEntry no. \{getEntryNum()} \t \{this.rarityStars()}" +
                STR."\nLocation: \{this.locationMain} - \{this.locationZone}" +
                STR."\nDrops: \{String.join(", ", this.drops)}" +
                STR."\nCan steal \{this.stealItemStr}";
        if (poach.length > 0) {
            output += STR."\nCan poach \{String.join(", ", this.poach)}";
        }
        output += "\nWiki: " + getWiki();
        if (this.isTrophy()) {
            output += "\n**Part of Hunt Club quest**";
        }
        return output;

    }



}

// Sorting helper functions
class SortByName implements Comparator<RareGame> {
    public int compare(RareGame rg1, RareGame rg2){
        return rg1.getName().compareTo(rg2.getName());
    }
}

class SortByLocation implements Comparator<RareGame> {
    public int compare(RareGame rg1, RareGame rg2){
        return rg1.getLocationMain().compareTo(rg2.getLocationMain());
    }
}

class SortByLevel implements Comparator<RareGame> {
    public int compare(RareGame rg1, RareGame rg2) {
        return rg1.getLevel() - rg2.getLevel();
    }
}
class SortByEntry implements Comparator<RareGame> {
    public int compare(RareGame rg1, RareGame rg2) {
        return rg1.getEntryNum() - rg2.getEntryNum();
    }
}