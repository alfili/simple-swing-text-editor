package com.alfili.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panel1;
    private JButton AddTextBtn;
    private JButton DeleteTextBtn;
    private JList TextList;
    private JTextPane SelectedText;

    public MainForm() {
        setSize(1280, 720);
        setTitle("МОЙ! Простой! Текстовый редактор.");
        setContentPane(panel1);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        AddTextBtn.setActionCommand("addNewText");

        AddTextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("addNewText")) {
                    AddNewText dialog = new AddNewText();

                    dialog.setSize(650, 650);
                    dialog.setTitle("Добавить новый текст");

                    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    dialog.setVisible(true);
                }
            }
        });
    }
}
