import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class CashRegister {
    public static class Product {
        public final String upc, name; public final double price;
        public Product(String upc, String name, double price){this.upc=upc;this.name=name;this.price=price;}
    }

    private final Map<String,Product> catalog=new LinkedHashMap<>();
    private final List<Product> scanned=new ArrayList<>();

    public CashRegister(String productsPath) throws IOException { load(productsPath); }

    private void load(String path) throws IOException {
        for(String raw:Files.readAllLines(Paths.get(path))){
            String s=raw.trim(); if(s.isEmpty()||s.startsWith("#")||s.toLowerCase().startsWith("upc")) continue;
            String[] t=s.contains(",")?s.split(",",3):s.split("\\s+",3);
            if(t.length<3) continue;
            String upc=t[0].trim(), name=t[1].trim(), price=t[2].trim().replace("$","");
            try{catalog.put(upc,new Product(upc,name,Double.parseDouble(price)));}catch(Exception ignore){}
        }
        if(catalog.isEmpty()) throw new IOException("No products");
    }

    public Product addItemByUPC(String upc){
        Product p=catalog.get(upc);
        if(p!=null) scanned.add(p);
        return p;
    }

    public double getSubtotal(){double s=0; for(Product p:scanned) s+=p.price; return s;}

    public List<Product> getScannedItems(){return Collections.unmodifiableList(scanned);}

    public static String formatRow(Product p){return p.upc+" — "+p.name+" — "+String.format("$%.2f",p.price);}
}
