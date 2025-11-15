public class Book {

    //속성 Filed
    private String title; //책 제목
    private String author; //책 저자
    private String rentalStatus; //책 대여여부


    //생성자 Constructor
    public Book(String title, String author, String rentalStatus) {
        this.title = title;
        this.author = author;
        this.rentalStatus = rentalStatus;
    }

    //기능 Method
    public String getTitle() { //책 제목을 가져오기 위한 기능
        return title;
    }

    public String getAuthor() { //책 저자를 가져오기 위한 기능
        return author;
    }
    public String getRentalStatus() { //책 대여 여부를 가져오기 위한기능
        return rentalStatus;
    }

    //대여여부를 수정하기 위한 기능 외부에서 넣은 인자값을 Book 속성값을 rentalStatus 에 대입
    public void setRentalStatus(String rentalStatus) {
        this. rentalStatus = rentalStatus;
    }

}
