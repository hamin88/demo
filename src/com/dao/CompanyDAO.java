package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.io.Company;
import com.utils.HibernateUtil;

@Repository
public class CompanyDAO {

	public List<Company> list() {
		return HibernateUtil.getHibernateTemplate().find("from Company");

	}

	public Company get(Long id) {
		return HibernateUtil.getHibernateTemplate().get(Company.class, id);

	}

	public void saveOrUpdate(Company company) {
		HibernateUtil.getHibernateTemplate().saveOrUpdate(company);

	}

	public void delete(Long id) {
		Company company = get(id);
		if (company != null) {
			HibernateUtil.getHibernateTemplate().delete(company);

		}

	}

}
