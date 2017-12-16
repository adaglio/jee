package com.wps.sneu.core.entities;

public class AddressNTT extends ConnectionableNTT {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4146579874755209168L;

	private String address;
	private String city;
	private String street;
	private String number;
	private String country;
	private String district;
	private String zipCode;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public EntityTypeEnum getEntityType() {

		return EntityTypeEnum.ADDRESS;
	}

}
