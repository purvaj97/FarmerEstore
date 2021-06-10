package com.app.daoImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IAdminRepository;
import com.app.models.Admin;

@Repository
public class AdminDaoImpl {
	
	@Autowired
	IAdminRepository adminRepo;
	
	public AdminDaoImpl() {
		System.out.println("In AdminDaoImpl constructor");
	}
	
	public Admin getAdminDetails(int adminId) {
		Admin admin = null;
		try {
			Optional<Admin> o=adminRepo.findById(adminId);
			if(o.isPresent())
				admin=o.get();
			else
				System.out.println("In admin details not found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
	public List<Admin> getAdminList(){
		List<Admin> adminList=adminRepo.findAll();
		return adminList;
	}
	
	public boolean addAdmin(Admin admin) {
		boolean status=false;
		try {
			adminRepo.save(admin);
			status=true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
	
	public boolean updateAdmin(int adminId,Admin admin) {
		boolean status=false;
		if(adminRepo.existsById(adminId)) {
			adminRepo.save(admin);
			status=true;
			System.out.println("Admin update dao: "+admin);
		} else {
			System.out.println("update Admin details not found");
		}
		return status;
	}
	
	public boolean deleteAdmin(int adminId) {
		boolean status=false;
		if(adminRepo.existsById(adminId)) {
			adminRepo.deleteById(adminId);
			status=true;
			System.out.println("Admin deleted");
		} else {
			System.out.println("Delete Admin details not found");
		}
		return status;
	}
	
	public Admin authenticateAdmin(String email,String password) {
		Admin admin=adminRepo.authenticate(email, password);
		if(admin!=null) {
			System.out.println("successfully login");
		}
		else
			System.out.println("invalid email or password");
		return admin;
	}

}
