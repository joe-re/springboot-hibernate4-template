package jp.co.buckets.service;

import java.util.List;

import jp.co.buckets.dto.Book;
import jp.co.buckets.exception.AlreadyExistsDataException;
import jp.co.buckets.exception.NotFoundDataException;

public interface BookService {
    public List<Book> getAllBook() throws NotFoundDataException;
    public Book getBook(int id) throws NotFoundDataException;
    public void insertBook(int id, String title) throws AlreadyExistsDataException;

}
