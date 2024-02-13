package main;

public class MenuInterfaces {

    private static final String[] mainMenu = new String[]{"Welcome to FFXII CLI Companion", "<<-------------------------->>", "1. View lists", "2. Search lists", "3. Update checklists", "0. Exit"};

    private static final String[] listMenu = new String[]{
            "List Options:",
            "<<-------------------->>",
            "1. Enemies",
            "2. Miscellaneous Side Quests",
            "3. Items",
            "0. Return to main.Main Menu"
    };
    private static final String[] searchMenu = new String[]{
            "Search Options",
            "<<-------------------->>",
            "1. Enemies",
            "2. Miscellaneous Side Quests",
            "3. Items",
            "4. Search by location",
            "5. Search by level range",
            "0. Return to main.Main Menu"
    };
    private static final String[] enemiesSubMenu = new String[]{
            "Enemies",
            "<<-------------------->>",
            "1. Optional Espers",
            "2. Rare Game",
            "3. Hunts",
            "4. Optional Bosses",
            "0. main.Main Menu"
    };

    private static String[] checkOffMenu = new String[]{
            "Checklist Options",
            "<<-------------------->>",
            "1. Enemies",
            "2. Miscellaneous Side Quests",
            "3. Items",
            "4. Return to main.Main Menu"
    };


    public static String[] getMainMenu() {
        return mainMenu;
    }

    public static String[] getListMenu() {
        return listMenu;
    }

    public static String[] getSearchMenu() {
        return searchMenu;
    }

    public static String[] getEnemiesSubMenu() {
        return enemiesSubMenu;
    }

    public static String[] getCheckOffMenu() {
        return checkOffMenu;
    }

    // * Print Functions * //
    public static void printMenu(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }
}




