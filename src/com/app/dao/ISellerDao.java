package com.app.dao;
import java.util.List;
import com.app.pojos.Seller;

public interface ISellerDao {

	Seller getDetails(int id);
	
	List<Seller> getSellerList();
	
	boolean addSeller(Seller s);
	
	boolean updateSeller(int id,Seller s);
	
	boolean deleteSeller(int Sellerid);

	Seller authenticateSeller(String email, String password);

	Seller getSellerDetailsByProducts(Integer sellerId);

	Seller getSellerDetailsByOrders(Integer sellerId);
	
}

