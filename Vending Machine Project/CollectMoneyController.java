import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CollectMoneyController {
    private MainView mainView;
    private MainController mainController;
    private CollectMoneyView collectMoneyView;
    private RegularVM regularVM;
    private SpecialVM specialVM;

    public CollectMoneyController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVM = mainController.getRegularVM();
        this.specialVM = mainController.getSpecialVM();
        this.collectMoneyView = this.mainView.getCollectMoneyView();

        regularCollect();
        specialCollect();
    }

    public void regularCollect () {
        collectMoneyView.setEnterBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getIsRegular()) {
                    regularVM.accessCashRegister().setDenominationList();
                    collectMoneyView.clearPane();
                    String money = collectMoneyView.getMoneyTfText();

                    float amt = Float.parseFloat(money);
                    if(amt >= 0 && regularVM.accessCashRegister().getTotalMoney() > 0) {
                        regularVM.accessCashRegister().giveMoneyModel(amt);

                        ArrayList<String> text = regularVM.accessCashRegister().getDisplayText();
                        StringBuilder display = new StringBuilder("Dispensng money...\n");
                        for (String t : text)
                            display.append(t).append("\n");

                        collectMoneyView.setFeedBackPane(display.toString());
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"INVALID!");
                    }
                    collectMoneyView.clearTextFields();
                    mainController.displayTotal();
                }
            }
        });

        collectMoneyView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    regularVM.accessCashRegister().setDenominationList();
                    collectMoneyView.clearPane();
                    mainView.setMainFramePanel(mainView.getPanels("Maintenance"));
                }
            }
        });
    }

    public void specialCollect () {
        collectMoneyView.setEnterBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getIsSpecial()) {
                    specialVM.accessCashRegister().setDenominationList();
                    collectMoneyView.clearPane();
                    String money = collectMoneyView.getMoneyTfText();

                    float amt = Float.parseFloat(money);
                    if(amt >= 0 && specialVM.accessCashRegister().getTotalMoney() > 0) {
                        specialVM.accessCashRegister().giveMoneyModel(amt);

                        ArrayList<String> text = specialVM.accessCashRegister().getDisplayText();
                        StringBuilder display = new StringBuilder("Dispensng money...\n");
                        for (String t : text)
                            display.append(t).append("\n");

                        collectMoneyView.setFeedBackPane(display.toString());
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"INVALID!");
                    }
                    collectMoneyView.clearTextFields();
                    mainController.displayTotal();
                }
            }
        });

        collectMoneyView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    specialVM.accessCashRegister().setDenominationList();
                    collectMoneyView.clearPane();
                    mainView.setMainFramePanel(mainView.getPanels("Maintenance"));
                }
            }
        });
    }
}
