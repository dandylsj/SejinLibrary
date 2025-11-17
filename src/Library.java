import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    //속성 Filed
    private Scanner sc = new Scanner(System.in);
    private List<Book> bookList;

    //생성자 Constructor
    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }


    //기능 Method

    /**
     * 프로그램 시작점
     **/
    public void start() {
        while (true) {  //메뉴를 반복하기 위한 반복문
            System.out.println("세진 도서관에 오신것을 환영합니다. \n" +
                    "===================================\n" +
                    "원하시는 메뉴의 번호를 누르면 이동합니다. \n" +
                    "1.책 목록조회\n2.책 대여하기\n3.책 반납하기\n4.책 등록하기\n5.종료");

            System.out.println(bookList.get(0).getTitle());

            int selectMenuNumber = sc.nextInt(); //입력한 숫자를 저장
            switch (selectMenuNumber) { //입력한 숫자의 번호에 맞는 메뉴를 실행하기 위한 스위치구문
                case (1):
                    bookListInquiry(); // 책 목록 보는 메뉴 진입
                    break;
                case (2):
                    bookRental(); // 책을 대여 하기위한 메뉴 진입
                    break;

                case (3):
                    bookReturn(); // 책을 반납 하기위한 메뉴로 진입
                    break;

                case (4):
                    registerBook(); //책을 등록하기위한 메뉴로 진입
                    break;

                case (5):  //프로그램 종료
                    return;
            }

        }
    }

    /**
     * 책 목록을 보는 기능
     **/
    public void bookListInquiry() {
        System.out.println("------------[책 목록]------------");
        //for 문을 사용하여 List 내부에 있는 모든 책목록을 출력함.
        for (int i = 0; i < bookList.size(); i++) {  //bookList 의 .get(i)을 먼저사용하여 해당 리스트의 i번째 주소를 불러온 후 get을 사용하여 문자로 출력
            System.out.println(i + 1 + "."+" 제목: "+ bookList.get(i).getTitle() + " | " +"저자: "+ bookList.get(i).getAuthor() + " | " + bookList.get(i).getRentalStatus());
        }
        System.out.println("\n"); //메뉴가 너무 붙어있게 나와 공백을 주기위하여
    }

    /**
     * 책 반납하는 기능
     **/
    public void bookReturn() {
        while (true) {
            bookListInquiry(); //책 목록 출력
            System.out.println("\n" + "해당 책의 숫자를 누르면 대여가 가능합니다. \n0번을 누르면 상위메뉴로 돌아갑니다.");
            int selectBookNumber = sc.nextInt();//해당 책 목록의 번호를 입력하면 대여 , 반납이 가능
            if (selectBookNumber == 0){ //모두 반납한 상태에서 메뉴를 빠져나올수 없어서 상위 메뉴로 나가는 기능 추가
                break;
            }
            try {
                if (bookList.get(selectBookNumber - 1).getRentalStatus().equals("대여 불가")) {
                    //반대로 대여 불가인 책을 누르면 반납하는 기능으로
                    bookList.get(selectBookNumber - 1).setRentalStatus("대여 가능");//set 기능을 이용하여 대여 가능으로 바꾸기
                } else if (bookList.get(selectBookNumber - 1).getRentalStatus().equals("대여 가능")) { //if 문을 사용하여 현재 선택한 책 목록의 리스트에 rentalStatus의 글자와 비교하여 같으면
                    System.out.println("🚨이미 반납한 책입니다.🚨 \n");
                    continue;// 다시 책목록 출력으로 돌아감
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("🚨선택한 책은 없는 책입니다. 다시 입력해주세요🚨");
                continue;
            }
                //어떤 책을 반납했는지에 대한 안내문 출력
                System.out.println("📕알림:" + bookList.get(selectBookNumber - 1).getTitle() + " | " + bookList.get(selectBookNumber - 1).getAuthor() + "를 반납 하였습니다.\n");
                System.out.println("다른 책을 반납 하시려면 1번 , 이전메뉴는 2번");
                int selectNumber = sc.nextInt(); // 해당 메뉴의 정수값을 입력하면
                if (selectNumber == 1) {  //다시 대여 반납 반복하기
                    continue;
                } else if (selectNumber == 2) { //상위 메뉴로 나가기
                    break;
                }
            }
        }
    /**
     * 책을 대여하는 기능
     **/
    public void bookRental () {
        while (true) { //메뉴를 반복하기위한 반복문
            bookListInquiry();//책 목록 출력
            System.out.println("\n" + "해당 책의 숫자를 누르면 대여가 가능합니다. \n0번을 누르면 상위메뉴로 돌아갑니다.");
            int selectBookNumber = sc.nextInt();//해당 책 목록의 번호를 입력하면 대여 , 반납이 가능
            if (selectBookNumber == 0){ //모두 대여한 상태에서 메뉴를 빠져나올수 없어서 상위 메뉴로 나가는 기능 추가
                break;
            }
            try {
                if (bookList.get(selectBookNumber - 1).getRentalStatus().equals("대여 가능")) {//if 문을 사용하여 현재 선택한 책 목록의 리스트에 rentalStatus의 글자와 비교하여 같으면
                    bookList.get(selectBookNumber - 1).setRentalStatus("대여 불가"); //대여 불가로 글자를 바꾸어 준다. set을 사용하여 속성값 변경
                    //어떤 책을 빌렸는지에 대한 안내문 출력
                    System.out.println("📖알림:" + bookList.get(selectBookNumber - 1).getTitle() + " | " + bookList.get(selectBookNumber - 1).getAuthor() + "를 대여 하였습니다.\n");
                } else if (bookList.get(selectBookNumber - 1).getRentalStatus().equals("대여 불가")) { //if 문을 사용하여 현재 선택한 책 목록의 리스트에 rentalStatus의 글자와 비교하여 같으면
                    System.out.println("🚨이미 반납한 책입니다.🚨 \n");
                    continue; // 다시 책목록 출력으로 돌아감
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("🚨선택한 책은 없는 책입니다. 다시 입력해주세요🚨");
                continue;
            }
            System.out.println("다른 책을 대여 하시려면 1번 , 이전메뉴는 2번");
            int selectNumber = sc.nextInt(); // 해당 메뉴의 정수값을 입력하면
            if (selectNumber == 1) {  //다시 대여 반납 반복하기
                continue;
            } else if (selectNumber == 2) { //상위 메뉴로 나가기
                break;
            }
        }
    }

    /**
     * 책을 등록하는 기능
     **/
    public void registerBook() {
        while (true) {  //반복문을 사용하여 메뉴 반복하기
            System.out.println("등록하실 책의 이름을 작성해주세요");
            String resisterBookTitle = sc.next(); //책제목을 저장하는 변수

            System.out.println("등록하실 책의 저자를 작성해주세요");
            String resisterBookAuthor = sc.next(); //책 저자를 저장하는 변수
            //Book 의 속성에 맞게 저장한 변수를 대입하고 , 대여가능을 기본으로 bookList 에 저장하기
            bookList.add(new Book(resisterBookTitle, resisterBookAuthor, "대여 가능"));

            bookListInquiry();//등록한 책을 보여주기 위한 출력
            System.out.println("더 등록 하려면 1번 , 이전메뉴는 2번");
            int selectNumber = sc.nextInt(); //입력한 메뉴의 정수를 변수에 저장
            if (selectNumber == 1) { // 다시 메뉴 반복

            } else if (selectNumber == 2) { //상위메뉴로 나가기
                break;
            }

        }
    }
}






