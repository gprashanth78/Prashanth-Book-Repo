package com.prashanthIt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SB_CUSTOMER_BOOK_TBL_DTLS")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;
	@Column(name = "CUSTOMER_NAME")
	private String customerFullName;
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ZIP_CODE")
	private Integer zipCode;
	@Column(name = "REGISTERED_DATE")
	private String registeredDate;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="USER_ROLES",
			   joinColumns = {
					   @JoinColumn(name="CUSTOMER_ID")
			   },
			   inverseJoinColumns = {
					   @JoinColumn(name="ROLE_ID")
			   }
	)
	private Set<Role> roles;
}