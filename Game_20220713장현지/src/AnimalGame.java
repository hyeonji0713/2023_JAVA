import java.awt.*;
import javax.swing.*;

public class AnimalGame extends JFrame {

    // 동물 달리기 스레드를 나타내는 내부 클래스
    class MyThread extends Thread {
        private int[] raceResults; // 경주 결과를 저장하는 배열
        private JLabel label; // 동물 이미지를 표시하는 JLabel
        private int x, y; // 동물의 시작 위치
        private String animalName; // 동물의 이름

        // 동물 달리기 스레드 생성자
        public MyThread(String animalName, int x, int y, int[] raceResults) {
            this.animalName = animalName; // 동물 이름 초기화
            this.x = x;
            this.y = y;
            this.raceResults = raceResults; // 결과 배열 초기화
            ImageIcon icon = new ImageIcon(animalName + ".jpg"); // 동물 이름으로 이미지 파일 가져옴
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            label = new JLabel(icon);
            label.setBounds(x, y, 150, 150);
            add(label);
        }
        // 등수 확인 메서드 (동기화 처리)
        private synchronized int getRank() {
            for (int i = 0; i < raceResults.length; i++) {
                if (raceResults[i] == 0) {
                    raceResults[i] = 1;
                    return i + 1;
                }
            }
            return -1;
        }

        // 동물 달리기 동작 메서드
        public void run() {
            for (int i = 0; i < 200; i++) {
                x += 20 * Math.random(); // 랜덤으로 동물 이동
                label.setBounds(x, y, 150, 150);
                repaint();
                if (x >= 650) { // 결승선 도달 조건
                    int rank = getRank(); // 등수 확인
                    System.out.println(rank + "등: " + animalName);
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // AnimalGame 클래스 생성자
    public AnimalGame() {
        setTitle("동물 달리기 대회");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        int[] raceResults = new int[5]; // 대회 등수 저장할 배열 생성

        (new MyThread("토끼", 100, 0, raceResults)).start();
        (new MyThread("강아지", 100, 100, raceResults)).start();
        (new MyThread("양", 100, 200, raceResults)).start();
        (new MyThread("돼지", 100, 300, raceResults)).start();
        (new MyThread("랫서팬더", 100, 400, raceResults)).start();

        // 결승선을 나타내는 패널
        JPanel finishLinePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5));
                g.drawLine(650, 0, 650, 600); 
            }
        };
        finishLinePanel.setBounds(0, 0, 800, 600);
        add(finishLinePanel);

        setVisible(true);
    }

    // 메인 메서드
    public static void main(String[] args) {
        System.out.println("[제 1회 동물 달리기 대회]");
        System.out.println("**1등으로 통과하는 동물에게는 '1년치 식량'을 상품으로 드립니다!**");
        System.out.println("----- 대회 결과 -----");
        AnimalGame c = new AnimalGame();
    }
}
