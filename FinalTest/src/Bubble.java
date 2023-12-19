import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


// 버블 게임의 메인 프레임 클래스
public class Bubble extends JFrame {
	private volatile boolean isRunning = true;	//실행 중인가를 true, false로 표현
    // 프레임 생성자
    public Bubble() {
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 게임 패널 생성 및 프레임에 추가
        GamePanel p = new GamePanel();
        setContentPane(p);
        setSize(500, 500);
        setVisible(true);
        
        //시작버튼
        JButton startButton = new JButton("시작");
        startButton.setBounds(150, 400, 60, 30);
        startButton.addActionListener(e -> {
            start();
        });
        getContentPane().add(startButton);
        setVisible(true);
        
        //종료버튼
        JButton stopButton = new JButton("종료");
        stopButton.setBounds(250, 400, 60, 30);
        stopButton.addActionListener(e -> {
        	stop();
        });
        getContentPane().add(stopButton);
        setVisible(true);
        
        Runnable task = () -> {
          while (true) {
              if (isRunning) {	//isRunning이 true면 게임 진행, false면 게임 진행 안함
                  repaint();
              }
              try {
                  Thread.sleep(50);
              } catch (InterruptedException ignore) {
              }
          }
      };
      new Thread(task).start();
    }
    private void start() {
    	isRunning = true;	//스타트버튼 눌렸으면 실행
    }

    private void stop() {
    	isRunning = false;	//스탑버튼 눌렸으면 실행 중지
    }
    
    // 메인 메서드
    public static void main(String[] args) {
        new Bubble();
    }
}

// 게임 패널 클래스
class GamePanel extends JPanel {
    // 생성자
    public GamePanel() {
        setLayout(null);

        // 마우스 클릭 이벤트 처리
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // 클릭된 위치에서 새로운 버블 스레드 시작
                new BubbleThread(e.getX(), e.getY()).start();
            }
        });
    }
    

    // 버블을 표현하고 이동시키는 스레드 클래스
    class BubbleThread extends Thread {
        private JLabel bubble;

        // 스레드 생성자
        public BubbleThread(int bubbleX, int bubbleY) {
            // 이미지 아이콘을 이용하여 버블 레이블 생성
            ImageIcon img = new ImageIcon("bubble.jpg");
            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconHeight());
            bubble.setLocation(bubbleX, bubbleY);
            add(bubble);
            repaint();
        }

        // 스레드 실행 메서드
        public void run() {
            while (true) {
                // 현재 버블의 위치
                int x = bubble.getX();
                int y = bubble.getY() - 5;		
                
                // 버블이 화면 위쪽으로 벗어나면 스레드 종료
                if (y + bubble.getHeight() + 5 < 0) {	
                    bubble = null;
                    return;
                } else {
                    // 새로운 위치로 버블 이동
                    bubble.setLocation(x, y);
                }

                try {
                    // 일시 정지
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // 인터럽트 예외가 발생하면 스레드 종료
                    return;
                }
                
            }
        }
    }
}
