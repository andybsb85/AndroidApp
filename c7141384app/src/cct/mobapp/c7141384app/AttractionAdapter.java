package cct.mobapp.c7141384app;

import java.util.ArrayList;

import cct.mobapp.c7141384app.model.Attraction;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class AttractionAdapter extends ArrayAdapter<Attraction>{

	private Context ctx;
	private ArrayList<Attraction> attractions;
	
	public AttractionAdapter(ArrayList<Attraction> attractions, Context ctx) {
		super(ctx, R.layout.row_layout, attractions);
		this.ctx = ctx;
		this.attractions = attractions;
	}

		@Override
	public int getCount() {
		return attractions.size();
	}

	@Override
	public Attraction getItem(int position) {
		return attractions.get(position);
	}

	
	@Override
	public long getItemId(int position) {
		return attractions.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		   Log.d("SwA", "Adapter getView");
           View v = convertView;
           if (convertView == null) {
	   			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   			v = inflater.inflate(R.layout.row_layout, null);
           }
           
           TextView tName = (TextView) v.findViewById(R.id.attraction_name);
           TextView lName = (TextView) v.findViewById(R.id.attraction_summary);
           
           Attraction ld = attractions.get(position);
           tName.setText(ld.getName());
           lName.setText(ld.getSummary());
           
           return v;
	
	}
	
	
	
}
