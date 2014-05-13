package cct.mobapp.c7141384app;

import cct.mobapp.c7141384app.database.DataBaseHandler;
import cct.mobapp.c7141384app.model.Attraction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class DetailActivity extends FragmentActivity{

	public int attraction;
    private DataBaseHandler db;
	public Attraction curAttraction;
		
       
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		
		DetailFragment f = new DetailFragment();
		
		Intent i = this.getIntent();
		attraction = i.getExtras().getInt("attraction");
		Log.d("SwA", "attraction = " + attraction);
		
		
    	db= new DataBaseHandler(this);
		db.openReadeable();
		curAttraction= db.getAttraction(attraction);
		Log.d("attrac from DB", "attraction: " + curAttraction.getName());
		db.close();
		
		
		f.init(attraction, curAttraction);		
		getSupportFragmentManager().beginTransaction().add(android.R.id.content, f).commit();
	}

}
