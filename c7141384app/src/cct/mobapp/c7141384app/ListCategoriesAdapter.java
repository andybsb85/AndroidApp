package cct.mobapp.c7141384app;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cct.mobapp.c7141384app.model.City;
import cct.mobapp.c7141384app.model.Region;


public class ListCategoriesAdapter extends BaseExpandableListAdapter{
	
	private ArrayList<Region> regions;
	private Context ctx;
	  
	public ListCategoriesAdapter(ArrayList<Region> regions, Context ctx) {

		this.regions = regions;
		this.ctx = ctx;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return regions.get(groupPosition).getCityList().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return regions.get(groupPosition).getCityList().get(childPosition).hashCode();
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		View v = convertView;
		
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
				      (Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.city_layout, parent, false);
		}
		
		final City city = regions.get(groupPosition).getCityList().get(childPosition);
		
		v.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				long cityId= city.getId();
			//	Toast.makeText(ctx, "You selected "+ cityId,Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(ctx, TypeAttractionActivity.class);
				intent.putExtra("cityid", cityId);
				ctx.startActivity(intent);
				
			}
			
		});
		TextView itemName = (TextView) v.findViewById(R.id.itemName);
		TextView itemDescr = (TextView) v.findViewById(R.id.itemDescr);
		
		
		
		itemName.setText(city.getName());
		itemDescr.setText(city.getDescription());
		
		return v;
		
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		int size = regions.get(groupPosition).getCityList().size();
		System.out.println("Child for group ["+groupPosition+"] is ["+size+"]");
		return size;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return regions.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
	  return regions.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return regions.get(groupPosition).hashCode();
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		View v = convertView;
		
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
				      (Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.region_layout, parent, false);
		}
		
		ImageView image = (ImageView) v.findViewById(R.id.imageRegion);
		TextView groupName = (TextView) v.findViewById(R.id.groupName);
		//TextView groupDescr = (TextView) v.findViewById(R.id.groupDescr);
		
			
		Region region = regions.get(groupPosition);
		
		groupName.setText(region.getName());
		//groupDescr.setText(region.getDescription());
		image.setImageResource(ctx.getResources().getIdentifier(
				region.getImage(), "drawable", "cct.mobapp.c7141384app"));
		
		return v;

	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	
}
