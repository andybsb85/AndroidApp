package cct.mobapp.c7141384app;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class TypeAttractionActivity extends ListActivity {
	Intent intentReturn;
	long cityId;

	private ArrayList<Option> optionInfo = new ArrayList<Option>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		// get data via the key
		cityId = extras.getLong("cityid", 0);
		//Toast.makeText(this, "city " + cityId, Toast.LENGTH_LONG).show();
		

		optionInfo.add(new Option("Places to Visit", "ic_places", 1));
		optionInfo.add(new Option("What to Do", "ic_entertainment", 2));
		optionInfo.add(new Option("Food and Drink", "ic_restaurants", 3));
		optionInfo.add(new Option("Hotels", "ic_hotels", 4));
			
		setListAdapter(new MyRowArrayAdapter(this, R.layout.options_layout, optionInfo));

	}
	
	class Option {

		public String name;
		public String image;
		public int type;
	//	public double rating;

		public Option(String name, String image, int type) {
			
			
			this.name = name;
			this.image = image;
			this.type = type;
			//this.rating = rating;
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

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

	
		

	}

	class MyRowArrayAdapter extends ArrayAdapter<Option> {

		private List<Option> list;
		private Context context;
		private int layout;

		public MyRowArrayAdapter(Context context, int resource,
				List<Option> objects) {
			super(context, resource, objects);
			this.list = objects;
			this.context = context;
			this.layout = resource;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			View row = convertView;

			if (row == null) {
				LayoutInflater inflater = (LayoutInflater) context
						.getSystemService(LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(layout, null);

			}

			final Option  option = list.get(position);
			
			row.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					int type= option.getType();
					//Toast.makeText(getApplicationContext(), "You selected "+ option.getType(),
						//	Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(getApplicationContext(), AttractionActivity.class);
					intent.putExtra("type", type);
					intent.putExtra("cityid", cityId);
					startActivity(intent);
				
				}
			});
			
			ImageView image = (ImageView) row.findViewById(R.id.attraction_image);
			
			image.setImageResource(context.getResources().getIdentifier(
					option.getImage(), "drawable", "cct.mobapp.c7141384app"));

			TextView name = (TextView) row.findViewById(R.id.attraction_name);
			name.setText(option.name);
			
			return row;
		}
	}

}
