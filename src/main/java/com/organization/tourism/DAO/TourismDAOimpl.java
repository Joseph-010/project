package com.organization.tourism.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.organization.tourism.entity.Tourism;
import com.organization.tourism.entity.UserManage;

@Repository
public class TourismDAOimpl implements TourismDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addEntry(Tourism entry) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entry);
	}

	@Override
	public List<Tourism> listOfEntries() {
		Session session = sessionFactory.getCurrentSession();
		Query<Tourism> query = session.createQuery("from Tourism", Tourism.class);
		List<Tourism> listAllEntries = query.getResultList();
		return listAllEntries;
	}

	@Override
	public Tourism getEntryById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Tourism entry = session.get(Tourism.class, id);
		return entry;
	}

	@Override
	public void deleteEntry(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Tourism> query = session.createQuery("delete from Tourism where id = :TourId");
		query.setParameter("TourId", id);
		query.executeUpdate();
	}

	@Override
	public List<UserManage> userList() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserManage> query = session.createQuery("from UserManage", UserManage.class);
		List<UserManage> listOfUsers = query.getResultList();
		return listOfUsers;
	}

	@Override
	public List<Tourism> getEntryBySearch(String fromLocation, String toLocation) {
		Session session = sessionFactory.getCurrentSession();
		Query<Tourism> query = session.createQuery("from Tourism where from_location = :fromLocation and to_location = :toLocation", Tourism.class);
		query.setParameter("fromLocation", fromLocation);
		query.setParameter("toLocation", toLocation);
		List<Tourism> resultList = query.getResultList();
		return resultList;
	}

}
