package org.zut.pbai.dao;

import org.zut.pbai.model.Film;

import java.util.List;

/**
 * Created by Vadim on 2016-09-04.
 */
public interface FilmDAO {

    public void addFilm(Film film);
    public void updateFilm(Film film);
    public void removeFilm(int id);
    public List<Film> listOfFilms();
    public Film getFilmById(int id);

}
