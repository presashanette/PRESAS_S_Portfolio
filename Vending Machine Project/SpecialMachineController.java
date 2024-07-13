import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpecialMachineController {
    private MainView mainView;
    private MainController mainController;
    private SpecialVM specialVM;
    private SpecialMachineView specialMachineView;
    private JDialog dialog;

    public SpecialMachineController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.specialVM = mainController.getSpecialVM();
        this.specialMachineView = mainView.getSpecialMachineView();

        specialMachineView.setDispensePane("empty.png");

        this.specialMachineView.setSlotBtnListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[0] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[0].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[1] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[1].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[2] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[2].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[3] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[3].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[4] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[4].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[5] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[5].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[6] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[6].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[7] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[7].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[8] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[8].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[9] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[9].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[10] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[10].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        this.specialMachineView.setSlotBtnListener(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialVM.getSlots()[11] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    specialMachineView.setSelectPane(specialVM.getSlots()[11].getItem().getName());
                    specialMachineView.clearPane();
                    specialMachineView.setDispensePane("empty.png");
                }
            }
        });

        //=== BUTTONS ===//
        this.specialMachineView.setEnterBtnListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int checker = 0;
                int count = 0;
                String[] itemsString = specialMachineView.getText().split("\n");

                for (Slot item : specialVM.getSlots())
                    for (String s : itemsString)
                        if (item != null)
                            if (item.getItem().getName().equalsIgnoreCase(s))
                                specialVM.addItem(item.getItem());

                //checks if an item not sold individually was bought
                for (Item i : specialVM.getCart())
                {
                    if (i.getIsSoldIndiv() == true || i.getName() == "Noodles")
                        checker = 1;
                    count++;
                }

                //checks if only noodles was ordered
                if (count == 1 && specialVM.getCart().get(0).getName() == "Noodles")
                    checker=0;

                if (checker == 0) {
                    specialVM.removeAllItem();
                    JOptionPane.showMessageDialog(null, "These items are not sold individually!");
                    specialMachineView.clearTextField();
                }

                else {
                    specialMachineView.setTotalTA(String.valueOf(specialVM.computeTotal()));
                    specialMachineView.setCalTA(String.valueOf(specialVM.computeCal()));
                }


            }
        });

        this.specialMachineView.setPaymentBtnListener(new ActionListener() {
            int a = 0;
            String file;
            @Override
            public void actionPerformed(ActionEvent e) {
                specialMachineView.clearPane();
                specialMachineView.setDispensePane("empty.png");
                specialVM.accessCashRegister().setDenominationList();

                if(!specialMachineView.getSelectPaneText().equalsIgnoreCase("")) {
                    dialog = new JDialog((Frame) null, "Payment", true);
                    dialog.setPreferredSize(new Dimension(700, 700));
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.add(mainView.getPanels("Payment"));

                    dialog.pack();
                    dialog.setVisible(true);

                    if(mainController.isSuccessful()) {
                        ArrayList<String> text = specialVM.accessCashRegister().getDisplayText();
                        StringBuilder display = new StringBuilder("Dispensing money...\n");
                        for(String t : text)
                            display.append(t).append("\n");

                        specialMachineView.setFeedBackPane(display.toString());

                        String[] itemsString = specialMachineView.getText().split("\n");

                        //"dispensing of item"
                        if(itemsString.length > 1) {
                            StringBuilder prep = new StringBuilder();
                            prep.append("Preparing..\n\n");

                            for (int i = 0; i < specialVM.getSlots().length; i++)
                                for (int j = 0; j < itemsString.length; j++)
                                    if (specialVM.getSlots()[i] != null)
                                        if (specialVM.getSlots()[i].getItem().getName().equalsIgnoreCase(itemsString[j])) {
                                            specialVM.dispenseItem(i);
                                            prep.append(specialVM.displayPrep(i));
                                        }

                            prep.append("\nOrder Done!\n");
                            JOptionPane.showMessageDialog(null, prep);

                            //for assigning what final product
                            for (Item i : specialVM.getCart())
                            {
                                if (i.getName() == "Noodles") {
                                    a = 1;  //Ramen
                                    break;
                                }

                                else if (i.getName() == "Rice") {
                                    a = 3;  //Chashu Fried Rice
                                    for (Item j : specialVM.getCart()) {
                                        if (j.getName() == "Smoked Salmon" || j.getName() == "Tuna") {
                                            a = 2; //Nigiri
                                            for (Item k : specialVM.getCart()) {
                                                if (k.getName() == "Nori") {
                                                    a = 4; //Maki
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if (j.getName() == "Chashu Pork") {
                                            a = 3; //Chashu Fried Rice
                                            break;
                                        }
                                        else if (j.getName() == "Nori") {
                                            a = 4; //Maki
                                            break;
                                        }
                                    }
                                    break;
                                }

                                else if (i.getName() == "Smoked Salmon")
                                {
                                    for (Item j : specialVM.getCart()) {
                                        if (j.getName() == "Tuna") {
                                            a = 5; //Chirashi
                                            for (Item k : specialVM.getCart()) {
                                                if (k.getName() == "Rice") {
                                                    a = 2; //Nigiri
                                                    for (Item l : specialVM.getCart()) {
                                                        if (l.getName() == "Nori") {
                                                            a = 4; //Maki
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if (j.getName() == "Rice") {
                                            a = 2; //Nigiri
                                            for (Item k : specialVM.getCart())
                                            {
                                                if (k.getName() == "Nori") {
                                                    a = 4;  //Maki
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if (j.getName() == "Ramen") {
                                            a = 1; //Ramen
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }


                            if (a == 1)
                                specialMachineView.setDispensePane("ramenCustomized.png");
                            else if (a == 2)
                                specialMachineView.setDispensePane("nigiri.png");
                            else if (a == 3)
                                specialMachineView.setDispensePane("friedrice.png");
                            else if (a == 4)
                                specialMachineView.setDispensePane("maki.png");
                            else if (a == 5)
                                specialMachineView.setDispensePane("chirashi.png");
                            else {
                                for (Item i : specialVM.getCart())
                                    if (i.getIsSoldIndiv() == true)
                                        file = i.getImagePath();
                                specialMachineView.setDispensePane(file);
                            }

                            mainController.displayItems();
                            specialVM.removeAllItem();

                            //if the user only bought one item
                        } else if (itemsString.length == 1) {
                            for(int i = 0; i < specialVM.getSlots().length; i++)
                                if(specialVM.getSlots()[i] != null)
                                    if (specialVM.getSlots()[i].getItem().getName().equalsIgnoreCase(itemsString[0])) {
                                        specialVM.dispenseItem(i);
                                        specialMachineView.setDispensePane(specialVM.getSlots()[i].getItem().getImagePath());
                                        mainController.displayItems();
                                    }
                        }

                        //if payment is not successful
                    } else {
                        ArrayList<String> text = specialVM.accessCashRegister().getDisplayText();
                        StringBuilder display = new StringBuilder();
                        for(String t : text)
                            display.append(t).append("\n");

                        specialMachineView.setFeedBackPane(display.toString());
                        specialVM.removeAllItem();
                    }
                    mainController.setIsSuccessful(false);
                    specialMachineView.clearTextField();
                    specialVM.accessCashRegister().setDenominationList();
                }
                else JOptionPane.showMessageDialog(null, "You have to select an item first");
            }
        });

        this.specialMachineView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialMachineView.clearTextField();
                specialMachineView.clearPane();
                specialMachineView.setDispensePane("empty.png");
                specialVM.accessCashRegister().setDenominationList();
                specialVM.removeAllItem();
                mainView.setMainFramePanel(mainView.getPanels("Test"));
            }
        });
    }
    public void closeDialog() {
        dialog.dispose();
    }
}