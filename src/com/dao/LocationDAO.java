package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.io.Location;
import com.utils.HibernateUtil;

@Repository
public class LocationDAO {

	public List<Location> list() {
		return HibernateUtil.getHibernateTemplate().find("from Location");

	}

	public Location get(Long id) {
		return HibernateUtil.getHibernateTemplate().get(Location.class, id);

	}

	public void saveOrUpdate(Location location) {
		HibernateUtil.getHibernateTemplate().saveOrUpdate(location);

	}

	public void delete(Long id) {
		Location location = get(id);
		if (location != null) {
			HibernateUtil.getHibernateTemplate().delete(location);

		}

	}

}
