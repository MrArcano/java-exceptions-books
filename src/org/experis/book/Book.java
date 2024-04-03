package org.experis.book;

public class Book {
    private String title;
    private int page;
    private  String author;
    private String editor;

    public Book(String title, int page, String author, String editor) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (page <= 0) {
            throw new IllegalArgumentException("Page count must be greater than zero");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        if (editor == null || editor.trim().isEmpty()) {
            throw new IllegalArgumentException("Editor cannot be empty");
        }
        this.title = title;
        this.page = page;
        this.author = author;
        this.editor = editor;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getPage() {
        return page;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    // Setter methods
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setPage(int page) {
        if (page <= 0) {
            throw new IllegalArgumentException("Page count must be greater than zero");
        }
        this.page = page;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    public void setEditor(String editor) {
        if (editor == null || editor.trim().isEmpty()) {
            throw new IllegalArgumentException("Editor cannot be empty");
        }
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Book {" +
                " title='" + title + '\'' +
                ", page=" + page +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                " }";
    }
}
