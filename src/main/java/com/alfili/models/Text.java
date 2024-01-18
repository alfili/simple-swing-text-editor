package com.alfili.models;

import java.util.Objects;

public class Text {

    // Other

    private String title;
    private String body;

    public String getTitle() { return title; }
    public String getBody() { return body; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(title, text.title) && Objects.equals(body, text.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body);
    }

    @Override
    public String toString() {
        return "Text{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
