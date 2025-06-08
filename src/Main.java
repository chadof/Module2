import Collections.MyArrayList;
import Collections.MyHashSet;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        MyHashSet set = new MyHashSet();
        set.add("asd");
        System.out.println(set.contains("asd"));
        System.out.println(set.contains("sad"));

        set.add("asd");set.add("asd");set.add("sad");set.add("sad");set.add("iuo");set.add("dsa");
        set.add(8);set.add(8);

        System.out.println(set.size());

        set.add(12);set.add(117);set.add(111);set.add(116);set.add(2321);
        set.add(12);set.add(121);set.add(131);set.add(1451);set.add(162);
        set.add(171);set.add(181);set.add(191);
        System.out.println(set.size());
        set.remove("asd");
        set.remove(12);set.remove(11);
        System.out.println(set.size());
        System.out.println();

        String[] strings = {"asd","asdas","1","1","1"};
        MyArrayList<String> list = new MyArrayList<>(strings);
        System.out.println(list);
        System.out.println();

        List<Student> students = List.of(
                new Student("Иван", Arrays.asList(
                        new Book("451 градус по фаренгейту", 2001, 200),
                        new Book("Над пропастью во ржи", 1999, 158),
                        new Book("Тихий дон", 1928, 500),
                        new Book("Сто лет одиночества", 1965, 252),
                        new Book("Маленький принц", 1994, 412)
                )),
                new Student("Илья", Arrays.asList(
                        new Book("Мастер и маргарита", 2001, 455),
                        new Book("Гордость и предубеждение", 2002, 456),
                        new Book("Приключение Тома Сойера", 2003, 234),
                        new Book("Отверженные", 2004, 753),
                        new Book("Война и мир", 2005, 532)
                )),
                new Student("Сергей", Arrays.asList(
                        new Book("Собачье сердце", 2006, 833),
                        new Book("Жизнь взаймы", 2007, 885),
                        new Book("Собор Парижской Богоматери", 2008, 544),
                        new Book("Белая Гвардия", 2009, 688),
                        new Book("Маленькие женщины", 20010, 522)
                )),
                new Student("Антон", Arrays.asList(
                        new Book("Белая ярмарка", 2011, 833),
                        new Book("Тысяча и одна ночь", 2012, 885),
                        new Book("Время жить и время умирать", 2013, 544),
                        new Book("Ярмарка тщеславия", 2014, 688),
                        new Book("Мертвые души", 2015, 522)
                ))
        );


        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(book -> book.getYear()>2000)
                .distinct()
                .limit(3)
                .map(Book::getYear)
                .findAny()
                .ifPresentOrElse(
                        year-> System.out.println("Год публикации "+year),
                        ()->System.out.println(("Книга не найдена "))
                );
    }
}
