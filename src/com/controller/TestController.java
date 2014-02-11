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

import com.dao.TaxDAO;
import com.io.Tax;
import com.utils.UIErrorMessages;

@Controller
@RequestMapping(value = "/test")
public class TestController {
 
	 
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView internalServer() {
		return new ModelAndView("test/test");
	}
}