import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static List<String> names = new ArrayList<>();
    public static List<Integer> entryNumbers = new ArrayList<>();
    public static List<Integer> rarityStars = new ArrayList<>();
    private static List<String> mainLocations = new ArrayList<>();
    private static List<String> locationZones = new ArrayList<>();
    private static List<Integer> levels = new ArrayList<>();
    private static List<String> dropItems = new ArrayList<>();
    private static List<String> stealItems = new ArrayList<>();
    private static List<String> poachItems = new ArrayList<>();
    private static List<String> wikiPages = new ArrayList<>();
    private static List<Boolean> isTrophy = new ArrayList<>();
    public static void main(String[] args) {
        MainApp app = new MainApp();
        MainApp.load();


    }

    public static class run {
        while(true) {
            printMainMenu();
            int mainMenuSelect = Integer.parseInt(input);
        }


    }

    private static void load(){
        String[] data = database.loadData();
        for (String entry : data) {
            String[] entryFields = entry.split("\\|");

            names.add(entryFields[0]);
            entryNumbers.add(Integer.parseInt(entryFields[1]));
            rarityStars.add(Integer.parseInt(entryFields[2]));
            mainLocations.add(entryFields[3]);
            locationZones.add(entryFields[4]);
            levels.add(Integer.parseInt(entryFields[5]));
            dropItems.add(entryFields[6]);
            stealItems.add(entryFields[7]);
            poachItems.add(entryFields[8]);
            wikiPages.add(entryFields[9]);
            isTrophy.add(entryFields[6].contains("Trophy"));
        }
    }
    private static String input(){
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    private static void printMainMenu(){
        System.out.println("Welcome to FFXII CLI Companion");
        System.out.println("<<-------------------------->>");
        System.out.println("1. View lists");
        System.out.println("2. Search lists");
        System.out.println("3. Update checklists");
        System.out.println("0. Exit");
    }


}
