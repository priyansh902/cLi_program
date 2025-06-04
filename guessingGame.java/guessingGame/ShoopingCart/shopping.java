import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class shopping {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<product> PRODUCTS = new ArrayList<>();
    private static final shop cart = new shop();
    private static final Map<Integer, product> pr = new HashMap<>();

    

    public static void main(String[] args) {

        
        productsin();
        int choice ;
        do {
            showmenu();
            try {
                choice = Integer.parseInt(sc.nextLine());
                handleChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input ");
                choice =-1;
            }
        } while (choice != 7);
    }

    private static void productsin() {
         PRODUCTS.add(new product(1, "Laptop", 45000));
        PRODUCTS.add(new product(2, "pnfn", 450));
        PRODUCTS.add(new product(3, "Lop", 4500));
        PRODUCTS.add(new product(4, "aptop", 4000));
       

    }

    private static void seedProducts() {
        int number = 0;
       
    //     PRODUCTS.add(new product(Integer.parseInt(sc.nextLine()), sc.nextLine(), Integer.parseInt(sc.nextLine())));
    
    //  sc.nextLine();
    System.out.println(" enter product name");
    String name = sc.nextLine();
    System.out.println("Enter product price ");
    int price = Integer.parseInt(sc.nextLine());
    // product productd = PRODUCTS.add(new product(number, name, price));

    product Product = new product(number, name, price);
    pr.put(number, Product);
    number++;
    System.out.println("product added " + pr);
     }

    private static void showmenu() {
        System.out.println("\n === Shoping Cart ====");
        System.out.println("1. View Product ");
        System.out.println("2.Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Update Cart");
        System.out.println("5. Check out");
       System.out.println("6. add new  Product ");
        System.out.println("7. Exit");
         
        System.out.println("Enter Choicec");
    }

    private static void handleChoice(int choice){
        switch (choice) {
            case 1 -> showProducts();
            case 2 -> addProductToCart();
            case 3 -> cart.viewCart();
            case 4 -> updateQuantity();
            case 5 -> cart.checkOut();
            case 6 -> seedProducts();
            case 7 -> System.out.println("Good Bye");
             
            default -> System.out.println("Invalid choice ");
        }
    }

    private static void showProducts() {
        System.out.println("\n ==== Available Products ===");
        for(product p : PRODUCTS){
            System.out.println(p);
        }
    }

    private static void addProductToCart() {
        showProducts();
        System.out.println("Enter Product id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter quantity");
        int qty = Integer.parseInt(sc.nextLine());

        product selected = findByProduct(id);
        if(selected != null){
            cart.addToCart(selected, qty);

        } else {
            System.out.println("Product not found ");
        }
    }
    private static void updateQuantity() {
        cart.viewCart();
        System.out.println("Enter product id to update ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter new quantity");
        int qty = Integer.parseInt(sc.nextLine());
        cart.updateQuantity(id, qty);
    }

    private static product findByProduct(int id) {
        for (product p : PRODUCTS){
            if(p.getid() == id) return p;
        }
        return null;
    }
}
