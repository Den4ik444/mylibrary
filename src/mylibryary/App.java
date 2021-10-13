
package mylibryary;

import java.util.Scanner;
import myClasses.Author;
import myClasses.Book;
import myClasses.Reader;
import myClasses.History;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    
    public void run(){
        String repeat = "r";
        do{
            System.out.println("Выберите номер задачи: ");
            System.out.println("0: Выход из программы");
            System.out.println("1: Добавить книгу");
            System.out.println("2: Список книг");
            System.out.println("3. Зарегистрировать нового читателя");
            System.out.println("4: Список читателей");
            System.out.println("5: Выдать книгу");
            System.out.println("6: список выданых книг");
            System.out.println("7: возврат книги");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("Пока! :)");
                    break;
                case 1:
                    System.out.println("---- Добавление книги ----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = addBook();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("---- Список книг -----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(books[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i] = addReader();
                            break;
                        }
                    }
                case 4:
                    System.out.println("---- Список книг -----");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.println(readers[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("---- выдать книгу -----");
                        for (int i = 0; i < histories.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }
                    }
                case 6:
                    printGivenBooks();
                    break;
                    
            
                case 7: 
                    System.out.println("Вернуть книгу: ");
                    printGivenBooks();
                    System.out.print("Выберите возвращаемую книгу: ");
                    int historyNumber = scanner.nextInt(); scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories[historyNumber-1].setReturnedDate(c.getTime());
                    break;
                    
                default:
                    System.out.println("Введите номер из списка!");
            
            }
        }while("r".equals(repeat));
    }
    private Book addBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setBookName(scanner.nextLine());
        System.out.print("Введите год публикации книги: ");
        book.setPublishedYear(scanner.nextInt()); scanner.nextLine();
        System.out.println("Автор книги: ");
        System.out.print("Введите количество авторов: ");
        int countAutors = scanner.nextInt(); scanner.nextLine();
        Author[] authors = new Author[countAutors];
        for (int i = 0; i < authors.length; i++) {
            Author author = new Author();
            System.out.print("Введите имя автора "+(i+1)+": ");
            author.setFirstName(scanner.nextLine());
            System.out.print("Введите фамилию автора: ");
            author.setLastName(scanner.nextLine());
            System.out.print("Введите год рождения автора: ");
            author.setYear(scanner.nextInt());scanner.nextLine();
            authors[i] = author;
        }
        book.setAuthor(authors);

        return book;
    }
    private Reader addReader(){
        Reader reader = new Reader();
        System.out.print("Введите имя: ");
        reader.setFirstName(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        reader.setLastName(scanner.nextLine());
        System.out.print("Введите номер телефона ");
        reader.setPhone (scanner.nextLine());
        return reader;
    }
    private History addHistory(){
        History history = new History();
        
        
        System.out.println("Список книг: ");
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null){
                System.out.println(i+1+". "+books[i].toString());
            }
        }
        System.out.print("Введите номерк книги: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список читателей: ");
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] != null){
                System.out.println(i+1+". "+readers[i].toString());
            }
        }
        System.out.print("Введите номерк читателя: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        history.setBook(books[numberBook-1]);
        history.setReader(readers[numberReader-1]);
        Calendar c = new GregorianCalendar();
        history.setGivenDate(c.getTime());
        return history;
    }
    private void printGivenBooks(){
        System.out.println("Список читаемых книг:");
        int n = 0;
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null && histories[i].getReturnedDate() == null){
                System.out.println(i+1+". Книгу "
                    +histories[i].getBook().getBookName()
                    +" читает "+histories[i].getReader().getFirstName()
                    +" "+histories[i].getReader().getLastName());
                    n++;
            }
        }
        if(n < 1){
            System.out.println("Нет читаемых книг!");
        }
    }
}