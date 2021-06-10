package com.app.dao;

import java.util.List;

import com.app.pojos.Admin;

public interface IAdminDao {

	Admin getAdminDetails(int id);
	
	List<Admin> getAdminList();
	
	boolean addAdmin(Admin admin);
	
	boolean updateAdmin(int id,Admin admin);
	
	boolean deleteAdmin(int adminId);
	
	public Admin authenticateAdmin(String email,String password);
	
}
