package org.zut.pbai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.BiletDAO;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.SeansDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Seans;
import org.zut.pbai.model.Uzytkownik;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
@SessionAttributes
public class SeansController {


    @Autowired
    FilmDAO filmDAO;

    @Autowired
    SeansDAO seansDAO;
    
    @Autowired
    BiletDAO biletDAO;
    /**
     * listFilmView action.
     */
    @RequestMapping(value = "/listSeansView", method = RequestMethod.GET)
    public ModelAndView listFilmView(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("listSeans");
        List<Seans> seansList = seansDAO.listOfSeanse();

        model.addObject("seansList", seansList);
        return model;
    }

    /**
     * addFilm action.
     */
   @RequestMapping(value = "/admin/addSeansView", method = RequestMethod.GET)
    public ModelAndView addFilmView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        ModelAndView model = new ModelAndView("/admin/addFilm");
        model.addObject("film", new Film());
        return model;
    }

    /**
     * addFilm action.
     */
    @RequestMapping(value = "/admin/addSeans", method = RequestMethod.POST)
    public ModelAndView addFilm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("film")Film film) {

        film.getIdfilm();
        ModelAndView model = new ModelAndView("redirect://admin/listFilmView");

        if(film.getIdfilm() == null){
            //new film, add it
            filmDAO.addFilm(film);
        }else{
            //existing film, call update
            filmDAO.updateFilm(film);
        }
        return model;
    }

    /**
     * editFilm action.
     */
    @RequestMapping(value = "/editSeans/{id}", method = RequestMethod.GET)
    public ModelAndView editFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("addFilm");
        Film film = filmDAO.getFilmById(id);
        model.addObject("film", film);
        return model;
    }

    /**
     * editFilm action.
     */
    @RequestMapping(value = "/detailsSeans/{id}", method = RequestMethod.GET)
    public ModelAndView detailsFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("filmDetails");
        Film film = filmDAO.getFilmById(id);
        model.addObject("film", film);
        return model;
    }

    /**
     * removeFilm action.
     */
    @RequestMapping(value = "/removeSeans/{id}", method = RequestMethod.GET)
    public ModelAndView removeFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

        filmDAO.removeFilm(id);
        ModelAndView model = new ModelAndView("listOfFilms");
        List<Film> filmList = filmDAO.listOfFilms();
        model.addObject("filmList", filmList);
        return model;
    }

    /**
     * my films  action.
     */




}
