import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	public MyFrame() {
		setSize(500, 300);
		setTitle("덕성여대 파이팅");
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel title = new JLabel("학생 등록하기");
		
		JLabel name = new JLabel("이름");
		JTextField tName = new JTextField(15);
		JLabel number = new JLabel("학번");
		JTextField tNumber = new JTextField(15);
		JLabel score = new JLabel("성적");
		JTextField tScore = new JTextField(15);
		
		JButton b1 = new JButton("등록하기");
		b1.addActionListener(this);
		JButton b2 = new JButton("취소");
		
		panel1.add(title);
		panel2.add(name);
		panel2.add(tName);
		panel2.add(number);
		panel2.add(tNumber);
		panel2.add(score);
		panel2.add(tScore);
		panel3.add(b1);
		panel3.add(b2);
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame();

	}
	
		public void actionPerformed(ActionEvent e)
		{
			String str =e.getActionCommand();
			String Lname = tName.getText();
			String Lnumber = tNumber.getText();
			String Lscore = tScore.getText();
			if(str.equals("등록하기"))
			{
				System.out.println("이름: "+Lname+" 학번: "+Lnumber+" 성적: "+Lscore);
			}
		}
	}

	


