package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Sala;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SalaDAOImpl implements SalaDAO{

	@Autowired
    protected SessionFactory sessionFactory;
	
	public Sala getSalaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Sala sala = (Sala) session.get(Sala.class, new Integer(id));

        if(null != sala)
        {
            return sala;
        }
        else
        {
            return null;
        }
    }
	
	public void addSala(Sala sala)
	{
		Session session = this.sessionFactory.getCurrentSession();
        session.save(sala);
	}

	public List<Sala> listOfSalas() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Sala> salaList = session.createQuery("from Sala").list();
        return salaList;
	}
	
	
}
