import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

//scanner class simulate barcode scanner device

public class Scanner {
    //listerner interface for notifying other components
    public interface ScanListener{void scanned(String upc);}
    //GUI componenets
    private final JFrame frame=new JFrame("Scanner");
    private final JButton scan=new JButton("Scan");
    //data structures
    private final List<String> upcs=new ArrayList<>();
    private final List<ScanListener> listeners=new ArrayList<>();
    private final Random rnd=new Random();
    //constructor initializes the GUI and loads UPC codes from specified file
    public Scanner(String productsPath) throws IOException{
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(8,8));
        frame.add(new JLabel("Click Scan"),BorderLayout.CENTER);
        JPanel south=new JPanel(); south.add(scan); frame.add(south,BorderLayout.SOUTH);
        frame.setSize(260,140); frame.setLocationByPlatform(true);
        loadUPCs(productsPath);
        scan.addActionListener(e->onScan());
    }
    //read all UPC codes (Ignores comments, headers, and empty lines)
    private void loadUPCs(String path) throws IOException{
        for(String raw:Files.readAllLines(Paths.get(path))){
            String s=raw.trim(); if(s.isEmpty()||s.startsWith("#")||s.toLowerCase().startsWith("upc")) continue;
            String first=s.contains(",")?s.split(",",2)[0].trim():s.split("\\s+",2)[0].trim();
            if(first.matches("\\d+")) upcs.add(first);
        }
        if(upcs.isEmpty()) throw new IOException("No UPCs");
    }
    //handles a simulated scan event (random selection of UPC from list and notifies all listeners
    private void onScan(){
        if(upcs.isEmpty()){JOptionPane.showMessageDialog(frame,"No UPCs","Error",JOptionPane.ERROR_MESSAGE);return;}
        String upc=upcs.get(rnd.nextInt(upcs.size()));
        System.out.println(upc);
        for(ScanListener l:listeners) l.scanned(upc);
    }
    //show scanner window
    public void show(){frame.setVisible(true);}
    //register listener to be notified after each scan occurs
    public void addScanListener(ScanListener l){listeners.add(l);}
}
