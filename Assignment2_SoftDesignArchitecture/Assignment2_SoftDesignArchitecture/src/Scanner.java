import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Scanner {
    public interface ScanListener{void scanned(String upc);}

    private final JFrame frame=new JFrame("Scanner");
    private final JButton scan=new JButton("Scan");
    private final List<String> upcs=new ArrayList<>();
    private final List<ScanListener> listeners=new ArrayList<>();
    private final Random rnd=new Random();

    public Scanner(String productsPath) throws IOException{
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(8,8));
        frame.add(new JLabel("Click Scan"),BorderLayout.CENTER);
        JPanel south=new JPanel(); south.add(scan); frame.add(south,BorderLayout.SOUTH);
        frame.setSize(260,140); frame.setLocationByPlatform(true);
        loadUPCs(productsPath);
        scan.addActionListener(e->onScan());
    }

    private void loadUPCs(String path) throws IOException{
        for(String raw:Files.readAllLines(Paths.get(path))){
            String s=raw.trim(); if(s.isEmpty()||s.startsWith("#")||s.toLowerCase().startsWith("upc")) continue;
            String first=s.contains(",")?s.split(",",2)[0].trim():s.split("\\s+",2)[0].trim();
            if(first.matches("\\d+")) upcs.add(first);
        }
        if(upcs.isEmpty()) throw new IOException("No UPCs");
    }

    private void onScan(){
        if(upcs.isEmpty()){JOptionPane.showMessageDialog(frame,"No UPCs","Error",JOptionPane.ERROR_MESSAGE);return;}
        String upc=upcs.get(rnd.nextInt(upcs.size()));
        System.out.println(upc);
        for(ScanListener l:listeners) l.scanned(upc);
    }

    public void show(){frame.setVisible(true);}
    public void addScanListener(ScanListener l){listeners.add(l);}
}
