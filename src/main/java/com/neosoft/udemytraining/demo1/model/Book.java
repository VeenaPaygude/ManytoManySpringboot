package com.neosoft.udemytraining.demo1.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String isbn;
    private String publisher;
    private String title;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public Book(String isbn, String publisher, String title) {
        this.isbn = isbn;
        this.publisher = publisher;
        this.title = title;
    }

    public Book(String isbn, String publisher, String title, Set<Author> authors) {
        this.isbn = isbn;
        this.publisher = publisher;
        this.title = title;
        this.authors = authors;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookid == book.bookid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
