package main;

public class Prompts {

    private static final String inputPrompt = "Please make a selection: ";


    private static final String returnMainMenu = "Please press ENTER to return to main menu.";


    private static String underConstructionMsg = "This section is currently under construction.\nCheck back soon!\nPress 0 to return to main.Main Menu.";

    public static void printInputPrompt() {
        System.out.println(inputPrompt);
    }

    public static void printReturnMainMenu() {
        System.out.println(returnMainMenu);
    }

    public static void printUnderConstructionMsg() {
        System.out.println(underConstructionMsg);
    }
}
