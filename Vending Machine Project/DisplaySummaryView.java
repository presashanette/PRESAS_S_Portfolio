import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class DisplaySummaryView {
    private JPanel summaryPanel, panel1, panel3, sp;
    private JPanel[] slotPanels = new JPanel[12];
    private JLabel[] slotLbl = new JLabel[12];
    private JLabel[] imageLabel = new JLabel[12];
    private JLabel[] slotStartStock = new JLabel[12];
    private JLabel[] slotEndStock = new JLabel[12];
    private JLabel summaryLbl, totalLbl;
    private JButton doneBtn;

    public DisplaySummaryView() {
        Border border1 = BorderFactory.createLineBorder(new Color(242, 234, 211), 10);

        summaryPanel = new JPanel(new GridBagLayout());
        summaryPanel.setPreferredSize(new Dimension(1000,800));
        summaryPanel.setBackground(new Color(134, 43, 13));

        panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(1000, 100));
        panel1.setBackground(new Color(134, 43, 13));

        summaryLbl = new JLabel("DISPLAY SUMMARY");
        summaryLbl.setForeground(Color.WHITE);
        summaryLbl.setFont(new Font("Ravie", Font.BOLD, 30));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        panel1.add(summaryLbl, constraints);

        sp = new JPanel(); //panel for ALL THE SLOTS
        int rows = 4;
        int columns = 3;
        sp.setLayout(new GridLayout(rows, columns, 10, 5)); // Adjust the spacing between slots if needed
        sp.setPreferredSize(new Dimension(1000, 800));
        sp.setBackground(new Color(242, 234, 211));
        sp.setBorder(border1);

        //panel per slot
        for (int i = 0; i < slotPanels.length; i++) {
            slotPanels[i] = new JPanel();
            slotPanels[i].setLayout(new BoxLayout(slotPanels[i], BoxLayout.Y_AXIS));
            slotPanels[i].setPreferredSize(new Dimension(500, 350)); // Adjust the size as needed
            slotPanels[i].setBackground(new Color(50, 38, 53));

            slotLbl[i] = new JLabel(); //name of the item
            slotLbl[i].setFont(new Font("MV boli", Font.BOLD, 18));
            slotLbl[i].setForeground(Color.WHITE);
            slotLbl[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            imageLabel[i] = new JLabel(); //image of the item
            imageLabel[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotStartStock[i] = new JLabel(); //stocks of the item
            slotStartStock[i].setFont(new Font("Arial", Font.BOLD, 12));
            slotStartStock[i].setForeground(Color.WHITE);
            slotStartStock[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            slotEndStock[i] = new JLabel(); //stocks of the item
            slotEndStock[i].setFont(new Font("Arial", Font.BOLD, 12));
            slotEndStock[i].setForeground(Color.WHITE);
            slotEndStock[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            //adding in the panel
            slotPanels[i].add(slotLbl[i]);
            slotPanels[i].add(imageLabel[i]);
            slotPanels[i].add(slotStartStock[i]);
            slotPanels[i].add(slotEndStock[i]);

            sp.add(slotPanels[i]);
        }

        totalLbl = new JLabel();
        totalLbl.setFont(new Font("MV boli", Font.BOLD, 20));
        totalLbl.setForeground(Color.WHITE);

        doneBtn = new JButton("BACK TO MAIN MENU");
        doneBtn.setPreferredSize(new Dimension(300, 50));
        doneBtn.setFont(new Font("MV boli", Font.BOLD, 15));
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setForeground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        summaryPanel.add(panel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        summaryPanel.add(sp, gbc);

        // Row 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        summaryPanel.add(totalLbl, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        summaryPanel.add(doneBtn, gbc);
    }

    public JPanel getSummaryPanel() {
        return summaryPanel;
    }
    public void setSlotLbl(int i, String text) {
        slotLbl[i].setText(text);
    }
    public void setImageIcon (int slotIndex, String fileName) {
        ImageIcon imageIcon = new ImageIcon(fileName);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        this.imageLabel[slotIndex].setIcon(scaledImageIcon);
    }
    public void setSlotStartStock(int i, String text) {
        slotStartStock[i].setText("Starting Stock: " + text);
    }
    public void setSlotEndStock(int i, String text) {
        slotEndStock[i].setText("Ending Stock: " + text);
    }
    public void setTotalLbl (String text) {
        totalLbl.setText("TOTAL: " + text);
    }
    public void setDoneBtnListener(ActionListener actionListener) {
        this.doneBtn.addActionListener(actionListener);
    }
}