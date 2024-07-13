import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SetPriceController {
    private MainView mainView;
    private MainController mainController;
    private RegularVM regularVM;
    private SpecialVM specialVM;
    private SetPriceView priceView;
    private Slot[] items;

    public SetPriceController(MainView mainView, MainController mainController)
    {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVM = mainController.getRegularVM();
        this.specialVM = mainController.getSpecialVM();
        this.priceView = mainView.getPriceView();

        priceView.setSlotBtnListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[0] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[0].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[1] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[1].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[2] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[2].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[3] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[3].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[4] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[4].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[5] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[5].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[6] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[6].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[7] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[7].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[8] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[8].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[9] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[9].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[10] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[10].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSlotBtnListener(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getSlots()[11] == null)
                    JOptionPane.showMessageDialog(null, "Select another item!");

                else {
                    priceView.setItemSelectedTextArea(mainController.getSlots()[11].getItem().getName());

                    for (int i = 0; i < mainController.getSlots().length; i++)
                        if (mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                            priceView.setTotalTA(String.valueOf(mainController.getSlots()[i].getItem().getPrice()));
                            break;
                        }
                }
            }
        });

        priceView.setSubmitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float newPrice;

                for(int i = 0; i < mainController.getSlots().length && mainController.getSlots()[i]!=null; i++) {
                    if(mainController.getSlots()[i].getItem().getName().equalsIgnoreCase(priceView.getItemSelectedText())) {
                        int result2;

                        try {
                            newPrice = Float.parseFloat(priceView.getPriceTf());
                            result2 = mainController.getSlots()[i].getItem().setPrice(newPrice);

                        } catch (NumberFormatException ex) {
                            result2 = 3;
                        }

                        if(result2 == 1) {
                            priceView.setFeedbackPaneText("Price Updated!");
                            priceView.clearTextField();
                            mainController.displaySetPrice(); //para mag-appear agad once mag-change
                        } else if (result2 == 0) {
                            priceView.setFeedbackPaneText("Failed!");
                            priceView.clearTextField();
                        } else if (result2 == 3) {
                            priceView.setFeedbackPaneText("Invalid!");
                            priceView.clearTextField();
                        }

                    }
                }
            }
        });

        this.priceView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                priceView.clearTextField();
                priceView.clearPane();

                if(mainController.getIsSpecial())
                    specialVM.accessCashRegister().setDenominationList();
                else regularVM.accessCashRegister().setDenominationList();

                mainView.setMainFramePanel(mainView.getPanels("Test"));
            }
        });
    }
}