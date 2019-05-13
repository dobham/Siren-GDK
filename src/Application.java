import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.SwingConstants.LEADING;

public class Application extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application");
        frame.setContentPane(new Application().application);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Application() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ManualGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var manGen = new ManualGenerate();
                manGen.setVisible(true);
            }
        });
        RandomGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var randGen = new RandomGenerate();
                randGen.setVisible(true);
            }
        });
    }
    private JPanel application;
    private JButton RandomGenerate;
    private JButton ManualGenerate;
    private JButton exitButton;

    public class RandomGenerate extends JFrame{
        public RandomGenerate(){
            initUI();
        }
        public void initUI(){
            setTitle("Generate a Random Map");
            setSize(500,500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    public class ManualGenerate extends JFrame{
        public ManualGenerate(){
            initUI();

        }
        public void initUI() {
            var height = new JTextField(3);
            var width = new JTextField(3);
            var setDimensions = new JButton("Set Dimensions");

//            setDimensions.addActionListener(new ClickAction());

            var JButtonComponents = new ArrayList<JButton>();
            JButtonComponents.add(modifyButton(setDimensions));

            var JTextFieldComponents = new ArrayList<JTextField>();
            JTextFieldComponents.add(modifyTextField(height));
            JTextFieldComponents.add(modifyTextField(width));

            createLayout(JTextFieldComponents.toArray(new JTextField[JTextFieldComponents.size()]), JButtonComponents.toArray(new JButton[JButtonComponents.size()]));

            setTitle("Manually Create a Map");
            setSize(500, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        public JTextField modifyTextField(JTextField component){
            component.setMaximumSize(new Dimension(90,40));
            component.setBackground(Color.red);
            return component;
        }
        public JButton modifyButton(JButton component){
            component.setMaximumSize(new Dimension(90,40));
            component.setBackground(Color.red);
            return component;
        }
        public void createLayout(JTextField[] textFieldComponents, JButton[] buttonComponents){
            var pane = (JPanel) getContentPane();
            var layout = new GroupLayout(pane);
            pane.setLayout(layout);
            layout.setAutoCreateContainerGaps(true);
            layout.setHorizontalGroup(layout.createParallelGroup()
                    .addComponent(textFieldComponents[0])
                    .addComponent(textFieldComponents[1])
                    .addComponent(buttonComponents[0])
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                    .addComponent(textFieldComponents[0])
                    .addComponent(textFieldComponents[1])
                    .addComponent(buttonComponents[0])
            );
        }
    }
//    public class Engine extends JFrame implements Runnable{}
}
