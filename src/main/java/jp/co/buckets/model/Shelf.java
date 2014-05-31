package jp.co.buckets.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.buckets.dao.BookDao;
import jp.co.buckets.dto.Book;

public class Shelf {
    List<Book> bookList = new ArrayList<Book>();
    @Autowired
    BookDao bookDao;
    
    public void addBook(Book book) {
        bookList.add(book);
    }
    
    public Book getBook(int id) {
        for (Book book : bookList) {
            if (book.getId() == id) { return book; };
        }
        return null;
    }
    
    public int getBookCount() {
        return bookList.size();
    }
}
