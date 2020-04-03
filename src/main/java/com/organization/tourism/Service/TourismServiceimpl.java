package com.organization.tourism.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.tourism.DAO.TourismDAO;
import com.organization.tourism.entity.Tourism;
import com.organization.tourism.entity.UserManage;

@Service
public class TourismServiceimpl implements TourismService{

	@Autowired
	TourismDAO tourismDao;
	
	@Override
	@Transactional
	public void addEntry(Tourism entry) {
		tourismDao.addEntry(entry);
	}

	@Override
	@Transactional
	public List<Tourism> listEntries() {
		List<Tourism> entryList = tourismDao.listOfEntries();
		return entryList;
	}

	@Override
	@Transactional
	public Tourism getEntryById(int id) {
		return tourismDao.getEntryById(id);
	}

	@Override
	@Transactional
	public void deleteEntry(int id) {
		tourismDao.deleteEntry(id);
	}

	@Override
	@Transactional
	public List<UserManage> listOfUsers() {
		List<UserManage> userList = tourismDao.userList();
		return userList;
	}

	@Override
	@Transactional
	public List<Tourism> getResultList(String fromLocation, String toLocation) {
		return tourismDao.getEntryBySearch(fromLocation, toLocation);
	}

}
