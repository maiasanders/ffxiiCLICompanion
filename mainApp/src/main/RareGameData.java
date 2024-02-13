package main;

import java.util.ArrayList;
import java.util.List;

public class RareGameData {
    public static String[] rareGameLoadData() {
        return new String[]{
                "Aspidochelon|293|5|Cerobi Steppe|Feddick River|42|Adamantine Trophy|Scarletite||https://finalfantasy.fandom.com/wiki/Aspidochelon_(Final_Fantasy_XII)",

                "Aerieel|294|5|Lhusu Mines|Ottam Span|12|Bat Fang, Golden Armor|Bat Wing|Taurus Gem|https://finalfantasy.fandom.com/wiki/Aerieel",

                "Thalassinon|295|4|Phon Coast|The Vaddu Strand|38|Shelled Trophy|Adamantite||https://finalfantasy.fandom.com/wiki/Thalassinon_(Final_Fantasy_XII)",

                "Anubys|296|5|Sochen Cave Palace|Mirror of the Soul|38|Ensanguined Trophy|Vampyr Fang||https://finalfantasy.fandom.com/wiki/Anubys_(Final_Fantasy_XII)",

                "Greeden|297|3|Dalmasca Estersand|Bank of the Nebra|31|Braid Wool, Blood Wool|Wind Crystal|Blood Wool|https://finalfantasy.fandom.com/wiki/Greeden",

                "Barmuu|298|3|Tomb of Raithwall|Royal Passage|19|Solid Stone, Betelgeuse|Lamia's Tiara|Quality Stone|https://finalfantasy.fandom.com/wiki/Barmuu",

                "Bull Croc|299|5|Ozmone Plain|The Shred|23|Braid Wool, Demon Mail|Blood Wool|Broken Sword|https://finalfantasy.fandom.com/wiki/Bull_Croc",

                "Vishno|300|2|The Pharos|First Ascent (Wellspring Ravel - 4th Flight)|57|Solid Stone, Ribbon|Orichalcum||https://finalfantasy.fandom.com/wiki/Vishno",

                "Gavial|301|4|Garamsythe Waterway|No. 10 Channel|46|Fur-scaled Trophy|Antarctic Wind||https://finalfantasy.fandom.com/wiki/Gavial_(Final_Fantasy_XII)"
        };
    }

    public static List<Enemy> rareGameList = new ArrayList<>();
    public static void printRgList(){
        for (Enemy rareGame: rareGameList){
            Results.printBreakLine();
            System.out.println(rareGame.toString());
        }
    }

    public static void load(){
        String[] raGaData = RareGameData.rareGameLoadData();
        for (String entry : raGaData) {
            String[] entryFields = entry.split("\\|");

            Enemy rareGame = new RareGame(
                    entryFields[0],
                    Integer.parseInt(entryFields[1]),
                    Integer.parseInt(entryFields[2]),
                    entryFields[3],
                    entryFields[4],
                    Integer.parseInt(entryFields[5]),
                    entryFields[6],
                    entryFields[7],
                    entryFields[8],
                    entryFields[9]
            );
            rareGameList.add(rareGame);
        }
    }

    public static List<Integer> filterRgByName(String rgSearched) {
        List<Integer> indexes = new ArrayList<>();
//        Collections.sort(rareGameList, new main.SortByName());
        for (int i = 0; i < rareGameList.size(); i++){

            if (rareGameList.get(i).getName().toLowerCase().contains(rgSearched.toLowerCase())){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
