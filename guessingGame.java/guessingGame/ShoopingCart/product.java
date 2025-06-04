public class product {
     private int id;
    private String Name;
    private int price;
//    private boolean isavailable;

    product(int id, String Name, int price){
        this.id = id;
        this.Name = Name;
        this.price = price;
    //    this.isavailable = true;
    }

    public  int getid(){
        return id;
    }

    public  String getname(){
       return Name;
    }

    public int getPrice(){
        return price;
    }

    public boolean isavailable(){
        return true;
    }

    @Override
    public String toString(){
        return "[" + id + "]"+ Name + "="+ price + " " ;
    }
}

class Cartitem{
//    private  int K;
//     private int V;
    // Cartitem(int product, int V){
    //     this.K = K;
    //     this.V = V;
    // }
    private final product Product;
    private int quantity;
    Cartitem(product Product, int quantity){
        this.Product = Product;
        this.quantity = quantity;
    }

    public product getProduct() { return Product; }
    public int getquantity() { return quantity; }

    public void setquantity(int quantity){
        this.quantity = quantity;
    }
   
    public double getTotalPrice() {
        return Product.getPrice()*quantity;
    }

    @Override
    public String toString(){
        return Product.getname() + " x "+ quantity + " " + getTotalPrice();
    }
}
