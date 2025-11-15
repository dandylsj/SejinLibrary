import org.w3c.dom.css.Counter;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // 1. 멤버 변수(필드)로 bookList를 선언
    private List<Book> bookList;

    // 2. 생성자: Library 객체가 생성될 때 bookList를 초기화
    public Library() {
        this.bookList = new ArrayList<>();
    }

    // 3. 책을 추가하는 기능(메소드)
    public void addBook(Book book) {
        this.bookList.add(book);
    }

    // 4. 책 제목을 모두 출력하는 기능(메소드)
    public void printAllBookTitles() {
        System.out.println("--- 보유 도서 목록 ---");
        int counter = 1;
        for (Book book : this.bookList) {
            System.out.println(counter + "." +book.getTitle() + " by " + book.getAuthor() + " (" + book.getRentalStatus() + ")");
            counter++;
        }
        System.out.println("--------------------");
    }

/*    public void bookRentalFunction() {
        bookList.*/
    /*}*/
}