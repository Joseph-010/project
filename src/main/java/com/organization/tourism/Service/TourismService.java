package com.organization.tourism.Service;

import java.util.List;

import com.organization.tourism.entity.Tourism;
import com.organization.tourism.entity.UserManage;

public interface TourismService {
	void addEntry(Tourism entry);
	List<Tourism> listEntries();
	Tourism getEntryById(int id);
	void deleteEntry(int id);
	List<UserManage> listOfUsers();
	List<Tourism> getResultList(String fromLocation,String toLocation);
}
