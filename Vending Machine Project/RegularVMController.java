import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularVMController {
    private MainView mainView;
    private MainController mainController;
    private RegularVMView regularVMView;
    private RegularVM regularVM;

    public RegularVMController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVMView = this.mainView.getRegularVMView();
        this.regularVM = this.mainController.getRegularVM();

        this.regularVMView.setSubmitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String capacity = regularVMView.getCapacityTf();
                int capacityPerSlot;

                int result2;

                try {
                    capacityPerSlot = Integer.parseInt(capacity);
                    result2 = regularVM.setCapacityPerSlot(capacityPerSlot) ;
                } catch (NumberFormatException ex) {
                    result2 = 3;
                }

                if(result2 == 1) {
                    mainController.setHasCreated();
                    mainController.setIsRegular(true);
                    mainController.setIsSpecial(false);

                    mainController.getRegularVM().emptySlots();
                    regularVM.accessCashRegister().setChange();
                    regularVM.accessCashRegister().setTotalSales(0);
                    regularVM.setSlotIndex(0);

                    mainController.getSpecialVM().emptySlots();
                    mainController.getSpecialVM().accessCashRegister().setChange();
                    mainController.getSpecialVM().accessCashRegister().setTotalSales(0);
                    mainController.getSpecialVM().setSlotIndex(0);
                    mainController.clearDisplays();

                    regularVMView.setFeedbackPaneText("Create success!");
                    regularVMView.clearTextFields();
                } else if (result2 == 0) {
                    regularVMView.setFeedbackPaneText("Create failed! should be >= 10");
                    regularVMView.clearTextFields();
                } else if (result2 == 3) {
                    regularVMView.setFeedbackPaneText("Invalid input! It should be a number.");
                    regularVMView.clearTextFields();
                }
            }
        });

        this.regularVMView.setGoBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setMainFramePanel(mainView.getPanels("Menu"));
                regularVMView.setFeedbackPaneText("");
            }
        });
    }
}
