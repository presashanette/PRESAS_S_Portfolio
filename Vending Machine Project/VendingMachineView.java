import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class VendingMachineView {
    private JPanel panel1, panel2, panel3, panel4, subPanel3, subPanel4a, subPanel4b, subPanel4c, subPanel4d, vendingPanel, sp;
    private JPanel[] slotPanels = new JPanel[12]; // Assuming you have 12 slots
    private JLabel[] slotLbl = new JLabel[12];
    private JLabel[] slotPrice = new JLabel[12];
    private JLabel[] slotCal = new JLabel[12];
    private JLabel[] slotStock = new JLabel[12];
    private JLabel totalLbl, dispensePic;
    private JLabel[] imageLabel = new JLabel[12];
    private JTextArea totalTA, itemSelected;
    private JTextPane feedbackPane, dispensePane;
    private JButton[] slotBtn = new JButton[12];
    private JButton paymentBtn, doneBtn;
    private JScrollPane scrollPane;

    public VendingMachineView() {
        Border border1 = BorderFactory.createLineBorder(new Color(146, 136, 248), 20);

        vendingPanel = new JPanel(); //MAIN PANEL
        vendingPanel.setLayout(new BorderLayout());
        vendingPanel.setSize(1000, 800);
        vendingPanel.setBackground(Color.BLACK);

        ImageIcon backgroundImage = new ImageIcon("background2.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);

        panel1 = new JPanel(); //NORTH of VENDING PANEL
        panel1.setPreferredSize(new Dimension(1000, 50));
        panel1.add(backgroundLabel);

        ImageIcon backgroundImage1 = new ImageIcon("background2.jpg");
        JLabel backgroundLabel1 = new JLabel(backgroundImage);

        panel2 = new JPanel(); //WEST of VENDING PANEL
        panel2.setPreferredSize(new Dimension(100, 650));
        panel2.add(backgroundLabel1);

        ImageIcon backgroundImage2 = new ImageIcon("background2.jpg");
        JLabel backgroundLabel2 = new JLabel(backgroundImage);

        panel3 = new JPanel(new BorderLayout()); //EAST of VENDING PANEL
        panel3.setPreferredSize(new Dimension(450, 650));
        panel3.add(backgroundLabel2);

        subPanel3 = new JPanel(new GridBagLayout()); //WEST of PANEl3
        subPanel3.setPreferredSize(new Dimension(350, 650));
        subPanel3.setBackground(new Color(50, 38, 53));
        subPanel3.setBorder(border1);

        panel4 = new JPanel(new BorderLayout()); //SOUTH of VENDING PANEL
        panel4.setPreferredSize(new Dimension(1000, 150));
        panel4.setBackground(new Color(50, 38, 53));

        ImageIcon backgroundImage4 = new ImageIcon("background2.jpg");
        JLabel backgroundLabel4 = new JLabel(backgroundImage);

        subPanel4b = new JPanel(new GridLayout());
        subPanel4b.setPreferredSize(new Dimension(100, 200));
        subPanel4b.add(backgroundLabel4);

        ImageIcon backgroundImage5 = new ImageIcon("background2.jpg");
        JLabel backgroundLabel5 = new JLabel(backgroundImage);

        subPanel4c = new JPanel(new BorderLayout());
        subPanel4c.setPreferredSize(new Dimension(100, 1000));
        subPanel4c.add(backgroundLabel5);

        this.dispensePane = new JTextPane();
        this.dispensePane.setLayout(new FlowLayout());
        this.dispensePane.setPreferredSize(new Dimension(800, 150));
        this.dispensePane.setFont(new Font("MV boli", Font.BOLD, 14));
        this.dispensePane.setForeground(new Color(0, 100, 0));
        this.dispensePane.setBackground(new Color(50, 38, 53));
        dispensePic = new JLabel();

        sp = new JPanel(); //panel for ALL THE SLOTS
        int rows = 4;
        int columns = 3;
        sp.setLayout(new GridLayout(rows, columns, 10, 5)); // Adjust the spacing between slots if needed
        sp.setPreferredSize(new Dimension(500, 650));
        sp.setBackground(new Color(128, 98, 214));
        sp.setBorder(border1);

        //panel per slot
        for (int i = 0; i < slotPanels.length; i++) {
            slotPanels[i] = new JPanel();
            slotPanels[i].setLayout(new BoxLayout(slotPanels[i], BoxLayout.Y_AXIS));
            slotPanels[i].setPreferredSize(new Dimension(150, 200)); // Adjust the size as needed
            slotPanels[i].setBackground(new Color(50, 38, 53));

            slotLbl[i] = new JLabel(); //name of the item
            slotLbl[i].setFont(new Font("MV boli", Font.BOLD, 18));
            slotLbl[i].setForeground(Color.WHITE);
            slotLbl[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            imageLabel[i] = new JLabel(); //image of the item
            imageLabel[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotPrice[i] = new JLabel(); //name of the item
            slotPrice[i].setFont(new Font("Arial", Font.BOLD, 12));
            slotPrice[i].setForeground(Color.WHITE);
            slotPrice[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotCal[i] = new JLabel(); //name of the item
            slotCal[i].setFont(new Font("Arial", Font.BOLD, 12));
            slotCal[i].setForeground(Color.WHITE);
            slotCal[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotStock[i] = new JLabel(); //stocks of the item
            slotStock[i].setFont(new Font("Arial", Font.BOLD, 12));
            slotStock[i].setForeground(Color.WHITE);
            slotStock[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotBtn[i] = new JButton("Select");
            slotBtn[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            //adding in the panel
            slotPanels[i].add(slotLbl[i]);
            slotPanels[i].add(imageLabel[i]);
//            slotPanels[i].add(Box.createVerticalStrut(2));
            slotPanels[i].add(slotPrice[i]);
//            slotPanels[i].add(Box.createVerticalStrut(2));
            slotPanels[i].add(slotCal[i]);
//            slotPanels[i].add(Box.createVerticalStrut(2));
            slotPanels[i].add(slotStock[i]);
            slotPanels[i].add(slotBtn[i]);

            sp.add(slotPanels[i]);
        }

        //adding elements in panel3
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel selectLbl = new JLabel("Select");
        selectLbl.setFont(new Font("MV boli", Font.BOLD, 16));
        selectLbl.setOpaque(true); // Ensure the label is opaque so that the background color is visible.
        selectLbl.setBackground(new Color(128, 98, 214));
        itemSelected = new JTextArea(1, 8);
        itemSelected.setFont(new Font("MV boli", Font.BOLD, 16));

        totalLbl = new JLabel(" TOTAL ");
        totalLbl.setFont(new Font("MV boli", Font.BOLD, 25));
        totalLbl.setOpaque(true); // Ensure the label is opaque so that the background color is visible.
        totalLbl.setBackground(new Color(128, 98, 214));
        totalTA = new JTextArea(1, 13);
        totalTA.setFont(new Font("Arial", Font.BOLD, 16));

        Component spacer = Box.createRigidArea(new Dimension(0, 25));

        paymentBtn = new JButton("PAYMENT");
        paymentBtn.setPreferredSize(new Dimension(200, 20));
        paymentBtn.setFont(new Font("MV boli", Font.BOLD, 18));
        paymentBtn.setBackground(new Color(250,227,146));
        paymentBtn.setForeground(Color.BLACK);

        this.feedbackPane = new JTextPane();
        this.feedbackPane.setPreferredSize(new Dimension(300, 300));
        this.feedbackPane.setFont(new Font("MV boli", Font.BOLD, 14));
        this.feedbackPane.setForeground(new Color(0, 100, 0));
        StyledDocument doc1 = feedbackPane.getStyledDocument();
        SimpleAttributeSet center1 = new SimpleAttributeSet();
        StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
        doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);

        scrollPane = new JScrollPane(feedbackPane);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        doneBtn = new JButton("DONE");
        doneBtn.setPreferredSize(new Dimension(200, 25));
        doneBtn.setFont(new Font("MV boli", Font.BOLD, 20));
        doneBtn.setBackground(new Color(250,227,146));
        doneBtn.setForeground(Color.BLACK);

        //ROW 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        subPanel3.add(selectLbl, gbc);
        //ROW 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        subPanel3.add(itemSelected, gbc);
        //ROW 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        subPanel3.add(totalLbl, gbc);
        //ROW 4
        gbc.gridx = 0;
        gbc.gridy = 3;
        subPanel3.add(totalTA, gbc);
        //ROW 5
        gbc.gridx = 0;
        gbc.gridy = 4;
        subPanel3.add(paymentBtn, gbc);
        //ROW 6
        gbc.gridx = 0;
        gbc.gridy = 5;
        subPanel3.add(scrollPane, gbc);
        //ROW 7
        gbc.gridx = 0;
        gbc.gridy = 6;
        subPanel3.add(spacer, gbc);
        //ROW 8
        gbc.gridx = 0;
        gbc.gridy = 7;
        subPanel3.add(doneBtn, gbc);

        panel3.add(subPanel3, BorderLayout.WEST);
        panel4.add(subPanel4b, BorderLayout.WEST);
        panel4.add(subPanel4c, BorderLayout.EAST);
        panel4.add(dispensePane);

        vendingPanel.add(panel1, BorderLayout.NORTH);
        vendingPanel.add(panel2, BorderLayout.WEST);
        vendingPanel.add(panel3, BorderLayout.EAST);
        vendingPanel.add(panel4, BorderLayout.SOUTH);
        vendingPanel.add(sp, BorderLayout.CENTER);
    }

    public void setTextLbl (int slotIndex, String text) {
        this.slotLbl[slotIndex].setText(text);
    }
    public void setPriceTextLbl (int slotIndex, String text) {
        this.slotPrice[slotIndex].setText("Price: " + text);
    }
    public void setCalTextLbl (int slotIndex, String text) {
        this.slotCal[slotIndex].setText("Cal: " + text);
    }
    public void setStockLbl (int slotIndex, String text) {
        this.slotStock[slotIndex].setText("Stocks: " + text);
    }
    public void setImageIcon (int slotIndex, String fileName) {
        ImageIcon imageIcon = new ImageIcon(fileName);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        this.imageLabel[slotIndex].setIcon(scaledImageIcon);
    }
    public void setSelectPane (String text) {
        this.itemSelected.setText(text);
    }
    public void setFeedBackPane (String text) {
        feedbackPane.setText(text);
        feedbackPane.setCaretPosition(0);
    }
    public void setDispensePane (String fileName) {
        ImageIcon imageIcon = new ImageIcon(fileName);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        dispensePic.setIcon(scaledImageIcon);

        dispensePane.add(dispensePic);

    }
    public String getItemSelectedText () {
        return itemSelected.getText();
    }
    public void setTotalTA (String text) {
        totalTA.setText(text);
    }
    public String getTotalTA () {
        return totalTA.getText();
    }

    public void clearTextField () {
        this.itemSelected.setText("");
        this.totalTA.setText("");
    }
    public void clearPane () {
        this.feedbackPane.setText("");
    }
    public void setSlotBtnListener (int index, ActionListener actionListener) {
        this.slotBtn[index].addActionListener(actionListener);
    }
    public void setPaymentBtnListener (ActionListener actionListener) {
        this.paymentBtn.addActionListener(actionListener);
    }

    public void setDoneBtnListener (ActionListener actionListener) {
        this.doneBtn.addActionListener(actionListener);
    }
    public JPanel getVendingPanel()
    {
        return vendingPanel;
    }
}