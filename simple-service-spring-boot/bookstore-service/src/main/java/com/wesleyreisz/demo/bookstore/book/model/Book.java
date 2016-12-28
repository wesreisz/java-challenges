package com.wesleyreisz.demo.bookstore.book.model;

import java.util.Date;

/**
 * Created by wesleyreisz on 12/28/16.
 */
public class Book {
    private String isbn;
    private String name;
    private Author authorName;
    private Date releaseDate;

    public Book(String isbn, String name, Author authorName, Date releaseDate) {
        this.isbn = isbn;
        this.name = name;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public Book() {}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", authorName=" + authorName +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
