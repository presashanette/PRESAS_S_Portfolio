import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestView {
    private JPanel testMaintenancePanel, panel1, panel2, panel3;
    private JLabel maintenanceLbl1, maintenancelbl2;
    private JButton stockBtn, restockBtn, setPriceBtn, collectMoneyBtn, replenishMoneyBtn, displaySummaryBtn, exitBtn;

    public TestView () {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        testMaintenancePanel = new JPanel();
        testMaintenancePanel.setLayout(new BorderLayout());
        testMaintenancePanel.setPreferredSize(new Dimension(1000, 800));
        testMaintenancePanel.setBackground(Color.WHITE);
        testMaintenancePanel.setBorder(border1);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        maintenanceLbl1 = new JLabel("Test Maintenance");
        maintenanceLbl1.setForeground(Color.WHITE);
        maintenanceLbl1.setFont(new Font("Ravie", Font.BOLD, 35));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(maintenanceLbl1, constraints);

        //======================================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        maintenancelbl2 = new JLabel("Please choose an option!");
        maintenancelbl2.setFont(new Font("MV boli", Font.PLAIN, 20));

        this.stockBtn = new JButton("Stock Items");
        this.stockBtn.setPreferredSize(new Dimension(330, 50));
        stockBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        stockBtn.setBackground(Color.PINK);

        this.restockBtn = new JButton("Restock Items");
        this.restockBtn.setPreferredSize(new Dimension(330, 50));
        restockBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        restockBtn.setBackground(Color.PINK);

        this.setPriceBtn = new JButton("Set Price");
        this.setPriceBtn.setPreferredSize(new Dimension(330, 50));
        setPriceBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        setPriceBtn.setBackground(Color.PINK);

        this.collectMoneyBtn = new JButton("Collect Money");
        this.collectMoneyBtn.setPreferredSize(new Dimension(330, 50));
        collectMoneyBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        collectMoneyBtn.setBackground(Color.PINK);

        this.replenishMoneyBtn = new JButton("Replenish Money");
        this.replenishMoneyBtn.setPreferredSize(new Dimension(330, 50));
        replenishMoneyBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        replenishMoneyBtn.setBackground(Color.PINK);

        this.displaySummaryBtn = new JButton("Display Summary");
        this.displaySummaryBtn.setPreferredSize(new Dimension(330, 50));
        displaySummaryBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        displaySummaryBtn.setBackground(Color.PINK);

        this.exitBtn = new JButton("Exit");
        this.exitBtn.setPreferredSize(new Dimension(330, 50));
        exitBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        exitBtn.setBackground(Color.PINK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1
        gbc.gridx = 0;
        panel2.add(maintenancelbl2, gbc);

        gbc.gridx = 0;
        panel2.add(stockBtn, gbc);

        gbc.gridx = 0;
        panel2.add(restockBtn, gbc);

        gbc.gridx = 0;
        panel2.add(setPriceBtn, gbc);

        gbc.gridx = 0;
        panel2.add(collectMoneyBtn, gbc);

        gbc.gridx = 0;
        panel2.add(replenishMoneyBtn, gbc);

        gbc.gridx = 0;
        panel2.add(displaySummaryBtn, gbc);

        gbc.gridx = 0;
        panel2.add(exitBtn, gbc);

        //==================================================================

        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(134, 43, 13));
        panel3.setBorder(border1); // Set border to panel3


        this.testMaintenancePanel.add(panel1, BorderLayout.NORTH);
        this.testMaintenancePanel.add(panel2, BorderLayout.CENTER);
        this.testMaintenancePanel.add(panel3, BorderLayout.SOUTH);
    }

    public void setStockBtnListener(ActionListener actionListener) {
        this.stockBtn.addActionListener(actionListener);
    }

    public void setRestockBtnListener(ActionListener actionListener) {
        this.restockBtn.addActionListener(actionListener);
    }

    public void setSetPriceBtnListener(ActionListener actionListener) {
        this.setPriceBtn.addActionListener(actionListener);
    }

    public void setCollectMoneyBtnListener(ActionListener actionListener) {
        this.collectMoneyBtn.addActionListener(actionListener);
    }

    public void setReplenishMoneyBtnListener(ActionListener actionListener) {
        this.replenishMoneyBtn.addActionListener(actionListener);
    }

    public void setDisplaySummaryBtnListener(ActionListener actionListener) {
        this.displaySummaryBtn.addActionListener(actionListener);
    }

    public void setExitBtnListener(ActionListener actionListener) {
        this.exitBtn.addActionListener(actionListener);
    }

    public JPanel getMaintenancePanel () {
        return testMaintenancePanel;
    }

}
