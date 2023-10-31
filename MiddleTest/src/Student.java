public class Student {
	
	private String Sname;
	private int Snum;
	private double Sgrade;
	
	public Student(String SName, int Snum, double Sgrade) {
		this.Sname = Sname;
		this.Snum = Snum;
		this.Sgrade = Sgrade;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String SName) {
		this.Sname = Sname;
	}
	public int getSnum() {
		return Snum;
	}
	public void setSnum(int SNum) {
		this.Snum = Snum;
	}
	public double getSgrade() {
		return Sgrade;
	}
	public void setSgrade(double Sgrade) {
		this.Sgrade = Sgrade;
	}
	
	public String toString() {
		return Sname + ", "+Snum+", "+Sgrade;
	}
}
	
