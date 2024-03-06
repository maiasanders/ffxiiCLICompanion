package main;

import java.io.File;

public class Main {
    public void main(String[] args) {
//        MainApp app = new MainApp();
        App app = new App();
        app.load();
        File saveFile = app.loadSaveFiles();
        app.run(saveFile);
    }

}
