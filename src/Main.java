import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Library 클래스의 인스턴스(실제 객체)를 생성
        Scanner sc = new Scanner(System.in);
        Library Library = new Library();

        // 2. Library 객체의 addBook 메소드를 사용해 책 추가
        Library.addBook(new Book("어린왕자", "생택쥐페리", "N"));
        Library.addBook(new Book("삼체", "류츠신", "N"));
        Library.addBook(new Book("자바의정석", "김기용", "N"));

        // 3. Library 객체의 메소드를 호출해 기능 사용
        while (true) {
            System.out.println("세진 도서관에 오신것을 환영합니다. \n " +
                    "-------------------\n " +
                    "1. 보유 한 책 목록 조회 \n " +
                    "2. 반납하기 \n " +
                    "3. 프로그램 종료 ");
            int selectNumber = sc.nextInt();
            if (selectNumber == 1) {
                Library.printAllBookTitles();
                System.out.println("대여할 책 번호를 선택해주세요");
                int rentalBookNumber = sc.nextInt();
              /*  Library.bookRentalFunction();*/

            } else if (selectNumber == 2) {
                /*Library.bookRentalFunction();*/
            } else if (selectNumber == 3) {
                return;
            }
                try {
                    if (selectNumber < 1 || selectNumber > 3) {
                        throw new IllegalAccessException();
                    }
                }
                    catch(Exception e){
                    System.out.println("잘못된 입력값입니다.");
                }

            }
        }
    }

