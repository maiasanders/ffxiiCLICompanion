package main.entryTypes;

import java.util.ArrayList;
import java.util.List;

public class HuntData {

    public static List<Hunt> hunts = new ArrayList<>();
    public static String[] huntEntries() {
        return new String[]{
                "Rogue Tomato|Dalmasca Estersand|The Stepping|2|Pebble, Fire Stone, Potion|https://finalfantasy.fandom.com/wiki/Rogue_Tomato|Red & Rotten in the Desert|1|Tomaj|Rabanastre|Sandsea Tavern",

                "Thextera|Dalmasca Westersand|Galtea Downs|6|Pebble, Potion, Wolf Pelt|https://finalfantasy.fandom.com/wiki/Thextera_(Final_Fantasy_XII)|Wolf in the Waste|1|Gatsly|Rabanastre|The Sandsea",

                "Flowering Cactoid|Dalmasca Estersand|Yardang Labyrinth|4|Cactus Fruit, Earth Stone, Potion|https://finalfantasy.fandom.com/wiki/Flowering_Cactoid|Dalmasca's Desert Bloom|1|Dantro|Dalmasca Estersand|Outpost",

                "Wraith|Garamsythe Waterway|Central Waterway Control|9|Glass Jewel, Dark Magicite, Hi-Potion|https://finalfantasy.fandom.com/wiki/Wraith_(Final_Fantasy_XII)|Waterway Haunting|1|Milha|Rabanastre Lowtown|North Sprawl",
        };
    }

//    public static List<main.entryTypes.Enemy> getHunts() {
//        return hunts;
//    }

//    public static void loadHunts() {
//        String[] huntData = HuntData.huntEntries();
//        for (String entry : huntData) {
//            String[] entryData = entry.split("\\|");
//            Hunt hunt = new Hunt(
//                    entryData[0],
//                    entryData[1],
//                    entryData[2],
//                    Integer.parseInt(entryData[3]),
//                    entryData[4],
//                    entryData[5],
//                    entryData[6],
//                    (entryData[7]),
//                    entryData[8],
//                    entryData[9],
//                    entryData[10],
//                    entryData[11]
//            );
//            hunts.add(hunt);
//        }
//    }

}
