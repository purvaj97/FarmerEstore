package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoImp.AdminDaoImpl;
import com.app.daoImp.CustomerDaoImpl;
import com.app.daoImp.SellerDaoImpl;
import com.app.models.Admin;
import com.app.models.Customer;
import com.app.models.Seller;

@Service
public class AdminService implements IAdminService{
	
	@Autowired
	AdminDaoImpl adminDao;
	
	@Autowired 
	CustomerDaoImpl customerDao;
	
	@Autowired
	SellerDaoImpl sellerDao;

	@Override
	public List<Admin> getAdminList() {
		// TODO Auto-generated method stub
		return adminDao.getAdminList();
	}

	@Override
	public Admin getAdminDetails(int id) {
		// TODO Auto-generated method stub
		return adminDao.getAdminDetails(id);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.addAdmin(admin);
	}

	@Override
	public boolean updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updateAdmin(id, admin);
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		return adminDao.deleteAdmin(adminId);
	}

	@Override
	public Admin authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return adminDao.authenticateAdmin(email, password);
	}

	@Override
	public List<Seller> getSellerList(){
		return sellerDao.getSellerList();		
	}
	
	public boolean verifySeller(int id) {
		boolean status= false;
		try {
			Seller seller = sellerDao.getDetails(id);
			seller.setStatus("Verified");
			sellerDao.updateSeller(id, seller);
			status = true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}
	
	@Override
	public List<Customer> getCustomerList(){
		return customerDao.getCustomerList();		
	}
	
	
	
}
