import javax.swing.ImageIcon;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame {
    private JPanel panel;
    private JLabel pic;
    private JLabel name;
    private JLabel job;
    private JLabel company;

    public MyFrame() {
        setTitle("명함");
        setSize(600,150);
        panel = new JPanel(new GridLayout(1, 2)); // 1행 2열의 그리드 레이아웃 설정
        pic = new JLabel();
        ImageIcon icon = new ImageIcon("duksae.png");
        pic.setIcon(icon);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        name = new JLabel("덕새");
        job = new JLabel("덕성여대 마스코트");
        company = new JLabel("덕성여자대학교");

        // 각 레이블을 패널에 추가
        panel.add(pic);
        JPanel labelPanel = new JPanel(); // 레이블을 담을 패널 생성
        labelPanel.setLayout(new GridLayout(3, 1)); // 3행 1열의 그리드 레이아웃 설정
        labelPanel.add(name);
        labelPanel.add(job);
        labelPanel.add(company);
        panel.add(labelPanel); // 레이블 패널을 패널에 추가

        add(panel);  // 패널을 프레임에 추가

        setVisible(true);  // 프레임을 표시
    }
}

public class Card {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
