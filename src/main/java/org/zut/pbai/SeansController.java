package org.zut.pbai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.BiletDAO;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.FilmDAOImpl;
import org.zut.pbai.dao.SalaDAO;
import org.zut.pbai.dao.SeansDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Seans;
import org.zut.pbai.model.Uzytkownik;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    @Autowired
    SalaDAO salaDAO;
    /**
     * listFilmView action.
     */
    @RequestMapping(value = "/listSeansView", method = RequestMethod.GET)
    public ModelAndView listSeansView(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("listSeans");
        List<Seans> seansList = seansDAO.listOfSeanse();

        model.addObject("seansList", seansList);
        return model;
    }
    
    @RequestMapping(value = "/filmSeansList/{id}", method = RequestMethod.GET)
    public ModelAndView listFilmSeansesView(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

        ModelAndView model = new ModelAndView("listSeans");
        List<Seans> seansList = seansDAO.listOfSeansesByFilm(id);

        model.addObject("seansList", seansList);
        model.addObject("film",filmDAO.getFilmById(id).getTytul());
        return model;
    }

    /**
     * addFilm action.
     */
   @RequestMapping(value = "/admin/addSeansView", method = RequestMethod.GET)
    public ModelAndView addFilmView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        ModelAndView model = new ModelAndView("/admin/addSeans");
       // model.addObject("seans", new Seans());
        model.addObject("sale", salaDAO.listOfSalas());
        model.addObject("filmy", filmDAO.listOfFilms());
        return model;
    }

    /**
     * addFilm action.
     */
    @RequestMapping(value = "/admin/addSeans", method = RequestMethod.POST)
    public ModelAndView addFilm(HttpServletRequest request, HttpServletResponse response, 
    		@RequestParam("dataField") String dateField, @RequestParam("timeField") String timeField, @RequestParam("salaField") String salaField,
    		@RequestParam("filmField") String filmField, @RequestParam("idseans") String idseans) {

        ModelAndView model = new ModelAndView("redirect:/filmSeansList/"+filmField);

        if(idseans.equals("")){
            //new film, add it
        	Seans seans = new Seans();
        	seans.setSala(salaDAO.getSalaById(Integer.parseInt(salaField)));
			seans.setFilm(filmDAO.getFilmById(Integer.parseInt(filmField)));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date data=new Date();
			try {
				data = df.parse(dateField+" "+timeField);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seans.setData(data);
            seansDAO.addSeans(seans);
        }else{
            //existing film, call update
        	Seans seans = seansDAO.getsSeansById(Integer.parseInt(idseans));
        	seans.setSala(salaDAO.getSalaById(Integer.parseInt(salaField)));
			seans.setFilm(filmDAO.getFilmById(Integer.parseInt(filmField)));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date data=new Date();
			try {
				data = df.parse(dateField+" "+timeField);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seans.setData(data);
            seansDAO.updateSeans(seans);
        }
        return model;
    }

    /**
     * editFilm action.
     */
    @RequestMapping(value = "/admin/editSeans/{id}", method = RequestMethod.GET)
    public ModelAndView editFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("admin/addSeans");
        Seans s = seansDAO.getsSeansById(id);
		
		model.addObject("idseans",s.getIdseans());
		
		model.addObject("nowySeans", false);

		model.addObject("sale", salaDAO.listOfSalas());
		model.addObject("film", s.getFilm());
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		model.addObject("oldData",df.format(s.getData()));
		System.out.println(df.format(s.getData()));
		
		df = new SimpleDateFormat("HH:mm");
		
		model.addObject("oldGodzina",df.format(s.getData()));
		System.out.println(df.format(s.getData()));
		
		model.addObject("oldSala", s.getSala().getIdsala());
		model.addObject("oldFilm", s.getFilm().getIdfilm());
		
		model.addObject("edit", true);
		
		System.out.println(s.getSala().getIdsala());
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
    @RequestMapping(value = "/admin/removeSeans/{id}", method = RequestMethod.GET)
    public ModelAndView removeFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

    	int filmID=seansDAO.getsSeansById(id).getFilm().getIdfilm();
    	System.out.println(filmID);
        seansDAO.remove(id);
        ModelAndView model = new ModelAndView("redirect:/filmSeansList/"+filmID);
        return model;
    }

    /**
     * my films  action.
     */




}
