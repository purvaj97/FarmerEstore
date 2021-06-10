package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.Seller;

public interface IAdminService {

	public List<Admin> getAdminList();
	
	public Admin getAdminDetails(int id);
	
	public boolean addAdmin(Admin admin);
	
	public boolean updateAdmin(int id,Admin admin);
	
	public boolean deleteAdmin(int adminId);

	public Admin authenticateAdmin(String email, String password);

	public List<Seller> getSellerList();

	public List<Customer> getCustomerList();
	
}
