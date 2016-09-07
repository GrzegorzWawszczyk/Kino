package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Film;

import java.util.List;

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
        session.save(film);

    }

    @Override
    public void updateFilm(Film film) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public void removeFilm(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Film film = (Film) session.load(Film.class, new Integer(id));
        if(null != film){
            session.delete(film);
        }
    }

    @Override
    public List<Film> listOfFilms() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Film> filmList = session.createQuery("from Film").list();
        return filmList;
    }

    @Override
    public Film getFilmById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Film film = (Film) session.load(Film.class, new Integer(id));

        if(null != film)
        {
            return film;
        }
        else
        {
            return null;
        }
    }

}
