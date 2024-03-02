package main.entryTypes;

public class Hunt extends Enemy implements Checkable{

    private String huntName;
    private int rank;
    private String petitioner;
    private String petitionerLocationMain;
    private String petitionerLocationZone;

    public Hunt(String name, int entryNum, String locationMain, String locationZone, int level, String stealItems, String wiki, String huntName, int rank, String petitioner, String petitionerLocationMain, String petitionerLocationZone) {
        super(name, entryNum, locationMain, locationZone, level, stealItems, wiki);
        this.huntName = huntName;
        this.rank = rank;
        this.petitioner = petitioner;
        this.petitionerLocationMain = petitionerLocationMain;
        this.petitionerLocationZone = petitionerLocationZone;
    }


    public String getFormattedRank() {
        String output = "";
        if (rank < 4) {
            for (int i = 0; i < rank; i++) {
                output += "I";
            }
        } else if (rank == 4) {
            output = "IV";
        } else {
            output += "V";
            if (rank > 5) {
                for (int i = 5; i < rank; i++) {
                    output += "I";
                }
            }
        }
        return output;
    }

    @Override
    public String toString(){
        return STR."\"\{huntName}\"" +
                STR."\nName: \{name}" +
                STR."\nLevel: \{getLevel()}\tRank: \{getFormattedRank()}" +
                STR."\nPetitioner: \{petitioner}" +
                STR."\nPetitioner Location: \{petitionerLocationMain} - \{petitionerLocationZone}" +
                STR."\nMark Location: \{getLocationMain()} - \{getLocationZone()}" +
                STR."\nCan Steal: \{getStealItemStr()}" +
                STR."\nWiki: \{getWiki()}";
    }

    public String getHuntName() {
        return huntName;
    }

    public int getRank() {
        return rank;
    }

    public String getPetitioner() {
        return petitioner;
    }

    public String getPetitionerLocationMain() {
        return petitionerLocationMain;
    }

    public String getPetitionerLocationZone() {
        return petitionerLocationZone;
    }

}
