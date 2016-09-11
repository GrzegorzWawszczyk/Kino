package org.zut.pbai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;

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

    	System.out.println("TEST: " + bilet.getMiejsce());
        Session session = this.sessionFactory.getCurrentSession();
        if(this.listOfBiletsBySeansAndSeat(bilet.getSeans().getIdseans(), bilet.getMiejsce()) == null)
        {
        	System.out.println("TEST3: " + bilet.getMiejsce());
        	if(Integer.parseInt(bilet.getMiejsce()) <= (bilet.getSeans().getSala().getLiczbaKolumn()
        			* bilet.getSeans().getSala().getLiczbaRzedow())
        	)
        	{
        		System.out.println("TEST2: " + bilet.getMiejsce());
        		session.save(bilet);
        	}
        }
    }

    @Override
    public void updateBilet(Bilet bilet) {

        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("TEST: " + bilet.getMiejsce());
       // if(this.listOfBiletsBySeansAndSeatAvaible(bilet.getSeans().getIdseans(), bilet.getMiejsce()) != null)
       // {
        	System.out.println("TEST2: " + bilet.getMiejsce());
        	if(Integer.parseInt(bilet.getMiejsce()) <= (bilet.getSeans().getSala().getLiczbaKolumn()
        			* bilet.getSeans().getSala().getLiczbaRzedow())
        	)
        	{
        		System.out.println("TEST3: " + bilet.getMiejsce());
        		session.merge(bilet);
        	}
      //  }
        
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
    public List<Bilet> listOfBiletsBySeans(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bilet> biletList = new ArrayList<Bilet>();

        biletList = sessionFactory.getCurrentSession().createQuery("from Bilet where idseans=?")
                .setParameter(0,id).list();

        return biletList;
    }
    public List<Bilet> listOfBiletsBySeansAndSeatAvaible(int id, String seat) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bilet> biletList = new ArrayList<Bilet>();

        biletList = sessionFactory.getCurrentSession().createQuery("from Bilet where idseans=? and miejsce = ? and (stan = ? or stan = ?)")
                .setParameter(0,id).setParameter(1,seat).setParameter(2, "zarezerwowany").setParameter(3, "kupiony").list();

        return biletList.isEmpty() ? null : biletList;
    }
    
    public List<Bilet> listOfBiletsBySeansAndSeat(int id, String seat) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bilet> biletList = new ArrayList<Bilet>();

        biletList = sessionFactory.getCurrentSession().createQuery("from Bilet where idseans=? and miejsce = ? and (stan = ? or stan = ?)")
                .setParameter(0,id).setParameter(1,seat).setParameter(2, "zarezerwowany").setParameter(3, "kupiony").list();

        return biletList.isEmpty() ? null : biletList;
    }
    @Override
    public List<Bilet> listOfBilets() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Bilet> biletList = session.createQuery("from Bilet ORDER BY seans.data DESC").list();
        return biletList;
    }
    
    @Override
    public Bilet getBiletById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bilet bilet = (Bilet) session.get(Bilet.class, new Integer(id));

        if(null != bilet)
        {
            return bilet;
        }
        else
        {
            return null;
        }
    }


}
