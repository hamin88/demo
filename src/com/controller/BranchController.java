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

import com.dao.BranchDAO;
import com.io.Branch;
import com.io.Status;
import com.utils.UIErrorMessages;

@Controller
@RequestMapping(value = "/branch")
public class BranchController {

	private static final int STATUS_ACTIVE = 1;

	@Autowired
	private BranchDAO branchDAO;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getList(@RequestParam Map<String, Object> params) {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Branch> branchList = branchDAO.list();
		data.put(UIErrorMessages.DATA, branchList);
		data.put(UIErrorMessages.TOTAL, branchList!=null?branchList.size():0);
		data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);

		return data;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("branch/branchlistview");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute("branch") Branch branch) {
		return new ModelAndView("addbranch", "branch", branch);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") Long id) {
		Branch dbBranch = branchDAO.get(id);
		return new ModelAndView("addbranch", "branch", dbBranch);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Long id) {
		Branch dbBranch = branchDAO.get(id);
		return new ModelAndView("addbranch", "branch", dbBranch);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("branch") Branch branch) {
		Status status = new Status();
		status.setId(STATUS_ACTIVE);
		branchDAO.saveOrUpdate(branch);
		return new ModelAndView("redirect:list");
	}

}