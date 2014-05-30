package jp.co.buckets.service;

import jp.co.buckets.dao.DaoImpl;
import jp.co.buckets.dto.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookInsertService {
    @Autowired
    DaoImpl daoImpl;
    @Transactional
    public void transactionTest() {
        Book book = new Book();
        book.setId(11);;
        book.setTitle("test書籍");
        daoImpl.insert(book);
    }

}
