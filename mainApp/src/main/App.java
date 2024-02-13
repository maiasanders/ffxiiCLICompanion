package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.load();
        app.run();
    }
    private static Scanner keyboard = new Scanner(System.in);
    private static String input(){
        return keyboard.nextLine();
    }

    public void run() {
        while (true) {

            MenuInterfaces.printMenu(MenuInterfaces.getMainMenu());
            Prompts.printInputPrompt();

            // take in menu selection

            int mainMenuSelect = Integer.parseInt(input());
            // redirect to lists
            if (mainMenuSelect == 1){
                MenuInterfaces.printMenu(MenuInterfaces.getListMenu());
                Prompts.printInputPrompt();
                int listsMenuSelect = Integer.parseInt(input());

                // enemies
                if (listsMenuSelect == 1){
                    MenuInterfaces.printMenu(MenuInterfaces.getEnemiesSubMenu());
                    Prompts.printInputPrompt();
                    int enemySubMenuSelect = Integer.parseInt(input());
                    //Espers
                    if (enemySubMenuSelect == 1){
                        Results.printLists(EsperData.espers);
//                        Results.printLists(EsperData.espers);
                        Prompts.printReturnMainMenu();
                        if (input().isEmpty()) continue;
                    } else if (enemySubMenuSelect == 2){
                    //Rare game
//                        RareGameData.printRgList();
                        Results.printLists(RareGameData.rareGameList);
                        Prompts.printReturnMainMenu();
                        if (input().isEmpty()) continue;
                    } else if (enemySubMenuSelect == 3) {
                        Results.printHuntList();
                        Prompts.printReturnMainMenu();
                        if (input().isEmpty()) continue;
                    } else if (enemySubMenuSelect == 4){
                        // TODO optional bosses
                        Results.printLists(OptionalBossData.optionalBosses);
                        Prompts.printReturnMainMenu();
                        if (input().isEmpty()) continue;
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
                int searchSelect = Integer.parseInt(input());
                // enemies
                if (searchSelect == 1){
                    MenuInterfaces.printMenu(MenuInterfaces.getEnemiesSubMenu());
                    Prompts.printInputPrompt();
                    int enemySelect = Integer.parseInt(input());
                    if (enemySelect == 1){
                        // Espers
                        String esperSearched = searchQuery("Optional main.Esper");
                        List<Integer> indexes = EsperData.filterEsperByName(esperSearched);
                        Results.printEsperSearch(indexes);
                        Prompts.printReturnMainMenu();
                        if (input().isEmpty()) continue;
                    } else if (enemySelect == 2){
                        // Rare game
                        String rgSearched = searchQuery("Rare Game");
                        // Refactor w/ inheritance
                        List<Integer> indexes = RareGameData.filterRgByName(rgSearched);
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



    // Load functions
    protected void load(){
        RareGameData.load();
        EsperData.loadEspers();
        HuntData.loadHunts();
    }

    private static String searchQuery(String category){
        System.out.print(STR."What \{category} are you looking for: ");
        return input();
    }

    //TODO refactor filterByString function to work with classes
    private static List<Integer> filterByString(List<String> list, String query, String searchField) {
        List<Integer> indexes = new ArrayList<>();
//        Collections.sort(rareGameList, new main.SortByName());
        for (int i = 0; i < list.size(); i++){

            if (list.get(i).toLowerCase().contains(query.toLowerCase())){
                indexes.add(i);
            }
        }
        return indexes;
    }


}


