package cct.mobapp.c7141384app;


import java.util.ArrayList;

import cct.mobapp.c7141384app.database.DataBaseHandler;
import cct.mobapp.c7141384app.model.Attraction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.util.Log;


	public class AttractionActivity extends FragmentActivity implements ChangeListListener{
		
    public long cityId;
    public int type;
    public ArrayList<Attraction> attractions;
    private DataBaseHandler db;
	public Attraction curAttraction;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		//Log.d("AttractionActivity", "onCreate");
		
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		// get data via the key
		cityId = extras.getLong("cityid", 0);
		type = extras.getInt("type", 0);
		db= new DataBaseHandler(this);
		
		db.openReadeable();
		attractions=db.getAttractionsByType(cityId, type);
		db.close();
		
		setContentView(R.layout.activity_main);
		
	/*	 android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		 android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
	         
		 AttractionListFragment llf = new AttractionListFragment();
	     ft.replace(R.id.listFragment, llf);
	     ft.commit();*/

	}
	
	/*	protected void onResume() {
		if (!nameET.getText().toString().equalsIgnoreCase("")) {

			user = retrieveUser(nameET.getText().toString());
			scoreTextView.setText(user.getSuccesfulAttemps() + "/"
					+ user.getTotalAttemps());

		}
		super.onResume();
	}*/
	

	public void onLinkChange(int attraction, Attraction data) {
		System.out.println("Listener");
		
		Log.d("AttractionActivity", "onLinkChange");
		// Here we detect if there's dual fragment
		
						
        if (findViewById(R.id.fragPage) != null) {
        	
          	
        	Log.d("find fragment", "fragPage");
        	DetailFragment f = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragPage);
        	
               	
    		if (f == null) {
    			System.out.println("Dual fragment - 1");
    			f = new DetailFragment();
    			f.init(attraction, data);
    			System.out.println("launching init");
    			// We are in dual fragment (Tablet and so on)
    			android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    			android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
    			
    			ft.replace(R.id.fragPage, f);
    			ft.commit();
    			
    		}
    		else {
    			Log.d("SwA", "Dual Fragment update");
    			f.updateAttraction(data);
    			
    		}
        }
		else {
			System.out.println("Start Activity");
			Intent i = new Intent(this, DetailActivity.class);
			i.putExtra("attraction", attraction);
			startActivity(i);
		}
		
	}
	
	public void getAttractionId (int attraction){
		
		
		
	}

}
