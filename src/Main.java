import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        //속성 Filed
        //기본적인 3권의 책 리스트 를 만들기
        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book("수학책", "수학선생님", "대여 가능");
        Book book2 = new Book("국어책", "국어선생님", "대여 가능");
        Book book3 = new Book("자바책", "김기용선생님", "대여 가능");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);


        //기능 Method

        //Library 클래스에서 실행하기위한 메소드  bookList를 주입하여 생성한다.
        Library library = new Library(bookList);
        library.start();



    }
}







