package com.alfili.forms;

import com.alfili.models.Text;
import com.alfili.models.TextList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panel1;
    private JButton AddTextBtn;
    private JButton DeleteTextBtn;
    private JList<Text> FormTextList;
    private JTextPane SelectedText;

    public MainForm() {

        setSize(1280, 720);
        setTitle("МОЙ! Простой! Текстовый редактор.");
        setContentPane(panel1);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        FormTextList.setModel(TextList.getTextList());

        DeleteTextBtn.setEnabled(!FormTextList.isSelectionEmpty());

        AddTextBtn.setActionCommand("addNewText");
        DeleteTextBtn.setActionCommand("deleteText");

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
        FormTextList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                DeleteTextBtn.setEnabled(!FormTextList.isSelectionEmpty());

                if(!FormTextList.isSelectionEmpty()) {
                    SelectedText.setText(TextList.get(FormTextList.getSelectedIndex()).getBody());
                }
            }
        });
        DeleteTextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("deleteText")) {
                    SelectedText.setText("");
                    TextList.deleteTextFromList(FormTextList.getSelectedIndex());
                }
            }
        });
    }
}
