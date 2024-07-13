import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView {

    private JPanel panel, panel1, panel2, panel3;
    private JLabel welcomeLbl1, welcomeLbl2;
    private JButton createBtn, testBtn, exitBtn;

    public MenuView () {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setPreferredSize(new Dimension(1000, 800));
        this.panel.setBackground(new Color(242, 234, 211));

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        this.welcomeLbl1 = new JLabel("VENDING MACHINE FACTORY");
        this.welcomeLbl1.setFont(new Font("Ravie", Font.BOLD, 40));
        this.welcomeLbl1.setForeground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(welcomeLbl1, constraints);

        //=================================================================

        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        this.welcomeLbl2 = new JLabel("Please choose an option!");
        this.welcomeLbl2.setFont(new Font("MV boli", Font.BOLD, 15));
        this.welcomeLbl2.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.createBtn = new JButton("Create Vending Machine");
        this.createBtn.setPreferredSize(new Dimension(330, 50));
        this.createBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        this.createBtn.setBackground(Color.PINK);

        this.testBtn = new JButton("Test Vending Machine");
        this.testBtn.setPreferredSize(new Dimension(330, 50));
        this.testBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        this.testBtn.setBackground(new Color(119,221,119));

        this.exitBtn = new JButton("Exit");
        this.exitBtn.setPreferredSize(new Dimension(330, 50));
        this.exitBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        this.exitBtn.setBackground(new Color(255,105,97));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1
        gbc.gridx = 0;
        panel2.add(welcomeLbl2, gbc);

        gbc.gridx = 0;
        panel2.add(createBtn, gbc);

        gbc.gridx = 0;
        panel2.add(testBtn, gbc);

        gbc.gridx = 0;
        panel2.add(exitBtn, gbc);

        //===============================================
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(134, 43, 13));
        panel3.setBorder(border1); // Set border to panel3


        this.panel.add(panel1, BorderLayout.NORTH);
        this.panel.add(panel2, BorderLayout.CENTER);
        this.panel.add(panel3, BorderLayout.SOUTH);
    }

    public void setCreateBtnListener(ActionListener actionListener) {
        this.createBtn.addActionListener(actionListener);
    }

    public void setTestBtnListener(ActionListener actionListener) {
        this.testBtn.addActionListener(actionListener);
    }

    public void setExitButton(ActionListener actionListener) {
        this.exitBtn.addActionListener(actionListener);
    }

    public JPanel getMenuPanel () {
        return panel;
    }
}
