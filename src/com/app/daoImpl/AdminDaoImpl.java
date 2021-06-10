package com.app.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public Admin getAdminDetails(int id) {
		// TODO Auto-generated method stub
		Admin admin;
		try {
			admin = sf.getCurrentSession().get(Admin.class, id);
		}
		catch(Exception e) {
			throw e;
		}
		
		return admin;
	}

	@Override
	public List<Admin> getAdminList() {
		// TODO Auto-generated method stub
		List<Admin> admins;
		String jpql = "select a from Admin a";
		
		try {
		admins= sf.getCurrentSession().createQuery(jpql, Admin.class).getResultList();
		}
		catch(Exception e) {
			throw e;
		}
		return admins;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			sf.getCurrentSession().persist(admin);
			status=true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			sf.getCurrentSession().update(admin);
			status=true;
			
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			Session hs = sf.getCurrentSession();
			Admin admin = hs.get(Admin.class, adminId);
			hs.delete(admin);
			status=true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public Admin authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		Admin admin;
		try {
			admin=sf.getCurrentSession().createQuery("select a from Admin a where a.email=:email and a.password=:password", Admin.class).setParameter("email", email).setParameter("password", password).getSingleResult();
		}
		catch(Exception e) {
			throw e;
		}
		return admin;
	}

}
