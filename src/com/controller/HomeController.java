package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.io.User;
import com.service.UserSessionBean;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private UserSessionBean sessionBean;

	// private final String LOGGEDIN_USER = "LOGGEDIN_USER";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request) {

		/*
		 * HttpSession session = request.getSession(false);
		 * 
		 * if (session != null) {
		 * 
		 * User user = (User) session.getAttribute(LOGGEDIN_USER); if (user !=
		 * null) { request.getSession(false).removeAttribute(LOGGEDIN_USER);
		 * 
		 * }
		 * 
		 * }
		 */
		if (sessionBean != null) {
			sessionBean.setCurrentUser(null);
		}

		return new ModelAndView("login/loginpage");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") User user,
			HttpServletRequest request) {
		if ("admin".equals(user.getUserId())
				&& "admin123".equals(user.getPassword())) {
			/*
			 * HttpSession session = request.getSession(false);
			 * 
			 * if (session != null) {
			 * 
			 * request.getSession(false).setAttribute(LOGGEDIN_USER, user);
			 * 
			 * }
			 */
			sessionBean.setCurrentUser(user);
			return new ModelAndView("redirect:/role/list");
		}

		return new ModelAndView("login/loginpage");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			if (sessionBean != null) {
				sessionBean.setCurrentUser(null);
			}
		}

		return new ModelAndView("login/loginpage");
	}
}