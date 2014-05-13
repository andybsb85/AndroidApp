package cct.mobapp.c7141384app.database;

import java.util.ArrayList;

import cct.mobapp.c7141384app.model.Attraction;
import cct.mobapp.c7141384app.model.City;
import cct.mobapp.c7141384app.model.Country;
import cct.mobapp.c7141384app.model.Region;
import cct.mobapp.c7141384app.model.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Name
	private static final String DATABASE_NAME = "ecuadorTourism.db";
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Contacts table name
	public static final String TABLE_COUNTRY = "country";
	public static final String TABLE_REGION = "region";
	public static final String TABLE_CITY = "city";
	public static final String TABLE_ATTRACTIONS = "attractions";
	public static final String TABLE_ENTERTAINMENT = "entretainment";
	public static final String TABLE_FOOD_DRINK = "food_drink";
	public static final String TABLE_HOTELS = "hotels";
	public static final String TABLE_USERS = "users";

	// Common column names
	public static final String KEY_ID = "id";
	public static final String KEY_COUNTRY_ID = "country_id";
	public static final String KEY_REGION_ID = "region_id";
	public static final String KEY_CITY_ID = "city_id";
	public static final String KEY_NAME = "name";
	public static final String COLUMN_IMAGE = "image";
	public static final String COLUMN_SUMMARY = "summary";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_OPENINGHOURS = "openinghours";
	public static final String COLUMN_ADDRESS = "address";
	public static final String COLUMN_POSTCODE = "postcode";
	public static final String COLUMN_WEBSITE = "website";
	public static final String COLUMN_PHONE = "phone";
	public static final String KEY_TYPE = "type";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_CPASSWORD = "c_password";
	

	// Attraction_type
	public static final int PLACE_CODE = 1;
	public static final int ENTERTAINMENT_CODE = 2;
	public static final int FOOD_CODE = 3;
	public static final int HOTEL_CODE = 4;

	// country Table columns
	private static final String DATABASE_COUNTRY = "CREATE TABLE "
			+ TABLE_COUNTRY + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
			+ " TEXT NOT NULL," + COLUMN_IMAGE + " TEXT," + COLUMN_DESCRIPTION
			+ " TEXT);";

	// Region Table columns
	private static final String DATABASE_REGION = "CREATE TABLE "
			+ TABLE_REGION + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_COUNTRY_ID
			+ " INTEGER NOT NULL," + KEY_NAME + " TEXT NOT NULL,"
			+ COLUMN_IMAGE + " TEXT," + COLUMN_DESCRIPTION + " TEXT)";

	// City Table columns
	private static final String DATABASE_CITY = "CREATE TABLE " + TABLE_CITY
			+ "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_COUNTRY_ID + " INTEGER NOT NULL," + KEY_REGION_ID
			+ " INTEGER NOT NULL," + KEY_NAME + " TEXT NOT NULL,"
			+ COLUMN_IMAGE + " TEXT," + COLUMN_DESCRIPTION + " TEXT);";

	// Attraction Table columns
	private static final String DATABASE_ATTRACTIONS = "CREATE TABLE "
			+ TABLE_ATTRACTIONS + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_COUNTRY_ID
			+ " INTEGER NOT NULL," + KEY_REGION_ID + " INTEGER NOT NULL,"
			+ KEY_CITY_ID + " INTEGER NOT NULL," + KEY_TYPE
			+ " INTEGER NOT NULL," + KEY_NAME + " TEXT NOT NULL,"
			+ COLUMN_SUMMARY + " TEXT," + COLUMN_IMAGE + " TEXT,"
			+ COLUMN_DESCRIPTION + " TEXT," + COLUMN_OPENINGHOURS + " TEXT,"
			+ COLUMN_ADDRESS + " TEXT," + COLUMN_POSTCODE + " TEXT,"
			+ COLUMN_WEBSITE + " TEXT," + COLUMN_PHONE + " TEXT);";
	
	private static final String DATABASE_USERS = "CREATE TABLE "
			+ TABLE_USERS + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," 
			+ COLUMN_NAME + " TEXT NOT NULL," 
			+ COLUMN_EMAIL + " TEXT NOT NULL," 
			+ COLUMN_PASSWORD + " TEXT NOT NULL," 
			+ COLUMN_CPASSWORD + " TEXT NOT NULL);";

	public DataBaseHandler(Context context) {

		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d("constcter ", "inserting 2 ...");
	}

	// Create Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db=db;
		Log.d("onCreate ", "onCreate 1 ...");
		db.execSQL(DATABASE_COUNTRY);
		db.execSQL(DATABASE_REGION);
		db.execSQL(DATABASE_CITY);
		db.execSQL(DATABASE_ATTRACTIONS);
		db.execSQL(DATABASE_USERS);
		Log.d("Insert ", "inserting 1 ...");
		DatabaseData.populateDataBase(this);

	}

	SQLiteDatabase db;

	public void openWritable(){
    	

	db= this.getWritableDatabase();
    	
    	
    }

	public void openReadeable() {
		db = this.getReadableDatabase();
	}

	public void close() {
		db.close();
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DataBaseHandler.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTRACTIONS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

		// Create tables again
		onCreate(db);
	}

	public void addUser(User user) {
		// SQLiteDatabase db= this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.COLUMN_NAME, user.getName()); 
		values.put(DataBaseHandler.COLUMN_EMAIL, user.getEmail()); 
		values.put(DataBaseHandler.COLUMN_PASSWORD, user.getPassword()); 
		values.put(DataBaseHandler.COLUMN_CPASSWORD, user.getcPassword()); 
		// Inserting Row
		db.insert(DataBaseHandler.TABLE_USERS, null, values);
		// db.close(); // Closing database connection
	}

	public void addCountry(Country country) {
		// SQLiteDatabase db= this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_NAME, country.getName()); // Country Name
		values.put(DataBaseHandler.COLUMN_IMAGE, country.getImage()); // Country
																		// image
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, country.getDescription()); // Country
																					// Summary

		
		// Inserting Row
		db.insert(DataBaseHandler.TABLE_COUNTRY, null, values);
		// db.close(); // Closing database connection
	}

	// Adding new Region
	public void addRegion(Region region) {
		// SQLiteDatabase db= this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_COUNTRY_ID, region.getCountryId()); // Region country id
		values.put(DataBaseHandler.KEY_NAME, region.getName()); // Region Name
		values.put(DataBaseHandler.COLUMN_IMAGE, region.getImage()); // Region image
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, region.getDescription()); // Region Summary

		// Inserting Row
		db.insert(DataBaseHandler.TABLE_REGION, null, values);
		// db.close(); // Closing database connection
	}

	// Adding new City
	public void addCity(City city) {

		// SQLiteDatabase db= this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_COUNTRY_ID, city.getCountryId()); // Country
																			// Id
		values.put(DataBaseHandler.KEY_REGION_ID, city.getRegionId()); // Region
																		// Id
		values.put(DataBaseHandler.KEY_NAME, city.getName()); // City Name
		values.put(DataBaseHandler.COLUMN_IMAGE, city.getImage()); // City image
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, city.getDescription()); // City
																				// description

		// Inserting Row
		db.insert(DataBaseHandler.TABLE_CITY, null, values);
		// db.close(); // Closing database connection
	}

	// Adding new attraction
	public void addAttraction(Attraction attraction) {
		// SQLiteDatabase db= this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_COUNTRY_ID, attraction.getCountryId()); // Country
		values.put(DataBaseHandler.KEY_REGION_ID, attraction.getRegionId()); // Region
		values.put(DataBaseHandler.KEY_CITY_ID, attraction.getCityId()); // City
		values.put(DataBaseHandler.KEY_TYPE, attraction.getType()); // City Type
		values.put(DataBaseHandler.KEY_NAME, attraction.getName()); // Attraction
		values.put(DataBaseHandler.COLUMN_SUMMARY, attraction.getSummary()); // Attraction
		values.put(DataBaseHandler.COLUMN_IMAGE, attraction.getImage()); // Attraction
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, attraction.getDescription()); // Attraction Summary
		values.put(DataBaseHandler.COLUMN_OPENINGHOURS,	attraction.getOpeninghours()); // Attraction Description
		values.put(DataBaseHandler.COLUMN_ADDRESS, attraction.getAddress()); // Attraction
		values.put(DataBaseHandler.COLUMN_POSTCODE, attraction.getPostcode()); // Attraction
		values.put(DataBaseHandler.COLUMN_WEBSITE, attraction.getWebsite()); // Attraction
		values.put(DataBaseHandler.COLUMN_PHONE, attraction.getPhone()); // Attraction
																		
		// Inserting Row
		db.insert(DataBaseHandler.TABLE_ATTRACTIONS, null, values);
		// db.close(); // Closing database connection
	}

	
	
	/*===============================Getting single objects=================================== */

	// Getting single country
	
	
	public User getUser(String name) {
		// SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(DataBaseHandler.TABLE_USERS, new String[] {
				DataBaseHandler.KEY_ID, 
				DataBaseHandler.COLUMN_NAME,
				DataBaseHandler.COLUMN_EMAIL,
				DataBaseHandler.COLUMN_PASSWORD,
				DataBaseHandler.COLUMN_CPASSWORD }, DataBaseHandler.COLUMN_NAME
				+ "=?", new String[] { String.valueOf(name) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		User user = new User(
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_NAME)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_EMAIL)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_PASSWORD)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_CPASSWORD)));

		// return country
		return user;
	}

	
	// Getting single country
	public Country getCountry(int id) {
		// SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(DataBaseHandler.TABLE_COUNTRY, new String[] {
				DataBaseHandler.KEY_ID, 
				DataBaseHandler.KEY_NAME,
				DataBaseHandler.COLUMN_IMAGE,
				DataBaseHandler.COLUMN_DESCRIPTION }, DataBaseHandler.KEY_ID
				+ "=?", new String[] { String.valueOf(id) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		Country country = new Country(
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_NAME)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));

		// return country
		return country;
	}

	// Getting single region
	public Region getRegion(int id) {
		// // SQLiteDatabase db= this.getWritableDatabase();

		Cursor cursor = db.query(DataBaseHandler.TABLE_REGION, new String[] {
				DataBaseHandler.KEY_ID,
				DataBaseHandler.KEY_COUNTRY_ID,
				DataBaseHandler.KEY_NAME, 
				DataBaseHandler.COLUMN_IMAGE,
				DataBaseHandler.COLUMN_DESCRIPTION }, DataBaseHandler.KEY_ID
				+ "=?", new String[] { String.valueOf(id) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		Region region = new Region(
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_NAME)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));

		// return region
		return region;
	}

	// Getting single city
	public City getCity(int id) {
		// // SQLiteDatabase db= this.getWritableDatabase();

		Cursor cursor = db.query(DataBaseHandler.TABLE_CITY, new String[] {
				DataBaseHandler.KEY_ID, 
				DataBaseHandler.KEY_COUNTRY_ID,
				DataBaseHandler.KEY_REGION_ID, 
				DataBaseHandler.KEY_NAME,
				DataBaseHandler.COLUMN_IMAGE,
				DataBaseHandler.COLUMN_DESCRIPTION }, DataBaseHandler.KEY_ID
				+ "=?", new String[] { String.valueOf(id) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		City city = new City(
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)), 
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_REGION_ID)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_NAME)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));


		// return city
		return city;
	}

	// Getting single attraction
	public Attraction getAttraction(int id) {
		// // SQLiteDatabase db= this.getWritableDatabase();

		Cursor cursor = db.query(DataBaseHandler.TABLE_ATTRACTIONS,	new String[] {
						DataBaseHandler.KEY_ID,
						DataBaseHandler.KEY_COUNTRY_ID,
						DataBaseHandler.KEY_REGION_ID,
						DataBaseHandler.KEY_CITY_ID,
						DataBaseHandler.KEY_NAME,
						DataBaseHandler.KEY_TYPE,
						DataBaseHandler.COLUMN_SUMMARY,
						DataBaseHandler.COLUMN_IMAGE,
						DataBaseHandler.COLUMN_DESCRIPTION,
						DataBaseHandler.COLUMN_OPENINGHOURS,
						DataBaseHandler.COLUMN_ADDRESS,
						DataBaseHandler.COLUMN_POSTCODE,
						DataBaseHandler.COLUMN_WEBSITE,
						DataBaseHandler.COLUMN_PHONE }, DataBaseHandler.KEY_ID
						+ "=?", new String[] { String.valueOf(id) }, null,
				null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Attraction attraction = new Attraction(
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)),
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_REGION_ID)), 
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_CITY_ID)), 
				cursor.getInt(cursor.getColumnIndex(DataBaseHandler.KEY_TYPE)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_NAME)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_SUMMARY)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_OPENINGHOURS)), 
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_ADDRESS)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_POSTCODE)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_WEBSITE)),
				cursor.getString(cursor.getColumnIndex(DataBaseHandler.COLUMN_PHONE)));

		// return attraction
		return attraction;
	}

	
	/* ===============================Getting all objects===================================*/

	// Getting All countries
	public ArrayList<Country> getAllCountry() {
		ArrayList<Country> countryList = new ArrayList<Country>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_COUNTRY;

		// SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Country country = new Country();
				country.setId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				country.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				country.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				country.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));

				// Adding contact to list
				countryList.add(country);
			} while (cursor.moveToNext());
		}

		// return countries list
		return countryList;
	}

	// Getting All regions
	public ArrayList<Region> getAllRegion() {
		ArrayList<Region> regionList = new ArrayList<Region>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_REGION;

		// SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Region region = new Region();
				region.setId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				region.setCountryId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)));
				region.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				region.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				region.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));

				// Adding regions to list
				regionList.add(region);
			} while (cursor.moveToNext());
		}

		// return contact list
		return regionList;
	}

	// Getting All regions by id
	public ArrayList<Region> getAllRegion(boolean populateCities) {

		ArrayList<Region> regionList = new ArrayList<Region>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_REGION;

		// // SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Region region = new Region();
				region.setId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				region.setCountryId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)));
				region.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				region.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				region.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));
				if (populateCities) {
					region.setCityList(getCitiesByRegion(region.getId()));
				}
				// Adding regions to list
				regionList.add(region);
			} while (cursor.moveToNext());
		}

		// return contact list
		return regionList;
	}

	// Getting All cities
	public ArrayList<City> getAllCities() {
		ArrayList<City> cityList = new ArrayList<City>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_CITY;

		// SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getLong(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				city.setCountryId(cursor.getLong(cursor
						.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)));
				city.setRegionId(cursor.getLong(cursor
						.getColumnIndex(DataBaseHandler.KEY_REGION_ID)));
				city.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				city.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				city.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));

				// Adding cities to list
				cityList.add(city);
			} while (cursor.moveToNext());
		}

		// return contact list
		return cityList;
	}

	// Getting by Region
	public ArrayList<City> getCitiesByRegion(int region_id) {
		ArrayList<City> cityList = new ArrayList<City>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_CITY
				+ " WHERE " + DataBaseHandler.KEY_REGION_ID + " = " + region_id;

		// SQLiteDatabase db = this.getWritableDatabase();
		// Log.d("BaseDataSour", "pre getCitiesByRegion" + selectQuery);
		Cursor cursor = db.rawQuery(selectQuery, null);
		/*
		 * Log.d("BaseDataSour", "poset getCitiesByRegion " +
		 * cursor.getCount()); Log.d("BaseDataSour", "poset getCitiesByRegion "
		 * + cursor.getColumnCount()); for (int i = 0; i <
		 * cursor.getColumnCount(); i++) { Log.d("BaseDataSour",
		 * "poset getCitiesByRegion " +i+ "  " +cursor.getColumnName(i)); }
		 */
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				City city = new City();
				Log.d("BaseDataSour", "pre 1" + selectQuery);
				city.setId(cursor.getLong(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				city.setCountryId(cursor.getLong(cursor
						.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)));
				city.setRegionId(cursor.getLong(cursor
						.getColumnIndex(DataBaseHandler.KEY_REGION_ID)));
				city.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				city.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				city.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));

				// Adding cities to list
				cityList.add(city);
			} while (cursor.moveToNext());
		}

		// return contact list
		return cityList;
	}

	// Getting All Attractions
	public ArrayList<Attraction> getAllAttractions() {
		ArrayList<Attraction> attractionList = new ArrayList<Attraction>();
		// Select All Query
		String selectQuery = "SELECT  * FROM "
				+ DataBaseHandler.TABLE_ATTRACTIONS;

		// SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Attraction attraction = new Attraction();
				attraction.setId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				attraction.setCountryId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)));
				attraction.setRegionId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_REGION_ID)));
				attraction.setCityId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_CITY_ID)));
				attraction.setType(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_TYPE)));
				attraction.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				attraction.setSummary(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_SUMMARY)));
				attraction.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				attraction.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));
				attraction.setOpeninghours(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_OPENINGHOURS)));
				attraction.setAddress(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_ADDRESS)));
				attraction.setPostcode(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_POSTCODE)));
				attraction.setWebsite(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_WEBSITE)));
				attraction.setPhone(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_PHONE)));

				// Adding attractions to list
				attractionList.add(attraction);
			} while (cursor.moveToNext());
		}

		// return contact list
		return attractionList;
	}
	
	
	//Getting all attractions by city and type
	
	public ArrayList<Attraction> getAttractionsByType(long cityId, int type ) {
		ArrayList<Attraction> attractionList = new ArrayList<Attraction>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_ATTRACTIONS
				+ " WHERE " + DataBaseHandler.KEY_CITY_ID + " = " + cityId + " AND " 
				+ DataBaseHandler.KEY_TYPE + " = " + type;

		// SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Attraction attraction = new Attraction();
				attraction.setId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_ID)));
				attraction.setCountryId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_COUNTRY_ID)));
				attraction.setRegionId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_REGION_ID)));
				attraction.setCityId(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_CITY_ID)));
				attraction.setType(cursor.getInt(cursor
						.getColumnIndex(DataBaseHandler.KEY_TYPE)));
				attraction.setName(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.KEY_NAME)));
				attraction.setSummary(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_SUMMARY)));
				attraction.setImage(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_IMAGE)));
				attraction.setDescription(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_DESCRIPTION)));
				attraction.setOpeninghours(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_OPENINGHOURS)));
				attraction.setAddress(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_ADDRESS)));
				attraction.setPostcode(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_POSTCODE)));
				attraction.setWebsite(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_WEBSITE)));
				attraction.setPhone(cursor.getString(cursor
						.getColumnIndex(DataBaseHandler.COLUMN_PHONE)));

				// Adding attractions to list
				attractionList.add(attraction);
			} while (cursor.moveToNext());
		}

		// return contact list
		return attractionList;
	}

	
	/* ===============================Updating single objects=================================== */
	// Updating single user
		public int updateUser(User user) {
			// SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(DataBaseHandler.COLUMN_NAME, user.getName());
			values.put(DataBaseHandler.COLUMN_EMAIL, user.getEmail());
			values.put(DataBaseHandler.COLUMN_PASSWORD, user.getPassword());
			values.put(DataBaseHandler.COLUMN_CPASSWORD, user.getcPassword());

			// updating row
			return db.update(DataBaseHandler.TABLE_USERS, values,
					DataBaseHandler.KEY_ID + " = ?",
					new String[] { String.valueOf(user.getId()) });
		}
		
		
	// Updating single country
	public int updateCountry(Country country) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_NAME, country.getName());
		values.put(DataBaseHandler.COLUMN_SUMMARY, country.getImage());
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, country.getDescription());

		// updating row
		return db.update(DataBaseHandler.TABLE_COUNTRY, values,
				DataBaseHandler.KEY_ID + " = ?",
				new String[] { String.valueOf(country.getId()) });
	}

	// Updating single region
	public int updateRegion(Region region) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_COUNTRY_ID, region.getCountryId());
		values.put(DataBaseHandler.KEY_NAME, region.getName());
		values.put(DataBaseHandler.COLUMN_SUMMARY, region.getImage());
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, region.getDescription());

		// updating row
		return db.update(DataBaseHandler.TABLE_REGION, values,
				DataBaseHandler.KEY_ID + " = ?",
				new String[] { String.valueOf(region.getId()) });
	}

	// Updating single city
	public int updateCity(City city) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_COUNTRY_ID, city.getCountryId());
		values.put(DataBaseHandler.KEY_REGION_ID, city.getRegionId());
		values.put(DataBaseHandler.KEY_NAME, city.getName());
		values.put(DataBaseHandler.COLUMN_SUMMARY, city.getImage());
		values.put(DataBaseHandler.COLUMN_DESCRIPTION, city.getDescription());

		// updating row
		return db.update(DataBaseHandler.TABLE_CITY, values,
				DataBaseHandler.KEY_ID + " = ?",
				new String[] { String.valueOf(city.getId()) });
	}

	// Updating single attraction
	public int updateAttraction(Attraction attraction) {
		// SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DataBaseHandler.KEY_COUNTRY_ID, attraction.getCountryId());
		values.put(DataBaseHandler.KEY_REGION_ID, attraction.getRegionId());
		values.put(DataBaseHandler.KEY_CITY_ID, attraction.getCityId());
		values.put(DataBaseHandler.KEY_TYPE, attraction.getType());
		values.put(DataBaseHandler.KEY_NAME, attraction.getName());
		values.put(DataBaseHandler.COLUMN_SUMMARY, attraction.getSummary());
		values.put(DataBaseHandler.COLUMN_DESCRIPTION,
				attraction.getDescription());
		values.put(DataBaseHandler.COLUMN_OPENINGHOURS,
				attraction.getOpeninghours());
		values.put(DataBaseHandler.COLUMN_ADDRESS, attraction.getAddress());
		values.put(DataBaseHandler.COLUMN_POSTCODE, attraction.getPostcode());
		values.put(DataBaseHandler.COLUMN_WEBSITE, attraction.getPostcode());
		values.put(DataBaseHandler.COLUMN_PHONE, attraction.getPhone());

		// updating row
		return db.update(DataBaseHandler.TABLE_ATTRACTIONS, values,
				DataBaseHandler.KEY_ID + " = ?",
				new String[] { String.valueOf(attraction.getId()) });
	}

	

	/* ===============================Deleting single objects===================================*/
	
	// Deleting single user
		public void deleteUser(User user) {
			// SQLiteDatabase db = this.getWritableDatabase();
			db.delete(DataBaseHandler.TABLE_USERS, DataBaseHandler.KEY_ID
					+ " = ?", new String[] { String.valueOf(user.getId()) });
			// db.close();
		}
	
	// Deleting single country
	public void deleteCountry(Country country) {
		// SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DataBaseHandler.TABLE_COUNTRY, DataBaseHandler.KEY_ID
				+ " = ?", new String[] { String.valueOf(country.getId()) });
		// db.close();
	}

	// Deleting single region
	public void deleteRegion(Region region) {
		// SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DataBaseHandler.TABLE_REGION,
				DataBaseHandler.KEY_ID + " = ?",
				new String[] { String.valueOf(region.getId()) });
		// db.close();
	}

	// Deleting single country
	public void deleteCity(City city) {
		// SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DataBaseHandler.TABLE_CITY, DataBaseHandler.KEY_ID + " = ?",
				new String[] { String.valueOf(city.getId()) });
		// db.close();
	}

	// Deleting single attraction
	public void deleteContact(Attraction attraction) {
		// SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DataBaseHandler.TABLE_ATTRACTIONS, DataBaseHandler.KEY_ID
				+ " = ?", new String[] { String.valueOf(attraction.getId()) });
		// db.close();
	}

	

	/* ===============================Getting objects count=================================== */
	
	// Getting countries Count
	public int getCountriesCount() {
		String countQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_COUNTRY;
		// SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	// Getting regions Count
	public int getRegionsCount() {
		String countQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_REGION;
		// SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	// Getting cities Count
	public int getCitiesCount() {
		String countQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_CITY;
		// SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	// Getting attractions Count
	public int getAttractionCount() {
		String countQuery = "SELECT  * FROM "
				+ DataBaseHandler.TABLE_ATTRACTIONS;
		// SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		// cursor.close();

		// return count
		return cursor.getCount();
	}

	
}
