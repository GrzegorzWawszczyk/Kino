package org.zut.pbai;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.Validator;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Uzytkownik;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@Autowired
	UserDAO userDAO;

	@Autowired
	FilmDAO filmDAO;
	/**
	 * Shows login page.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView  start(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("login");
        LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);

		return model;
	}

	@RequestMapping(value = { "/home**" }, method = RequestMethod.GET)
	public ModelAndView  home(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		//add user to session
		Object user = (auth != null) ? auth.getPrincipal() :  null;
		request.getSession().setAttribute("user",userDAO.findUserByEmail(((User) user).getUsername()) );

		LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);

		return model;
	}
	
	/**
	 * Login action.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView  signUp(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("signup");
		return model;
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
   public String register(@ModelAttribute("User")Uzytkownik user, 
		   ModelMap model, HttpServletRequest request) 
	{       	
		String error = "";
		Validator validor = new Validator();
	        	if( (user.getHaslo() == null) || (user.getHaslo().equals("")) || 
	        			(user.getEmail() == null) ||(user.getEmail().equals("")) ||
	        			(user.getImie() == null) ||(user.getImie().equals("")) ||	
	        			(user.getNazwisko() == null) ||(user.getNazwisko().equals("")) ||
	        			(user.getPesel() == null) ||(user.getPesel().equals("")) ||
	        			(user.getTel() == null) ||	(user.getTel().toString().equals(""))
	        	)
	        	{
	        		error += "wypelnij wszystkie pola!\n";
	        	
	        	}  
	        	if(userDAO.findUserByEmail(user.getEmail()) != null) 
	        	{
	        		error += "juz jest taki uzytkownik!\n";
	        	}  
	        	if(validor.validateEmail(user.getEmail()) != true)
	        	{
	        		error += "Prosze podac prawidlowy e-mail!\n";
	        	}
	        	 if(validor.validatePassword(user.getHaslo()) != true)
	        	{
	        		 error += "Haslo musi posiadac:"
	        				+ " Wielka litere, mala litere, cyfre"
	        				+ " i znak specjalny(@#$%) oraz conajmniej 8 znakow\n";
	        	}
	        	if(!user.getHaslo().equals(request.getParameter("haslo2")))
	        	{
	        		error += "Hasla musza sie zgadzac!\n";
	     		}
	        	 if(!user.getEmail().equals(request.getParameter("email2")))
	        	{
	        		 error += "Adresy email musza sie zgadzac!<br />";
	     		}
	        		 
	        	 if(error == ""){
	        		model.addAttribute("error", "Uzytkownik zostal dodany! mozesz sie zalogowac!");
	        		user.setRola("ROLE_USER");
	        		userDAO.insert(user);
	        		return "login";
	        	 }
	        	
	        	model.addAttribute("error", error);
	        	return "signup";
	  }
	
}
