package tests;

import main.Hunt;
import main.HuntData;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HuntTest {

    @Test
    public void constructor_functions_appropriately() {
        // Arrange
        String[] testArray = new String[]{"steal", "Items"};

        // Act
        Hunt hunt = new Hunt("Name", "Location Main", "Zone", 1, "steal, Items", "site.com", "title", 1, "guy", "guy's town", "guy's house");

        // Assert
        Assert.assertEquals("Name", hunt.getName());
        Assert.assertEquals("Location Main", hunt.getLocationMain());
        Assert.assertEquals("Zone", hunt.getLocationZone());
        Assert.assertEquals(1, hunt.getLevel());
        Assert.assertArrayEquals(testArray, hunt.getStealItems());
        Assert.assertEquals("site.com", hunt.getWiki());
        Assert.assertEquals("title", hunt.getHuntName());
        Assert.assertEquals(1, hunt.getRank());
        Assert.assertEquals("guy", hunt.getPetitioner());
        Assert.assertEquals("guy's town", hunt.getPetitionerLocationMain());
        Assert.assertEquals("guy's house", hunt.getPetitionerLocationZone());
    }

    Hunt hunt;
    @Before
    public void setTestHunt() {
        hunt = new Hunt("Name", "Location Main", "Zone", 1, "steal, Items", "site.com", "title", 1, "guy", "guy's town", "guy's house");
    }

    @Test
    public void toString_output_is_correct() {
        String expected = "\"title\"\nName: Name\nLevel: 1\tRank: I\nPetitioner: guy\nPetitioner Location: guy's town - guy's house\nMark Location: Location Main - Zone\nCan Steal: steal, Items\nWiki: site.com";

        Assert.assertEquals(expected, hunt.toString());
    }

    @Test
    public void getFormattedRank_returns_appropriate_results() {
        // Arrange
        Hunt[] hunts = new Hunt[]{
                new Hunt ("Name", "Location Main", "Zone", 1, "steal, Items", "site.com", "title", 4, "guy", "guy's town", "guy's house"),

            new Hunt("Name", "Location Main", "Zone", 1, "steal, Items", "site.com", "title", 5, "guy", "guy's town", "guy's house"),

                new Hunt("Name", "Location Main", "Zone", 6, "steal, Items", "site.com", "title", 6, "guy", "guy's town", "guy's house"),

                new Hunt("Name", "Location Main", "Zone", 1, "steal, Items", "site.com", "title", 8, "guy", "guy's town", "guy's house")
        };

        String[] expectedReturn = new String[]{"IV", "V", "VI", "VIII"};

        //Act

        for (int i = 0; i < hunts.length; i++) {
            String actual = hunts[i].getFormattedRank();

            Assert.assertEquals(expectedReturn[i], actual);
        }


    }



}
