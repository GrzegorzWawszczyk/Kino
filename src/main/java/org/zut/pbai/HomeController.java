package org.zut.pbai;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zut.pbai.dao.UserDAO;
import org.zut.pbai.helpers.LoginBean;
import org.zut.pbai.model.Uzytkownik;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@Autowired
	UserDAO userDAO;

	/**
	 * Shows login page.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView  login(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("login");
        LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);

		return model;
	}

	/**
	 * Login action.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String executeLogin(Model model,HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {

        loginBean.getEmail();
		Uzytkownik uzytkownik =  userDAO.findUserByEmailAndPassword(loginBean.getEmail(), loginBean.getPassword());

		if(uzytkownik != null) {

			if(uzytkownik.getRola().equals("ADMIN"))
			{
				model.addAttribute("admin", true);
			}

			return "home";
		}
		else{
			model.addAttribute("error", "Niepoprawne dane");
			return "login";

		}

	}
}
