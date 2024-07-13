import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaymentController {
    private MainView mainView;
    private MainController mainController;
    private RegularVM regularVM;
    private SpecialVM specialVM;
    private PaymentView paymentView;
    private ArrayList<Float> tempPay = new ArrayList<>();
    private VendingMachineController vmController;
    private SpecialMachineController smController;

    public PaymentController (MainView mainView, MainController mainController) {
        this.mainView = mainView;
        this.mainController = mainController;
        this.regularVM = mainController.getRegularVM();
        this.specialVM = mainController.getSpecialVM();
        this.paymentView = mainView.getPaymentView();
        this.vmController = mainController.getVendingMachineController();
        this.smController = mainController.getSpecialMachineController();

        this.paymentView.setEnterBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] denomination = {1, 5, 10, 20, 50, 100, 200, 500, 1000};
                boolean checker = false;
                float money = Float.parseFloat(paymentView.getMoneyTextField());

                for(int i = 0; i < 9; i++) {
                    if(money == denomination[i]) {
                        tempPay.add(money);
                        checker = true;
                        break;
                    }
                }

                if(checker) {
                    paymentView.setFeedbackPane("Accepted!");
                    paymentView.clearTextField();
                }
                else {
                    paymentView.setFeedbackPane("Not Valid Denomination!");
                    paymentView.clearTextField();
                }
            }
        });

        this.paymentView.setDoneBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainController.getIsRegular()) {
                    if(regularVM.accessCashRegister().receivePaymentModel(Float.parseFloat(mainView.getVendingMachineView().getTotalTA()), tempPay)) {
                        mainController.setIsSuccessful(true);
                        tempPay.clear();
                        vmController.closeDialog();
                    }
                    else {
                        tempPay.clear();
                        vmController.closeDialog();
                    }

                }
                else if (mainController.getIsSpecial()) {
                    if(specialVM.accessCashRegister().receivePaymentModel(Float.parseFloat(mainView.getSpecialMachineView().getTotalTA()), tempPay)) {
                        mainController.setIsSuccessful(true);
                        tempPay.clear();
                        smController.closeDialog();
                        specialVM.removeAllItem();
                    }
                    else {
                        tempPay.clear();
                        smController.closeDialog();
                        specialVM.removeAllItem();
                    }
                }
                paymentView.setFeedbackPane("");
            }
        });
    }
}