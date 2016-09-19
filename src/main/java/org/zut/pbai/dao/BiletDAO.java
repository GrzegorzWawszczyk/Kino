package org.zut.pbai.dao;

import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;

import java.util.List;

/**
 * Created by vadim on 2016-09-07.
 */
public interface BiletDAO {

    public void addBilet(Bilet bilet);
    public void updateBilet(Bilet bilet);
    public List<Bilet> listOfBiletsByUser(int userId);
    public List<Bilet> listOfBiletsBySeans(int seansId);
    public List<Bilet> listOfBilets();
    public List<Bilet> listOfBiletsBySeansAndSeatAvaible(int id, String seat);
    public List<Bilet> listOfBiletsBySeansAndSeat(int id, String seat);
    public Bilet getBiletById(int id);
}
