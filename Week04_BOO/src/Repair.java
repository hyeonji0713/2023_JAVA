import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Repair extends JPanel implements ItemListener {
    JCheckBox[] checkboxes = new JCheckBox[4];
    String[] items = {"엔진오일 교환", "자동변속기오일 교환", "에어컨필터 교환", "타이어 교환"};
    int[] prices = {45000, 80000, 30000, 100000};
    int totalCost = 0;
    JLabel label;

    public Repair() {
        super();
        // 체크박스 생성
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = new JCheckBox(items[i]);
            checkboxes[i].addItemListener(this);
            add(checkboxes[i]);
        }

        label = new JLabel("선택한 수리 항목의 전체 가격: " + totalCost + "원"); // 초기 라벨 텍스트 설정
        add(label);

        setSize(500, 500);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        totalCost = 0;
        for (int i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].isSelected()) {
                totalCost += prices[i];
            }
        }
        label.setText("선택한 수리 항목의 전체 가격: " + totalCost + "원");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Repair");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Repair());
        frame.pack();
        frame.setVisible(true);
    }
}
