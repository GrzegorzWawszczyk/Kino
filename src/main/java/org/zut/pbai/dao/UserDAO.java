package org.zut.pbai.dao;

import java.util.List;

import org.zut.pbai.model.Seans;
import org.zut.pbai.model.Uzytkownik;

/**
 * Created by Vadim on 2016-09-06.
 */
public interface UserDAO {
    Uzytkownik findUserByEmailAndPassword(String email, String password);
    Uzytkownik findUserByEmail(String email);
    public Uzytkownik getUserById(int id);
    public void update(Uzytkownik user, boolean passwordChanged);
    public List<Uzytkownik> listOfUsers();    
    public void insert(Uzytkownik user);
}
