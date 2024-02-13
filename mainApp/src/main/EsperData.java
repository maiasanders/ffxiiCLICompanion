package main;

import java.util.ArrayList;
import java.util.List;

public class EsperData {

    public static List<Enemy> espers = new ArrayList<>();
    private static String[] esperLoadData() {
        return new String[]{
                "Adrammelech|Zertinan Caverns|Athroza Quicksands|39|Lightning|Pebble, Capricorn Gem, High Arcana|https://finalfantasy.fandom.com/wiki/https://finalfantasy.fandom.com/wiki/Adrammelech_(Final_Fantasy_XII)",

                "Cúchulainn|Garamsythe Waterway|No. 1 Cloaca|45|Posion|Scorpio Gem, Elixir, High Arcana|https://finalfantasy.fandom.com/wiki/https://finalfantasy.fandom.com/wiki/C%C3%BAchulainn_(Final_Fantasy_XII)",

                "Zalera|Barheim Passage|Terminus No. 7|40|Death|Pebble, Gemini Gem, High Arcana|https://finalfantasy.fandom.com/wiki/Zalera_(Final_Fantasy_XII)",

                "Zeromus|Stilshrine of Miriam|Throne of Veiled Gods|51|Gravity|Cancer Gem, Elixir, High Arcana|https://finalfantasy.fandom.com/wiki/Zeromus_(Final_Fantasy_XII)",

                "Exodus|Mosphoran Highwaste|Empyrean Seat|46|Aether|Libra Gem, Elixir, High Arcana|https://finalfantasy.fandom.com/wiki/Exodus_(Final_Fantasy_XII)",

                "Chaos|Necrohol of Nabudis|The Crucible|57|Wind|Taurus Gem, Elixir, High Arcana|https://finalfantasy.fandom.com/wiki/Chaos_(Final_Fantasy_XII)",

                "Ultima|Great Crystal|Crystal Peak|63|Holy|Virgo Gem, High Arcana, Megalixir|https://finalfantasy.fandom.com/wiki/Ultima_(Final_Fantasy_XII)",

                "Zodiark|Henne Mines|Ore Separation|66|Darkness|Serpentarius, High Arcana, Megalixir|https://finalfantasy.fandom.com/wiki/Zodiark_(Final_Fantasy_XII)"
        };
    }
    public static void loadEspers(){
        String[] esperData = EsperData.esperLoadData();
        for (String entry : esperData){
            String[] entryData = entry.split("\\|");
            Enemy esper = new Esper(
                    entryData[0],
                    entryData[1],
                    entryData[2],
                    Integer.parseInt(entryData[3]),
                    entryData[4],
                    entryData[5],
                    entryData[6]
            );
            EsperData.espers.add(esper);
        }
    }

    public static List<Integer> filterEsperByName(String esperSearched) {
        List<Integer> indexes = new ArrayList<>();
//        Collections.sort(rareGameList, new main.SortByName());
        for (int i = 0; i < espers.size(); i++){

            if (espers.get(i).getName().toLowerCase().contains(esperSearched.toLowerCase())){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
