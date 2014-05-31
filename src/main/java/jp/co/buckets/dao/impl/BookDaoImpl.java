package jp.co.buckets.dao.impl;

import java.util.List;

import jp.co.buckets.dao.BookDao;
import jp.co.buckets.dto.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Book> get() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Book.class).list();
    }
    public Book get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where id = :id")
                .setParameter("id", id);
        return (Book)query.uniqueResult();
    }
    public int insert(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
        return 1;
    }

}
