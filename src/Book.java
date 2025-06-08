public class Book {
    private String name;
    private int yearOfPublication;
    private int numberOfPages;

    public Book(String name, int dateOfPublication, int numberOfPages){
        this.name = name;
        this.yearOfPublication = dateOfPublication;
        this.numberOfPages = numberOfPages;
    }
    public String getName() {
        return name;
    }
    public int getYear() {
        return yearOfPublication;
    }
    public int getPages(){
        return numberOfPages;
    }
    public String toString(){
        return "Название: "+name+" Год публикации: "+yearOfPublication+" Количество страниц: "+numberOfPages;
    }
}
