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
}
