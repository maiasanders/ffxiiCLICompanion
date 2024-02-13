package main;

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
    public static void printBreakLine(){
        System.out.println("--------------------------------------");
    }
}
