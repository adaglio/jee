package com.wps.msk.core.entities;

import java.util.Date;

import com.wps.msk.core.entities.others.BirthDetail;
import com.wps.msk.core.entities.others.GenderEnum;
import com.wps.msk.core.entities.others.OtherNames;

public class PersonNTT extends ConnectionableNTT {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 191484030125601163L;
	
	private GenderEnum gender;
	private String citizenship;
	private Date dateOfBirth;
	private Date dateOfDeath;
	
	private String title;
	private String firstName;
	private String lastName;
	
	private String nameSuffix;
	private String namePrefix;
	
	private String salutation;
	private String vatNumber; // Value Added Tax Identification Number, Umsatzsteuer-Identifikationsnummer

	private BirthDetail birthDetail;

	private OtherNames otherNames;

	

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public BirthDetail getBirthDetail() {
		return birthDetail;
	}

	public void setBirthDetail(BirthDetail birthDetail) {
		this.birthDetail = birthDetail;
	}

	public OtherNames getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(OtherNames otherNames) {
		this.otherNames = otherNames;
	}


	

	@Override
	public EntityTypeEnum getEntityType() {
		return EntityTypeEnum.PERSON;
	}

	
}
