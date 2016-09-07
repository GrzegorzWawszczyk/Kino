package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Seans;

/**
 * Created by Vadim on 2016-09-07.
 */
@Repository
@Transactional
public class SeansDAOImpl implements SeansDAO{


    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Seans getsSeansById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Seans seans = (Seans) session.get(Seans.class, new Integer(id));

        if(null != seans)
        {
            return seans;
        }
        else
        {
            return null;
        }
    }



}
