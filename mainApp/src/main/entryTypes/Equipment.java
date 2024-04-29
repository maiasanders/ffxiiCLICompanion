package main.entryTypes;

public abstract class Equipment implements Checkable, Obtainable{

    private String name;
    private String location;
    private int entryNum;
    private String type;
    private String element;
    private String notes;
    private boolean isChecked;
    private boolean bazaar;
    private boolean treasure;
    private boolean inShop;

    public Equipment(String name, String location, int entryNum, String type, String element, String notes, boolean isChecked, boolean bazaar, boolean treasure, boolean inShop) {
        this.name = name;
        this.location = location;
        this.entryNum = entryNum;
        this.type = type;
        this.element = element;
        this.notes = notes;
        this.isChecked = isChecked;
        this.bazaar = bazaar;
        this.treasure = treasure;
        this.inShop = inShop;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getElement() {
        return element;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isBazaar() {
        return bazaar;
    }

    /* ------Checkable methods------- */

    @Override
    public void checkOff() {
        isChecked = true;
    }

    @Override
    public void uncheck() {
        isChecked = false;
    }

    @Override
    public boolean isCheckedOff() {
        return isChecked;
    }

    @Override
    public String getLocationMain() {
        return location;
    }

    @Override
    public int getEntryNum() {
        return entryNum;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public boolean isFromBazaar() {
        return bazaar;
    }

    @Override
    public boolean isInShop() {
        return inShop;
    }

    @Override
    public boolean isTreasure() {
        return treasure;
    }
}
