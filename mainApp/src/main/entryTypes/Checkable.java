package main.entryTypes;

import java.util.Comparator;

public interface Checkable {

    void checkOff();
    void uncheck();
    boolean isCheckedOff();
    String getLocationMain();
    int getEntryNum();
    String getTitle();
    String getLocation();

}

