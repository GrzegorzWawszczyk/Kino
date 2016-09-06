package org.zut.pbai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Film;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vadim on 2016-09-04.
 */
@Controller
public class FilmController {


    @Autowired
    FilmDAO filmDAO;

    /**
     * Login action.
     */
   @RequestMapping(value = "/addFilmView", method = RequestMethod.GET)
    public ModelAndView addFilmView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        ModelAndView model = new ModelAndView("addFilm");
        model.addObject("film", new Film());
        return model;
    }

    /**
     * Login action.
     */
    @RequestMapping(value = "/addFilm", method = RequestMethod.POST)
    public ModelAndView addFilm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("film")Film film) {

        film.getIdfilm();
        ModelAndView model = new ModelAndView("addFilm");

        filmDAO.addFilm(film);
        return model;
    }
}
