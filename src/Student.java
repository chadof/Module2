import java.util.List;

public class Student {
    private final String name;
    private final List<Book> bookArray;

    public Student(String name, List<Book> bookArray){
        this.name = name;
        this.bookArray = bookArray;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return bookArray;
    }
    public String toString(){
        return "Имя студента: "+name+" Список книг: "+bookArray;
    }
}
