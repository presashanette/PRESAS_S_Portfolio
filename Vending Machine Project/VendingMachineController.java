import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class  VendingMachineController {
    private MainView mainView;
    private MainController mainController;
    private RegularVM regularVM;
    private VendingMachineView vendingMachineView;
    private JDialog dialog;

    public VendingMachineController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVM = mainController.getRegularVM();
        this.vendingMachineView = mainView.getVendingMachineView();

        vendingMachineView.setDispensePane("empty.png");

        vendingMachineView.setSlotBtnListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(regularVM.getSlots()[0] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[0].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[1] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[1].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[2] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[2].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[3] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[3].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[4] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[4].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[5] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[5].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[6] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[6].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[7] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[7].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[8] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[8].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[9] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[9].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[10] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[10].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        vendingMachineView.setSlotBtnListener(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(regularVM.getSlots()[11] == null) {
                    JOptionPane.showMessageDialog(null, "Select another item");
                }
                else {
                    vendingMachineView.setSelectPane(regularVM.getSlots()[11].getItem().getName());
                    for (int i = 0; i < regularVM.getSlots().length; i++)
                        if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                            vendingMachineView.setTotalTA(String.valueOf(regularVM.getSlots()[i].getItem().getPrice()));
                            vendingMachineView.setFeedBackPane("");
                            break;
                        }
                }
            }
        });

        this.vendingMachineView.setPaymentBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachineView.clearPane();
                vendingMachineView.setDispensePane("empty.png");
                regularVM.accessCashRegister().setDenominationList();

                if(!vendingMachineView.getItemSelectedText().equalsIgnoreCase("")) {
                    dialog = new JDialog((Frame) null, "Payment", true);
                    dialog.setPreferredSize(new Dimension(700, 700));
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.add(mainView.getPanels("Payment"));

                    dialog.pack();
                    dialog.setResizable(false);
                    dialog.setVisible(true);

                    if(mainController.isSuccessful()) {
                        ArrayList<String> text = regularVM.accessCashRegister().getDisplayText();
                        StringBuilder display = new StringBuilder("Dispensing money...\n");
                        for(String t : text)
                            display.append(t).append("\n");

                        vendingMachineView.setFeedBackPane(display.toString());

                        for(int i = 0; i < regularVM.getSlots().length; i++)
                            if (regularVM.getSlots()[i].getItem().getName().equalsIgnoreCase(vendingMachineView.getItemSelectedText())) {
                                vendingMachineView.setDispensePane(regularVM.getSlots()[i].getItem().getImagePath());
                                regularVM.dispenseItem(i);
                                mainController.displayItems();
                                break;
                            }
                    } else {
                        ArrayList<String> text = regularVM.accessCashRegister().getDisplayText();
                        StringBuilder display = new StringBuilder();
                        for(String t : text)
                            display.append(t).append("\n");

                        vendingMachineView.setFeedBackPane(display.toString());
                    }
                    mainController.setIsSuccessful(false);
                    vendingMachineView.clearTextField();
                    regularVM.accessCashRegister().setDenominationList();
                }
                else JOptionPane.showMessageDialog(null, "You have to select an item first");
            }
        });

        this.vendingMachineView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachineView.clearTextField();
                vendingMachineView.clearPane();
                vendingMachineView.setDispensePane("empty.png");
                regularVM.accessCashRegister().setDenominationList();
                mainView.setMainFramePanel(mainView.getPanels("Test"));
            }
        });
    }

    public void closeDialog() {
        dialog.dispose();
    }
}