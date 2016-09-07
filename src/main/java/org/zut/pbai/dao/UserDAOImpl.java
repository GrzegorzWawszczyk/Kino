package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
}
