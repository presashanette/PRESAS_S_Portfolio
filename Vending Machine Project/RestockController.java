import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestockController {
    private MainView mainView;
    private MainController mainController;
    private RestockView restockView;
    private RegularVM regularVM;
    private SpecialVM specialVM;

    public RestockController(MainView mainView, MainController mainController)
    {
        this.mainView = mainView;
        this.mainController = mainController;
        this.restockView = mainView.getRestockView();
        this.regularVM = mainController.getRegularVM();
        this.specialVM = mainController.getSpecialVM();

        restockView.setSlotBtnListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(mainController.getSlots()[0] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[0].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[1] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[1].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[2] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[2].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[3] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[3].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[4] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[4].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[5] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[5].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[6] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[6].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[7] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[7].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[8] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[8].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[9] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[9].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[10] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[10].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setSlotBtnListener(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getSlots()[11] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    restockView.setItemSelectedTextArea(mainController.getSlots()[11].getItem().getName());
                    for(int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())) {
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                            break;
                        }
                }
            }
        });

        restockView.setAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    for (int i = 0; i < mainController.getSlots().length && mainController.getSlots()[i] != null; i++) {
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())
                                && mainController.getSlots()[i].getNumOfItems() < mainController.getSlots()[i].getCapacity()) {
                            mainController.getRegularVM().restockItem(i, 1);
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                        }
                    }
                } else {
                    for (int i = 0; i < mainController.getSlots().length && mainController.getSlots()[i] != null; i++) {
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())
                                && mainController.getSlots()[i].getNumOfItems() < mainController.getSlots()[i].getCapacity()) {
                            mainController.getSpecialVM().restockItem(i, 1);
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                        }
                    }
                }
            }
        });

        restockView.setMinusBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    for (int i = 0; i < mainController.getSlots().length && mainController.getSlots()[i] != null; i++) {
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())
                                && mainController.getSlots()[i].getNumOfItems() >= 1) {
                            mainController.getRegularVM().restockItem(i, -1);
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                        }
                    }
                }
                else {
                    for (int i = 0; i < mainController.getSlots().length && mainController.getSlots()[i] != null; i++) {
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(restockView.getItemSelectedText())
                                && mainController.getSlots()[i].getNumOfItems() >= 1) {
                            mainController.getSpecialVM().restockItem(i, -1);
                            restockView.setCurStockTA(String.valueOf(mainController.getSlots()[i].getNumOfItems()));
                        }
                    }
                }
            }
        });

        restockView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    restockView.clearTextField();
                    regularVM.accessCashRegister().setDenominationList();
                    mainView.setMainFramePanel(mainView.getPanels("Test"));
                }
                else {
                    restockView.clearTextField();
                    specialVM.accessCashRegister().setDenominationList();
                    mainView.setMainFramePanel(mainView.getPanels("Test"));
                }
            }
        });
    }
}