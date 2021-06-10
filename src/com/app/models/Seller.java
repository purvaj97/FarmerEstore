package com.app.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Seller {

	private Integer sellerId;
	
	@NotEmpty(message = "Please fill First Name")
	private String firstName;
	
	@NotEmpty(message = "Please fill Last Name")
	private String lastName;
	@Email(message = "Invalid email format")
	private String email;
	@Pattern(message = "Invalid password format", regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,10})")
	private String password;
	@NotEmpty(message = "Phone no is required")
	@Length(min = 10,max=10,message = "Invalid phone no")
	private String phoneNumber;
	@NotEmpty(message = "Address is required")
	private String address;
	
	private String status;
	@NotEmpty(message = "Account no is required")
	private String accountNumber;
	@NotEmpty(message = "IFSC code is required")
	private String IFSC;
	//Mapping
	
	private List<Product> products;
	
	private List<Orders> orders;
	
	//Constructors
	
	public Seller() {
		System.out.println("In Seller Constr");
	}
	
	
	public Seller(String firstName, String lastName, String email, String password, String phoneNumber, String address,
			String accountNumber, String iFSC) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNumber = accountNumber;
		this.IFSC = iFSC;
		this.status="Not Verified";
	}

	@Id
	@Column(name = "seller_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "seller")
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@OneToMany(mappedBy = "seller")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", status=" + status + ", accountNumber=" + accountNumber + ", IFSC=" + IFSC +  "]";
	}
	
	
			
}