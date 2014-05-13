package cct.mobapp.c7141384app;

import java.util.ArrayList;

import cct.mobapp.c7141384app.database.DataBaseHandler;
import cct.mobapp.c7141384app.model.City;
import cct.mobapp.c7141384app.model.Region;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;


public class ListCategoriesActivity extends Activity{
	
	public ArrayList<Region> regions;
	public ArrayList<City> cities;
	public Region region;
	public City city;
	public static DataBaseHandler databaseHandler;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		databaseHandler = new DataBaseHandler(this);
	
		  
		setContentView(R.layout.categories_layout);
		
		databaseHandler.openWritable();
		regions = databaseHandler.getAllRegion(true);
		
		 
		ExpandableListView exList = (ExpandableListView) findViewById(R.id.expandableListView1);
		exList.setIndicatorBounds(5, 5);
		ListCategoriesAdapter exAdpt = new ListCategoriesAdapter(regions, this);
		exList.setIndicatorBounds(0, 20);
		exList.setAdapter(exAdpt);
	
	}
}
