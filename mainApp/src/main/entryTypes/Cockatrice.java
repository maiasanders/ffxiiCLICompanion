package main.entryTypes;

public class Cockatrice extends SideQuest{

    String cockatriceName;
    String tasks;
    String reward;

    public Cockatrice(String locationMain, int entryNum, String cockatriceName, String tasks, String reward) {
        super("Great Cockatrice Escape", locationMain, entryNum);
        this.cockatriceName = cockatriceName;
        this.tasks = tasks;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return STR."-- Great Cockatrice Escape --\n\tName: \{cockatriceName}\n\tLocation: \{getLocationMain()}\n\tTask(s): \{tasks}\n\tReward: \{reward}";
    }
}
