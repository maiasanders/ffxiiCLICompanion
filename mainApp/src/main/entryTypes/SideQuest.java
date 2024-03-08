package main.entryTypes;

public class SideQuest implements Checkable{

    String questName;
    String locationMain;
    int entryNum;
    boolean isChecked;

    public SideQuest(String questName, String locationMain, int entryNum) {
        this.questName = questName;
        this.locationMain = locationMain;
        this.entryNum = entryNum;
        this.isChecked = false;
    }

    /* ----------------- Checkable Methods --------------------- */
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
        return locationMain;
    }

    @Override
    public int getEntryNum() {
        return entryNum;
    }

    @Override
    public String getTitle() {
        return questName;
    }
}
