import java.awt.*;
import javax.swing.*;

public class AnimalGame extends JFrame {

    class MyThread extends Thread {
        private int[] raceResults;
        private JLabel label;
        private int x, y;
        private String animalName;
        private RaceResultPanel resultPanel;

        // 동물 달리기 스레드 생성자
        public MyThread(String animalName, int x, int y, int[] raceResults, RaceResultPanel resultPanel) {
            this.animalName = animalName;
            this.x = x;
            this.y = y;
            this.raceResults = raceResults;
            this.resultPanel = resultPanel;
            // 동물 이미지 로드
            ImageIcon icon = new ImageIcon(animalName + ".jpg");
            Image image = icon.getImage();
            // 이미지 크기 조절
            Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            // JLabel을 사용하여 이미지를 표시
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
                    resultPanel.addResult(animalName, rank);

                    // 모든 동물이 결승선을 통과하면 최종 우승자 출력
                    if (resultPanel.allAnimalsFinished()) {
                        String winner = resultPanel.getWinner();
                        System.out.println("축하합니다! 우승자는 " + winner + " 입니다!");
                        System.out.println("**우승자에게는 상품으로 '1년치 식량을 드립니다!**");
                    }
                    break;
                }
                try {
                    Thread.sleep(200); // 0.2초마다 동물 이동하도록 대기 시간 지정
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class RaceResultPanel extends JPanel {
        private JTextArea resultTextArea;
        private int finishedCount;

        // 경주 결과를 표시하는 패널 생성자
        public RaceResultPanel() {
            resultTextArea = new JTextArea();
            resultTextArea.setEditable(false);
            // 스크롤 가능한 JTextArea를 사용하여 결과를 표시
            JScrollPane scrollPane = new JScrollPane(resultTextArea);
            scrollPane.setPreferredSize(new Dimension(150, 300));
            add(scrollPane);
        }

        // 결과 추가 메서드
        public void addResult(String animalName, int rank) {
            resultTextArea.append(rank + "등: " + animalName + "\n");
            finishedCount++;
        }

        // 모든 동물이 결승선을 통과했는지 확인하는 메서드
        public boolean allAnimalsFinished() {
            return finishedCount == 5;
        }

        // 최종 우승자를 결정하는 메서드
        public String getWinner() {
            // 1등으로 도착한 동물 이름을 반환
            for (int i = 0; i < raceResults.length; i++) {
                if (raceResults[i] == 1) {
                    return animalNames[i];
                }
            }
            return "";
        }
    }

    private String[] animalNames = {"토끼", "강아지", "양", "돼지", "랫서팬더"};
    private int[] raceResults = new int[5];

    // AnimalGame 클래스 생성자
    public AnimalGame() {
        setTitle("동물 달리기 대회");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 결과를 표시하는 패널 생성
        RaceResultPanel resultPanel = new RaceResultPanel();
        resultPanel.setBounds(800, 100, 200, 600);
        add(resultPanel);

        // 각각의 동물에 대한 스레드 생성 및 시작
        for (int i = 0; i < animalNames.length; i++) {
            (new MyThread(animalNames[i], 100, i * 100, raceResults, resultPanel)).start();
        }

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
        System.out.println("참가 동물( 토끼 / 강아지 / 양 / 돼지 / 랫서팬더 )");
        System.out.println("----- 대회 결과 -----");
        AnimalGame c = new AnimalGame();
    }
}
