/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home2;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
 
public class Textedit extends JFrame implements ActionListener {
 
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem newMenuItem, openMenuItem, saveMenuItem, printMenuItem, cutMenuItem, copyMenuItem, pasteMenuItem;
    private JButton closeButton;
    private Clipboard clipboard;
 
    public Textedit() {
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
 
        // create text area
        textArea = new JTextArea();
 
        // create menu bar
        menuBar = new JMenuBar();
 
        // create file menu and menu items
        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(this);
        openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);
        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);
        printMenuItem = new JMenuItem("Print");
        printMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(printMenuItem);
 
        // create edit menu and menu items
        editMenu = new JMenu("Edit");
        cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(this);
        copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(this);
        pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(this);
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
           cutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });
           printMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        });
        copyMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });
         pasteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        // add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
 
        // create close button
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
 
        // add components to frame
        setJMenuBar(menuBar);
        add(textArea, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);
 
        // initialize clipboard
        clipboard = getToolkit().getSystemClipboard();
 
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("New")) {
            textArea.setText("");
        } else if (command.equals("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    reader.close();
                    textArea.setText(stringBuilder.toString());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (command.equals("Save")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                    textArea.write(writer);
                    writer.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error writing file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
       
    public static void main(String[] arg) {
    Textedit mb = new Textedit();
    mb.setVisible(true);
  }
}
