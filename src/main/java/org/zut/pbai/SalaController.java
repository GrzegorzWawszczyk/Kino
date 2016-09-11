package org.zut.pbai;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.SalaDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Sala;

@Controller
@SessionAttributes
public class SalaController {
	
	@Autowired
    SalaDAO salaDAO;
	
	@RequestMapping(value = "/admin/addSalaView", method = RequestMethod.GET)
    public ModelAndView addSalaView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        ModelAndView model = new ModelAndView("/admin/addSala");
        model.addObject("sala", new Sala());
        return model;
    }
	
	
	@RequestMapping(value = "/admin/addSala", method = RequestMethod.POST)
    public ModelAndView addFilm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("sala")Sala sala) {

        ModelAndView model = new ModelAndView("redirect:/");

    	sala.setIloscMiejsc(sala.getLiczbaRzedow() * sala.getLiczbaKolumn());
        salaDAO.addSala(sala);

        return model;
    }

}
