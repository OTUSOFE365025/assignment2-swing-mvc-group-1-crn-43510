import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class View {
    private final JFrame frame = new JFrame("Cash Register View");
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> list = new JList<>(listModel);
    private final JLabel subtotal = new JLabel("$0.00", SwingConstants.RIGHT);

    public View() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(8, 8));
        list.setVisibleRowCount(10);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        JPanel south = new JPanel(new BorderLayout());
        south.add(new JLabel("Subtotal: "), BorderLayout.WEST);
        subtotal.setFont(subtotal.getFont().deriveFont(Font.BOLD));
        south.add(subtotal, BorderLayout.EAST);
        frame.add(south, BorderLayout.SOUTH);
        frame.setSize(460, 320);
        frame.setLocationByPlatform(true);
    }

    public void show() { frame.setVisible(true); }
    public void appendRow(String row) { listModel.addElement(row); }
    public void setSubtotal(double value) { subtotal.setText(String.format("$%.2f", value)); }
}
