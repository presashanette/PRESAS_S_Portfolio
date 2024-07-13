import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMenuController {

    private MainView mainView;
    private MainController mainController;
    private TestMenuView testMenuView;
    private RegularVM regularVM;
    private SpecialVM specialVM;

    public TestMenuController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVM = mainController.getRegularVM();
        this.specialVM = mainController.getSpecialVM();

        testMenuView = mainView.getTestMenuView();

        testMenuView.setFeaturesBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mainController.getRegularVM().isEmpty()) {
                    mainView.setMainFramePanel(mainView.getPanels("Vending"));
                    mainController.displayItems();
                }
                else if (!mainController.getSpecialVM().isEmpty()) {
                    mainView.setMainFramePanel(mainView.getPanels("Special Machine"));
                    mainController.displayItems();
                }
                else JOptionPane.showMessageDialog(null, "The vending machine is still empty!");
            }
        });

        testMenuView.setMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Maintenance"));
            }
        });

        testMenuView.setGoBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Menu"));
            }
        });
    }
}