package main;

public class OptionalBoss extends Enemy{

    private String quest;
    private String reward;


    public OptionalBoss(String name, String locationMain, String locationZone, int level, String stealItems, String wiki, String reward, String quest) {
        super(name, locationMain, locationZone, level, stealItems, wiki);
        this.reward = reward;
        this.quest = quest;
    }

    @Override
    public String toString() {
        return STR."Name: \{name}" +
                STR."\nLocation: \{locationMain} - \{locationZone}" +
                STR."\nLevel: \{level}" +
                STR."\nCan steal: \{stealItemStr}" +
                STR."\nWiki: \{wiki}" +
                STR."\nAssociated Quest: \{quest}" +
                STR."\nReward: \{reward}";
    }
}
