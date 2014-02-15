package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDAO;
import com.io.User;
import com.utils.HibernateUtil;
import com.utils.UIErrorMessages;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	 
	@RequestMapping(value = "/getList")
	public @ResponseBody
	Map<String, Object> getList(@RequestParam Map<String, Object> params) {

		Map<String, Object> data = new HashMap<String, Object>();

		try{
			
			List<User> userList = userDAO.list();
			data.put(UIErrorMessages.DATA, userList);
			data.put(UIErrorMessages.TOTAL, userList != null ? userList.size() : 0);
			data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);

		}catch(Exception e){

			e.printStackTrace();
			data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.FALSE);

		}
		
		return data;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("user/userlistview");
	}
}