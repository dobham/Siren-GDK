import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayerTesting extends JPanel {
    private class buttonCreateTest extends JFrame {
        private buttonCreateTest() {
            initUI();
        }

        private void initUI() {
            var quitButton = new JButton("Test");
            var quitButton2 = new JButton("Test");
            createLayout(quitButton);

            setTitle("Test button");
            setSize(600, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        private void createLayout(JComponent... arg) {
            var pane = getContentPane();
            var layout = new GroupLayout(pane);
            pane.setLayout(layout);
            layout.setAutoCreateContainerGaps(true);
            layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(arg[0]));
            layout.setVerticalGroup(layout.createSequentialGroup().addComponent(arg[0]));
        }
    }
    private LayerTesting() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var ex = new buttonCreateTest();
                ex.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LayerTesting");
        frame.setContentPane(new LayerTesting().LayerOne);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private JPanel LayerOne;
    private JButton button1;

}
