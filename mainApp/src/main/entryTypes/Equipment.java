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
