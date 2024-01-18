package com.alfili.models;

import javax.swing.*;

public class TextList {
    public static final DefaultListModel<Text> textList = new DefaultListModel<>();

    public static DefaultListModel<Text> getTextList() {
        return  textList;
    }

    public static void addTextToList(Text text) {
        textList.addElement(text);
    }

    public static Text get(int id) {
        return textList.get(id);
    }

    public static void deleteTextFromList(int index) {
        textList.remove(index);
    }
}
