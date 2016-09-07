package org.zut.pbai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.BiletDAO;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.SeansDAO;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Uzytkownik;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vadim on 2016-09-07.
 */
@Controller
@SessionAttributes
public class TicketController {

    @Autowired
    FilmDAO filmDAO;

    @Autowired
    SeansDAO seansDAO;

    @Autowired
    BiletDAO biletDAO;

    /**
     * editFilm action.
     */
    @RequestMapping(value = "/buyTicketFilm/{id}", method = RequestMethod.GET)
    public ModelAndView buyTicketFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("redirect:/listFilmView");
        Film film = filmDAO.getFilmById(id);
        Uzytkownik uzytkownik = (Uzytkownik) request.getSession().getAttribute("user");

        Bilet bilet = new Bilet();
        bilet.setUzytkownik(uzytkownik);
        bilet.setFilm(film);
        bilet.setSeans(seansDAO.getsSeansById(1));

        biletDAO.addBilet(bilet);
        model.addObject("film", film);
        return model;
    }
}
