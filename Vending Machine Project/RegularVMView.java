import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegularVMView {

    private JPanel regularPanel, panel1, panel2, panel3;
    private JButton submitBtn, goBackBtn;
    private JLabel regularLbl1, slotLbl, capacityLbl, slotLbl2;
    private JTextField capacityTf;
    private JTextPane feedbackPane;

    public RegularVMView () {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        regularPanel = new JPanel();
        regularPanel.setLayout(new BorderLayout());
        regularPanel.setPreferredSize(new Dimension(1000, 800));
        regularPanel.setBackground(Color.WHITE);
        regularPanel.setBorder(border1);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        regularLbl1 = new JLabel("CREATE A REGULAR VENDING MACHINE");
        regularLbl1.setForeground(Color.WHITE);
        regularLbl1.setFont(new Font("Ravie", Font.BOLD, 30));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(regularLbl1, constraints);

        //=============================================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        this.slotLbl = new JLabel("The number of slots: ");
        this.slotLbl.setFont(new Font("Mv boli", Font.BOLD, 20));
        this.slotLbl.setForeground(Color.red);

        this.capacityLbl = new JLabel("Enter capacity per slot [should be >= 10]: ");
        this.capacityLbl.setFont(new Font("Mv boli", Font.BOLD, 20));
        this.capacityLbl.setForeground(Color.red);

        this.feedbackPane = new JTextPane();
        this.feedbackPane.setPreferredSize(new Dimension(400, 30));
        this.feedbackPane.setFont(new Font("MV boli", Font.BOLD, 16));
        this.feedbackPane.setForeground(new Color(0, 100, 0));
        StyledDocument doc = feedbackPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        this.slotLbl2 = new JLabel();
        this.slotLbl2.setText("12");
        this.slotLbl2.setPreferredSize(new Dimension(275, 40));
        this.slotLbl2.setFont(new Font("MV boli", Font.BOLD, 20));
        slotLbl2.setBackground(Color.WHITE);
        slotLbl2.setHorizontalAlignment(SwingConstants.CENTER);
        slotLbl2.setVerticalAlignment(SwingConstants.CENTER);

        this.capacityTf = new JTextField();
        this.capacityTf.setPreferredSize(new Dimension(275, 40));
        this.capacityTf.setFont(new Font("MV boli", Font.BOLD, 20));
        capacityTf.setBackground(Color.WHITE);

        this.submitBtn = new JButton("Submit");
        this.submitBtn.setPreferredSize(new Dimension(275, 40));
        this.submitBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        this.submitBtn.setBackground(Color.PINK);

        goBackBtn = new JButton("Go Back To Main Menu");
        goBackBtn.setPreferredSize(new Dimension(275, 40));
        goBackBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        goBackBtn.setBackground(Color.PINK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(slotLbl, gbc);

        gbc.gridx = 1;
        panel2.add(slotLbl2, gbc);

        // Row 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(capacityLbl, gbc);

        gbc.gridx = 1;
        panel2.add(capacityTf, gbc);

        //row 3
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel2.add(submitBtn, gbc);

        //Row 4
        gbc.gridx = 1;
        gbc.gridy = 3;

        panel2.add(feedbackPane, gbc);

        //Row 4
        gbc.gridx = 1;
        gbc.gridy = 4;

        panel2.add(goBackBtn, gbc);

        //==========================================================================

        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(134, 43, 13));
        panel3.setBorder(border1); // Set border to panel3

        regularPanel.add(panel1, BorderLayout.NORTH);
        regularPanel.add(panel2, BorderLayout.CENTER);
        regularPanel.add(panel3, BorderLayout.SOUTH);

    }

    public void setSubmitBtnListener (ActionListener actionListener) {
        this.submitBtn.addActionListener(actionListener);
    }

    public void setGoBackBtnListener (ActionListener actionListener) {
        this.goBackBtn.addActionListener(actionListener);
    }

    public void setFeedbackPaneText (String text) {
        this.feedbackPane.setText(text);
    }

    public String getCapacityTf() {
        return this.capacityTf.getText();
    }

    public void clearTextFields() {
        this.capacityTf.setText("");
    }

    public JPanel getRegularPanel () {
        return regularPanel;
    }
}
