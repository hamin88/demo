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

import com.dao.LocationDAO;
import com.io.Location;
import com.utils.UIErrorMessages;

@Controller
@RequestMapping(value = "/location")
public class LocationController {

	@Autowired
	private LocationDAO locationDAO;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getList(@RequestParam Map<String, Object> params) {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Location> locationList = locationDAO.list();
		data.put(UIErrorMessages.DATA, locationList);
		data.put(UIErrorMessages.TOTAL, locationList != null ? locationList.size() : 0);
		data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);

		return data;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("location/locationlistview");
	}
}