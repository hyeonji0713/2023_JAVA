//중간고사 3번 답-3

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GradeBook {
	private ArrayList<Student> list;
	
	public GradeBook() {
		this.list = new ArrayList<>();
	}
	
	//학생을 등록하는 메서드
	public void saveStudent(Student student) { 
	    list.add(student);	    
	    System.out.println(student.name + "학생이 저장되었습니다.");
        System.out.println("이름: " + student.getName());
        System.out.println("학번: " + student.getNumber());
        System.out.println("성적: " + student.getGrade());
        
	}
	
	//전체 평균을 구하는 메서드
	public double averageGrade() {
		double sum=0;
		double avg=1.0;
		
		for(Student student : list) {
			sum += student.getGrade();
		}
		avg = sum/list.size();
		return avg;
	}
	
	//특정 학번을 가진 학생의 정보를 검색
	public void searchStudent(String number) {
		   for (Student student : list) {
	            if (student.getNumber().equals(number)) {
	                System.out.println("학번이 " + number + "인 학생을 찾았습니다.");
	                System.out.println("이름: " + student.getName());
	                System.out.println("학번: " + student.getNumber());
	                System.out.println("성적: " + student.getGrade());
	                return;
			    }
			}
		   System.out.println("학번이 " + number + "인 학생을 찾을 수 없습니다.");
	}
	
	//학생 정보를 화면에 출력
	public void showAllStu() {
		System.out.println("전체 학생은 총 " + list.size() + "명이고, 학생들의 전체 평균은 점수는 " + averageGrade() + "접입니다.");		
		for(Student student : list) {
			System.out.println(student);
		}
		System.out.println();
	}
	
	//학생 정보를 파일에 출력
	public void printAllStu() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("stu_out.txt"))) {
	        writer.println("전체 학생은 총 " + list.size() + "명이고, 학생들의 전체 평균은 " + averageGrade() + "점입니다.");
			for(Student student : list) {
				writer.println(student);
			}
	        System.out.println("학생 정보가 파일에 저장되었습니다.");
	    } catch (IOException e) {
	        // Handling IOException by printing the stack trace
	        e.printStackTrace();
	    }
	}
	
}
//
//import java.util.ArrayList;
//
//public class GradeBook {
//	private ArrayList<Student> arrayList;
//	
//	public GradeBook() {
//		arrayList = new ArrayList<Student>();
//	}
//	
//	public double Averg (double Sgrade) { 	/*평균*/
//		for (int i=0;i<arrayList.size();i++) {
//			Student student = arrayList.get(Sgrade);
//			int sum += Sgrade;
//			double averg = sum / (arrayList-1);
//			
//		}
//	}
//	public void Search (int Snum) {		/*검색*/
//		
//	}
//	
//	public void showAllBook() { 
//		for(Student student : arrayList) {
//			System.out.println(student);
//		}
//		System.out.println();
//	}
//} 
