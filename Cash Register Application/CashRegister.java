import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class CashRegister {
    // represents a single product with UPC, Name, and Price
    public static class Product {
        public final String upc, name;
        public final double price;
        // product constructor
        public Product(String upc, String name, double price)
        {
            this.upc=upc;
            this.name=name;
            this.price=price;}
    }
    //product catalog mapped by UPC
    private final Map<String,Product> catalog=new LinkedHashMap<>();
    //products scanned during transaction
    private final List<Product> scanned=new ArrayList<>();

    public CashRegister(String productsPath) throws IOException { load(productsPath); }
    // loads product data from file into catalog
    // expected format each line contains UPC,name,price seperated by comma / space
    private void load(String path) throws IOException {
        for(String raw:Files.readAllLines(Paths.get(path))){
            String s=raw.trim();
            if(s.isEmpty()||s.startsWith("#")||s.toLowerCase().startsWith("upc")) continue;
            String[] t=s.contains(",")?s.split(",",3):s.split("\\s+",3);
            if(t.length<3) continue;
            String upc=t[0].trim(), name=t[1].trim(), price=t[2].trim().replace("$","");
            try{catalog.put(upc,new Product(upc,name,Double.parseDouble(price)));}catch(Exception ignore){}
        }
        if(catalog.isEmpty()) throw new IOException("No products");
    }
//add a products to teh scanned list using its UPC
    public Product addItemByUPC(String upc){
        Product p=catalog.get(upc);
        if(p!=null) scanned.add(p);
        return p;
    }
//calculate running subtotal
    public double getSubtotal()
    {
        double s=0;
        for(Product p:scanned) s+=p.price;
        return s;
    }
//return unmodifiable view of scanned item
    public List<Product> getScannedItems(){return Collections.unmodifiableList(scanned);}
//format product info
    public static String formatRow(Product p){return p.upc+" — "+p.name+" — "+String.format("$%.2f",p.price);}
}
