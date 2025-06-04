import java.util.HashMap;
import java.util.Map;

public class shop {
     private final Map<Integer, Cartitem> cart = new HashMap<>();
    
    public void addToCart(product Product, int quantity){
        if(cart.containsKey(Product.getid())) {
            Cartitem item = cart.get(Product.getid());
            item.setquantity(item.getquantity() + quantity);
        } else {
            cart.put(Product.getid(), new Cartitem(Product, quantity));
        }
        System.out.println("Aded To Cart " + Product.getname());
    }

    public void removeFromCart(int ProductId){
        if(cart.containsKey(ProductId)) {
            cart.remove(ProductId);
            System.out.println(" Item removed from cart  ");
        } else {
            System.out.println("item not found in cart ");
        }
    }

    public void updateQuantity(int ProductId, int quantity){
        if(cart.containsKey(ProductId)) {
            cart.get(ProductId).setquantity(quantity);
            System.out.println("Quantity updated ");
        } else {
            System.out.println("item not found in cart ");
        }
    }

    public void viewCart() {
        if(cart.isEmpty()){
            System.out.println("your cart is empty ");
            return;
        }
        System.out.println("\n ==== your Cart ====");
        for(Cartitem item : cart.values()){
            System.out.println(item);
        }
        System.out.println(calculateTotal());
    }

    public double calculateTotal() {
        return cart.values().stream().mapToDouble(Cartitem:: getTotalPrice).sum();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public void checkOut(){
        if(isEmpty()){
            System.out.println("Cart is eEmpty . Nothing to checkout ");
            return;
        }
        viewCart();
        System.out.println("Thank you for shopping ");
        cart.clear();
    }
}
