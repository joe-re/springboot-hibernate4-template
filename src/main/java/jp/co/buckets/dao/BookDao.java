package jp.co.buckets.dao;

import java.util.List;

import jp.co.buckets.dto.Book;

public interface BookDao {
    public List<Book> get();
    public Book get(int id);
    public int insert(Book book);
}
