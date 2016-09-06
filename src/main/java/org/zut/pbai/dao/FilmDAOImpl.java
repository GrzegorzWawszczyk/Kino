package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Film;

/**
 * Created by Vadim on 2016-09-04.
 */
@Repository
@Transactional
public class FilmDAOImpl implements  FilmDAO {


    @Autowired
    protected SessionFactory sessionFactory;
/*	 @Autowired
	 @Qualifier("sessionFactory")
	 private SessionFactory sessionFactory;
	 
	 private Session getCurrentSession() {
		 return sessionFactory.getCurrentSession();
	 }*/

    @Override
    public void addFilm(Film film) {

        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("DAO impl " + film.getAktorzy());

         session.save(film);

    }
}
