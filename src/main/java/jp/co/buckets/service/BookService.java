package jp.co.buckets.service;

import java.util.List;

import jp.co.buckets.dao.BookDao;
import jp.co.buckets.dto.Book;
import jp.co.buckets.exception.AlreadyExistsDataException;
import jp.co.buckets.exception.NotFoundDataException;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> getAllBook() throws NotFoundDataException {
        List<Book> bookList = bookDao.get();
        if (CollectionUtils.isEmpty(bookList)) { throw new NotFoundDataException(); };
        return bookList;
    }

    public Book getBook(int id) throws NotFoundDataException {
        Book book = bookDao.get(id);
        if (book == null) { throw new NotFoundDataException(); };
        return book;
    }

    public void insertBook(int id, String title) throws AlreadyExistsDataException {
        if (bookDao.get(id) != null) { throw new AlreadyExistsDataException(); };
        Book book = new Book();
        book.setId(id);;
        book.setTitle(title);
        bookDao.insert(book);
    }

}
