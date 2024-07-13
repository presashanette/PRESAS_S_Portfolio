import java.awt.*;

public class MainDriver {
    public static void main (String[] args) {
        RegularVM regularVM = new RegularVM();
        SpecialVM specialVM = new SpecialVM();
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView, regularVM, specialVM);
    }
}