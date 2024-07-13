import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialVMController {
    private MainView mainView;
    private MainController mainController;
    private SpecialVMView specialVMView;
    private SpecialVM specialVM;

    public SpecialVMController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.specialVMView = this.mainView.getSpecialVMView();
        this.specialVM = this.mainController.getSpecialVM();

        this.specialVMView.setSubmitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String capacity = specialVMView.getCapacityTf();
                int capacityPerSlot;

                int result2;

                try {
                    capacityPerSlot = Integer.parseInt(capacity);
                    result2 = specialVM.setCapacityPerSlot(capacityPerSlot) ;
                } catch (NumberFormatException ex) {
                    result2 = 3;
                }

                if(result2 == 1) {
                    mainController.setHasCreated();
                    mainController.setIsSpecial(true);
                    mainController.setIsRegular(false);

                    mainController.getSpecialVM().emptySlots();
                    specialVM.accessCashRegister().setChange();
                    specialVM.accessCashRegister().setTotalSales(0);
                    specialVM.setSlotIndex(0);

                    mainController.getRegularVM().emptySlots();
                    mainController.getRegularVM().accessCashRegister().setChange();
                    mainController.getRegularVM().accessCashRegister().setTotalSales(0);
                    mainController.getRegularVM().setSlotIndex(0);
                    mainController.clearDisplays();

                    specialVMView.setFeedbackPaneText("Create success!");
                    specialVMView.clearTextFields();
                } else if (result2 == 0) {
                    specialVMView.setFeedbackPaneText("Create failed! should be >= 10");
                    specialVMView.clearTextFields();
                } else if (result2 == 3) {
                    specialVMView.setFeedbackPaneText("Invalid input! It should be a number.");
                    specialVMView.clearTextFields();
                }
            }
        });

        this.specialVMView.setGoBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Menu"));
                specialVMView.setFeedbackPaneText("");
            }
        });
    }
}
