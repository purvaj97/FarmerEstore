package com.app.service;
import java.util.List;
import com.app.pojos.*;

public interface ISellerService {

		List<Seller> getSellerList();
		
		Seller getSellerDetails(int id);
		
		Seller authenticateSeller(String email,String password);
		
		boolean addSeller(Seller c);
		
		boolean updateSeller(int id,Seller c);
		
		boolean deleteSeller(int id);

		Seller getSellerDetailsByProducts(Integer sellerId);

		Seller getSellerDetailsByOrders(Integer sellerId);
		
}
