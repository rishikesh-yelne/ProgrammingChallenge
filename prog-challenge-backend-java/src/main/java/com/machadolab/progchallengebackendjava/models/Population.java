package com.machadolab.progchallengebackendjava.models;

public class Population {
	public int Id;
	public String PremiseId;
	public int TotalAnimalCount;
	public String Address;
	public String City;
	public String Name;
	public int PostalCode;
	public String State;
	public float Latitude;
	public float Longitude;
	
	public Population() {}
	
	public Population(String premiseId, int totalCount) {
		setPremiseId(premiseId);
		setTotalAnimalCount(totalCount);
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getPremiseId() {
		return PremiseId;
	}
	public void setPremiseId(String premiseId) {
		PremiseId = premiseId;
	}
	
	public int getTotalAnimalCount() {
		return TotalAnimalCount;
	}
	public void setTotalAnimalCount(int totalAnimalCount) {
		TotalAnimalCount = totalAnimalCount;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public int getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	public float getLatitude() {
		return Latitude;
	}
	public void setLatitude(float latitude) {
		Latitude = latitude;
	}
	
	public float getLongitude() {
		return Longitude;
	}
	public void setLongitude(float longitude) {
		Longitude = longitude;
	}
}