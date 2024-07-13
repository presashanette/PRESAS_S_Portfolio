import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaymentView {
    private JDialog paymentDialog;
    private JPanel paymentPanel, panel1, panel2, panel3,  panels[] = new JPanel[9];
    private JLabel titleLbl, guideLbl, paymentLbl;
    private JTextField moneyTf;
    private JTextPane feedbackPane;
    private JButton enterBtn, doneBtn;
    private JLabel[] imageLabel = new JLabel[9];
    private String[] peso = {"1Peso", "5Peso", "10Peso", "20Peso", "50Peso", "100Peso", "200Peso", "500Peso", "1000Peso"};

    public PaymentView() {
        Border border1 = BorderFactory.createLineBorder(new Color(146, 136, 248), 20);
//        paymentDialog = new JDialog((Frame) null, "Payment", true);
//        paymentDialog.setPreferredSize(new Dimension(700, 725));
//        paymentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        paymentPanel = new JPanel(new BorderLayout());
        paymentPanel.setSize(500, 500);
        paymentPanel.setBackground(new Color(146, 136, 248));

        titleLbl = new JLabel("Payment");
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setFont(new Font("Ravie", Font.BOLD, 40));

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(500, 150));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(titleLbl, constraints);
        //==================================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(500, 500));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        guideLbl = new JLabel("Enter bill: ");
        guideLbl.setFont(new Font("MV boli", Font.BOLD, 15));

        paymentLbl = new JLabel("COLLECT: ");
        paymentLbl.setFont(new Font("MV boli", Font.BOLD, 20));

        moneyTf = new JTextField();
        moneyTf.setPreferredSize(new Dimension(275, 40));
        moneyTf.setFont(new Font("MV boli", Font.BOLD, 20));
        moneyTf.setAlignmentX(Component.LEFT_ALIGNMENT);
        moneyTf.setBackground(Color.WHITE);

        enterBtn = new JButton("ENTER");
        enterBtn.setPreferredSize(new Dimension(200, 50));
        enterBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        enterBtn.setBackground(Color.WHITE);
        enterBtn.setForeground(Color.BLACK);

        this.feedbackPane = new JTextPane();
        this.feedbackPane.setPreferredSize(new Dimension(350, 50));
        this.feedbackPane.setFont(new Font("MV boli", Font.BOLD, 20));
        this.feedbackPane.setForeground(new Color(0, 100, 0));
        StyledDocument doc = feedbackPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 4
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel2.add(guideLbl, gbc);

        //Row 5
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel2.add(paymentLbl, gbc);

        gbc.gridx = 1;
        panel2.add(moneyTf, gbc);

        //row 6
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel2.add(enterBtn, gbc);

        //Row 7
        gbc.gridx = 1;
        gbc.gridy = 5;

        panel2.add(feedbackPane, gbc);
        //==========================================================================
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout with center alignment
        panel3.setPreferredSize(new Dimension(1000, 75));
        panel3.setBackground(new Color(146, 136, 248));
        panel3.setBorder(border1); // Set border to panel3

        doneBtn = new JButton("DONE");
        doneBtn.setPreferredSize(new Dimension(200, 40));
        doneBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setForeground(Color.BLACK);

        panel3.add(doneBtn);

        paymentPanel.add(panel1, BorderLayout.NORTH);
        paymentPanel.add(panel2, BorderLayout.CENTER);
        paymentPanel.add(panel3, BorderLayout.SOUTH);

//        paymentDialog.add(paymentPanel);
//        paymentDialog.pack();
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (screenSize.width - paymentDialog.getWidth()) / 2;
//        int y = (screenSize.height - paymentDialog.getHeight()) / 2;
//        paymentDialog.setLocation(x, y);
//
//        paymentDialog.setVisible(true);
    }

    public void setImageIcon() {
        for (int i = 0; i < peso.length; i++) {
            ImageIcon imageIcon = new ImageIcon(peso[i]+".png");
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

            imageLabel[i].setIcon(scaledImageIcon);
        }
    }
    public JPanel getPaymentPanel () {
        return paymentPanel;
    }

//    public static void main(String[] args) {
//        PaymentView paymentView = new PaymentView();
//    }

    public String getMoneyTextField () {
        return moneyTf.getText();
    }

    public void clearTextField() {
        moneyTf.setText("");
    }

    public void setFeedbackPane (String text) {
        this.feedbackPane.setText(text);
    }

    public void setEnterBtnListener (ActionListener actionListener) {
        this.enterBtn.addActionListener(actionListener);
    }

    public void setDoneBtnListener (ActionListener actionListener) {
        this.doneBtn.addActionListener(actionListener);
    }

}
