package cct.mobapp.c7141384app;

import java.util.ArrayList;

import cct.mobapp.c7141384app.model.Attraction;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class AttractionListFragment extends Fragment {
		
	 private AttractionAdapter la;
	 private ArrayList<Attraction> attractionsa = new ArrayList<Attraction>();
	
	
    
	public AttractionListFragment() {		
	}
	

	public void setAttractions(ArrayList<Attraction> attractions){
		this.attractionsa=attractions;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.listfragment_layout, container, false);
		ListView lv = (ListView) v.findViewById(R.id.attractions);
		
		attractionsa=((AttractionActivity) getActivity()).attractions;
		Log.d("listat","attractions "+attractionsa.size());
		
		la = new AttractionAdapter(attractionsa, getActivity());
	   //Log.d("SwA", "---- on create view size "+attraction.size()+" cuenta"+la.getCount());
		lv.setAdapter(la);  
				
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			 public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                     long id) {
				Attraction data = ( (AttractionAdapter) la ).getItem(position);
				
				Log.d("data","data id "+ data.getId());
				((ChangeListListener) getActivity()).onLinkChange((int) data.getId(), data); 
			}

		});
		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		// We verify that our activity implements the listener
		if (! (activity instanceof ChangeListListener) )
			throw new ClassCastException();
		
		Log.d("SwA", "onAttach");
		super.onAttach(activity);
	}

}
