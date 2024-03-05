package main;

public class Main {
    public void main(String[] args) {
//        MainApp app = new MainApp();
        App app = new App();
        app.load();
        app.loadSaveFiles();
        app.run();
    }

}
