package main.util;

import main.entryTypes.Esper;
import main.entryTypes.Hunt;
import main.entryTypes.OptionalBoss;
import main.entryTypes.RareGame;

public class DataTransformation {
    public static Hunt getHunt(String hunt) {
        String[] entryData = hunt.split("\\|");
        return new Hunt(
                entryData[0],
                Integer.parseInt(entryData[1]),
                entryData[2],
                entryData[3],
                Integer.parseInt(entryData[4]),
                entryData[5],
                entryData[6],
                entryData[7],
                Integer.parseInt(entryData[8]),
                entryData[9],
                entryData[10],
                entryData[11]
        );
    }

    public static Esper getEsper(String esper) {
        String[] entryData = esper.split("\\|");
        return new Esper(
                entryData[0],
                Integer.parseInt(entryData[1]),
                entryData[2],
                entryData[3],
                Integer.parseInt(entryData[4]),
                entryData[5],
                entryData[6],
                entryData[7]
        );
    }

    public static RareGame getRareGame(String rareGame) {
        String[] entryFields = rareGame.split("\\|");
        return new RareGame(
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

    }

    public static OptionalBoss getOptionalBoss(String optionalBoss) {
        String[] bossData = optionalBoss.split("\\|");
        return new OptionalBoss(
                bossData[0],
                Integer.parseInt(bossData[1]),
                bossData[2],
                bossData[3],
                Integer.parseInt(bossData[4]),
                bossData[5],
                bossData[6],
                bossData[7],
                bossData[8]
        );
    }
}