package com.organization.tourism.DAO;

import java.util.List;

import com.organization.tourism.entity.Tourism;
import com.organization.tourism.entity.UserManage;

public interface TourismDAO {
	public void addEntry(Tourism entry);
	public List<Tourism> listOfEntries();
	public Tourism getEntryById(int id);
	public void deleteEntry(int id);
	public List<UserManage> userList();
	public List<Tourism> getEntryBySearch(String fromLocation,String toLocation);
}
