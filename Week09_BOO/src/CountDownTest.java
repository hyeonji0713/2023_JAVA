import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame {
    private JLabel label;
    private Thread t;
    private int currentCount; // 현재 카운트 값
    private boolean isCounting; // 카운트 중인지 여부

    class Counter extends Thread {
        public void run() {
            for (int i = currentCount; i <= 100; i++) {
                if (!isCounting) {
                    return;
                }
                try {
                    Thread.sleep(1000);
                    label.setText(i + "");
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public CountDownTest() {
        setTitle("카운트다운");
        setSize(400, 150);
        getContentPane().setLayout(null);

        label = new JLabel("0");
        label.setBounds(0, 0, 384, 111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        JButton b1 = new JButton("카운트 중지");
        b1.setBounds(247, 25, 125, 23);
        b1.addActionListener(e -> {
            isCounting = false;
            t.interrupt();
        });
        getContentPane().add(b1);

        JButton b2 = new JButton("카운트 다시 시작");
        b2.setBounds(247, 50, 125, 23);
        b2.addActionListener(e -> {
            isCounting = true;
            currentCount = Integer.parseInt(label.getText());
            t = new Counter();
            t.start();
        });
        getContentPane().add(b2);

        setVisible(true);
        t = new Counter();
        isCounting = true;
        t.start();
    }

    public static void main(String[] args) {
        CountDownTest t = new CountDownTest();
    }
}
