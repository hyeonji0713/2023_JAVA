import java.awt.*;
import javax.swing.*;

public class CarGame extends JFrame {

    class MyThread extends Thread {
        private JLabel label;	//자동차 이미지
        private int[] raceResults;	//결과 배열	
        private int x, y;			//위치를 나타낼 x, y값
        private RaceResultPanel resultPanel;	//결과를 보여주는 패널
        private String carName;	//차 이름
        
        // 경주 스레드 생성자
        public MyThread(String carname, int x, int y, int[] raceResults) {
            this.x = x;
            this.y = y;
            this.carName = carname;
            this.raceResults = raceResults;
            // 이미지
            ImageIcon icon = new ImageIcon(carname+".gif");
            Image image = icon.getImage();
            // JLabel을 사용하여 이미지를 표시
            label = new JLabel(icon);
            label.setBounds(x, y, 200, 150);	
            add(label);
        }

        // 등수 확인 메서드 (동기화 처리)
        private synchronized int getRank() {
            for (int i = 0; i < raceResults.length; i++) {
                if (raceResults[i] == 0) {	//배열의 값이 0이면 그 위치에 1을 대입하고 i+1을 반환한다, 즉 등수를 반환한다.
                    raceResults[i] = 1;
                    return i + 1;
                }
            }
            return -1;
        }

        //경주 동작 메서드
        public void run() {
            for (int i = 0; i < 200; i++) {
                x += 20 * Math.random(); // 랜덤으로 이동
                label.setBounds(x, y, 150, 150);
                repaint();	
                
                
                if (x >= 600) { // 결승선 도달 조건
                    int rank = getRank(); // 등수 확인

                    // 모두 결승선을 통과하면 최종 우승자 출력
                    if (resultPanel.Finished()) {
                        String winner = resultPanel.getWinner();
                        System.out.println("\n"+"우승자는 " + winner + " 입니다!");
                    }
                    break;
                }
                try {
                    Thread.sleep(100); // 0.1초마다 이동하도록 대기 시간 지정
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    //결과 패널 클래스
    class RaceResultPanel extends JPanel {
        private int finishedCount;			

        // 결과 추가 메서드
        public void addResult(String carName, int rank) {
            finishedCount++;	//결과출력창에 결과 정보 출력, 결승선 통과한 동물 수 증가
        }

        // 모두 결승선을 통과했는지 확인하는 메서드
        public boolean Finished() {
            return finishedCount == 5;
        }

        // 최종 우승자를 결정하는 메서드
        public String getWinner() {
            // 1등으로 도착(결과배열 값이 1)한 차 이름 반환
            for (int i = 0; i < raceResults.length; i++) {
                if (raceResults[i] == 1) {
                    return carNames[i];
                }
            }
            return "";
        }
    }
    //차, 결과를 저장하는 배열
    private String[] carNames = {"car1", "car2", "car3", "car4", "car5"};
    private int[] raceResults = new int[5];

    // 클래스 생성자
    public CarGame() {
    	
        setTitle("Car Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        new MyThread("car1", 100, 0, raceResults).start();
        new MyThread("car2", 100, 100, raceResults).start();
        new MyThread("car3", 100, 200, raceResults).start();
        new MyThread("car1", 100, 300, raceResults).start();
        new MyThread("car2", 100, 400, raceResults).start();
        
        //race.gif 삽입
        JLabel label0 = new JLabel();
        ImageIcon icon = new ImageIcon("race.gif");
        Image image = icon.getImage();
        // JLabel을 사용하여 이미지를 표시
        label0 = new JLabel(icon);
        label0.setBounds(600, 0, 200, 150);	
        add(label0);
        
        // 결승선을 나타내는 패널
        JPanel finishLinePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5));	
                g.drawLine(600, 0, 600, 600);		
            }
        };
        finishLinePanel.setBounds(0, 0, 800, 600);	//가로800 세로600의 패널 
        add(finishLinePanel);

        setVisible(true);
    }

    // 메인 메서드
    public static void main(String[] args) {
        System.out.println("자동차게임");
        System.out.println("----- 결과 -----");
        CarGame c = new CarGame();	//경기 실행
    }
}
