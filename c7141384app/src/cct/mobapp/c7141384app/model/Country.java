package cct.mobapp.c7141384app.model;

public class Country {

	private int id;
	private String name;
	private String image;
	private String description;
	
	public Country(){
		
	}

	public Country(String name, String image, String description) {
		super();

		this.name = name;
		this.image = image;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
