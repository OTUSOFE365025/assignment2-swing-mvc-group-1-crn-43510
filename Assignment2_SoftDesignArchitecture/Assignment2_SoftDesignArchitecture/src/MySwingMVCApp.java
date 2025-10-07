import javax.swing.SwingUtilities;

public class MySwingMVCApp {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            try{
                String PRODUCTS="products.csv";
                CashRegister m=new CashRegister(PRODUCTS);
                View v=new View();
                Scanner s=new Scanner(PRODUCTS);
                new Controller(m,v,s).start();
            }catch(Exception e){e.printStackTrace();}
        });
    }
}
