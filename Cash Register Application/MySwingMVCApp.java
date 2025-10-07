import javax.swing.SwingUtilities;

public class MySwingMVCApp {
    public static void main(String[] args){
        //ensures gui creation & update EDT to avoid concurrency issues
        SwingUtilities.invokeLater(()->{
            try{
                //file path
                String PRODUCTS="products.csv";
                // creat emodel
                CashRegister m=new CashRegister(PRODUCTS);
                //create view
                View v=new View();
                //create scanner
                Scanner s=new Scanner(PRODUCTS);
                //create controller
                new Controller(m,v,s).start();
            }catch(Exception e)
            {
                //print exceptions
                e.printStackTrace();
            }
        });
    }
}
