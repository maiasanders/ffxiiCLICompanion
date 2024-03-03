package main;

import main.entryTypes.*;
import main.util.DataTransformation;
import main.util.InvalidInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    final int HUNT_START_ENTRY_NUM = 212;
    final int HUNT_END_ENTRY_NUM = 261;
    final int ESPER_START_ENTRY_NUM = 262;
    final int ESPER_END_ENTRY_NUM = 274;
    final int BOSS_START_ENTRY_NUM = 275;
    final int BOSS_END_ENTRY_NUM = 292;
    final int RARE_GAME_START_ENTRY_NUM = 293;
    final int RARE_GAME_END_ENTRY_NUM = 372;
    final int PHOENIX_ENTRY_NUM = 259;
    List<Checkable> entries;
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
                        System.out.println(Prompts.getSearchPrompt());
                        String esperSearched = input();
                        searchByTitle(esperSearched, ESPER_START_ENTRY_NUM, ESPER_END_ENTRY_NUM, false);
                        Prompts.printReturnMainMenu();
                        input();
                    } else if (enemySelect == 2){
                        // Rare game
                        System.out.println(Prompts.getSearchPrompt());
                        String rgSearched = input();
                        searchByTitle(rgSearched, RARE_GAME_START_ENTRY_NUM, RARE_GAME_END_ENTRY_NUM, false);
                        Prompts.printReturnMainMenu();
                        input();
                    } else if (enemySelect == 3) {
                    // hunts
                        System.out.println(Prompts.getSearchPrompt());
                        String huntSearched = input();
                        searchByTitle(huntSearched, HUNT_START_ENTRY_NUM, HUNT_END_ENTRY_NUM, false);
                        Prompts.printReturnMainMenu();
                        input();
                    } else if (enemySelect == 4) {
                    // optional bosses
                        System.out.println(Prompts.getSearchPrompt());
                        String bossSearched = input();
                        searchByTitle(bossSearched, BOSS_START_ENTRY_NUM, BOSS_END_ENTRY_NUM, true);
                    }
                } else if (searchSelect == 2) {
                    // Misc. side quest
                    // TODO sidequests search
                    Prompts.printUnderConstructionMsg();
                } else if (searchSelect == 3) {
                    //TODO add items search
                    Prompts.printUnderConstructionMsg();
                    // items
                        //unique treasures
                        //ultimate weapons
                        //bazaar
                            // monographs
                            // weapons
                            // other items

                } else if (searchSelect == 4) {

                    System.out.println(Prompts.getSearchPrompt());
                    String locationSearched = input();
                    searchByLocation(locationSearched);
                } else if (searchSelect == 5) {
                    System.out.println("Please enter the minimum level (1-99)");
                    int minLevel;
                    while (true) {
                        try {
                            minLevel = Integer.parseInt(input());
                            if (minLevel < 1 || minLevel > 99) {
                                throw new InvalidInputException();
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("**Please enter a valid number");
                        }
                    }
                    System.out.println("Please enter the maximum level (1-99)");
                    int maxLevel;
                    while (true) {
                        try {
                            maxLevel = Integer.parseInt(input());
                            if (maxLevel < 1 || maxLevel > 99) {
                                throw new InvalidInputException();
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("**Please enter a valid number");
                        }
                    }
                    searchByLevels(minLevel, maxLevel);
                    Prompts.printReturnMainMenu();
                    input();
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
                entries.add(DataTransformation.getHunt(hunt));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble loading Hunt data");;
        }
        try {
            List<String> esperData = InputOutput.readFile("Resources/data/espers.dat");
            for (String esper : esperData) {
                entries.add(DataTransformation.getEsper(esper));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble loading Esper data");
        }
        try {
            List<String> rareGameData = InputOutput.readFile("Resources/data/rareGame.dat");
            for (String rareGame : rareGameData) {
                entries.add(DataTransformation.getRareGame(rareGame));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble reading Rare Game data");
        }
        try {
            List<String> optionalBossData = InputOutput.readFile("Resources/data/optionalBosses.dat");
            for (String boss : optionalBossData) {
                entries.add(DataTransformation.getOptionalBoss(boss));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Trouble loading Optional Boss data");
        }
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

    private void searchByTitle(String searchQuery, int startInd, int endInd, boolean includePhoenix) {
        boolean hasResults = false;
        for (Checkable entry : entries) {
            int entryNum = entry.getEntryNum();
            if (includePhoenix) {
                if ( ((entryNum >= startInd && entryNum <= endInd) || entryNum == PHOENIX_ENTRY_NUM ) && entry.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                    hasResults = true;
                    System.out.println(entry);
                    Results.printBreakLine();
                }

            } else {
                if (entryNum >= startInd && entryNum <= endInd && entryNum != PHOENIX_ENTRY_NUM && entry.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                    hasResults = true;
                    System.out.println(entry);
                    Results.printBreakLine();
                }
            }
        }

        if (!hasResults) {
            System.out.println("Sorry, nothing matches your search");
        }
    }

    private void searchByTitle(String searchQuery) {
        boolean hasResults = false;
        for (Checkable entry : entries) {
            if (entry.getTitle().contains(searchQuery)) {
                hasResults = true;
                System.out.println(entry);
                Results.printBreakLine();
            }
        }
        if (!hasResults) {
            System.out.println("Sorry, nothing matches your search");
        }
    }

    private void searchByLocation(String search) {
        boolean hasResults = false;
        for (Checkable entry : entries) {
            if (entry.getLocation().toLowerCase().contains(search.toLowerCase())) {
                hasResults = true;
                System.out.println(entry);
                Results.printBreakLine();
            }
        }
        if (!hasResults) {
            System.out.println("Sorry, nothing matches your search");
        }
    }

    private void searchByLevels(int minLevel, int maxLevel) {
        boolean hasResults = false;
        for (Checkable entry : entries) {
            if (entry instanceof Enemy && ((Enemy) entry).getLevel() >= minLevel && ((Enemy) entry).getLevel() <= maxLevel) {
                hasResults = true;
                System.out.println(entry);
                Results.printBreakLine();
            }
        }
        if (!hasResults) {
            System.out.println("Sorry, nothing matches your search");
        }
    }


}


