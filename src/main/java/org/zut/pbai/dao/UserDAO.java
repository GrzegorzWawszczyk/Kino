package org.zut.pbai.dao;

import org.zut.pbai.model.Uzytkownik;

/**
 * Created by Vadim on 2016-09-06.
 */
public interface UserDAO {
    Uzytkownik findUserByEmailAndPassword(String email, String password);
}
