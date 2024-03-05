package main.entryTypes;

import java.util.Comparator;

public class SortByEntryNum implements Comparator<Checkable> {

    @Override
    public int compare(Checkable o1, Checkable o2) {
        return o1.getEntryNum() - o2.getEntryNum();
    }
}
