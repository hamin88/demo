package com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.io.User;
import com.service.UserSessionBean;

public class AppInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserSessionBean sessionBean;

	//private final String LOGGEDIN_USER = "LOGGEDIN_USER";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		if (!uri.endsWith("login") && !uri.endsWith("logout")) {

			if (sessionBean == null || sessionBean.getCurrentUser() == null) {
				response.sendRedirect("../home/login");
				return false;

			}
			/*
			 * HttpSession session = request.getSession(false);
			 * 
			 * if (session != null) { User userData = (User)
			 * session.getAttribute(LOGGEDIN_USER); if (userData == null) {
			 * 
			 * System.out.print("intercept");
			 * 
			 * response.sendRedirect("../home/login"); return false; } }
			 */}
		return true;
	}
}
