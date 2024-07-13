import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestController {
    private MainView mainView;
    private  TestView testView;
    private MainController mainController;

    public TestController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        testView = this.mainView.getTestMaintenanceView();
        this.mainController = mainController;


        testView.setStockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.displayChoices();
                mainView.setMainFramePanel(mainView.getPanels("Stock"));
            }
        });

        testView.setRestockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.displayRestock();
                mainView.setMainFramePanel(mainView.getPanels("Restock"));
            }
        });

        testView.setSetPriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.displaySetPrice();
                mainView.setMainFramePanel(mainView.getPanels("Price"));
            }
        });

        testView.setCollectMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.displayTotal();
                mainView.setMainFramePanel(mainView.getPanels("Collect"));
            }
        });

        testView.setReplenishMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.displayMoneyCount();
                mainView.setMainFramePanel(mainView.getPanels("Replenish"));

            }
        });

        testView.setDisplaySummaryBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.displaySummary();
                mainView.setMainFramePanel(mainView.getPanels("Summary"));
            }
        });

        testView.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Menu"));
            }
        });
    }
}