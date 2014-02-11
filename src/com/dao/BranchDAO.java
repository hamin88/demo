package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.io.Branch;
import com.utils.HibernateUtil;

@Repository
public class BranchDAO {

	public List<Branch> list() {
		return HibernateUtil.getHibernateTemplate().find("from Branch");

	}

	public Branch get(Long id) {
		return HibernateUtil.getHibernateTemplate().get(Branch.class, id);

	}

	public void saveOrUpdate(Branch branch) {
		HibernateUtil.getHibernateTemplate().saveOrUpdate(branch);

	}

	public void delete(Long id) {
		Branch branch = get(id);
		if (branch != null) {
			HibernateUtil.getHibernateTemplate().delete(branch);

		}

	}

}
