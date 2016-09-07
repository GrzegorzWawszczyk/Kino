package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Bilet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadim on 2016-09-07.
 */
@Repository
@Transactional
public class BiletDAOImpl implements  BiletDAO{


    @Autowired
    protected SessionFactory sessionFactory;


    @Override
    public void addBilet(Bilet bilet) {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(bilet);

    }

    @Override
    public List<Bilet> listOfBiletsByUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bilet> biletList = new ArrayList<Bilet>();

        biletList = sessionFactory.getCurrentSession().createQuery("from Bilet where idklient=?")
                .setParameter(0,id).list();

        return biletList;
    }

    @Override
    public List<Bilet> listOfBilets() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Bilet> biletList = session.createQuery("from Bilet").list();
        return biletList;
    }



}
