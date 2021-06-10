package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	@Query("select a from admin a where a.email=:email and a.password=:password")
	public Admin authenticate(@Param("email") String email, @Param("password") String password);
}
