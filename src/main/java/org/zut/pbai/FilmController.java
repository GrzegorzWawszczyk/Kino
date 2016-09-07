package org.zut.pbai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Film;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Vadim on 2016-09-04.
 */
@Controller
@SessionAttributes("user")
public class FilmController {


    @Autowired
    FilmDAO filmDAO;


    /**
     * listFilmView action.
     */
    @RequestMapping(value = "/listFilmView", method = RequestMethod.GET)
    public ModelAndView listFilmView(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("listOfFilms");
        List<Film> filmList = filmDAO.listOfFilms();
        model.addObject("filmList", filmList);
        return model;
    }

    /**
     * addFilm action.
     */
   @RequestMapping(value = "/addFilmView", method = RequestMethod.GET)
    public ModelAndView addFilmView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        ModelAndView model = new ModelAndView("addFilm");
        model.addObject("film", new Film());
        return model;
    }

    /**
     * addFilm action.
     */
    @RequestMapping(value = "/addFilm", method = RequestMethod.POST)
    public ModelAndView addFilm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("film")Film film) {

        film.getIdfilm();
        ModelAndView model = new ModelAndView("redirect:/listFilmView");

        if(film.getIdfilm() == 0){
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
    @RequestMapping(value = "/editFilm/{id}", method = RequestMethod.GET)
    public ModelAndView editFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("addFilm");
        model.addObject("film", filmDAO.getFilmById(id));
        return model;
    }

    /**
     * removeFilm action.
     */
    @RequestMapping(value = "/removeFilm/{id}", method = RequestMethod.GET)
    public ModelAndView removeFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

        filmDAO.removeFilm(id);
        ModelAndView model = new ModelAndView("listOfFilms");
        List<Film> filmList = filmDAO.listOfFilms();
        model.addObject("filmList", filmList);
        return model;
    }
}
