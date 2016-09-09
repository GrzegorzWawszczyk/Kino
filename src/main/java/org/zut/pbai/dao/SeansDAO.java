package org.zut.pbai.dao;

import java.util.List;

import org.zut.pbai.model.Seans;

/**
 * Created by Vadim on 2016-09-07.
 */
public interface SeansDAO {

    public Seans getsSeansById(int id);
    public List<Seans> listOfSeanse();
}
