import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateController {

    private MainView mainView;
    private CreateView createView;

    public CreateController (MainView mainView) {
        this.mainView = mainView;
        createView = this.mainView.getCreateView();

        createView.setRegularBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Regular"));
            }
        });

        createView.setSpecialBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Special"));
            }
        });

        createView.setGoBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Menu"));
            }
        });
    }
}