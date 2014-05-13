package cct.mobapp.c7141384app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity implements  View.OnClickListener{
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	//private Button btn4;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_main);
		
		btn1 = (Button) findViewById(R.id.InfoGeneralButton);
		btn1.setOnClickListener(this);
		btn2 = (Button) findViewById(R.id.CategoriesButton);
		btn2.setOnClickListener(this);
		btn3 = (Button) findViewById(R.id.MapButton);
		btn3.setOnClickListener(this);
		
		
		//btn4 = (Button) findViewById(R.id.SettingsButton);
		//btn4.setOnClickListener(this);
	}

	 public void onClick(View arg) {
		 Intent intent;
			switch (arg.getId()){
			case R.id.InfoGeneralButton:
				//startActivity(intent);
				intent = new Intent (this, InformationGeneral.class);
				startActivity(intent);
				break;
				
			case R.id.CategoriesButton:
				//startActivity(intent);
				intent = new Intent (this, ListCategoriesActivity.class);
				startActivity(intent);
				break;
				
			case R.id.MapButton:
				//startActivity(intent);
				//intent = new Intent (this, MapActivity.class);
				intent = new Intent (this, UserActivity.class);
				startActivity(intent);
				break;
				
			/*case R.id.SettingsButton:
				//startActivity(intent);
				intent = new Intent (this, SettingsActivity.class);
				startActivity(intent);
				break;*/
			}
	}

}
