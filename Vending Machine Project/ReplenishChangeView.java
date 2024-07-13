import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReplenishChangeView {

    private JPanel replenishPanel, panel1, panel2, panel3;
    private JLabel titleLbl;
    private JLabel[] moneyLbl = new JLabel[10];
    private JButton[] addBtn = new JButton[10];
    private JTextArea[] moneyTextArea = new JTextArea[10];
    private JButton[] minusBtn = new JButton[10];
    private JButton doneBtn;

    public ReplenishChangeView () {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        replenishPanel = new JPanel();
        replenishPanel.setLayout(new BorderLayout());
        replenishPanel.setPreferredSize(new Dimension(1000, 800));
        replenishPanel.setBackground(Color.WHITE);
        replenishPanel.setBorder(border1);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        titleLbl = new JLabel("Replenish Money");
        titleLbl.setFont(new Font("Ravie", Font.BOLD, 40)); // Set font for the title
        titleLbl.setForeground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(titleLbl, constraints);


        //==========================================================================
        constraints.gridwidth = 1;

        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        moneyLbl[1] = new JLabel("Money Denomination 1.0");
        moneyLbl[2] = new JLabel("Money Denomination 5.0");
        moneyLbl[3] = new JLabel("Money Denomination 10.0");
        moneyLbl[4] = new JLabel("Money Denomination 20.0");
        moneyLbl[5] = new JLabel("Money Denomination 50.0");
        moneyLbl[6] = new JLabel("Money Denomination 100.0");
        moneyLbl[7] = new JLabel("Money Denomination 200.0");
        moneyLbl[8] = new JLabel("Money Denomination 500.0");
        moneyLbl[9] = new JLabel("Money Denomination 1000.0");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 1; i <= 9; i++) {
            moneyLbl[i].setFont(new Font("Arial", Font.BOLD, 15));

            minusBtn[i] = new JButton("-");
            minusBtn[i].setFont(new Font("Arial", Font.BOLD, 15));
            minusBtn[i].setPreferredSize(new Dimension(50, 25));

            moneyTextArea[i] = new JTextArea(2, 5);
            moneyTextArea[i].setPreferredSize(new Dimension(50, 30));
            moneyTextArea[i].setFont(new Font("MV boli", Font.BOLD, 20));

            addBtn[i] = new JButton("+");
            addBtn[i].setFont(new Font("Arial", Font.BOLD, 15));
            addBtn[i].setPreferredSize(new Dimension(50, 25));

            gbc.gridx = 0;
            gbc.gridy = i-1;
            panel2.add(moneyLbl[i], gbc);

            gbc.gridx = 1;
            panel2.add(minusBtn[i], gbc);

            gbc.gridx = 2;
            panel2.add(moneyTextArea[i], gbc);

            gbc.gridx = 3;
            panel2.add(addBtn[i], gbc);
        }

        //==========================================================================
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(134, 43, 13));
        panel3.setBorder(border1); // Set border to panel3

        doneBtn = new JButton("DONE");
        doneBtn.setPreferredSize(new Dimension(200, 50));
        doneBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setForeground(Color.BLACK);

        panel3.add(doneBtn);

        replenishPanel.add(panel1, BorderLayout.NORTH);
        replenishPanel.add(panel2, BorderLayout.CENTER);
        replenishPanel.add(panel3, BorderLayout.SOUTH);
    }

    //add
    public void setAddBtn1Listener (ActionListener actionListener) {
        this.addBtn[1].addActionListener(actionListener);
    }
    public void setAddBtn5Listener (ActionListener actionListener) {
        this.addBtn[2].addActionListener(actionListener);
    }
    public void setAddBtn10Listener (ActionListener actionListener) {
        this.addBtn[3].addActionListener(actionListener);
    }
    public void setAddBtn20Listener (ActionListener actionListener) {
        this.addBtn[4].addActionListener(actionListener);
    }
    public void setAddBtn50Listener (ActionListener actionListener) {
        this.addBtn[5].addActionListener(actionListener);
    }
    public void setAddBtn100Listener (ActionListener actionListener) {
        this.addBtn[6].addActionListener(actionListener);
    }
    public void setAddBtn200Listener (ActionListener actionListener) {
        this.addBtn[7].addActionListener(actionListener);
    }
    public void setAddBtn500Listener (ActionListener actionListener) {
        this.addBtn[8].addActionListener(actionListener);
    }
    public void setAddBtn1000Listener (ActionListener actionListener) {
        this.addBtn[9].addActionListener(actionListener);
    }

    //minus
    public void setMinusBtn1Listener (ActionListener actionListener) {
        this.minusBtn[1].addActionListener(actionListener);
    }
    public void setMinusBtn5Listener (ActionListener actionListener) {
        this.minusBtn[2].addActionListener(actionListener);
    }
    public void setMinusBtn10Listener (ActionListener actionListener) {
        this.minusBtn[3].addActionListener(actionListener);
    }
    public void setMinusBtn20Listener (ActionListener actionListener) {
        this.minusBtn[4].addActionListener(actionListener);
    }
    public void setMinusBtn50Listener (ActionListener actionListener) {
        this.minusBtn[5].addActionListener(actionListener);
    }
    public void setMinusBtn100Listener (ActionListener actionListener) {
        this.minusBtn[6].addActionListener(actionListener);
    }
    public void setMinusBtn200Listener (ActionListener actionListener) {
        this.minusBtn[7].addActionListener(actionListener);
    }
    public void setMinusBtn500Listener (ActionListener actionListener) {
        this.minusBtn[8].addActionListener(actionListener);
    }
    public void setMinusBtn1000Listener (ActionListener actionListener) {
        this.minusBtn[9].addActionListener(actionListener);
    }

    //TextArea
    public void setMoneyTextArea1(String text) {
        this.moneyTextArea[1].setText(text);
    }
    public void setMoneyTextArea5(String text) {
        this.moneyTextArea[2].setText(text);
    }
    public void setMoneyTextArea10(String text) {
        this.moneyTextArea[3].setText(text);
    }
    public void setMoneyTextArea20(String text) {
        this.moneyTextArea[4].setText(text);
    }
    public void setMoneyTextArea50(String text) {
        this.moneyTextArea[5].setText(text);
    }
    public void setMoneyTextArea100(String text) {
        this.moneyTextArea[6].setText(text);
    }
    public void setMoneyTextArea200(String text) {
        this.moneyTextArea[7].setText(text);
    }
    public void setMoneyTextArea500(String text) {
        this.moneyTextArea[8].setText(text);
    }
    public void setMoneyTextArea1000(String text) {
        this.moneyTextArea[9].setText(text);
    }

    public void setDoneBtnListener (ActionListener actionListener) {
        doneBtn.addActionListener(actionListener);
    }

    public JPanel getReplenishPanel () {
        return replenishPanel;
    }
}