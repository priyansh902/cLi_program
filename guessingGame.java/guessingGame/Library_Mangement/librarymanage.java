import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class librarymanage {
   public static final Scanner sc = new Scanner(System.in);
    private static final Library library = new Library();

    String Books;
    public inventry(String Books){
        this.Books = Books;
    }

    //add books
    public static void add( ArrayList<String> list,  String Books){
       
        list.add(Books);
        System.out.println(list+" ");
    }

    //remove books

    public static void Remove( ArrayList<String> list, String Books){
        list.remove(Books);
        System.out.println(list+ " ");
    }

    //borrow
    public static void borrow( HashMap<String, String> bw , String name, String Books){
       
        bw.put(name, Books);
        
        System.out.println(bw+" ");
    }

    public static void Return( HashMap<String, String> bw , String name, String Books){

        bw.remove(name, Books);
        System.out.println(bw+" ");
    }

    public static void main(String[] args) {
  
    //      ArrayList<String> list = new ArrayList<>();
    //       HashMap<String, String> bw = new HashMap<>();

    //     add(list,"Ram");
    //     add(list, "math");
    //     Remove(list, "math");
    //     borrow(bw, "Ram", "science");
    //     borrow(bw, "Ram", "Math");
    //    Return(bw, "Ram", "Math");

    int choice;
    do {
        showmenu();
        try {
            choice = Integer.parseInt(sc.nextLine());
            handleChoice(choice);
        } catch (NumberFormatException e){
            System.out.println("Invalid input: please enter a number ");
            choice = -1;
        }

    } while (choice != 6);
    }


    private static void showmenu() {
        System.out.println("\n ==== Library management system=====");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. List all Books");
        System.out.println("4. Borrow book");
        System.out.println("5. Return Book");
        System.out.println("6. exit");
        System.out.println("Enter your choice: ");
    }

    private static void handleChoice(int choice){
        switch (choice) {
            case 1 -> addBook();
            case 2 -> removeBook();
            case 3 -> library.listBooks();
            case 4 -> borrowBook();
            case 5 -> returnBook();
            case 6 -> System.out.println("Existing..... GoodBye");
            default -> System.out.println("Invalid choice. Try Again");
        }
    }

    private static void addBook() {
        System.out.println("Enter title: ");
        String title = sc.nextLine();

        System.out.println("enter author: ");
        String author = sc.nextLine();

        library.addBook(title, author);
    }

    private static void removeBook() {
        System.out.println(" Enter Book id to remove ");
        int id = Integer.parseInt(sc.nextLine());
        library.removeBook(id);
    }

    private static void borrowBook() {
        System.out.println(" Enter book to borrow ");
        int id = Integer.parseInt(sc.nextLine());
        library.borrowVook(id);
    }

    private static void returnBook() {
        System.out.println(" Enter book id to remove ");
        int id = Integer.parseInt(sc.nextLine());
        library.returnBook(id);
    }
 
}
