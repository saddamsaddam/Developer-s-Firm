/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home2;

/**
 *
 * @author 01957
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;

public class TextEditor extends JFrame {
    // create the undo manager
    private final UndoManager undoManager = new UndoManager();

    // create the text area
    private final JTextArea textArea = new JTextArea();

    public TextEditor() {
        // create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // create the edit menu
        JMenu editMenu = new JMenu("Edit");

        // create the undo menu item
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        undoMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });
        editMenu.add(undoMenuItem);

        // create the redo menu item
        JMenuItem redoMenuItem = new JMenuItem("Redo");
        redoMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        });
        editMenu.add(redoMenuItem);

        // add the edit menu to the menu bar
        menuBar.add(editMenu);

        // set the menu bar
        setJMenuBar(menuBar);

        // add the text area to the frame
        add(textArea);

        // create the undoable edit listener
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        // set the frame properties
        setTitle("Text Editor");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
