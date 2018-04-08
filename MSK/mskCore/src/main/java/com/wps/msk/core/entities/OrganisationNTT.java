package com.wps.msk.core.entities;

import com.wps.msk.core.entities.others.OrganisationTypeEnum;

public class OrganisationNTT extends ConnectionableNTT {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5954357598889823455L;

	private OrganisationTypeEnum organisationType;
	private String districtCourtRef;
	private String economyIdentNumber;
	private String name;
	private String tradeRegisterEntry;
	private String tradeRegisterNumber;
	private String vatNumber;
	private String seat;
	
	
	


	public OrganisationTypeEnum getOrganisationType() {
		return organisationType;
	}


	public void setOrganisationType(OrganisationTypeEnum organisationType) {
		this.organisationType = organisationType;
	}


	public String getDistrictCourtRef() {
		return districtCourtRef;
	}


	public void setDistrictCourtRef(String districtCourtRef) {
		this.districtCourtRef = districtCourtRef;
	}


	public String getEconomyIdentNumber() {
		return economyIdentNumber;
	}


	public void setEconomyIdentNumber(String economyIdentNumber) {
		this.economyIdentNumber = economyIdentNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTradeRegisterEntry() {
		return tradeRegisterEntry;
	}


	public void setTradeRegisterEntry(String tradeRegisterEntry) {
		this.tradeRegisterEntry = tradeRegisterEntry;
	}


	public String getTradeRegisterNumber() {
		return tradeRegisterNumber;
	}


	public void setTradeRegisterNumber(String tradeRegisterNumber) {
		this.tradeRegisterNumber = tradeRegisterNumber;
	}


	public String getVatNumber() {
		return vatNumber;
	}


	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}


	public String getSeat() {
		return seat;
	}


	public void setSeat(String seat) {
		this.seat = seat;
	}



	@Override
	public EntityTypeEnum getEntityType() {
		return EntityTypeEnum.ORGANISATION;
	}
	
}
