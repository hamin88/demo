package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.io.Tax;
import com.utils.HibernateUtil;

@Repository
public class TaxDAO {

	public List<Tax> list() {
		return HibernateUtil.getHibernateTemplate().find("from Tax");

	}

}
