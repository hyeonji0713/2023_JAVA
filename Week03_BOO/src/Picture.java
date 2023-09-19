import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Picture extends JFrame {
    int img_x = 200, img_y = 100;
    JButton button1, button2;
    JLabel imageLabel;
    ImageIcon icon;
    JPanel panel;

    public Picture() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("LEFT");
        button2 = new JButton("RIGHT");
        icon = new ImageIcon("snoopy.jpg");
        imageLabel = new JLabel(icon);
        panel = new JPanel();

        panel.setLayout(null);

        button1.setBounds(100, 300, 100, 50);
        button2.setBounds(400, 300, 100, 50);
        imageLabel.setBounds(img_x, img_y, icon.getIconWidth(), icon.getIconHeight());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLeft();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveRight();
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(imageLabel);
        add(panel);
        setFocusable(true);
    }

    private void moveLeft() {
        if (img_x > 0) {
            img_x -= 10;
            imageLabel.setBounds(img_x, img_y, icon.getIconWidth(), icon.getIconHeight());
        }
    }

    private void moveRight() {
        if (img_x + icon.getIconWidth() < getWidth()) {
            img_x += 10;
            imageLabel.setBounds(img_x, img_y, icon.getIconWidth(), icon.getIconHeight());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Picture picture = new Picture();
                picture.setVisible(true);
            }
        });
    }
}

