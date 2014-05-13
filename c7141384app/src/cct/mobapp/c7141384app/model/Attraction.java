package cct.mobapp.c7141384app.model;

public class Attraction {

	private int id;
	private int countryId;
	private int regionId;
	private int cityId;
	private int type;
	private String name;
	private String summary;
	private String image;
	private String description;
	private String openinghours;
	private String address;
	private String postcode;
	private String website;
	private String phone;
	
	

	public Attraction() {
	}

	public Attraction(int countryId, int regionId, int cityId, int type,
			String name, String summary, String image, String description,
			String openinghours, String address, String postcode,
			String website, String phone) {
		super();
		this.countryId = countryId;
		this.regionId = regionId;
		this.cityId = cityId;
		this.type = type;
		this.name = name;
		this.summary = summary;
		this.image = image;
		this.description = description;
		this.openinghours = openinghours;
		this.address = address;
		this.postcode = postcode;
		this.website = website;
		this.phone = phone;
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

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getOpeninghours() {
		return openinghours;
	}

	public void setOpeninghours(String openinghours) {
		this.openinghours = openinghours;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return name;
	}

	

}