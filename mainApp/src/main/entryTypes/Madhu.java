package main.entryTypes;

import main.entryTypes.SideQuest;

public class Madhu extends SideQuest {

    String locationZone;
    String bottleLocationDescription;
    String buyer;

    public Madhu(String locationMain, int entryNum, String locationZone, String bottleLocationDescription, String buyer) {
        super("Bhujerban Madhu", locationMain, entryNum);
        this.locationZone = locationZone;
        this.bottleLocationDescription = bottleLocationDescription;
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "--Bhujerban Madhu Bottle--" +
                STR."\n\tZone: \{locationZone} - \{bottleLocationDescription}" +
                STR."\n\tBuyer: \{buyer}";
    }
}
