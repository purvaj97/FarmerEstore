package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoImp.SellerDaoImpl;
import com.app.models.Seller;

@Service
public class SellerService implements ISellerService{
	
	@Autowired
	SellerDaoImpl sellerDao;

	@Override
	public List<Seller> getSellerList() {
		List<Seller> sellers=sellerDao.getSellerList();
		if(sellers!=null)
			return sellers;
		return null;
	}

	@Override
	public Seller getSellerDetails(int id) {
		return sellerDao.getDetails(id);
	}

	@Override
	public Seller authenticateSeller(String email, String password) {
		// TODO Auto-generated method stub
		return sellerDao.authenticateSeller(email, password);
	}

	@Override
	public boolean addSeller(Seller c) {
		// TODO Auto-generated method stub
		return sellerDao.addSeller(c);
	}

	@Override
	public boolean updateSeller(int id, Seller c) {
		// TODO Auto-generated method stub
		return sellerDao.updateSeller(id, c);
	}

	@Override
	public boolean deleteSeller(int id) {
		// TODO Auto-generated method stub
		return sellerDao.deleteSeller(id);
	}

	@Override
	public Seller getSellerDetailsByProducts(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerDao.getSellerDetailsByProducts(sellerId);
	}

	@Override
	public Seller getSellerDetailsByOrders(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerDao.getSellerDetailsByOrders(sellerId);
	}

}
