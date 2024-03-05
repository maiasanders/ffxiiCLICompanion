package main.entryTypes;

public abstract class Enemy implements Checkable {
    protected String name;
    int entryNum;
    protected String locationMain;
    protected String locationZone;
    protected int level;
    protected String stealItemStr;
    protected String wiki;
    protected boolean checkedOff;


    public Enemy(String name, int entryNum, String locationMain, String locationZone, int level, String stealItems, String wiki) {
        this.name = name;
        this.entryNum = entryNum;
        this.locationMain = locationMain;
        this.locationZone = locationZone;
        this.level = level;
        this.stealItemStr = stealItems;
        this.wiki = wiki;
        this.checkedOff = false;
    }
    @Override
    public int getEntryNum() {
        return entryNum;
    }

    private String[] stealItemsArr() {
        return stealItemStr.split(", ");
    }

    public String getName() {
        return this.name;
    }

    public String getLocationMain() {
        return this.locationMain;
    }

    public String getLocationZone() {
        return this.locationZone;
    }

    public int getLevel() {
        return this.level;
    }

    public String getStealItemStr() {
        return this.stealItemStr;
    }

    public String[] getStealItems() {
        return this.stealItemsArr();
    }

    public String getWiki() {
        return this.wiki;
    }

    @Override
    public void checkOff() {
        checkedOff = true;
    }
    @Override
    public void uncheck() {
        this.checkedOff = false;
    }
    @Override
    public boolean isCheckedOff() {
        return checkedOff;
    }

    public String getTitle() {
        return this.name;
    }
    public String getLocation() {
        return this.locationMain;
    }



}
