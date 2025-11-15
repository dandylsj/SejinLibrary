public class Book {

    //속성 Filed
    private String title;
    private String author;
    private String rentalStatus;

    //생성자 Constructor
    Book(String title, String author, String rentalStatus) {
        this.title = title;
        this.author = author;
        this.rentalStatus = rentalStatus;


    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getRentalStatus() {
        return rentalStatus;
    }

}

