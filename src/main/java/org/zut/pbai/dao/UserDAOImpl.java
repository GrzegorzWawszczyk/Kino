package org.zut.pbai.dao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Seans;
import org.zut.pbai.model.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 2016-09-06.
 */
@Repository
@Transactional
public class UserDAOImpl implements  UserDAO {


    @Autowired
    protected SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Uzytkownik findUserByEmailAndPassword(String email, String password) {

        Session session = this.sessionFactory.getCurrentSession();
        List<Uzytkownik> uzytkownikList = new ArrayList<Uzytkownik>();

        uzytkownikList = sessionFactory.getCurrentSession().createQuery("from Uzytkownik where email=? and haslo=?")
                .setParameter(0,email).setParameter(1,password).list();

        if(uzytkownikList.size() > 0 && uzytkownikList.get(0) != null)
        {
            return  uzytkownikList.get(0);
        }
        else {
            return null;
        }
    }
    
    @Override
    public Uzytkownik findUserByEmail(String email) {

        Session session = this.sessionFactory.getCurrentSession();
        List<Uzytkownik> uzytkownikList = new ArrayList<Uzytkownik>();

        uzytkownikList = sessionFactory.getCurrentSession().createQuery("from Uzytkownik where email=?")
                .setParameter(0,email).list();

        if(uzytkownikList.size() > 0 && uzytkownikList.get(0) != null)
        {
            return  uzytkownikList.get(0);
        }
        else {
            return null;
        }
    }
    
    @Override
    public void insert(Uzytkownik user)
    {
    	Session session = this.sessionFactory.getCurrentSession();
    	if(user != null)
    	{
    		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    		user.setHaslo( passwordEncoder.encode(user.getHaslo()));
    		session.save(user);
    		System.out.println(user.getHaslo());
    	}
        session.save(user);
    }


	@Override
	public List<Uzytkownik> listOfUsers() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Uzytkownik> userList = session.createQuery("from Uzytkownik").list();
        return userList;
	}


	@Override
	public Uzytkownik getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Uzytkownik user = (Uzytkownik) session.get(Uzytkownik.class, new Integer(id));

        if(null != user)
        {
            return user;
        }
        else
        {
            return null;
        }
	}    
	public void update(Uzytkownik user, boolean passwordChanged)
    {
    	Session session = this.sessionFactory.getCurrentSession();
    	if(user != null)
    	{
    		if (passwordChanged)
    		{
	    		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
	    		user.setHaslo( passwordEncoder.encode(user.getHaslo()));
    		}
    		session.merge(user);
    	}
       
    }}
