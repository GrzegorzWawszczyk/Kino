package org.zut.pbai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.BiletDAO;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.SalaDAO;
import org.zut.pbai.dao.SeansDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.Validator;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Film;
import org.zut.pbai.model.Sala;
import org.zut.pbai.model.Seans;
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

    @Autowired
    UserDAO userDAO;
    
    @Autowired
    SalaDAO salaDAO;
    /**
     * editFilm action.
     */
    @RequestMapping(value = "/buyTicketFilm/{id}", method = RequestMethod.GET)
    public ModelAndView buyTicketFilm(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView("redirect:/listFilmView");
        Film film = filmDAO.getFilmById(id);
        Uzytkownik uzytkownik = (Uzytkownik) request.getSession().getAttribute("user");

        Bilet bilet = new Bilet();
        bilet.setUzytkownik(userDAO.findUserByEmail(auth.getName()));
        System.out.println(bilet.getUzytkownik().getEmail());
        bilet.setFilm(film);
        bilet.setSeans(seansDAO.getsSeansById(1));
        bilet.setMiejsce("5");
        bilet.setTyp("zarezerwowany");
        bilet.setCena("50");
        bilet.setStan("zarezerwowany");
        biletDAO.addBilet(bilet);
        model.addObject("film", film);
        return model;
    }
    
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView bookTicket(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Uzytkownik uzytkownik = userDAO.findUserByEmail(auth.getName());
    	Seans seans = seansDAO.getsSeansById(id);
    	Film film = seans.getFilm();
    	Sala sala = seans.getSala();
    	ModelAndView model = new ModelAndView("redirect:/listFilmView");
		 
		List<Bilet> list = biletDAO.listOfBiletsBySeans(id);
		String booked = "";
		boolean flag = false;
		for (Bilet b : list){
			
			if (flag == false){
				booked += b.getMiejsce();
				System.out.println("numer: "+ b.getMiejsce());
				flag = true;
			}
			else{
				
				booked += ", " +b.getMiejsce();
			}
		}
		System.out.println("booked: "+ booked);
		model.addObject("rows", sala.getLiczbaRzedow());
		model.addObject("cols", sala.getLiczbaKolumn());
		model.addObject("booked", booked);
		model.addObject("idseans", id );
		model.setViewName("book");
		return model;
    }
    
    @RequestMapping(value = "/bookt", method = RequestMethod.POST)
	   public String zarezerwuj(@ModelAttribute("Bilet")Bilet bilet, 
	   ModelMap model, HttpServletRequest request) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Uzytkownik uzytkownik = userDAO.findUserByEmail(auth.getName());
    	/*
    	 * 
    	 * public Bilet(int idbilet, Film film, Seans seans, Uzytkownik uzytkownik, String stan,
			String miejsce, String cena, String typ)
    	 */
		String cutted=  bilet.getMiejsce().substring(0, bilet.getMiejsce().length()-1);
		String[] list= cutted.split(",");
		for(String l : list){
			//int id, int msid, int seatnumber, String username
			Bilet b = new Bilet();
			b.setUzytkownik(uzytkownik);
			b.setSeans(seansDAO.getsSeansById( Integer.parseInt(request.getParameter("seansid"))));
			b.setFilm(b.getSeans().getFilm());
			b.setMiejsce(l);
			b.setStan("zarezerwowane");
			biletDAO.addBilet(b);
			//biletDAO.addBilet;(new Book(0, book.getMsid(),Integer.parseInt(l),book.getUsername()));
		}
	    model.addAttribute("error","Zarezerwowano!");
		return "redirect:/listFilmView";
	   }
    @RequestMapping(value = "/admin/editTicketCommand", method = RequestMethod.POST)
    public ModelAndView editTicketCommand(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("bilet")Bilet bilet) {

      //  bilet.getIdfilm();
    	
    	Bilet b = biletDAO.getBiletById(bilet.getIdbilet());
    	b.setTyp(((String)request.getParameter("typ")));
    	bilet = b;
        ModelAndView model = new ModelAndView("redirect://admin/allTicketsView");
        biletDAO.updateBilet(bilet);
        System.out.println("TYP: " +b.getTyp());
        return model;
    }
    
    @RequestMapping(value = "/admin/editTicket/{id}", method = RequestMethod.GET)
    public ModelAndView editTicket(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {


        ModelAndView model = new ModelAndView("/admin/editTicket");
        Bilet bilet = biletDAO.getBiletById(id);
        model.addObject("bilet", bilet);
        return model;
    }
    
    @RequestMapping(value = "/admin/allTicketsView", method = RequestMethod.GET)
    public ModelAndView listFilmView(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("/admin/allTickets");
        List<Bilet> biletList = biletDAO.listOfBilets();
        for(Bilet b : biletList)
        	System.out.println(b.getMiejsce());
        model.addObject("biletList", biletList);
        return model;
    }
    
    @RequestMapping(value = "/cardPayment/{id}", method = RequestMethod.GET)
    public ModelAndView cardPaymentView(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
    	ModelAndView model = new ModelAndView("/cardPayment");
    	Bilet bilet = biletDAO.getBiletById(id);
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (!bilet.getUzytkownik().getEmail().equals(auth.getName()))
    		return new ModelAndView("redirect:/");
    		
		model.addObject("bilet", bilet);
    	return model;
    }
    
    
    @RequestMapping(value = "/transferPayment/{id}", method = RequestMethod.GET)
    public ModelAndView transferPaymentView(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
    	ModelAndView model = new ModelAndView("/transferPayment");
    	Bilet bilet = biletDAO.getBiletById(id);
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (!bilet.getUzytkownik().getEmail().equals(auth.getName()))
    		return new ModelAndView("redirect:/");
    		
		model.addObject("bilet", bilet);
		model.addObject("accountNumber", "12345678909876543212345678"); //Fajnie by to by³o trzymac gdzieœ w bazie chyba
    	
    	return model;
    }
    

	Validator validor = new Validator();
	
	@RequestMapping(value = "/cardPayment", method = RequestMethod.POST)
	public ModelAndView carsPaymentPost(@RequestParam("id")String idString, @RequestParam("cardNumber") String cardNumber, @RequestParam("CVV") String CVV){
	
		Validator validate = new Validator();
		
		int id=Integer.parseInt(idString);
		Bilet bilet = biletDAO.getBiletById(id);

		if (!validate.validateCardNumber(cardNumber) || !validate.validateCVV(CVV))
		{
			ModelAndView model = new ModelAndView("/cardPayment");
			model.addObject("error", "B³êdne dane karty!");
			model.addObject("bilet", bilet);
			return model;			
		}
		
		bilet.setStan("kupiony");
		biletDAO.updateBilet(bilet);
		
		return new ModelAndView("redirect:/"); //ZMIENIÆ NA REDIRECT DO KUPIONEGO BILETU
	}
}
