package main.entryTypes;

import main.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputOutput {

//    private File saveDir;
//    private File currSave;
//    private File tempSave;
//    private File rareGameData;
//    private File esperData;
//    private File huntData;
//    private File optionalBossData;
//
//    public InputOutput() {
//        this.saveDir = new File("saves");
//    }
//
//    public void loadSaveFiles() {
//        if (saveDir.exists()) {
//            System.out.println(Arrays.toString(saveDir.listFiles()));
//            System.out.println("Please input the number of the save you wish to load: ");
//            String fileNum = App.input();
//        }
//    }

    public static List<String> readFile(String fileName) throws FileNotFoundException {
        List<String> results = new ArrayList<>();
        File file = new File(fileName);
        try (Scanner fileContents = new Scanner(file)) {
            while (fileContents.hasNextLine()) {
                String line = fileContents.nextLine();
                results.add(line);
            }
        }
        return results;
    }

    public static void writeFile(List<String> toWrite, String fileName) throws FileNotFoundException {
        try (PrintWriter output = new PrintWriter(fileName)) {
            for (String line : toWrite) {
                output.println(line);
            }
            output.flush();
        }
    }

}
