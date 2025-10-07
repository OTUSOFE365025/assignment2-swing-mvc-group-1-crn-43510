import javax.swing.*;

public class Controller {
    private final CashRegister model;
    private final View view;
    private final Scanner scanner;

    public Controller(CashRegister m, View v, Scanner s){this.model=m; this.view=v; this.scanner=s;}

    public void start(){
        SwingUtilities.invokeLater(()->{view.show(); scanner.show();});
        scanner.addScanListener(this::onUPC);
    }

    private void onUPC(String upc){
        CashRegister.Product p=model.addItemByUPC(upc);
        if(p==null){JOptionPane.showMessageDialog(null,"Unknown UPC: "+upc,"Not Found",JOptionPane.WARNING_MESSAGE);return;}
        view.appendRow(CashRegister.formatRow(p));
        view.setSubtotal(model.getSubtotal());
    }
}
