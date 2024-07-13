import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplaySummaryController {
    private MainView mainView;
    private MainController mainController;
    private DisplaySummaryView summaryView;

    public DisplaySummaryController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.summaryView = mainView.getSummaryView();

        this.summaryView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Menu"));
            }
        });
    }
}