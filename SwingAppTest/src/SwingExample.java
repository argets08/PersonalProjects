

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingExample extends JFrame {

    public SwingExample() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
            	SwingExample ex = new SwingExample();
                ex.setVisible(true);
            }
        });
    }
}