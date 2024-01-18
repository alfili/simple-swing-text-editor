package com.alfili.models;

import java.util.ArrayList;

public class TextList {

    // Global static vars
    private static final ArrayList<Text> textList = new ArrayList<>();

    public static ArrayList<Text> getTextList() {
        return  textList;
    }

    public static void addTextToList(Text text) {
        textList.add(text);
    }
}
