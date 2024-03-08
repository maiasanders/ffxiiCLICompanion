package main.util;

import main.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputOutput {

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

    public static void writeFile(List<String> toWrite, String fileName, boolean append) throws FileNotFoundException {
        if (append) {
            try (PrintWriter output = new PrintWriter(new FileOutputStream(fileName, true))) {
                output.println(toWrite);
            }
        } else {
            try (PrintWriter output = new PrintWriter(fileName)) {
            for (String line : toWrite) {
                output.println(line);
            }
            output.flush();
        }
        }
    }

}
