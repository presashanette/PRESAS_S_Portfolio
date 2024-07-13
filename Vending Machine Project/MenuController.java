import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

    boolean checker = false;
    private MainView mainView;
    private MenuView menuView;
    private TestMenuView testMenuView;

    public MenuController (MainView mainView, MainController mainController) {

        this.mainView = mainView;
        menuView = this.mainView.getMenuView();
        mainView.setMainFramePanel(mainView.getPanels("Menu"));

        this.menuView.setCreateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Create"));
            }
        });

        testMenuView = this.mainView.getTestMenuView();
        this.menuView.setTestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getHasCreated()) {
                    mainView.setMainFramePanel(mainView.getPanels("Test"));
                }
                else {
                    JOptionPane.showMessageDialog(null, "no vending machine created yet!");
                }
            }
        });

        this.menuView.setExitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
