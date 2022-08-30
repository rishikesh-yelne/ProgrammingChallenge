package com.machadolab.progchallengebackendjava.models;

import java.sql.Date;

public class Movement {
	public int Id;
	public String CompanyName;
	public String Reason;
	public String Species;
	public int MovedCount;
	public Date StartDate;
	public String OriginPremiseId;
	public String DestinationPremiseId;
	
	public Movement() {}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	
	public String getSpecies() {
		return Species;
	}
	public void setSpecies(String species) {
		Species = species;
	}
	
	public int getMovedCount() {
		return MovedCount;
	}
	public void setMovedCount(int movedCount) {
		MovedCount = movedCount;
	}
	
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	
	public String getOriginPremiseId() {
		return OriginPremiseId;
	}
	public void setOriginPremiseId(String originPremiseId) {
		OriginPremiseId = originPremiseId;
	}
	
	public String getDestinationPremiseId() {
		return DestinationPremiseId;
	}
	public void setDestinationPremiseId(String destinationPremiseId) {
		DestinationPremiseId = destinationPremiseId;
	}
}