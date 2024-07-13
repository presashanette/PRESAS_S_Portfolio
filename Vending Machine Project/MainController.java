public class MainController {
    private MenuController menuController;
    private CreateController createController;
    private RegularVMController regularVMController;
    private SpecialVMController specialVMController;
    private TestMenuController testMenuController;
    private TestController testController;
    private StockController stockController;
    private CollectMoneyController collectController;
    private ReplenishChangeController replenishChangeController;
    private VendingMachineController vendingMachineController;
    private SpecialMachineController specialMachineController;
    private PaymentController paymentController;
    private SetPriceController priceController;
    private RestockController restockController;
    private DisplaySummaryController summaryController;
    private RegularVM regularVM;
    private SpecialVM specialVM;
    private MainView mainView;
    private boolean hasCreated = false;
    private boolean isSuccessful = false;
    private boolean isRegular;
    private boolean isSpecial;

    public MainController (MainView mainView, RegularVM regularVM, SpecialVM specialVM) {
        this.regularVM = regularVM;
        this.specialVM = specialVM;
        this.mainView = mainView;

        menuController = new MenuController(mainView, this);
        createController = new CreateController(mainView);
        testMenuController = new TestMenuController(mainView, this);
        testController = new TestController(mainView, this);
        stockController = new StockController(mainView, this);
        collectController = new CollectMoneyController(mainView, this);
        replenishChangeController = new ReplenishChangeController(mainView, this);
        regularVMController = new RegularVMController(mainView, this);
        specialVMController = new SpecialVMController(mainView, this);
        vendingMachineController = new VendingMachineController(mainView, this);
        specialMachineController = new SpecialMachineController(mainView, this);
        paymentController = new PaymentController(mainView, this);
        priceController = new SetPriceController(mainView, this);
        restockController = new RestockController(mainView, this);
        summaryController = new DisplaySummaryController(mainView, this);
    }


    public void displayItems () {

        Slot[] itemsChosen;

        if (getIsSpecial()) { //for special
            itemsChosen = specialVM.getSlots();

            for(int i = 0; i < itemsChosen.length; i++) {
                if(itemsChosen[i] != null && itemsChosen[i].getNumOfItems() != 0) {
                    mainView.getSpecialMachineView().setTextLbl(i, itemsChosen[i].getItem().getName());
                    mainView.getSpecialMachineView().setImageIcon(i, itemsChosen[i].getItem().getImagePath());
                    mainView.getSpecialMachineView().setPriceTextLbl(i, String.valueOf(itemsChosen[i].getItem().getPrice()));
                    mainView.getSpecialMachineView().setCalTextLbl(i, String.valueOf(itemsChosen[i].getItem().getCalories()));
                    mainView.getSpecialMachineView().setStockLbl(i, String.valueOf(itemsChosen[i].getNumOfItems()));
                }
                else {
                    getSpecialVM().getSlots()[i] = null;
                    mainView.getSpecialMachineView().setTextLbl(i, "EMPTY");
                    mainView.getSpecialMachineView().setImageIcon(i,"empty.png");
                    mainView.getSpecialMachineView().setPriceTextLbl(i, "");
                    mainView.getSpecialMachineView().setCalTextLbl(i, "");
                    mainView.getSpecialMachineView().setStockLbl(i, "");
                }
            }
        }
        else { //for regular
            itemsChosen = regularVM.getSlots();

            for(int i = 0; i < itemsChosen.length; i++) {
                if(itemsChosen[i] != null && itemsChosen[i].getNumOfItems() != 0) {
                    mainView.getVendingMachineView().setTextLbl(i, itemsChosen[i].getItem().getName());
                    mainView.getVendingMachineView().setImageIcon(i, itemsChosen[i].getItem().getImagePath());
                    mainView.getVendingMachineView().setPriceTextLbl(i, String.valueOf(itemsChosen[i].getItem().getPrice()));
                    mainView.getVendingMachineView().setCalTextLbl(i, String.valueOf(itemsChosen[i].getItem().getCalories()));
                    mainView.getVendingMachineView().setStockLbl(i, String.valueOf(itemsChosen[i].getNumOfItems()));
                }
                else {
                    getRegularVM().getSlots()[i] = null;
                    mainView.getVendingMachineView().setTextLbl(i, "EMPTY");
                    mainView.getVendingMachineView().setImageIcon(i,"empty.png");
                    mainView.getVendingMachineView().setPriceTextLbl(i, "");
                    mainView.getVendingMachineView().setCalTextLbl(i, "");
                    mainView.getVendingMachineView().setStockLbl(i, "");
                }
            }
        }
    }

    public void clearDisplays() {

        if (getIsSpecial()) { //for special

            for(int i = 0; i < 12; i++) {
                mainView.getSpecialMachineView().setTextLbl(i, "EMPTY");
                mainView.getSpecialMachineView().setImageIcon(i, "empty.png");
                mainView.getSpecialMachineView().setPriceTextLbl(i, "");
                mainView.getSpecialMachineView().setCalTextLbl(i, "");
                mainView.getSpecialMachineView().setStockLbl(i, "");
            }
        }
        else { //for regular

            for(int i = 0; i < 12; i++) {
                mainView.getVendingMachineView().setTextLbl(i, "EMPTY");
                mainView.getVendingMachineView().setImageIcon(i, "empty.png");
                mainView.getVendingMachineView().setPriceTextLbl(i, "");
                mainView.getVendingMachineView().setCalTextLbl(i, "");
                mainView.getVendingMachineView().setStockLbl(i, "");
            }
        }
    }
    public void displayChoices () {
        Item[] itemChoices;

        //choices for Special
        if(getIsSpecial())
        {
            itemChoices = specialVM.getItemChoices();

            for(int i = 0; i < itemChoices.length; i++) {
                if(itemChoices[i] != null) {
                    mainView.getStockView().setTextLbl(i, itemChoices[i].getName());
                    mainView.getStockView().setImageIcon(i, itemChoices[i].getImagePath());
                }
                else {
                    mainView.getStockView().setTextLbl(i, "EMPTY");
                    mainView.getStockView().setImageIcon(i,"empty.png");
                }
            }
        }

        //choices for regular
        else {
            itemChoices = regularVM.getItemChoices();

            for(int i = 0; i < itemChoices.length; i++) {
                if(itemChoices[i] != null) {
                    mainView.getStockView().setTextLbl(i, itemChoices[i].getName());
                    mainView.getStockView().setImageIcon(i, itemChoices[i].getImagePath());
                }
                else {
                    mainView.getStockView().setTextLbl(i, "EMPTY");
                    mainView.getStockView().setImageIcon(i,"empty.png");
                }
            }
        }
    }
    public Item[] getItemChoices () {
        if(getIsSpecial())
            return specialVM.getItemChoices();
        return regularVM.getItemChoices();
    }

    public Slot[] getSlots() {
        if(getIsSpecial())
            return specialVM.getSlots();
        return regularVM.getSlots();
    }
    public void displaySetPrice () {
        SetPriceView priceView = mainView.getPriceView();
        Slot[] itemsChosen;

        if (getIsSpecial())
            itemsChosen = specialVM.getSlots();
        else
            itemsChosen = regularVM.getSlots();

        for(int i = 0; i < itemsChosen.length; i++) {
            if(itemsChosen[i] != null && itemsChosen[i].getNumOfItems() != 0) {
                mainView.getPriceView().setTextLbl(i, itemsChosen[i].getItem().getName());
                mainView.getPriceView().setImageIcon(i, itemsChosen[i].getItem().getImagePath());
                mainView.getPriceView().setPriceTextLbl(i, String.valueOf(itemsChosen[i].getItem().getPrice()));
            }
            else {
                mainView.getPriceView().setTextLbl(i, "EMPTY");
                mainView.getPriceView().setImageIcon(i,"empty.png");
                mainView.getPriceView().setPriceTextLbl(i, "");
            }
        }

    }
    public void displayMoneyCount () {
        if(getIsSpecial()) {
            mainView.getReplenishChangeView().setMoneyTextArea1(String.valueOf(specialVM.accessCashRegister().getDenomination(0)));
            mainView.getReplenishChangeView().setMoneyTextArea5(String.valueOf(specialVM.accessCashRegister().getDenomination(1)));
            mainView.getReplenishChangeView().setMoneyTextArea10(String.valueOf(specialVM.accessCashRegister().getDenomination(2)));
            mainView.getReplenishChangeView().setMoneyTextArea20(String.valueOf(specialVM.accessCashRegister().getDenomination(3)));
            mainView.getReplenishChangeView().setMoneyTextArea50(String.valueOf(specialVM.accessCashRegister().getDenomination(4)));
            mainView.getReplenishChangeView().setMoneyTextArea100(String.valueOf(specialVM.accessCashRegister().getDenomination(5)));
            mainView.getReplenishChangeView().setMoneyTextArea200(String.valueOf(specialVM.accessCashRegister().getDenomination(6)));
            mainView.getReplenishChangeView().setMoneyTextArea500(String.valueOf(specialVM.accessCashRegister().getDenomination(7)));
            mainView.getReplenishChangeView().setMoneyTextArea1000(String.valueOf(specialVM.accessCashRegister().getDenomination(8)));

        } else {
            mainView.getReplenishChangeView().setMoneyTextArea1(String.valueOf(regularVM.accessCashRegister().getDenomination(0)));
            mainView.getReplenishChangeView().setMoneyTextArea5(String.valueOf(regularVM.accessCashRegister().getDenomination(1)));
            mainView.getReplenishChangeView().setMoneyTextArea10(String.valueOf(regularVM.accessCashRegister().getDenomination(2)));
            mainView.getReplenishChangeView().setMoneyTextArea20(String.valueOf(regularVM.accessCashRegister().getDenomination(3)));
            mainView.getReplenishChangeView().setMoneyTextArea50(String.valueOf(regularVM.accessCashRegister().getDenomination(4)));
            mainView.getReplenishChangeView().setMoneyTextArea100(String.valueOf(regularVM.accessCashRegister().getDenomination(5)));
            mainView.getReplenishChangeView().setMoneyTextArea200(String.valueOf(regularVM.accessCashRegister().getDenomination(6)));
            mainView.getReplenishChangeView().setMoneyTextArea500(String.valueOf(regularVM.accessCashRegister().getDenomination(7)));
            mainView.getReplenishChangeView().setMoneyTextArea1000(String.valueOf(regularVM.accessCashRegister().getDenomination(8)));
        }
    }
    public void displayTotal () {

        if(getIsSpecial())
            mainView.getCollectMoneyView().setTotalTA(String.valueOf(specialVM.accessCashRegister().getTotalMoney()));
        else
            mainView.getCollectMoneyView().setTotalTA(String.valueOf(regularVM.accessCashRegister().getTotalMoney()));
    }
    public void displayRestock () {
        RestockView restockView = mainView.getRestockView();
        Slot[] itemsChosen;

        if (getIsSpecial())
            itemsChosen = specialVM.getSlots();
        else
            itemsChosen = regularVM.getSlots();

        for(int i = 0; i < itemsChosen.length; i++) {
            if(itemsChosen[i] != null && itemsChosen[i].getNumOfItems() != 0) {
                mainView.getRestockView().setTextLbl(i, itemsChosen[i].getItem().getName());
                mainView.getRestockView().setImageIcon(i, itemsChosen[i].getItem().getImagePath());
                mainView.getRestockView().setStockLbl(i, String.valueOf(itemsChosen[i].getNumOfItems()));
            }
            else {
                mainView.getRestockView().setTextLbl(i, "EMPTY");
                mainView.getRestockView().setImageIcon(i,"empty.png");
                mainView.getRestockView().setStockLbl(i, "");
            }
        }
    }
    public void displaySummary () {
        DisplaySummaryView summaryView = mainView.getSummaryView();
        Slot[] itemsChosen;

        if (getIsSpecial())
            itemsChosen = specialVM.getSlots();
        else
            itemsChosen = regularVM.getSlots();

        for(int i = 0; i < itemsChosen.length; i++) {
            if(itemsChosen[i] != null) {
                mainView.getSummaryView().setSlotLbl(i, itemsChosen[i].getItem().getName());
                mainView.getSummaryView().setImageIcon(i, itemsChosen[i].getItem().getImagePath());
                mainView.getSummaryView().setSlotStartStock(i, String.valueOf(itemsChosen[i].getStartInventory()));
                mainView.getSummaryView().setSlotEndStock(i, String.valueOf(itemsChosen[i].getNumOfItems()));
            }
            else {
                mainView.getSummaryView().setSlotLbl(i, "EMPTY");
                mainView.getSummaryView().setImageIcon(i,"empty.png");
            }
        }
        if(getIsRegular())
            mainView.getSummaryView().setTotalLbl(String.valueOf(regularVM.accessCashRegister().getTotalSales()));
        else mainView.getSummaryView().setTotalLbl(String.valueOf(specialVM.accessCashRegister().getTotalSales()));
    }


    //=== setters and getters ===//
    public boolean getHasCreated () {
        return hasCreated;
    }
    public void setHasCreated () {
        hasCreated = true;
    }
    public void setIsRegular(boolean word) {
        this.isRegular = word;
    }
    public void setIsSpecial (boolean word) {
        this.isSpecial = word;
    }
    public void setIsSuccessful (boolean word) {
        isSuccessful = word;
    }
    public boolean isSuccessful () {
        return isSuccessful;
    }
    public boolean getIsRegular() {
        return isRegular;
    }

    public boolean getIsSpecial() {
        return isSpecial;
    }

    public RegularVM getRegularVM () {
        return regularVM;
    }

    public SpecialVM getSpecialVM () {
        return specialVM;
    }
    public VendingMachineController getVendingMachineController() {
        return vendingMachineController;
    }
    public SpecialMachineController getSpecialMachineController() {
        return specialMachineController;
    }
}