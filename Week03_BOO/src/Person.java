import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Person extends JFrame{
	public Person() {
		setTitle("회원 등록하기");
		setSize(550,200);
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.add(new JLabel("이름  	"));
		panel.add(new JTextField(20));
		panel.add(new JLabel("패스워드  "));
		panel.add(new JPasswordField(20));
		panel.add(new JLabel("이메일 주소  "));
		panel.add(new JTextField(20));
		panel.add(new JLabel("전화번호  	"));
		panel.add(new JTextField(20));
		
		JButton login = new JButton("등록하기");
		panel.add(login);
		
		JButton cancel = new JButton("취소");
		panel.add(cancel);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		Person p = new Person();
	
}
}
