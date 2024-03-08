package main.entryTypes;

public class BottleClue extends SideQuest{

    private String color;
    private String clue;
    private String solution;
    private String message;

    public BottleClue(String locationMain, int entryNum, String color, String clue, String solution, String message) {
        super("Colored bottle - Hunt for Matamune", locationMain, entryNum);
        this.color = color;
        this.clue = clue;
        this.solution = solution;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("--Colored Bottles - Hunt for Matamune--\n\tDalmasca Estersand Fishing\n\tColor: %s\n\tClue: %s\n\tSolution: %s\n\tMessage location: %s\n\tMessage: %s", color, clue, solution, getLocationMain(), message);
    }
}
