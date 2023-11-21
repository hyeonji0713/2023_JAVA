//중간고사 3번 답-1

public class Student {
	String name;
	String number;
	Double grade;
	
	//생성자를 사용하여 이름, 학번, 점수 초기화
	public Student(String name, String number,  Double grade) {
		super();
		this.name = name;
		this.number = number;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public Double getGrade() {
		return grade;
	}
	
    @Override
	public String toString() {
	    return "이름: " + name + ", 학번: " + number + ", 점수: " + grade;
	}

}
//public class Student {
//	
//	private String Sname;
//	private int Snum;
//	private double Sgrade;
//	
//	public Student(String SName, int Snum, double Sgrade) {
//		this.Sname = Sname;
//		this.Snum = Snum;
//		this.Sgrade = Sgrade;
//	}
//	public String getSname() {
//		return Sname;
//	}
//	public void setSname(String SName) {
//		this.Sname = Sname;
//	}
//	public int getSnum() {
//		return Snum;
//	}
//	public void setSnum(int SNum) {
//		this.Snum = Snum;
//	}
//	public double getSgrade() {
//		return Sgrade;
//	}
//	public void setSgrade(double Sgrade) {
//		this.Sgrade = Sgrade;
//	}
//	
//	public String toString() {
//		return Sname + ", "+Snum+", "+Sgrade;
//	}
//}
//	
