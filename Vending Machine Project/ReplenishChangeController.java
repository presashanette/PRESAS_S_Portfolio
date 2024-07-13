import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplenishChangeController {
    MainView mainView;
    MainController mainController;
    ReplenishChangeView replenishChangeView;

    public ReplenishChangeController(MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        replenishChangeView = this.mainView.getReplenishChangeView();

        regularReplenish();
        specialReplenish();
    }

    public void regularReplenish () {
        // ===== ADD ===== //
        replenishChangeView.setAddBtn1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(1, 1);
                    replenishChangeView.setMoneyTextArea1(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(0)));
                }
            }
        });

        replenishChangeView.setAddBtn5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(5, 1);
                    replenishChangeView.setMoneyTextArea5(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(1)));
                }
            }
        });

        replenishChangeView.setAddBtn10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(10, 1);
                    replenishChangeView.setMoneyTextArea10(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(2)));
                }
            }
        });

        replenishChangeView.setAddBtn20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(20, 1);
                    replenishChangeView.setMoneyTextArea20(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(3)));
                }
            }
        });

        replenishChangeView.setAddBtn50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(50, 1);
                    replenishChangeView.setMoneyTextArea50(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(4)));
                }
            }
        });

        replenishChangeView.setAddBtn100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.getRegularVM().accessCashRegister().replenishChange(100, 1);
                replenishChangeView.setMoneyTextArea100(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(5)));
            }
        });

        replenishChangeView.setAddBtn200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(200, 1);
                    replenishChangeView.setMoneyTextArea200(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(6)));
                }
            }
        });

        replenishChangeView.setAddBtn500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(500, 1);
                    replenishChangeView.setMoneyTextArea500(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(7)));
                }
            }
        });

        replenishChangeView.setAddBtn1000Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().replenishChange(1000, 1);
                    replenishChangeView.setMoneyTextArea1000(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(8)));
                }
            }
        });

        // ===== MINUS ===== //
        replenishChangeView.setMinusBtn1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(1, 1);
                    replenishChangeView.setMoneyTextArea1(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(0)));
                }
            }
        });

        replenishChangeView.setMinusBtn5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(5, 1);
                    replenishChangeView.setMoneyTextArea5(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(1)));
                }
            }
        });

        replenishChangeView.setMinusBtn10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(10, 1);
                    replenishChangeView.setMoneyTextArea10(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(2)));
                }
            }
        });

        replenishChangeView.setMinusBtn20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(20, 1);
                    replenishChangeView.setMoneyTextArea20(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(3)));
                }
            }
        });

        replenishChangeView.setMinusBtn50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(50, 1);
                    replenishChangeView.setMoneyTextArea50(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(4)));
                }
            }
        });

        replenishChangeView.setMinusBtn100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(100, 1);
                    replenishChangeView.setMoneyTextArea100(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(5)));
                }
            }
        });

        replenishChangeView.setMinusBtn200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(200, 1);
                    replenishChangeView.setMoneyTextArea200(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(6)));
                }
            }
        });

        replenishChangeView.setMinusBtn500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(500, 1);
                    replenishChangeView.setMoneyTextArea500(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(7)));
                }
            }
        });

        replenishChangeView.setMinusBtn1000Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    mainController.getRegularVM().accessCashRegister().decreaseChange(1000, 1);
                    replenishChangeView.setMoneyTextArea1000(String.valueOf(mainController.getRegularVM().accessCashRegister().getDenomination(8)));
                }
            }
        });

        // ===== DONE ===== //
        replenishChangeView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getIsRegular())
                    mainView.setMainFramePanel(mainView.getPanels("Maintenance"));
            }
        });
    }

    public void specialReplenish () {
        // ===== ADD ===== //
        replenishChangeView.setAddBtn1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(1, 1);
                    replenishChangeView.setMoneyTextArea1(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(0)));
                }
            }
        });

        replenishChangeView.setAddBtn5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(5, 1);
                    replenishChangeView.setMoneyTextArea5(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(1)));
                }
            }
        });

        replenishChangeView.setAddBtn10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(10, 1);
                    replenishChangeView.setMoneyTextArea10(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(2)));
                }
            }
        });

        replenishChangeView.setAddBtn20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(20, 1);
                    replenishChangeView.setMoneyTextArea20(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(3)));
                }
            }
        });

        replenishChangeView.setAddBtn50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(50, 1);
                    replenishChangeView.setMoneyTextArea50(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(4)));
                }
            }
        });

        replenishChangeView.setAddBtn100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(100, 1);
                    replenishChangeView.setMoneyTextArea100(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(5)));
                }
            }
        });

        replenishChangeView.setAddBtn200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(200, 1);
                    replenishChangeView.setMoneyTextArea200(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(6)));
                }
            }
        });

        replenishChangeView.setAddBtn500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(500, 1);
                    replenishChangeView.setMoneyTextArea500(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(7)));
                }
            }
        });

        replenishChangeView.setAddBtn1000Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().replenishChange(1000, 1);
                    replenishChangeView.setMoneyTextArea1000(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(8)));
                }
            }
        });
        // ===== MINUS ===== //
        replenishChangeView.setMinusBtn1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(1, 1);
                    replenishChangeView.setMoneyTextArea1(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(0)));
                }
            }
        });

        replenishChangeView.setMinusBtn5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(5, 1);
                    replenishChangeView.setMoneyTextArea5(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(1)));
                }
            }
        });

        replenishChangeView.setMinusBtn10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(10, 1);
                    replenishChangeView.setMoneyTextArea10(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(2)));
                }
            }
        });

        replenishChangeView.setMinusBtn20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(20, 1);
                    replenishChangeView.setMoneyTextArea20(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(3)));
                }
            }
        });

        replenishChangeView.setMinusBtn50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(50, 1);
                    replenishChangeView.setMoneyTextArea50(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(4)));
                }
            }
        });

        replenishChangeView.setMinusBtn100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(100, 1);
                    replenishChangeView.setMoneyTextArea100(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(5)));
                }
            }
        });

        replenishChangeView.setMinusBtn200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(200, 1);
                    replenishChangeView.setMoneyTextArea200(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(6)));
                }
            }
        });

        replenishChangeView.setMinusBtn500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(500, 1);
                    replenishChangeView.setMoneyTextArea500(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(7)));
                }
            }
        });

        replenishChangeView.setMinusBtn1000Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial()) {
                    mainController.getSpecialVM().accessCashRegister().decreaseChange(1000, 1);
                    replenishChangeView.setMoneyTextArea1000(String.valueOf(mainController.getSpecialVM().accessCashRegister().getDenomination(8)));
                }
            }
        });
        // ===== DONE ===== //
        replenishChangeView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsSpecial())
                    mainView.setMainFramePanel(mainView.getPanels("Maintenance"));
            }
        });
    }
}
