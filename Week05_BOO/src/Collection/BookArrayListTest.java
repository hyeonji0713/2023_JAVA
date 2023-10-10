package Collection;

import java.util.Scanner;

public class BookArrayListTest {

	public static void main(String[] args) {
		BookArrayList bookArrayList = new BookArrayList();
		
		Book book1 = new Book(0001, "파우스트");
		Book book2 = new Book(0002, "황무지");
		Book book3 = new Book(0003, "변신");
		Book book4 = new Book(0004, "픽션들");
		Book book5 = new Book(0005, "톨스토이");
		
		bookArrayList.addBook(book1);
		bookArrayList.addBook(book2);
		bookArrayList.addBook(book3);
		bookArrayList.addBook(book4);
		bookArrayList.addBook(book5);

		bookArrayList.showAllBook();		//전체 책 출력
		
		//키보드로 위치와 책ID, 책 제목을 받아서 추가
        Scanner scanner = new Scanner(System.in);
		System.out.print("도서를 추가할 위치를 입력: ");
        int insertIndex = scanner.nextInt();
        System.out.print("책 ID 입력: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        System.out.print("책 제목 입력: ");
        String title = scanner.nextLine();
        
		Book newBook = new Book(bookId, title);
		boolean added = bookArrayList.addBookAtIndex(insertIndex, newBook);

        if (added) {
            System.out.println("책이 추가되었습니다.");
        } else {
            System.out.println("책을 추가하지 못했습니다.");
        }
		
		bookArrayList.showAllBook();		//전체 책 출력
		
		scanner.close();
	}

}
