package tests;

import main.entryTypes.BottleClue;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BottleClueTest {

    @Test
    public void testToString() {
        BottleClue bottle = new BottleClue(
                "Nabreus Deadlands",
                4000,
                "Blue",
                "Truth lies just beyond falsehood\nCDZCKZMCRNANZS",
                "DEADLANDS BOAT",
                "River...unde...o"
                );

        String results = bottle.toString();
        String expected = "--Colored Bottles - Hunt for Matamune--" + "\n\tDalmasca Estersand Fishing" + "\n\tColor: Blue" + "\n\tClue: Truth lies just beyond falsehood\nCDZCKZMCRNANZS" + "\n\tSolution: DEADLANDS BOAT" + "\n\tMessage location: Nabreus Deadlands" + "\n\tMessage: River...unde...o";

        Assert.assertEquals(expected, results);

    }
}