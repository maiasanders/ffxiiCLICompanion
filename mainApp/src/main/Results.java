package main;

import main.entryTypes.*;

import java.util.List;

public class Results {
    public static void printRgSearch(List<Integer> indexes){
        for (int index : indexes){
            Enemy rareGame = RareGameData.rareGameList.get(index);
            printBreakLine();
            System.out.println(rareGame.toString());
        }
    }

    public static void printLists(List<Enemy> entries) {
        for (Enemy entry : entries) {
            printBreakLine();
            System.out.println(entry.toString());
        }
    }
    public static void printHuntList(){
        for (Hunt hunt : HuntData.hunts) {
            printBreakLine();
            System.out.println(hunt.toString());
        }
    }
    public static void printEsperSearch(List<Integer> indexes){
        for (int ind : indexes) {
            Enemy esper = EsperData.espers.get(ind);
            printBreakLine();
            esper.toString();
        }
    }

//    public static void printLists(int startInd, int endInd, boolean includePhoenix) {
//        for (Checkable entry : entries) {
//            if (entry.getEntryNum() >= RARE_GAME_START_ENTRY_NUM && entry.getEntryNum() <= RARE_GAME_END_ENTRY_NUM) {
//                System.out.println(entry);
//                Results.printBreakLine();
//            }
//        }
//    }
    public static void printBreakLine(){
        System.out.println("--------------------------------------");
    }
}
