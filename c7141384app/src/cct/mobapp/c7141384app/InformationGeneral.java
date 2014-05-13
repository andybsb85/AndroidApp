package cct.mobapp.c7141384app;


//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;

import cct.mobapp.c7141384app.database.DataBaseHandler;
import cct.mobapp.c7141384app.model.Country;
import android.app.Activity;
//import android.content.Context;
//import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationGeneral extends Activity   {
	
	  private DataBaseHandler databaseHelper;
	  private int id = 1;
	  
	  public TextView countryName;
	  public ImageView countryImage;
	  public TextView countryDescription;
	 // private Bitmap bitmap;
	  //private String path = "http://peytonhamil.com/suns.jpg";
	  
	  
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information_general);
		
		//Drawable image = ImageOperations(this, path, "image.jpg");
		
		countryName = (TextView)findViewById(R.id.countryName);
		countryImage= (ImageView)findViewById(R.id.countryImage);
		countryDescription = (TextView)findViewById(R.id.countryDescription);
		//countryImage.setImageDrawable(image);
		
		databaseHelper = new DataBaseHandler(this);
		
		databaseHelper.openWritable();
		Country country = databaseHelper.getCountry(id);
		countryName.setText(country.getName());
		countryDescription.setText(country.getDescription());
		
				
		
	}
	
	/*  private Drawable ImageOperations(Context ctx, String url, String saveFilename) {
	        try {
	            InputStream is = (InputStream) this.fetch(url);
	            Drawable d = Drawable.createFromStream(is, "src");
	            return d;
	        } catch (MalformedURLException e) {
	            return null;
	        } catch (IOException e) {
	            return null;
	        }
	    }

	    public Object fetch(String address) throws MalformedURLException,IOException {
	        URL url = new URL(address);
	        Object content = url.getContent();
	        return content;
	    }
	
	public Bitmap getBitMapFromURL (String src){
		try{
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			return myBitmap;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}*/

}
