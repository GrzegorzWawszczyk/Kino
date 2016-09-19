package org.zut.pbai.dao;

import java.util.List;

import org.zut.pbai.model.Seans;

/**
 * Created by Vadim on 2016-09-07.
 */
public interface SeansDAO {

	public void addSeans(Seans seans);
	public void updateSeans(Seans seans);
    public Seans getsSeansById(int id);
    public void remove(int id);
    public List<Seans> listOfSeanse();
    public List<Seans> listOfSeansesByFilm(int idFilm);
}
