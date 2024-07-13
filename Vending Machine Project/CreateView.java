import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateView {

    private JPanel createPanel, panel1, panel2, panel3;
    private JLabel createLbl1, createLbl2;
    private JButton regularBtn, specialBtn, goBackBtn;

    public CreateView () {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        createPanel = new JPanel();
        createPanel.setLayout(new BorderLayout());
        createPanel.setPreferredSize(new Dimension(1000, 800));
        createPanel.setBackground(Color.WHITE);
        createPanel.setBorder(border1);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        createLbl1 = new JLabel("CREATE A VENDING MACHINE");
        createLbl1.setForeground(Color.WHITE);
        createLbl1.setFont(new Font("Ravie", Font.BOLD, 35));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(createLbl1, constraints);

        //==================================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        createLbl2 = new JLabel("Please choose an option!");
        createLbl2.setFont(new Font("Mv Boli", Font.BOLD, 15));

        regularBtn = new JButton("Regular Vending Machine");
        regularBtn.setPreferredSize(new Dimension(330, 50));
        regularBtn.setFont(new Font("Mv Boli", Font.BOLD, 20));
        regularBtn.setBackground(Color.PINK);

        specialBtn = new JButton("Special Vending Machine");
        specialBtn.setPreferredSize(new Dimension(330, 50));
        specialBtn.setFont(new Font("Mv Boli", Font.BOLD, 20));
        specialBtn.setBackground(Color.PINK);

        goBackBtn = new JButton("Go Back To Main Menu");
        goBackBtn.setPreferredSize(new Dimension(330, 50));
        goBackBtn.setFont(new Font("Mv Boli", Font.BOLD, 20));
        goBackBtn.setBackground(Color.PINK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1
        gbc.gridx = 0;
        panel2.add(createLbl2, gbc);

        gbc.gridx = 0;
        panel2.add(regularBtn, gbc);

        gbc.gridx = 0;
        panel2.add(specialBtn, gbc);

        gbc.gridx = 0;
        panel2.add(goBackBtn, gbc);

        //===============================================
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(134, 43, 13));
        panel3.setBorder(border1); // Set border to panel3


        this.createPanel.add(panel1, BorderLayout.NORTH);
        this.createPanel.add(panel2, BorderLayout.CENTER);
        this.createPanel.add(panel3, BorderLayout.SOUTH);
    }

    public void setRegularBtnListener(ActionListener actionListener) {
        this.regularBtn.addActionListener(actionListener);
    }

    public void setSpecialBtnListener(ActionListener actionListener) {
        this.specialBtn.addActionListener(actionListener);
    }

    public void setGoBackBtnListener(ActionListener actionListener) {
        this.goBackBtn.addActionListener(actionListener);
    }

    public JPanel getCreatePanel() {
        return createPanel;
    }
}
