package Practicheskay_4;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Джоан Роулинг", "Гарри Шпротер", 1997);

        System.out.println("Автор: " + book.getAuthor());
        System.out.println("Название: " + book.getTitle());
        System.out.println("Год написания: " + book.getYear());

        book.setTitle("Гарри Поттер");
        System.out.println("Обновленное название: " + book.getTitle());
    }
}
