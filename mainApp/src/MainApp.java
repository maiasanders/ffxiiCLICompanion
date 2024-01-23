import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static Scanner keyboard = new Scanner(System.in);
    private static String input(){
        return keyboard.nextLine();
    };

    public static List<String> rGNames = new ArrayList<>();
    public static List<Integer> rGEntryNumbers = new ArrayList<>();
    public static List<Integer> rGRarityStars = new ArrayList<>();
    private static List<String> rGMainLocations = new ArrayList<>();
    private static List<String> rgLocationZones = new ArrayList<>();
    private static List<Integer> rGLevels = new ArrayList<>();
    private static List<String> rGDropItems = new ArrayList<>();
    private static List<String> rGStealItems = new ArrayList<>();
    private static List<String> rgPoachItems = new ArrayList<>();
    private static List<String> rgWikiPages = new ArrayList<>();
    private static List<Boolean> rgIsTrophy = new ArrayList<>();
    public static void main(String[] args) {
        MainApp app = new MainApp();
        MainApp.load();
        MainApp.run();

    }

    public static void run() {
        while (true) {

            printMainMenu();
            printInputPrompt();

            // take in menu selection

            int mainMenuSelect = Integer.parseInt(input());
            // redirect to lists
            if (mainMenuSelect == 1){
                printListMenu();
                printInputPrompt();
                int listsMenuSelect = Integer.parseInt(input());

                // enemies
                if (listsMenuSelect == 1){
                    printEnemiesSubMenu();
                    printInputPrompt();
                    int enemySubMenuSelect = Integer.parseInt(input());
                    //Espers
                    if (enemySubMenuSelect == 1){
                        //TODO add espers
                        underConstructionMsg();
                    } else if (enemySubMenuSelect == 2){
                    //Rare game
                        printRgList();
                    } else if (enemySubMenuSelect == 3) {
                        // TODO hunts
                        underConstructionMsg();
                    } else if (enemySubMenuSelect == 4){
                        // TODO optional bosses
                        underConstructionMsg();
                    }

                // Misc. side quest
                } else if (listsMenuSelect == 2){
                    // TODO add side quest logic & data
                    underConstructionMsg();
                // items
                } else if (listsMenuSelect == 3){

                    //TODO add items data & logic

                    //unique treasures
                    //ultimate weapons
                    //bazaar
                        // monographs
                        // weapons
                        // other items

                } else if (listsMenuSelect == 0){
                    break;
                }

            // redirect to search
            } else if (mainMenuSelect == 2){
                printSearchMenu();
                printInputPrompt();
                int searchSelect = Integer.parseInt(input());
                // enemies
                if (searchSelect == 1){
                    printEnemiesSubMenu();
                    printInputPrompt();
                    int enemySelect = Integer.parseInt(input());
                    if (enemySelect == 1){
                        //TODO Espers
                        underConstructionMsg();
                    } else if (enemySelect == 2){
                        //Rare game
                        String rgSearched = searchQuery("Rage Game");
                        List<Integer> indexes = filterByString(rGNames, rgSearched);
                        printRgSearch(indexes);
                    }
                    // hunts
                    // optional bosses
                } else if (searchSelect == 2) {
                    // Misc. side quest
                    // TODO sidequests search
                    underConstructionMsg();
                } else if (searchSelect == 3) {
                    //TODO
                    underConstructionMsg();
                    // items
                        //unique treasures
                        //ultimate weapons
                        //bazaar
                            // monographs
                            // weapons
                            // other items

                } else if (searchSelect == 4) {
                    // TODO search by location
                    underConstructionMsg();
                } else if (searchSelect == 5) {
                    // TODO search by level range
                    underConstructionMsg();
                } else if (searchSelect == 0) {
                    break;
                }

            } else if (mainMenuSelect == 3) {
            // redirect to check off
                printCheckOffMenu();
                printInputPrompt();
                int checkOffSelect = Integer.parseInt(input());
                // enemies
                // Misc. side quest
                // items

            } else if (mainMenuSelect == 0) {

                break;
            }
        }


    }

    private static void load(){
        String[] raGaData = database.rareGameLoadData();
        for (String entry : raGaData) {
            String[] entryFields = entry.split("\\|");

            rGNames.add(entryFields[0]);
            rGEntryNumbers.add(Integer.parseInt(entryFields[1]));
            rGRarityStars.add(Integer.parseInt(entryFields[2]));
            rGMainLocations.add(entryFields[3]);
            rgLocationZones.add(entryFields[4]);
            rGLevels.add(Integer.parseInt(entryFields[5]));
            rGDropItems.add(entryFields[6]);
            rGStealItems.add(entryFields[7]);
            rgPoachItems.add(entryFields[8]);
            rgWikiPages.add(entryFields[9]);
            rgIsTrophy.add(entryFields[6].contains("Trophy"));
        }
    }


    private static void printMainMenu(){
        System.out.println("Welcome to FFXII CLI Companion");
        System.out.println("<<-------------------------->>");
        System.out.println("1. View lists");
        System.out.println("2. Search lists");
        System.out.println("3. Update checklists");
        System.out.println("0. Exit");
    }

    private static void printListMenu(){
        System.out.println("List Options:");
        System.out.println("<<-------------------->>");
        System.out.println("1. Enemies");
        System.out.println("2. Miscellaneous Side Quests");
        System.out.println("3. Items");
        System.out.println("0. Return to Main Menu");
    }

    private static void printSearchMenu(){
        System.out.println("Search Options");
        System.out.println("<<-------------------->>");
        System.out.println("1. Enemies");
        System.out.println("2. Miscellaneous Side Quests");
        System.out.println("3. Items");
        System.out.println("4. Search by location");
        System.out.println("5. Search by level range");
        System.out.println("0. Return to Main Menu");
    }

    private static void printCheckOffMenu(){
        System.out.println("Checklist Options");
        System.out.println("<<-------------------->>");
        System.out.println("1. Enemies");
        System.out.println("2. Miscellaneous Side Quests");
        System.out.println("3. Items");
        System.out.println("4. Return to Main Menu");
    }

    private static void printEnemiesSubMenu(){
        System.out.println("Enemies");
        System.out.println("<<-------------------->>");
        System.out.println("1. Optional Espers");//Espers
        System.out.println("2. Rare Game");//Rare game
        System.out.println("3. Hunts");// hunts
        System.out.println("4. Optional Bosses");// optional bosses
        System.out.println("0. Main Menu");
    }

    private static void printInputPrompt(){
        System.out.print("Please make a selection: ");
    }

    private static void underConstructionMsg(){
        System.out.println("This section is currently under construction.");
        System.out.println("Check back soon!");
        System.out.println("Press 0 to return to Main Menu.");
    }


    // List/Search screen output functions
    private static void printRgSearch(List<Integer> indexes){
        for (int i = 0; i < indexes.size(); i++){
            printRgEntry(indexes.get(i));
        }
    }

    private static void printRgList(){
        for (int i = 0; i < rGNames.size(); i++){
            printRgEntry(i);
        }
    }
    private static void printRgEntry(int ind){
        if (ind > 0) System.out.println("--------------------------------------");
        System.out.println(STR."Name: \{rGNames.get(ind)}");
        System.out.println(STR."Entry no. \{rGEntryNumbers.get(ind)}\t\{printStars(rGRarityStars.get(ind))}");
        System.out.println(STR."Location: \{rGMainLocations.get(ind)} - \{rgLocationZones.get(ind)}");
        System.out.println(STR."Drops \{rGDropItems.get(ind)}");
        System.out.println(STR."Can steal \{rGStealItems.get(ind)}");
        String poach = rgPoachItems.get(ind);
        if (!poach.isEmpty()) System.out.println(STR."Can poach \{poach}");
        boolean isTrophy = rgIsTrophy.get(ind);
        if (isTrophy) System.out.println("**Part of Hunt Club quest**");
    }

    private static String printStars(int num){
        String output = "";
        for (int i = 0; i < num; i++){
            output += "☆";
        }
        return output;
    }

    // filter functions

    private static String searchQuery(String category){
        System.out.print(STR."What \{category} are you looking for: ");
        return input();
    }
    private static List<Integer> filterByString(List<String> list, String query) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){

            if (list.get(i).toLowerCase().contains(query.toLowerCase())){
                indexes.add(i);
            }
        }
        return indexes;
    }




}
