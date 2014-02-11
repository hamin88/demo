package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.io.Role;
import com.io.Role;
import com.utils.HibernateUtil;

@Repository
public class RoleDAO {

	public List<Role> list() {
		return HibernateUtil.getHibernateTemplate().find("from Role");

	}
 
	public Role get(Integer id) {
		return HibernateUtil.getHibernateTemplate().get(Role.class, id);

	}

	public void saveOrUpdate(Role role) {
		HibernateUtil.getHibernateTemplate().saveOrUpdate(role);

	}

	public void delete(Integer id) {
		Role role = get(id);
		if (role != null) {
			HibernateUtil.getHibernateTemplate().delete(role);

		}

	}
}
