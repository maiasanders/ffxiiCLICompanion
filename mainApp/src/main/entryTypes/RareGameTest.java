package main.entryTypes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RareGameTest {

    @Test
    public void testToString() {

        RareGame aspidochelon = new RareGame("Aspidochelon", 293, 5, "Cerobi Steppe", "Feddick River", 42, "Adamantine Trophy", "Scarletite", "", "https://finalfantasy.fandom.com/wiki/Aspidochelon_(Final_Fantasy_XII)");
        String expected = "Name: Aspidochelon\nLevel: 42\nEntry no. 293 \t ☆☆☆☆☆\nLocation: Cerobi Steppe - Feddick River\nDrops: Adamantine Trophy\nCan steal Scarletite\nWiki: https://finalfantasy.fandom.com/wiki/Aspidochelon_(Final_Fantasy_XII)\n**Part of Hunt Club quest**";

        String result = aspidochelon.toString();


        Assert.assertEquals(expected, result);

    }
}