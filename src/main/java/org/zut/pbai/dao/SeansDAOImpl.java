package org.zut.pbai.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;
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
    public void addSeans(Seans seans) {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(seans);

    }
    
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
    
    @Override
    public List<Seans> listOfSeanse() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Seans> seansList = session.createQuery("from Seans where data >= NOW()").list();
        return seansList;
    }

	@Override
	public List<Seans> listOfSeansesByFilm(int idFilm) {
		Session session = this.sessionFactory.getCurrentSession();
        List<Seans> seansList = new ArrayList<Seans>();

        seansList = sessionFactory.getCurrentSession().createQuery("from Seans where idfilm=? AND data >= NOW()")
                .setParameter(0,idFilm).list();

        return seansList;
	}

	@Override
	public void updateSeans(Seans seans) {
		Session session = this.sessionFactory.getCurrentSession();
        session.merge(seans);		
	}

	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Seans seans = (Seans) session.load(Seans.class, new Integer(id));
        if(null != seans){
            session.delete(seans);
        }
		
	}


}
