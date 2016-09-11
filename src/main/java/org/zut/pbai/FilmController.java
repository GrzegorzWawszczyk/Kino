package org.zut.pbai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.BiletDAO;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Uzytkownik;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by Vadim on 2016-09-04.
 */
@Controller
@SessionAttributes
public class FilmController {


    @Autowired
    FilmDAO filmDAO;


    @Autowired
    BiletDAO biletDAO;
    
    @Autowired
    UserDAO userDAO;
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
   @RequestMapping(value = "/admin/addFilmView", method = RequestMethod.GET)
    public ModelAndView addFilmView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        ModelAndView model = new ModelAndView("/admin/addFilm");
        model.addObject("film", new Film());
        return model;
    }

    /**
     * addFilm action.
     */
    @RequestMapping(value = "/admin/addFilm", method = RequestMethod.POST)
    public ModelAndView addFilm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("film")Film film) {

        film.getIdfilm();
        ModelAndView model = new ModelAndView("redirect:/listFilmView");

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
    @RequestMapping(value = "/admin/editFilm/{id}", method = RequestMethod.GET)
    public ModelAndView editFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("admin/addFilm");
        Film film = filmDAO.getFilmById(id);
        model.addObject("film", film);
        return model;
    }

    /**
     * editFilm action.
     */
    @RequestMapping(value = "/detailsFilm/{id}", method = RequestMethod.GET)
    public ModelAndView detailsFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("filmDetails");
        Film film = filmDAO.getFilmById(id);
        model.addObject("film", film);
        return model;
    }

    /**
     * removeFilm action.
     */
    @RequestMapping(value = "/admin/removeFilm/{id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/myBilets", method = RequestMethod.GET)
    public ModelAndView myFilms(HttpServletRequest request, HttpServletResponse response) {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik uzytkownik = userDAO.findUserByEmail(auth.getName());
        
        ModelAndView model = new ModelAndView("myBilets");

        List<Bilet> biletList = biletDAO.listOfBiletsByUser(uzytkownik.getIdklient());
        model.addObject("biletList", biletList);
        return model;
    }




}
