import javax.swing.*;

public class Controller {
    //references components
    private final CashRegister model;
    private final View view;
    private final Scanner scanner;

    //constructor connects model, view and scanner components

    public Controller(CashRegister m, View v, Scanner s){this.model=m; this.view=v; this.scanner=s;}
    //starts the application
    public void start(){
        //ensures GUI components are shown on EDT
        SwingUtilities.invokeLater(()->{view.show(); scanner.show();});
        scanner.addScanListener(this::onUPC);
    }
    //called whenever UPC is scanned
    private void onUPC(String upc){
        //ask the model to add the product that matches UPC
        System.out.println("I am scanning");
        CashRegister.Product p=model.addItemByUPC(upc);
        if(p==null){
            JOptionPane.showMessageDialog(null,"Unknown UPC: "+upc,"Not Found",JOptionPane.WARNING_MESSAGE);
            return;
        }
        //add scanned product to the display in view
        view.appendRow(CashRegister.formatRow(p));
        //update subtotal
        view.setSubtotal(model.getSubtotal());
    }
}
