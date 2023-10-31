
import java.util.ArrayList;

public class GradeBook {
	private ArrayList<Student> arrayList;
	
	public GradeBook() {
		arrayList = new ArrayList<Student>();
	}
	
	public double Averg (double Sgrade) { 	/*평균*/
		for (int i=0;i<arrayList.size();i++) {
			Student student = arrayList.get(Sgrade);
			int sum += Sgrade;
			double averg = sum / (arrayList-1);
			
		}
	}
	public void Search (int Snum) {		/*검색*/
		
	}
	
	public void showAllBook() { 
		for(Student student : arrayList) {
			System.out.println(student);
		}
		System.out.println();
	}
} 
