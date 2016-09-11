package org.zut.pbai;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.FilmDAO;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.MailMail;
import org.zut.pbai.helpers.PDFCreator;
import org.zut.pbai.helpers.Validator;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Bilet;
import org.zut.pbai.model.Uzytkownik;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class HomeController   {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@Autowired
	UserDAO userDAO;

	@Autowired
	MailMail mailMail;



	@Autowired
	org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder;
	@Autowired
	FilmDAO filmDAO;
	@Autowired
	ServletContext servletContext;
/*	@Autowired
	ServletContext servletContext;

	public ServletConfig getServletConfig() {
		return config;
	}

	@Autowired
	private ServletConfig config;

	public void setServletConfig(ServletConfig servletConfig) {
		this.config = servletConfig;
	}*/
	/**
	 * Shows login page.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView  start(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object user = (auth != null) ? auth.getPrincipal() :  null;

		if(SecurityContextHolder.getContext().getAuthentication()
				instanceof AnonymousAuthenticationToken)
		{
			ModelAndView model = new ModelAndView("login");
			LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
			return model;
		}
		else
		{
			ModelAndView model = new ModelAndView("home");
			return model;
		}
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

	/**
	 * Login action.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response,
							   @RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		model.setViewName("redirect:/");

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

					String toAddr = "pbai2016zut@gmail.com";
					String fromAddr = user.getEmail();
					// email subject
					String subject = "Witamy " + user.getImie() + " " + user.getNazwisko() + " na naszym serwisie";

					// email body
					String body = "Zyczymy udanego korzystania z naszego serwisu";
					mailMail.sendMail(toAddr, fromAddr, subject, body);
					return "login";
	        	 }
	        	
	        	model.addAttribute("error", error);
	        	return "signup";
	  }
	@RequestMapping(value = { "/changePassword" }, method = RequestMethod.GET)
	public ModelAndView  changePassword(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("changePassword");
		return model;
	}
	@RequestMapping(value = { "/changePasswordCommand" }, method = RequestMethod.POST)
	public String  changePasswordCommand(HttpServletRequest request, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Uzytkownik uzytkownik = userDAO.findUserByEmail(auth.getName());
        String error = "";
		Validator validor = new Validator();
	        	if( (request.getParameter("haslo")== null) || 
	        		(request.getParameter("haslo1")== null) || 
	        		(request.getParameter("haslo2")== null)
	        	)
	        	{
	        		error += "wypelnij wszystkie pola!\n";
	        		return "changePassword";
	        	}  
	        			
	        	if(
	        			(validor.validatePassword(request.getParameter("haslo1")) != true) ||
	        			(validor.validatePassword(request.getParameter("haslo2")) != true)
	        	)
	        	{
	        		 error += "Haslo musi posiadac:"
	        				+ " Wielka litere, mala litere, cyfre"
	        				+ " i znak specjalny(@#$%) oraz conajmniej 8 znakow\n";
	        	}
	        	if(!request.getParameter("haslo1").equals(request.getParameter("haslo2")))
	        	{
	        		error += "Hasla musza sie zgadzac!\n";
	     		}
	        	 if(encoder.matches(request.getParameter("haslo"), uzytkownik.getHaslo()))
	        	{
	        		 error += "Niepoprawne stare haslo!<br />";
	     		}
	        		 
	        	 if(error == ""){
	        		model.addAttribute("error", "Haslo zostalo zmienione!");
	        		uzytkownik.setHaslo(request.getParameter("haslo1"));
	        		userDAO.update(uzytkownik);
	        		return "changePassword";
	        	 }
	        	
	        	model.addAttribute("error", error);
	        	return "changePassword";
	}
	
	
}
