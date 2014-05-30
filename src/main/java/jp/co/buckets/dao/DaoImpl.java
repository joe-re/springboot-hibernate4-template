package jp.co.buckets.dao;

import jp.co.buckets.dto.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl extends AbstractDao{
    @Autowired
    private SessionFactory sessionFactory;

    public int insert(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);

        return 1;
        
    }

}
