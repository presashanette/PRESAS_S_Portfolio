import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestMenuView {

    private JPanel testMenuPanel, panel1, panel2, panel3;

    private JLabel testLbl1, testLbl2;
    private JButton featuresBtn, maintenanceBtn, goBackBtn;

    public TestMenuView () {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        testMenuPanel = new JPanel();
        testMenuPanel.setLayout(new BorderLayout());
        testMenuPanel.setPreferredSize(new Dimension(1000, 800));
        testMenuPanel.setBackground(Color.WHITE);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        testLbl1 = new JLabel("TEST A VENDING MACHINE");
        testLbl1.setForeground(Color.WHITE);
        testLbl1.setFont(new Font("Ravie", Font.BOLD, 35));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(testLbl1, constraints);

        //=============================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        testLbl2 = new JLabel("Please choose an option!");
        testLbl2.setFont(new Font("Mv boli", Font.PLAIN, 15));

        featuresBtn = new JButton("Test Vending Machine Features");
        featuresBtn.setPreferredSize(new Dimension(330, 50));
        featuresBtn.setFont(new Font("Mv boli", Font.BOLD, 18));
        featuresBtn.setBackground(Color.PINK);

        maintenanceBtn = new JButton("Test Maintenance");
        maintenanceBtn.setPreferredSize(new Dimension(330, 50));
        maintenanceBtn.setFont(new Font("Mv boli", Font.BOLD, 20));
        maintenanceBtn.setBackground(Color.PINK);

        goBackBtn = new JButton("Go Back To Main Menu");
        goBackBtn.setPreferredSize(new Dimension(330, 50));
        goBackBtn.setFont(new Font("Mv boli", Font.BOLD, 20));
        goBackBtn.setBackground(Color.PINK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1
        gbc.gridx = 0;
        panel2.add(testLbl2, gbc);

        gbc.gridx = 0;
        panel2.add(featuresBtn, gbc);

        gbc.gridx = 0;
        panel2.add(maintenanceBtn, gbc);

        gbc.gridx = 0;
        panel2.add(goBackBtn, gbc);

        //===============================================
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(134, 43, 13));
        panel3.setBorder(border1); // Set border to panel3


        this.testMenuPanel.add(panel1, BorderLayout.NORTH);
        this.testMenuPanel.add(panel2, BorderLayout.CENTER);
        this.testMenuPanel.add(panel3, BorderLayout.SOUTH);
    }

    public void setFeaturesBtnListener(ActionListener actionListener) {
        this.featuresBtn.addActionListener(actionListener);
    }

    public void setMaintenanceBtnListener(ActionListener actionListener) {
        this.maintenanceBtn.addActionListener(actionListener);
    }

    public void setGoBackBtnListener(ActionListener actionListener) {
        this.goBackBtn.addActionListener(actionListener);
    }

    public JPanel getTestMenuPanel() {
        return testMenuPanel;
    }

}
