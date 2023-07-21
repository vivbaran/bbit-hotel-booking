package com.bbit.app.bbithotelbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "HOTEL")
public class HotelEntity {

	public HotelEntity(String name, String country, String city, String address, String contactNo)  {
		super();
		this.name = name;
		this.country = country;
		this.city = city;
		this.address = address;
		this.contactNo = contactNo;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CITY")
	private String city;

	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CONTACT_NO")
	private String contactNo;

}
