package main;

import main.entryTypes.*;
import main.util.InvalidInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private final int HUNT_START_ENTRY_NUM = 212;
    private final int HUNT_END_ENTRY_NUM = 261;
    private final int ESPER_START_ENTRY_NUM = 262;
    private final int ESPER_END_ENTRY_NUM = 274;
    private final int BOSS_START_ENTRY_NUM = 275;
    private final int BOSS_END_ENTRY_NUM = 292;
    private final int RARE_GAME_START_ENTRY_NUM = 293;
    private final int RARE_GAME_END_ENTRY_NUM = 372;
    private final int PHOENIX_ENTRY_NUM = 259;
    private List<Checkable> entries;
    public void main(String[] args) {
        App app = new App();
        app.load();
        app.run();
    }

    SearchFunctions searchFunctions = new SearchFunctions();
    public static Scanner keyboard = new Scanner(System.in);
    public static String input(){
        return keyboard.nextLine();
    }
    File saveDir = new File("Resources/saves");


    public void loadSaveFiles() {
        if (saveDir.exists() && saveDir.listFiles().length > 0) {

            System.out.println(Arrays.toString(saveDir.listFiles()));

            System.out.println("Would you like to start a new save? (Y/N)");
            String newSaveSelect = input();

            if (newSaveSelect.equals("N")) {
                System.out.println("Please input the number of the save you wish to load: ");
                int fileNum = Integer.parseInt(input());
            }
        } else if (saveDir.exists()) {
            createNewSave();
        } else {
            saveDir.mkdir();
        }
    }
    void createNewSave() {
        if (saveDir.listFiles().length == 0) {

        }
    }

    public void run() {
        while (true) {

            MenuInterfaces.printMenu(MenuInterfaces.getMainMenu());
            Prompts.printInputPrompt();

            // take in menu selection

            int mainMenuSelect = numSelection(3);

            // redirect to lists
            if (mainMenuSelect == 1){
                MenuInterfaces.printMenu(MenuInterfaces.getListMenu());
                Prompts.printInputPrompt();
                int listsMenuSelect = numSelection(3);

                // enemies
                if (listsMenuSelect == 1){
                    MenuInterfaces.printMenu(MenuInterfaces.getEnemiesSubMenu());
                    Prompts.printInputPrompt();
                    int enemySubMenuSelect = numSelection(4);

                    //Espers
                    if (enemySubMenuSelect == 1){

                        printLists(ESPER_START_ENTRY_NUM, ESPER_END_ENTRY_NUM, false);
                        Prompts.printReturnMainMenu();
                        input();

                    } else if (enemySubMenuSelect == 2){
                        // Rare game filter
                        printLists(RARE_GAME_START_ENTRY_NUM, RARE_GAME_END_ENTRY_NUM, false);
                        Prompts.printReturnMainMenu();
                        input();

                    } else if (enemySubMenuSelect == 3) {
                        // Hunts, doesn't include phoenix
                        printLists(HUNT_START_ENTRY_NUM, HUNT_END_ENTRY_NUM, false);
                        Prompts.printReturnMainMenu();
                        input();

                    } else if (enemySubMenuSelect == 4){
                        // Optional Bosses, includes Phoenix
                        printLists(BOSS_START_ENTRY_NUM, BOSS_END_ENTRY_NUM, true);
                        Prompts.printReturnMainMenu();
                        input();
                    }

                // Misc. side quest
                } else if (listsMenuSelect == 2){
                    // TODO add side quest logic & data
                    Prompts.printUnderConstructionMsg();
                    Prompts.printReturnMainMenu();
                    if (input().isEmpty()) continue;
                // items
                } else if (listsMenuSelect == 3){
                    Prompts.printUnderConstructionMsg();
                    //TODO add items data & logic

                    //unique treasures
                    //ultimate weapons
                    //bazaar
                        // monographs
                        // weapons
                        // other items

                } else if (listsMenuSelect == 0){
                    continue;
                }

            // redirect to search
            } else if (mainMenuSelect == 2){
                MenuInterfaces.printMenu(MenuInterfaces.getSearchMenu());
                Prompts.printInputPrompt();
                int searchSelect = numSelection(5);
                // enemies
                if (searchSelect == 1){
                    MenuInterfaces.printMenu(MenuInterfaces.getEnemiesSubMenu());
                    Prompts.printInputPrompt();
                    int enemySelect = numSelection(4);
                    if (enemySelect == 1){
                        // Espers
                        String esperSearched = input();
//                        List<Integer> indexes = EsperData.filterEsperByName(esperSearched);
                        for (Checkable entry : entries) {
                            if (entry.getEntryNum() >= ESPER_START_ENTRY_NUM && entry.getEntryNum() <= ESPER_END_ENTRY_NUM && entry.getTitle().contains(esperSearched)) {
                                System.out.println(entry);
                                Results.printBreakLine();
                            }
                        };
                        Prompts.printReturnMainMenu();
                        input();
                    } else if (enemySelect == 2){
                        // Rare game
                        String rgSearched = searchFunctions.searchQuery("Rare Game");
                        // Refactor w/ inheritance
//                        List<Integer> indexes = RareGameData.filterRgByName(rgSearched);
                        List<Integer> indexes1 = SearchFunctions.filterByName(RareGameData.rareGameList, rgSearched);
//                        Results.printRgSearch(indexes);
                        Prompts.printReturnMainMenu();
                        if (input().isEmpty()) continue;
                    }
                    // hunts
                    // optional bosses
                } else if (searchSelect == 2) {
                    // Misc. side quest
                    // TODO sidequests search
                    Prompts.printUnderConstructionMsg();
                } else if (searchSelect == 3) {
                    //TODO
                    Prompts.printUnderConstructionMsg();
                    // items
                        //unique treasures
                        //ultimate weapons
                        //bazaar
                            // monographs
                            // weapons
                            // other items

                } else if (searchSelect == 4) {
                    // TODO search by location
                    System.out.println(Prompts.getSearchPrompt());

                    Prompts.printUnderConstructionMsg();
                } else if (searchSelect == 5) {
                    // TODO search by level range
                    Prompts.printUnderConstructionMsg();
                } else if (searchSelect == 0) {
                    break;
                }

            } else if (mainMenuSelect == 3) {
            // redirect to check off
               MenuInterfaces.printMenu(MenuInterfaces.getCheckOffMenu());
                Prompts.printInputPrompt();
                int checkOffSelect = Integer.parseInt(input());
                // enemies
                // Misc. side quest
                // items

            } else if (mainMenuSelect == 0) {

                break;
            }
        }
    }



    // Loads data from appropriate files and adds to entries list
    protected void load(){

        entries = new ArrayList<>();
        try {
            List<String> huntsData = InputOutput.readFile("Resources/data/hunts.dat");
            for (String hunt : huntsData) {
                entries.add(getHunt(hunt));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble loading Hunt data");;
        }
        try {
            List<String> esperData = InputOutput.readFile("Resources/data/espers.dat");
            for (String esper : esperData) {
                entries.add(getEsper(esper));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble loading Esper data");
        }
        try {
            List<String> rareGameData = InputOutput.readFile("Resources/data/rareGame.dat");
            for (String rareGame : rareGameData) {
                entries.add(getRareGame(rareGame));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble reading Rare Game data");
        }
        try {
            List<String> optionalBossData = InputOutput.readFile("Resources/data/optionalBosses.dat");
            for (String boss : optionalBossData) {
                entries.add(getOptionalBoss(boss));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble loading Optional Boss data");
        }
    }

    private static Hunt getHunt(String hunt) {
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
    private static Esper getEsper(String esper) {
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
    private static RareGame getRareGame(String rareGame) {
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
    private static OptionalBoss getOptionalBoss(String optionalBoss) {
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

    private int numSelection(int max) {
        int selection;
        while (true){
            try {
                selection = Integer.parseInt(input());
                if (selection < 0 || selection > max) throw new InvalidInputException();
                break;
            } catch (Exception e) {
                System.err.println("Please select a valid option: ");
            }
        }
        return selection;
    }

    private void printLists(int startInd, int endInd, boolean includePhoenix) {
        for (Checkable entry : entries) {
            int entryNum = entry.getEntryNum();
            if (includePhoenix) {
                if ( (entryNum >= startInd && entryNum <= endInd) || entryNum == PHOENIX_ENTRY_NUM ) {
                    System.out.println(entry);
                    Results.printBreakLine();
                }

            } else {
                if (entryNum >= startInd && entryNum <= endInd && entryNum != PHOENIX_ENTRY_NUM) {
                    System.out.println(entry);
                    Results.printBreakLine();
                }
            }
        }
    }


}


