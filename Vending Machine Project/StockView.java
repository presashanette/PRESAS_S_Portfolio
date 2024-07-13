import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class StockView {
    private JPanel stockPanel, panel1, panel2, panel3, panel4, sp;
    private JPanel[] slotPanels;
    private JLabel titleLbl, guideLbl;
    private JLabel[] imageLabel = new JLabel[24];
    private JLabel[] slotLbl = new JLabel[24];
    private JButton doneBtn, submitBtn;
    private JButton[] slotBtn;
    private JTextArea itemSelected;
    private JTextField stocksTf;
    private JTextPane feedbackPane; //add success
    public StockView()
    {

        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        stockPanel = new JPanel(new BorderLayout());
        stockPanel.setPreferredSize(new Dimension(1000, 800));
        stockPanel.setBackground(Color.WHITE);
        stockPanel.setBorder(border1);

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));
        panel1.setBorder(border1);

        titleLbl = new JLabel("Stock New Items");
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setFont(new Font("Ravie", Font.BOLD, 40));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(titleLbl, constraints);
        //===========================================================================
        panel2 = new JPanel(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(1000, 100));
        panel2.setBackground(new Color(242, 234, 211));
        panel2.setBorder(border1);

        sp = new JPanel(); //panel for ALL THE SLOTS
        int rows = 4;
        int columns = 6;
        sp.setLayout(new GridLayout(rows, columns, 10, 10)); // Adjust the spacing between slots if needed
        sp.setPreferredSize(new Dimension(1000, 800));
        sp.setBackground(new Color(128, 98, 214));
        sp.setBorder(border1);

        //start of other layout for stock
        guideLbl = new JLabel("Select the item to add to the vending machine!");
        guideLbl.setFont(new Font("MV boli", Font.BOLD, 15));

        slotPanels = new JPanel[24];
        slotBtn = new JButton[24];
        //panel per slot
        for (int i = 0; i < slotPanels.length; i++) {
            slotPanels[i] = new JPanel();
            slotPanels[i].setLayout(new BoxLayout(slotPanels[i], BoxLayout.Y_AXIS));
            slotPanels[i].setPreferredSize(new Dimension(150, 200)); // Adjust the size as needed
            slotPanels[i].setBackground(new Color(50, 38, 53));

            slotLbl[i] = new JLabel();
            slotLbl[i].setFont(new Font("MV boli", Font.BOLD, 15));
            slotLbl[i].setForeground(Color.WHITE);
            slotLbl[i].setAlignmentX(Component.CENTER_ALIGNMENT);


            imageLabel[i] = new JLabel();
            imageLabel[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotBtn[i] = new JButton("Select");
            slotBtn[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotPanels[i].add(slotLbl[i]);
            slotPanels[i].add(Box.createVerticalStrut(10));
            slotPanels[i].add(imageLabel[i]);
            slotPanels[i].add(Box.createVerticalStrut(10));
            slotPanels[i].add(slotBtn[i]);

            sp.add(slotPanels[i]);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        //ROW 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(guideLbl, gbc);
        //ROW 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(sp, gbc);

        //==========================================================
        panel4 = new JPanel(new GridBagLayout());
        panel4.setPreferredSize(new Dimension(200, 800));
        panel4.setBackground(new Color(242, 234, 211));
        panel4.setBorder(border1); // Set border to panel3

        JLabel selectLbl = new JLabel("Select");
        selectLbl.setFont(new Font("MV boli", Font.BOLD, 15));
        itemSelected = new JTextArea();
        itemSelected.setFont(new Font("MV boli", Font.BOLD, 15));
        itemSelected.setMaximumSize(new Dimension(10, 20));

        JLabel capacityLabel = new JLabel("Enter number of stocks:");
        capacityLabel.setFont(new Font("MV boli", Font.BOLD, 12));

        stocksTf = new JTextField();
        stocksTf.setPreferredSize(new Dimension(50, 20));
        stocksTf.setFont(new Font("MV boli", Font.BOLD, 15));
        stocksTf.setBackground(Color.WHITE);

        submitBtn = new JButton("Submit");
        submitBtn.setPreferredSize(new Dimension(50, 20));
        submitBtn.setFont(new Font("MV boli", Font.BOLD, 15));
        submitBtn.setBackground(Color.PINK);

        this.feedbackPane = new JTextPane();
        this.feedbackPane.setPreferredSize(new Dimension(50, 35));
        this.feedbackPane.setFont(new Font("MV boli", Font.BOLD, 16));
        this.feedbackPane.setForeground(new Color(0, 100, 0));
        StyledDocument doc = feedbackPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 5, 5, 5);

        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(selectLbl, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(itemSelected, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(capacityLabel, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 3;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(stocksTf, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 4;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(feedbackPane, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 5;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(submitBtn, gbc1);

        //==========================================================
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

        stockPanel.add(panel1, BorderLayout.NORTH);
        stockPanel.add(panel2, BorderLayout.CENTER);
        stockPanel.add(panel3, BorderLayout.SOUTH);
        stockPanel.add(panel4, BorderLayout.EAST);
    }

    public void setFeedbackPaneText (String text) {
        this.feedbackPane.setText(text);
    }
    public void setTextLbl (int slotIndex, String text) {
        this.slotLbl[slotIndex].setText(text);
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
    public void setSubmitBtnListener (ActionListener actionListener) {
        this.submitBtn.addActionListener(actionListener);
    }
    public String getItemSelectedText () {
        return itemSelected.getText();
    }

    public String getCapacityTf () {
        return stocksTf.getText();
    }
    public void clearTextField () {
        this.itemSelected.setText("");
        this.stocksTf.setText("");
    }

    public void setDoneBtnListener(ActionListener actionListener) {
        this.doneBtn.addActionListener(actionListener);
    }
    public void setSlotBtnListener (int index, ActionListener actionListener) {
        this.slotBtn[index].addActionListener(actionListener);
    }
    public JPanel getStockPanel()
    {
        return stockPanel;
    }
}