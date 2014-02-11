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
@RequestMapping(value = "/tax")
public class TaxController {

	@Autowired
	private TaxDAO taxDAO;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getList(@RequestParam Map<String, Object> params) {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Tax> taxList = taxDAO.list();
		data.put(UIErrorMessages.DATA, taxList);
		data.put(UIErrorMessages.TOTAL, taxList != null ? taxList.size() : 0);
		data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);

		return data;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("tax/taxlistview");
	}
}