package home2;

import java.awt.Container;
import java.awt.FlowLayout;
//from w  w w. j  ava 2  s  .  c o  m
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame {
  JMenuBar mb;

  JMenu fm, om, hm; // File, Options, Help

  JMenu opSubm; // Options Sub-Menu

  JMenuItem mi;

  Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());

  
   
    opSubm = new JMenu("SubOptions");
    mi = new JMenuItem("Alpha");
    mi = new JMenuItem("Gamma");
    mi = new JMenuItem("Delta");
    opSubm.add(mi);
    opSubm.add(mi);
    opSubm.add(mi);
    
    mb = new JMenuBar();
    om = new JMenu("Options");
    om.add(opSubm);
    mb.add(om);
   setJMenuBar(mb);

    pack();
  }
  public static void main(String[] arg) {
    Main mb = new Main();
    mb.setVisible(true);
  }
}