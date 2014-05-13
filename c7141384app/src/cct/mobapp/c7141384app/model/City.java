package cct.mobapp.c7141384app.model;

public class City {
	
	private long id;
	private long countryId;
	private long regionId;
	private String name;
	private String image;
	private String description;
	
	public City (){
		
	}

	public City(long countryId, long regionId, String name, String image,
			String description) {
		super();
		this.countryId = countryId;
		this.regionId = regionId;
		this.name = name;
		this.image = image;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
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
	

}
