package com.app.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISellerDao;
import com.app.pojos.Seller;

@Repository //
@Transactional // for transactions

public class SellerDaoImpl implements ISellerDao {

	@Autowired
	private SessionFactory sf;

	public SellerDaoImpl() {
		System.out.println("In SellerDaoImpl");
	}

	@Override
	public Seller getDetails(int id) {
		Seller seller;

		String query = "select s from Seller s join fetch s.products where s.sellerId=:id";
		try {
			seller = sf.getCurrentSession().createQuery(query, Seller.class).setParameter("id", id).getSingleResult();

		} catch (Exception e) {
			seller = sf.getCurrentSession().get(Seller.class, id);
			return seller;
		}
		return seller;
	}

	@Override
	public boolean updateSeller(int id, Seller seller) {
		boolean status = false;
		try {
			System.out.println("seller Update dao:" + seller);
			sf.getCurrentSession().saveOrUpdate(seller);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteSeller(int Sellerid) {
		Session hs = sf.getCurrentSession();
		Seller s = hs.get(Seller.class, Sellerid);

		if (s != null) {
			hs.delete(s);
			return true;
		} else
			return false;

	}

	@Override
	public List<Seller> getSellerList() {
		return sf.getCurrentSession().createQuery("select s from Seller s", Seller.class).getResultList();
	}

	@Override
	public boolean addSeller(Seller s) {
		boolean status = false;
		try {
			sf.getCurrentSession().persist(s);
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;

	}

	@Override
	public Seller authenticateSeller(String email, String password) {
		// fetch seller details by email and password
		Seller seller;
		try {
			seller = sf.getCurrentSession()
					.createQuery("select s from Seller s where s.email=:email and s.password=:password", Seller.class)
					.setParameter("email", email).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			throw e;
		}
		return seller;
	}

	@Override
	public Seller getSellerDetailsByProducts(Integer sellerId) {
		// TODO Auto-generated method stub
		Seller seller;
		String query = "select s from Seller s join fetch s.products where s.sellerId=:id";
		try {
			seller = sf.getCurrentSession().createQuery(query, Seller.class).setParameter("id", sellerId)
					.getSingleResult();

		} catch (Exception e) {
			throw e;
		}
		return seller;
	}

	@Override
	public Seller getSellerDetailsByOrders(Integer sellerId) {
		// TODO Auto-generated method stub
		Seller seller;

		String query = "select s from Seller s join fetch s.orders where s.sellerId=:id";
		// String query = "select s from seller s where s.sellerId=:id";
		try {
			seller = sf.getCurrentSession().createQuery(query, Seller.class).setParameter("id", sellerId)
					.getSingleResult();

		} catch (Exception e) {
			throw e;
		}
		return seller;
	}

}
