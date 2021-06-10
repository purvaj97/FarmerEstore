package com.app.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.ISellerRepository;
import com.app.models.Seller;

@Repository
public class SellerDaoImpl {
	
	@Autowired
	ISellerRepository sellerRepo;
	
	public SellerDaoImpl() {
		System.out.println("In SellerDaoImpl");
	}

	public List<Seller> getSellerList() {
		List<Seller> sellerList=sellerRepo.findAll();
		return  sellerList;
	}

	public Seller getDetails(int id) {
		Seller seller = null;
		try {
			seller=sellerRepo.findDetailsbyId(id);
		}
		catch(Exception e) {
			System.out.println(e+"In getDetails");
		}
		return seller;
	}

	public Seller authenticateSeller(String email, String password) {
		Seller seller=sellerRepo.authenticate(email, password);
		if(seller!=null) {
			System.out.println("successfully login");
		}
		else
			System.out.println("invalid email or password");
		return seller;
	}

	public boolean addSeller(Seller seller) {
		boolean status=false;
		try {
			sellerRepo.save(seller);
			status=true;
		}catch(Exception e) {
		throw e;
		}
		return status;
	}

	public boolean updateSeller(int id, Seller seller) {
		boolean status=false;
		if(sellerRepo.existsById(id)) {
			sellerRepo.save(seller);
			status=true;
			System.out.println("seller Update dao: "+seller);
		}else {
			System.out.println(" update seller details not found ");
		}
		return status;
	}


	public boolean deleteSeller(int id) {
		boolean status=false;
		if(sellerRepo.existsById(id)) {
			sellerRepo.deleteById(id);
			status=true;
			System.out.println("seller delete dao");
		}
		return status;
	}


	public Seller getSellerDetailsByProducts(Integer sellerId) {
		Seller seller;
		try {
			seller=sellerRepo.findDetailsbyProducts(sellerId);
		}
		catch(Exception e){
			throw e;
		}
		return seller;
	}


	public Seller getSellerDetailsByOrders(Integer sellerId) {
		Seller seller;
		try {
			seller=sellerRepo.findDetailsbyOrders(sellerId);
		}
		catch(Exception e){
			throw e;
		}
		return seller;
	}

}
