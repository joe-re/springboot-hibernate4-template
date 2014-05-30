package jp.co.buckets.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrectSession() {
        return sessionFactory.getCurrentSession();
    }

}
