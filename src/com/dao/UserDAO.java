package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.io.User;
import com.utils.HibernateUtil;

@Repository
public class UserDAO {

	public List<User> list() {
		return HibernateUtil.getHibernateTemplate().find("from User");

	}

}
