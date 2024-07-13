import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockController {
    private MainView mainView;
    private MainController mainController;
    private RegularVM regularVM;
    private SpecialVM specialVM;
    private StockView stockView;

    public StockController(MainView mainView, MainController mainController)
    {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVM = this.mainController.getRegularVM();
        this.specialVM = this.mainController.getSpecialVM();
        this.stockView = this.mainView.getStockView();

        stockView.setSlotBtnListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[0].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[1].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[2].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[3].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[4].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[5].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[6].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[7].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[8].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[9].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[10].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[11].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(12, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[12].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(13, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[13].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(14, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[14].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[15].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[16].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[17].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(18, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[18].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(19, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[19].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[20].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(21, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[21].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(22, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[22].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSlotBtnListener(23, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setItemSelectedTextArea(mainController.getItemChoices()[23].getName());
                stockView.setFeedbackPaneText("");
            }
        });

        stockView.setSubmitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int capacity;

                for(int i = 0; i < mainController.getItemChoices().length; i++) {
                    if(mainController.getItemChoices()[i].getName().equalsIgnoreCase(stockView.getItemSelectedText())) {
                        int result2;

                        try {
                            capacity = Integer.parseInt(stockView.getCapacityTf());
                            if (mainController.getIsSpecial())
                                result2 = specialVM.setSlot(mainController.getItemChoices()[i], capacity) ;
                            else
                                result2 = regularVM.setSlot(mainController.getItemChoices()[i], capacity) ;

                        } catch (NumberFormatException ex) {
                            result2 = 3;
                        }

                        if(result2 == 1) {

                            stockView.setFeedbackPaneText("Added!");
                            stockView.clearTextField();
                        } else if (result2 == 0) {
                            stockView.setFeedbackPaneText("Failed!");
                            stockView.clearTextField();
                        } else if (result2 == 3) {
                            stockView.setFeedbackPaneText("Invalid!");
                            stockView.clearTextField();
                        }

                    }
                }
            }
        });

        stockView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockView.setFeedbackPaneText("");
                mainView.setMainFramePanel(mainView.getPanels("Maintenance"));
            }
        });
    }
}