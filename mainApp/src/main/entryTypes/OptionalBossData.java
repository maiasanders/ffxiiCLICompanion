package main.entryTypes;

import java.util.ArrayList;
import java.util.List;

public class OptionalBossData {

    public static List<Enemy> optionalBosses = new ArrayList<>();

    private String[] optionalBossLoadData() {
        return new String[] {
                "Earth Tyrant|Dalmasca Westersand|Wyrm's Nest|30|Hi Potion, Tyrant Hide, Tyrant Bone|https://finalfantasy.fandom.com/wiki/Earth_Tyrant|1200 gil, opens Wyrm's Nest for travel|Earth Tyrant Extermination - Talk to Rimzat at Rabanastre Westgate to begin",

                "Fury|Necrohol of Nabudis|Cloister of Reason|46|Bloodwool, Moondust, Aries Gem|https://finalfantasy.fandom.com/wiki/Fury_(Final_Fantasy_XII)|2100 gil, Bacchus's Wine|Part of Three Medallions quest to obtain Chaos",

                "Humbaba Mistant|Necrohol of Nabudis|Cloister of Solace|46|Beastlord Hide, Beastloard Horn, Behemoth Steak|https://finalfantasy.fandom.com/wiki/Humbaba_Mistant|2100 gil|Part of Three Medallions quest to obtain Chaos",

                "Hell Wyrm|Sochen Cave Palace|Hall of the Wroth God|60|Dark Stone, Dark Magicite, Dark Crystal|https://finalfantasy.fandom.com/wiki/Hell_Wyrm|50,000 gil, sprite in Sky Pirate's Den/Trophy|Wyrm Philosopher, must have completed hunt for Vyraal",

                "King Bomb|Salikawood|Grand Bower|34|Bomb Shell, Fire Crystal, Bomb Fragment|https://finalfantasy.fandom.com/wiki/King_Bomb_(Final_Fantasy_XII)|Opens path to Necrohol of Nabudis and Nabreus Deadlands|n/a",

                "Phoenix|The Pharos - Subterra|Penumbra|59|Windslicer Pinion, Eye of the Hawk, Split Armor|https://finalfantasy.fandom.com/wiki/Phoenix_(Final_Fantasy_XII)|n/a|Encountered standalone and in Shadowseer hunt",

                "Omega Mark XII|Great Crystal|Dhebon Jilaam Avaa|99|Knot of Rust|https://finalfantasy.fandom.com/wiki/Omega_Mark_XII|Omega Badge|Must accept Yiazmat hunt"

        };
    }

//    public void loadData() {
//        for (String entry : optionalBossLoadData()) {
//            String[] entryData = entry.split("\\|");
//            Enemy boss = new OptionalBoss(
//                    entryData[0],
//                    entryData[1],
//                    entryData[2],
//                    Integer.parseInt(entryData[3]),
//                    entryData[4],
//                    entryData[5],
//                    entryData[6],
//                    entryData[7]
//
//            );
//            optionalBosses.add(boss);
//        }
//    }


}
