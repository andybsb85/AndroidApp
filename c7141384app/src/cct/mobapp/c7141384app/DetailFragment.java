package cct.mobapp.c7141384app;

import cct.mobapp.c7141384app.model.Attraction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment{
//private String currentURL;

private Attraction currentAttraction;
public int currentAttractionId;


	public void init(int attraction, Attraction data) {
		currentAttractionId = attraction;
		currentAttraction = data;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {		
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
				
		Log.d("SwA", "WVF onCreateView");
		View v = inflater.inflate(R.layout.detail_layout, container, false);
		
		if(Integer.toString(currentAttractionId) != null && currentAttraction!=null){
			
			//currentAttraction=((AttractionActivity) getActivity()).curAttraction;
			Log.d("DetailFragment", "attraction:"+ currentAttraction.getName());
			
			TextView name = (TextView) v.findViewById(R.id.at_name);
			name.setText(currentAttraction.getName());
			
			TextView description = (TextView) v.findViewById(R.id.at_description);
			description.setText(currentAttraction.getDescription());
			
			TextView openingHours = (TextView) v.findViewById(R.id.at_opening_hours);
			openingHours.setText(currentAttraction.getOpeninghours());
			
			TextView website = (TextView) v.findViewById(R.id.at_website);
			website.setText(currentAttraction.getWebsite());
			
			TextView address = (TextView)v.findViewById(R.id.at_address);
			address.setText(currentAttraction.getAddress());
		}
		return v;
		
	
	}
	
	public void updateAttraction(Attraction data) {
		
		currentAttraction = data;
		
		Log.d("DetailFragment", "attraction:"+ currentAttraction.getName());
		
		TextView name = (TextView) getView().findViewById(R.id.at_name);
		name.setText(currentAttraction.getName());
		
		TextView description = (TextView) getView().findViewById(R.id.at_description);
		description.setText(currentAttraction.getDescription());
		
		TextView openingHours = (TextView) getView().findViewById(R.id.at_opening_hours);
		openingHours.setText(currentAttraction.getOpeninghours());
		
		TextView website = (TextView) getView().findViewById(R.id.at_website);
		website.setText(currentAttraction.getWebsite());
		
		TextView address = (TextView) getView().findViewById(R.id.at_address);
		address.setText(currentAttraction.getAddress());
		
	}
}
