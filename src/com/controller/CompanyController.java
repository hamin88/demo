package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CompanyDAO;
import com.io.Company;
import com.io.Status;
import com.utils.UIErrorMessages;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	private static final int STATUS_ACTIVE = 1;

	@Autowired
	private CompanyDAO companyDAO;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getList(@RequestParam Map<String, Object> params) {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Company> companyList = companyDAO.list();
		data.put(UIErrorMessages.DATA, companyList);
		data.put(UIErrorMessages.TOTAL, companyList!=null?companyList.size():0);
		data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);

		return data;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("company/companylistview");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute("company") Company company) {
		return new ModelAndView("addcompany", "company", company);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") Long id) {
		Company dbCompany = companyDAO.get(id);
		return new ModelAndView("addcompany", "company", dbCompany);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Long id) {
		Company dbCompany = companyDAO.get(id);
		return new ModelAndView("addcompany", "company", dbCompany);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("company") Company company) {
		Status status = new Status();
		status.setId(STATUS_ACTIVE);
		companyDAO.saveOrUpdate(company);
		return new ModelAndView("redirect:list");
	}

}