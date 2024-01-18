package com.alfili.forms;

import com.alfili.models.TextList;

import javax.swing.*;
import java.awt.event.*;

public class DeleteTextItem extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel deleteTextTitleWarning;

    private int itemIndex;
    private JTextPane textPane;

    public DeleteTextItem(int index, JTextPane textPane) {

        this.itemIndex = index;
        this.textPane = textPane;

        deleteTextTitleWarning.setText("Вы действительно хотите удалить текст: " + TextList.get(this.itemIndex).getTitle() + "?");

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        textPane.setText("");
        TextList.deleteTextFromList(this.itemIndex);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
