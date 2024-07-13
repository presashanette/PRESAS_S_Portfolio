import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class RestockView {
    private JPanel restockPanel, panel1, panel2, panel3, panel4, subPanel3, subPanel4b, subPanel4c, sp, panel3a;
    private JButton doneBtn;
    private JPanel[] slotPanels = new JPanel[12]; // Assuming you have 12 slots
    private JLabel[] slotLbl = new JLabel[12];
    private JLabel[] slotStock = new JLabel[12];
    private JLabel stockLbl, stockLbl2;  //check this
    private JLabel[] imageLabel = new JLabel[12];
    private JTextArea stockTA, itemSelected, curStockTA;
    private JTextPane feedbackPane, dispensePane;
    private JButton[] slotBtn = new JButton[12];
    private JButton submitBtn, minusBtn, addBtn;

    public RestockView()
    {
        Border border1 = BorderFactory.createLineBorder(new Color(146, 136, 248), 20);

        restockPanel = new JPanel(); //MAIN PANEL
        restockPanel.setLayout(new BorderLayout());
        restockPanel.setSize(1000, 800);
        restockPanel.setBackground(Color.BLACK);

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

            slotStock[i] = new JLabel(); //stocks of the item
            slotStock[i].setFont(new Font("Arial", Font.BOLD, 14));
            slotStock[i].setForeground(Color.WHITE);
            slotStock[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotBtn[i] = new JButton("Select");
            slotBtn[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            //adding in the panel
            slotPanels[i].add(slotLbl[i]);
            slotPanels[i].add(imageLabel[i]);
            slotPanels[i].add(Box.createVerticalStrut(2));
            slotPanels[i].add(slotStock[i]);
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

        stockLbl = new JLabel(" RESTOCK ");
        stockLbl.setFont(new Font("MV boli", Font.BOLD, 35));
        stockLbl.setOpaque(true); // Ensure the label is opaque so that the background color is visible.
        stockLbl.setBackground(new Color(128, 98, 214));

        Component spacer = Box.createRigidArea(new Dimension(0, 50));

        //ADD HERE FOR RESTOCK BUTTONS
        panel3a = new JPanel(new GridBagLayout());
        panel3a.setPreferredSize(new Dimension(200, 100));
        panel3a.setBackground(new Color(242, 234, 211));
        panel3a.setBorder(border1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        minusBtn = new JButton("-");
        minusBtn.setFont(new Font("Arial", Font.BOLD, 15));
        minusBtn.setPreferredSize(new Dimension(50, 25));

        curStockTA = new JTextArea(2, 5);
        curStockTA.setPreferredSize(new Dimension(50, 30));
        curStockTA.setFont(new Font("MV boli", Font.BOLD, 20));

        addBtn = new JButton("+");
        addBtn.setFont(new Font("Arial", Font.BOLD, 15));
        addBtn.setPreferredSize(new Dimension(50, 25));

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panel3a.add(minusBtn, gbc2);

        gbc2.gridx = 1;
        panel3a.add(curStockTA, gbc2);

        gbc2.gridx = 2;
        panel3a.add(addBtn, gbc2);

        //end

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
        subPanel3.add(stockLbl, gbc);
        //ROW 4
        gbc.gridx = 0;
        gbc.gridy = 3;
        subPanel3.add(panel3a, gbc);
        //ROW 6
        gbc.gridx = 0;
        gbc.gridy = 4;
        subPanel3.add(doneBtn, gbc);

        panel3.add(subPanel3, BorderLayout.WEST);
        panel4.add(subPanel4b, BorderLayout.WEST);
        panel4.add(subPanel4c, BorderLayout.EAST);
        panel4.add(dispensePane);

        restockPanel.add(panel1, BorderLayout.NORTH);
        restockPanel.add(panel2, BorderLayout.WEST);
        restockPanel.add(panel3, BorderLayout.EAST);
        restockPanel.add(panel4, BorderLayout.SOUTH);
        restockPanel.add(sp, BorderLayout.CENTER);
    }

    public JPanel getRestockPanel()
    {
        return restockPanel;
    }

    public void setTextLbl (int slotIndex, String text) {
        this.slotLbl[slotIndex].setText(text);
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
    public void setItemSelectedTextArea (String text) {
        this.itemSelected.setText(text);
    }
    public String getItemSelectedText () {
        return itemSelected.getText();
    }
    public void setStockTA (String text) {
        stockTA.setText(text);
    }
    public void setCurStockTA(String text) {
        curStockTA.setText(text);
    }
    public void clearTextField () {
        this.itemSelected.setText("");
    }
    public void setSlotBtnListener (int index, ActionListener actionListener) {
        this.slotBtn[index].addActionListener(actionListener);
    }
    public void setAddBtnListener (ActionListener actionListener) {
        this.addBtn.addActionListener(actionListener);
    }
    public void setMinusBtnListener (ActionListener actionListener) {
        this.minusBtn.addActionListener(actionListener);
    }
    public void setDoneBtnListener (ActionListener actionListener) {
        this.doneBtn.addActionListener(actionListener);
    }
}
