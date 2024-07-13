import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetPriceView {
    private JPanel pricePanel, panel1, panel2, panel3, panel4, subPanel3, subPanel4b, subPanel4c, sp;
    private JTextField priceTf;
    private JButton doneBtn;
    private JPanel[] slotPanels = new JPanel[12]; // Assuming you have 12 slots
    private JLabel[] slotLbl = new JLabel[12];
    private JLabel[] slotPrice = new JLabel[12];
    private JLabel totalLbl, dispensePic, setPriceLbl;
    private JLabel[] imageLabel = new JLabel[12];
    private JTextArea totalTA, itemSelected;
    private JTextPane feedbackPane, dispensePane;
    private JButton[] slotBtn = new JButton[12];
    private JButton submitBtn;

    public SetPriceView()
    {
        Border border1 = BorderFactory.createLineBorder(new Color(146, 136, 248), 20);

        pricePanel = new JPanel(); //MAIN PANEL
        pricePanel.setLayout(new BorderLayout());
        pricePanel.setSize(1000, 800);
        pricePanel.setBackground(Color.BLACK);

        ImageIcon backgroundImage = new ImageIcon("background2.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);

        panel1 = new JPanel(); //NORTH of VENDING PANEL
        panel1.setPreferredSize(new Dimension(1000, 75));
        panel1.add(backgroundLabel);

        ImageIcon backgroundImage1 = new ImageIcon("background2.jpg");
        JLabel backgroundLabel1 = new JLabel(backgroundImage);

        panel2 = new JPanel(); //WEST of VENDING PANEL
        panel2.setPreferredSize(new Dimension(100, 700));
        panel2.add(backgroundLabel1);

        ImageIcon backgroundImage2 = new ImageIcon("background2.jpg");
        JLabel backgroundLabel2 = new JLabel(backgroundImage);

        panel3 = new JPanel(new BorderLayout()); //EAST of VENDING PANEL
        panel3.setPreferredSize(new Dimension(450, 700));
        panel3.add(backgroundLabel2);

        subPanel3 = new JPanel(new GridBagLayout()); //WEST of PANEl3
        subPanel3.setPreferredSize(new Dimension(350, 800));
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
        sp.setPreferredSize(new Dimension(500, 700));
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
            slotPrice[i].setFont(new Font("Arial", Font.BOLD, 14));
            slotPrice[i].setForeground(Color.WHITE);
            slotPrice[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotBtn[i] = new JButton("Select");
            slotBtn[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            //adding in the panel
            slotPanels[i].add(slotLbl[i]);
            slotPanels[i].add(imageLabel[i]);
            slotPanels[i].add(Box.createVerticalStrut(2));
            slotPanels[i].add(slotPrice[i]);
            slotPanels[i].add(slotBtn[i]);

            sp.add(slotPanels[i]);
        }

        //adding elements in panel3
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel selectLbl = new JLabel("Select");
        selectLbl.setFont(new Font("MV boli", Font.BOLD, 20));
        selectLbl.setOpaque(true); // Ensure the label is opaque so that the background color is visible.
        selectLbl.setBackground(new Color(128, 98, 214));
        itemSelected = new JTextArea(1, 10);
        itemSelected.setFont(new Font("MV boli", Font.BOLD, 20));

        totalLbl = new JLabel(" PRICE ");
        totalLbl.setFont(new Font("MV boli", Font.BOLD, 35));
        totalLbl.setOpaque(true); // Ensure the label is opaque so that the background color is visible.
        totalLbl.setBackground(new Color(128, 98, 214));
        totalTA = new JTextArea(1, 13);
        totalTA.setFont(new Font("Arial", Font.BOLD, 20));
        totalTA.setAlignmentX(Component.CENTER_ALIGNMENT);

        Component spacer = Box.createRigidArea(new Dimension(0, 50));

        setPriceLbl = new JLabel("SET PRICE");
        setPriceLbl.setFont(new Font("MV boli", Font.BOLD, 20));
        setPriceLbl.setOpaque(true);
        setPriceLbl.setBackground(new Color(128,98,214));

        priceTf = new JTextField();
        priceTf.setPreferredSize(new Dimension(200, 25));
        priceTf.setFont(new Font("MV boli", Font.BOLD, 15));
        priceTf.setBackground(Color.WHITE);

        submitBtn = new JButton("Submit");
        submitBtn.setPreferredSize(new Dimension(200, 25));
        submitBtn.setFont(new Font("MV boli", Font.BOLD, 15));
        submitBtn.setBackground(Color.PINK);

        this.feedbackPane = new JTextPane();
        this.feedbackPane.setPreferredSize(new Dimension(200,35));
        this.feedbackPane.setFont(new Font("MV boli", Font.BOLD, 16));
        this.feedbackPane.setForeground(new Color(0, 100, 0));
        StyledDocument doc1 = feedbackPane.getStyledDocument();
        SimpleAttributeSet center1 = new SimpleAttributeSet();
        StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
        doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);

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
        subPanel3.add(setPriceLbl, gbc);
        //ROW 6
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        subPanel3.add(priceTf, gbc);
        //ROW 7
        gbc.gridx = 0;
        gbc.gridy = 6;
        subPanel3.add(submitBtn, gbc);
        //ROW 8
        gbc.gridx = 0;
        gbc.gridy = 7;
        subPanel3.add(feedbackPane, gbc);
        //subPanel3.add(spacer, gbc);
        //ROW 9
        gbc.gridx = 0;
        gbc.gridy = 8;
        subPanel3.add(doneBtn, gbc);

        panel3.add(subPanel3, BorderLayout.WEST);
        panel4.add(subPanel4b, BorderLayout.WEST);
        panel4.add(subPanel4c, BorderLayout.EAST);
        panel4.add(dispensePane);

        pricePanel.add(panel1, BorderLayout.NORTH);
        pricePanel.add(panel2, BorderLayout.WEST);
        pricePanel.add(panel3, BorderLayout.EAST);
        pricePanel.add(panel4, BorderLayout.SOUTH);
        pricePanel.add(sp, BorderLayout.CENTER);
    }

    public JPanel getPricePanel()
    {
        return pricePanel;
    }

    public String getPriceTf()
    {
        return priceTf.getText();
    }
    public void setTextLbl (int slotIndex, String text) {
        this.slotLbl[slotIndex].setText(text);
    }
    public void setPriceTextLbl (int slotIndex, String text) {
        this.slotPrice[slotIndex].setText("Price: " + text);
    }
    public void setImageIcon (int slotIndex, String fileName) {
        ImageIcon imageIcon = new ImageIcon(fileName);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        this.imageLabel[slotIndex].setIcon(scaledImageIcon);
    }
    public void setItemSelectedTextArea (String text) {
        this.itemSelected.setText(text);
    }
    public void setFeedbackPaneText (String text) {
        feedbackPane.setText(text);
    }
    public String getItemSelectedText () {
        return itemSelected.getText();
    }
    public void setTotalTA (String text) {
        totalTA.setText(text);
    }
    public void clearTextField () {
        this.itemSelected.setText("");
        this.totalTA.setText("");
        this.priceTf.setText("");
    }
    public void clearPane () {
        this.feedbackPane.setText("");
    }
    public void setSlotBtnListener (int index, ActionListener actionListener) {
        this.slotBtn[index].addActionListener(actionListener);
    }
    public void setSubmitBtnListener (ActionListener actionListener) {
        this.submitBtn.addActionListener(actionListener);
    }
    public void setDoneBtnListener (ActionListener actionListener) {
        this.doneBtn.addActionListener(actionListener);
    }
}