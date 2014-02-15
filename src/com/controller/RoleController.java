package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RoleDAO;
import com.io.Role;
import com.utils.GenericPropEditor;
import com.utils.UIErrorMessages;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleDAO roleDAO;

	@InitBinder  
    private void initBinder(WebDataBinder binder) {  
        binder.registerCustomEditor(Role.class,new GenericPropEditor<Role>(new Role()));  
    }  
	@RequestMapping(value = "/getList")
	public @ResponseBody
	Map<String, Object> getList(@RequestParam Map<String, Object> params) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		try{

			List<Role> roleList = roleDAO.list();
			data.put(UIErrorMessages.DATA, roleList);
			data.put(UIErrorMessages.TOTAL, roleList != null ? roleList.size() : 0);
			data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);
		}catch(Exception e){
			data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.FALSE);
		}
				return data;
	}

	@RequestMapping(value = "/save/{id}")
	public @ResponseBody Map<String, Object>save(@PathVariable("id") Integer id, @RequestParam ("data") Role role ,@RequestParam Map<String, Object> params) {
		Map<String, Object>  data = new HashMap<String, Object>();
		data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.FALSE);
		System.out.println("params :"+params);
	 
		if(id!=null && id>0){
			Role dbRole = roleDAO.get(id);
			if(dbRole!=null){
				dbRole.setRoleName(role.getRoleName());
				dbRole.setDescription(role.getDescription());
				roleDAO.saveOrUpdate(dbRole);
				data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);
			}
			
		}
	 
		return data;
	}

	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody
	Map<String, Object> delete(@PathVariable("id")  Integer id) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {

			roleDAO.delete(id);
			data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.TRUE);

		} catch (Exception e) {
			data.put(UIErrorMessages.SUCCESS_KEY, UIErrorMessages.FALSE);

		}
		return data;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("role/rolelistview");
	}
}