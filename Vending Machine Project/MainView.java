import javax.swing.*;
import java.awt.*;

public class MainView {
    JFrame mainFrame;

    private String panelMenu = "Menu";
    private String panelCreate = "Create";
    private String panelTest = "Test";
    private String panelTestMaintenance = "Maintenance";
    private String panelStock = "Stock";
    private String panelCollect = "Collect";
    private String panelReplenish = "Replenish";
    private String panelRegular = "Regular";
    private String panelSpecial = "Special";
    private String panelVending = "Vending";
    private String panelSpecialMachine = "Special Machine";
    private String panelPayment = "Payment";
    private String panelPrice = "Price";
    private String panelRestock = "Restock";
    private String panelSummary = "Summary";
    private MenuView menuPanel;
    private CreateView createPanel;
    private TestMenuView testMenuPanel;
    private TestView testMaintenancePanel;
    private StockView stockPanel;
    private CollectMoneyView collectMoneyPanel;
    private ReplenishChangeView replenishChangePanel;
    private RegularVMView regularPanel;
    private SpecialVMView specialPanel;
    private VendingMachineView vmPanel;
    private SpecialMachineView specialMachinePanel;
    private PaymentView paymentPanel;
    private SetPriceView pricePanel;
    private RestockView restockPanel;
    private DisplaySummaryView summaryPanel;

    public MainView () {

        this.mainFrame = new JFrame("Vending Machine Simulator");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(1000, 800);
        this.mainFrame.getContentPane().setBackground(new Color(242, 234, 211));
        this.mainFrame.setResizable(false);

        ImageIcon logo = new ImageIcon("VendingMachineLogo.png");
        this.mainFrame.setIconImage(logo.getImage());

        menuPanel = new MenuView();
        createPanel = new CreateView();
        regularPanel = new RegularVMView();
        specialPanel = new SpecialVMView();
        testMenuPanel = new TestMenuView();
        testMaintenancePanel = new TestView();
        stockPanel = new StockView(); //cleaning
        collectMoneyPanel = new CollectMoneyView();
        replenishChangePanel = new ReplenishChangeView();
        vmPanel = new VendingMachineView();
        specialMachinePanel = new SpecialMachineView();
        paymentPanel = new PaymentView();
        pricePanel = new SetPriceView();
        restockPanel = new RestockView();
        summaryPanel = new DisplaySummaryView();

        mainFrame.setVisible(true);
    }

    public void setMainFramePanel (JPanel panel) {
        mainFrame.setContentPane(panel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public JPanel getPanels (String name) {
        if(name.equals(panelMenu))
            return menuPanel.getMenuPanel();
        else if(name.equals(panelCreate))
            return createPanel.getCreatePanel();
        else if(name.equals(panelTest))
            return testMenuPanel.getTestMenuPanel();
        else if(name.equals(panelRegular))
            return regularPanel.getRegularPanel();
        else if(name.equals(panelSpecial))
            return specialPanel.getSpecialPanel();
        else if(name.equals(panelTestMaintenance))
            return testMaintenancePanel.getMaintenancePanel();
        else if(name.equals(panelStock))
            return stockPanel.getStockPanel();
        else if(name.equals(panelCollect))
            return collectMoneyPanel.getCollectPanel();
        else if(name.equals(panelVending))
            return vmPanel.getVendingPanel();
        else if(name.equals(panelSpecialMachine))
            return specialMachinePanel.getSpecialMachinePanel();
        else if(name.equals(panelReplenish))
            return replenishChangePanel.getReplenishPanel();
        else if(name.equalsIgnoreCase(panelPayment))
            return paymentPanel.getPaymentPanel();
        else if(name.equalsIgnoreCase(panelPrice))
            return pricePanel.getPricePanel();
        else if(name.equalsIgnoreCase(panelRestock))
            return restockPanel.getRestockPanel();
        else if(name.equalsIgnoreCase(panelSummary))
            return summaryPanel.getSummaryPanel();
        else
            return null;
    }

    public MenuView getMenuView () {
        return menuPanel;
    }
    public CreateView getCreateView () {
        return createPanel;
    }
    public TestMenuView getTestMenuView () {
        return testMenuPanel;
    }
    public TestView getTestMaintenanceView () {
        return  testMaintenancePanel;
    }
    public StockView getStockView () {
        return stockPanel;
    }
    public CollectMoneyView getCollectMoneyView () {
        return collectMoneyPanel;
    }
    public ReplenishChangeView getReplenishChangeView () {
        return replenishChangePanel;
    }
    public RegularVMView getRegularVMView () {
        return regularPanel;
    }
    public SpecialVMView getSpecialVMView () {
        return specialPanel;
    }
    public VendingMachineView getVendingMachineView () {
        return vmPanel;
    }
    public SpecialMachineView getSpecialMachineView() {
        return specialMachinePanel;
    }
    public PaymentView getPaymentView () {
        return paymentPanel;
    }
    public SetPriceView getPriceView ()
    {
        return pricePanel;
    }
    public RestockView getRestockView() {
        return restockPanel;
    }
    public DisplaySummaryView getSummaryView() {
        return summaryPanel;
    }

}