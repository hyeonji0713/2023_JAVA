//중간고사 1번 답
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Form extends JFrame{
	private JPanel contentPane;
   
    private JTextField textField_01;
    private JTextField textField_02;
    private JTextField textField_03;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Form(){
		setTitle("덕성여대 화이팅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_00 = new JLabel("학생 등록하기");
        label_00.setBounds(12, 30, 100, 15);
        label_00.setFont(new Font("맑은고딕", Font.BOLD, 15)); 
	    label_00.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(label_00);

	    JLabel label_01 = new JLabel("이름");
	    label_01.setBounds(12, 60, 57, 15);
	    contentPane.add(label_01);

	    JLabel label_02 = new JLabel("학번");
	    label_02.setBounds(12, 90, 57, 15);
	    contentPane.add(label_02);

	    JLabel label_03 = new JLabel("성적");
	    label_03.setBounds(12, 120, 57, 15);
	    contentPane.add(label_03);

	    textField_01 = new JTextField();
	    textField_01.setBounds(81, 60, 243, 21);
	    contentPane.add(textField_01);
	    textField_01.setColumns(10);

	    textField_02 = new JTextField();
	    textField_02.setColumns(10);
	    textField_02.setBounds(81, 90, 243, 21);
	    contentPane.add(textField_02);

	    textField_03 = new JTextField();
	    textField_03.setColumns(10);
	    textField_03.setBounds(81, 120, 243, 21);
	    contentPane.add(textField_03);

	    JButton button_01 = new JButton("등록하기");
	    button_01.setBounds(100, 181, 97, 23);
		contentPane.add(button_01);
		button_01.addActionListener(e->{
			String name = textField_01.getText();
			String num = textField_02.getText();
			String grade = textField_03.getText();
			System.out.println("이름: "+name+" 학번: "+num+" 성적: "+grade);
		});
		
		
		JButton button_02 = new JButton("취소");
		button_02.setBounds(227, 181, 97, 23);
		contentPane.add(button_02);
		button_02.addActionListener(e->{
			System.exit(0);
		});
	}
}