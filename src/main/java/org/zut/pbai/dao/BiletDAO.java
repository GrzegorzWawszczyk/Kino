package org.zut.pbai.dao;

import org.zut.pbai.model.Bilet;

import java.util.List;

/**
 * Created by vadim on 2016-09-07.
 */
public interface BiletDAO {

    public void addBilet(Bilet bilet);
    public List<Bilet> listOfBiletsByUser(int userId);
    public List<Bilet> listOfBilets();

}
