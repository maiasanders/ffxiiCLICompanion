package main.util;

import main.entryTypes.Madhu;
import main.entryTypes.*;

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

    public static Madhu getMadhu(String madhu) {
        String[] madhuData = madhu.split("\\|");
        return new Madhu(
                madhuData[2],
                Integer.parseInt(madhuData[3]),
                madhuData[4],
                madhuData[5],
                madhuData[6]

        );
    }

    public static SevenSisters getSevenSisters(String trip) {
        String[] tripData = trip.split("\\|");
        return new SevenSisters(
                tripData[2],
                Integer.parseInt(tripData[3]),
                tripData[4]
        );
    }

    public static Cockatrice getCockatrice(String cockatrice) {
        String[] cockatriceData = cockatrice.split("\\|");
        return new Cockatrice(
                cockatriceData[1],
                Integer.parseInt(cockatriceData[2]),
                cockatriceData[3],
                cockatriceData[4],
                cockatriceData[5]
        );
    }

    public static BottleClue getBottleClue(String bottle) {
        String[] bottleData = bottle.split("\\|");
        return new BottleClue(
                bottleData[1],
                Integer.parseInt(bottleData[2]),
                bottleData[3],
                bottleData[4],
                bottleData[5],
                bottleData[6]
        );
    }
}