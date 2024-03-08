package main.entryTypes;

public class SevenSisters extends SideQuest{

    String routeDestination;

    public SevenSisters(String locationMain, int entryNum, String routeDestination) {
        super("Seven Sisters on the Airships", locationMain, entryNum);
        this.routeDestination = routeDestination;
    }

    @Override
    public String toString() {
        return STR."--Seven Sisters on the Airships--\n\tDeparture Location: \{getLocationMain()}\n\tDestination: \{routeDestination}";
    }
}
