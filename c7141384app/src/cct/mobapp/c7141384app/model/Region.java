package cct.mobapp.c7141384app.model;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private int id;
	private int countryId;
	private String name;
	private String image;
	private String description;
	private List<City> cityList = new ArrayList<City>();
	
	public Region (){
		
	}

	public Region(int countryId, String name, String image, String description) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.image = image;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	
	
}
