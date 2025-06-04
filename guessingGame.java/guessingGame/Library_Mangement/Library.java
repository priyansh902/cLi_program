import java.util.HashMap;
import java.util.Map;

public class Library {
      private Map<Integer, Book> books = new HashMap<>();
    private int nextid = 1;

    public void addBook(String title, String author){
        Book book = new Book(nextid++, title, author);
        books.put(book.getid(), book);
        System.out.println("book added" + book);
    }

    public void removeBook(int id){
        Book removed = books.remove(id);
        if(removed != null){
            System.out.println("Book removedd" + removed.gettitle());

        } else {
            System.out.println("Book not found");
        }
    }

    public void listBooks(){
        if(books.isEmpty()){
            System.out.println("Library is empty");
            return;
        }
        for(Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void borrowVook(int id){
        Book book = books.get(id);
        if(book == null){
            System.out.println("Book not found");

        } else if(book.isBorrowed()) {
            System.out.println("Book is already borrowed");
        } else {
            book.borrow();
            System.out.println("you borrowed" +book.gettitle());
        }
    }

    public void returnBook(int id){
        Book book = books.get(id);
        if(book == null){
            System.out.println("Book not found");
        } else if(!book.isBorrowed()) {
            System.out.println("Book was not borrowed");
        } else {
            book.returnBook();
            System.out.println("you returned " + book.gettitle());
        }
    }
}
