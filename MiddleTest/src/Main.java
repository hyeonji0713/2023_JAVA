
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {
	public Main() {
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

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int num0;
			Scanner scan = null;
			String name, search;
			int num;
			double grade;
			PrintWriter in = new PrintWriter(new FileWriter("stu_out.txt"));
			while(true) {
				name = tName.getText();
				num = tNum.getText();
				grade = tScore.getText();
				if (num0 == 1)
					break;
			}
			in.close();
			
			double aver = Averg (Sgrade); 
			System.out.println("전체 학생은 총 "+arrayList.size()-1+" 이고, 학생들의 전체 평균 점수는 "+aver+"입니다.");
			Main m = new Main();
			
			System.out.println("검색하실 사용자 번호를 입력하세요");
	        num0 = s.nextInt();
	        search = num0 + "";
	        scan = new Scanner(new BufferedReader(new FileReader("user.txt")));
	        scan.useDelimiter("\n"); // 각 사용자 정보를 개행으로 구분
	        boolean found = false;
	        PrintWriter findUserWriter = new PrintWriter(new FileWriter("find_user.txt"));
	        while (scan.hasNext()) {
	            String userInfo = scan.next();
	            String[] userInfoParts = userInfo.split(",");
	            num = userInfoParts[0];
	            name = userInfoParts[1];
	            grade = userInfoParts[2];
	            if (num.equals(search)) {
	              //  System.out.println("사용자 번호 " + num2 + "의 전화번호는 " + tel + "입니다.");
	            	found = true;
	                // 검색 결과를 find_user.txt 파일에 저장
	                findUserWriter.print(num + "," + name + "," + grade + "\n");
	                break; // 해당 사용자를 찾았으면 검색 종료
	            }
	        }
	        if (!found) {
	            System.out.println("사용자 번호 " + num0 + "을 찾을 수 없습니다.");
	        }
	        findUserWriter.close(); // find_user.txt 파일을 닫습니다.

	        if (scan != null)
	            scan.close();

		}
		
		
	}

	


