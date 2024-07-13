import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CollectMoneyView {

    private JPanel collectPanel, panel1, panel2, panel3;
    private JLabel titleLbl, totalLbl, collectLbl, guideLbl;
    private JTextArea salesTA, initialTA, totalTA;
    private JTextField moneyTf;
    private JButton enterBtn, doneBtn;
    private JTextPane feedbackPane;
    private JScrollPane scrollPane;

    public CollectMoneyView() {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        collectPanel = new JPanel();
        collectPanel.setLayout(new BorderLayout());
        collectPanel.setPreferredSize(new Dimension(1000, 800));
        collectPanel.setBackground(Color.WHITE);
        collectPanel.setBorder(border1);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        titleLbl = new JLabel("COLLECT MONEY");
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setFont(new Font("Ravie", Font.BOLD, 40));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(titleLbl, constraints);

        //==========================================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        totalLbl = new JLabel("TOTAL: ");
        totalLbl.setFont(new Font("MV boli", Font.BOLD, 20));

        guideLbl = new JLabel("Enter the amount you want to collect:");
        guideLbl.setFont(new Font("MV boli", Font.BOLD, 15));

        collectLbl = new JLabel("COLLECT: ");
        collectLbl.setFont(new Font("MV boli", Font.BOLD, 20));

        moneyTf = new JTextField();
        moneyTf.setPreferredSize(new Dimension(275, 40));
        moneyTf.setFont(new Font("MV boli", Font.BOLD, 20));
        moneyTf.setAlignmentX(Component.LEFT_ALIGNMENT);
        moneyTf.setBackground(Color.WHITE);

        salesTA = new JTextArea(1, 15);
        salesTA.setFont(new Font("Arial", Font.BOLD, 20));
        initialTA = new JTextArea(1, 15);
        initialTA.setFont(new Font("Arial", Font.BOLD, 20));
        totalTA = new JTextArea(1, 15);
        totalTA.setFont(new Font("Arial", Font.BOLD, 20));

        enterBtn = new JButton("ENTER");
        enterBtn.setPreferredSize(new Dimension(200, 50));
        enterBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        enterBtn.setBackground(Color.WHITE);
        enterBtn.setForeground(Color.BLACK);

        this.feedbackPane = new JTextPane();
        this.feedbackPane.setPreferredSize(new Dimension(400, 200));
        this.feedbackPane.setFont(new Font("MV boli", Font.BOLD, 18));
        this.feedbackPane.setForeground(new Color(0, 100, 0));
        StyledDocument doc = feedbackPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        scrollPane = new JScrollPane(feedbackPane);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 3
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(totalLbl, gbc);

        gbc.gridx = 1;
        panel2.add(totalTA, gbc);

        // Row 4
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel2.add(guideLbl, gbc);

        //Row 5
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel2.add(collectLbl, gbc);

        gbc.gridx = 1;
        panel2.add(moneyTf, gbc);

        //row 6
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel2.add(enterBtn, gbc);

        //Row 7
        gbc.gridx = 1;
        gbc.gridy = 5;

        panel2.add(scrollPane, gbc);

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

        collectPanel.add(panel1, BorderLayout.NORTH);
        collectPanel.add(panel2, BorderLayout.CENTER);
        collectPanel.add(panel3, BorderLayout.SOUTH);
    }

    public void setDoneBtnListener (ActionListener actionListener) {
        doneBtn.addActionListener(actionListener);
    }
    public void setEnterBtnListener (ActionListener actionListener) {
        enterBtn.addActionListener(actionListener);
    }
    public void setTotalTA (String text) {
        totalTA.setText(text);
    }
    public void setFeedBackPane (String text) {
        feedbackPane.setText(text);
    }
    public String getMoneyTfText () {
        return this.moneyTf.getText();
    }

    public void clearTextFields () {
        this.moneyTf.setText("");
    }
    public void clearPane () {
        this.feedbackPane.setText("");
    }
    public JPanel getCollectPanel () {
        return collectPanel;
    }
}
