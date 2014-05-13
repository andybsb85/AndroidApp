package cct.mobapp.c7141384app.database;

import android.util.Log;
import cct.mobapp.c7141384app.model.Attraction;
import cct.mobapp.c7141384app.model.City;
import cct.mobapp.c7141384app.model.Country;
import cct.mobapp.c7141384app.model.Region;

public class DatabaseData {

	
	public static void populateDataBase(DataBaseHandler databaseHandler) {

		
		
		// Inserting country
		Log.d("Insert country", "inserting country ...");
		databaseHandler.addCountry(new Country("Ecuador",
				"http://www.paisverde.com/ecuador_collage.jpg",
				"Ecuador is located in Latinamerica"));

		// Inserting regions
		Log.d("Insert region", "inserting region ...");
		databaseHandler.addRegion(new Region(1, "Pacific Coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));
		databaseHandler
				.addRegion(new Region(
						1,
						"Andes",
						"http://t3.gstatic.com/images?q=tbn:ANd9GcT_ZwDnJdflnkX4aKq2lzLxo6UL1jPmurHKbPhVAHYKS6fL6VuoTA",
						"A lot of mountains and volcanos are located in Andes Region"));
		databaseHandler
				.addRegion(new Region(
						1,
						"Amazon",
						"http://www.onthegotours.com/repository/Amazon-High-1-195161351875143_0_500.jpg",
						"There is a large amount of biodeversity, flora and fauna in Amazon"));
		databaseHandler
				.addRegion(new Region(
						1,
						"Galapagos",
						"http://sintaxis.net/ecuador/images/stories/easygallery/paradise%202.jpg",
						"The Galapagos Islands are a group of volcanic islands. A biological marine reserve."));

		// Inserting cities for pacific coast
		Log.d("Insert city", "inserting city ...");
		databaseHandler.addCity(new City(1, 1, "Manta",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));
		databaseHandler.addCity(new City(1, 1, "Esmeraldas",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		databaseHandler.addCity(new City(1, 1, "Guayaquil",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		// Inserting cities for andes

		Log.d("Insert city", "inserting city ...");
		databaseHandler.addCity(new City(1, 2, "Quito",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));
		databaseHandler.addCity(new City(1, 2, "Cuenca",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		databaseHandler.addCity(new City(1, 2, "Ambato",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		// Inserting cities for amazon

		databaseHandler.addCity(new City(1, 3, "Napo",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));
		databaseHandler.addCity(new City(1, 3, "Pastaza",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		databaseHandler.addCity(new City(1, 3, "Sucumbios",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		// Inserting cities for galapagos

		databaseHandler.addCity(new City(1, 4, "Puerto Ayora",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));
		databaseHandler.addCity(new City(1, 4, "Puerto Baquerizo Moreno",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));

		databaseHandler.addCity(new City(1, 4, "San Cristobal",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"There are a lot of beaches to visit in the coast"));
		

/*=========================================INSERTING PLACES=========================================================*/
		
		
		// Inserting places for region 1 city 1

		Log.d("IPR1", "inserting places region 1 ..."); 
		
		databaseHandler.addAttraction (new Attraction(1, 1, 1,
				DataBaseHandler.PLACE_CODE,
				"Place 1 R1 C1",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
		databaseHandler.addAttraction (new Attraction(1, 1, 1,
				DataBaseHandler.PLACE_CODE,
				"Place 2 R1 C1",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
				
		// Inserting places for region 1 city 2
		databaseHandler.addAttraction (new Attraction(1, 1, 2,
				DataBaseHandler.PLACE_CODE,
				"Place 3 R1 C2",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
		databaseHandler.addAttraction (new Attraction(1, 1, 2,
				DataBaseHandler.PLACE_CODE,
				"Place 4 R1 C2",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
												
		// Inserting places for region 1 city 3
		databaseHandler.addAttraction (new Attraction(1, 1, 3,
				DataBaseHandler.PLACE_CODE,
				"Place 5 R1 C3",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
				
		databaseHandler.addAttraction (new Attraction(1, 1, 3,
				DataBaseHandler.PLACE_CODE,
				"Place 6 R1 C3",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
				
		// Inserting places for region 2 city 4

		Log.d("IPR2", "inserting places region 2 ..."); 
				
		databaseHandler.addAttraction (new Attraction(1, 2, 4,
				DataBaseHandler.PLACE_CODE,
				"Place 1 R2 C4",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
		databaseHandler.addAttraction (new Attraction(1, 2, 4,
				DataBaseHandler.PLACE_CODE,
				"Place 2 R2 C4",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
						
		// Inserting places for region 2 city 5
		databaseHandler.addAttraction (new Attraction(1, 2, 5,
				DataBaseHandler.PLACE_CODE,
				"Place 3 R2 C5",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
				
		databaseHandler.addAttraction (new Attraction(1, 2, 5,
				DataBaseHandler.PLACE_CODE,
				"Place 4 R2 C5",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
		
														
		// Inserting places for region 2 city 6
		databaseHandler.addAttraction (new Attraction(1, 2, 6,
				DataBaseHandler.PLACE_CODE,
				"Place 5 R2 C6",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));
					
		databaseHandler.addAttraction (new Attraction(1, 2, 6,
				DataBaseHandler.PLACE_CODE,
				"Attraction 6 R2 C6",
				"There are a lot of beaches to visit in the coast",
				"http://www.esl-languages.com/data/category/image2/518.jpg",
				"Description",
				"Monday to Friday  9:00 am - 16:00 pm",
				"556 24 de Mayo and Miraflores", 
				"MA444E",
				"www.attraction1.com",
				"+593 933444444"));							 
	
	
		// Inserting places for region 3 city 7

			Log.d("IPR3", "inserting places region 3 ..."); 
					
			databaseHandler.addAttraction (new Attraction(1, 3, 7,
					DataBaseHandler.PLACE_CODE,
					"Place 1 R3 C7",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
			databaseHandler.addAttraction (new Attraction(1, 3, 7,
					DataBaseHandler.PLACE_CODE,
					"Place 2 R3 C7",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
							
			// Inserting places for region 3 city 8
			databaseHandler.addAttraction (new Attraction(1, 3, 8,
					DataBaseHandler.PLACE_CODE,
					"Place 3 R3 C8",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
					
			databaseHandler.addAttraction (new Attraction(1, 3, 8,
					DataBaseHandler.PLACE_CODE,
					"Place 4 R3 C8",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
															
			// Inserting places for region 3 city 9
			databaseHandler.addAttraction (new Attraction(1, 3, 9,
					DataBaseHandler.PLACE_CODE,
					"Place 5 R3 C9",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
						
			databaseHandler.addAttraction (new Attraction(1, 3, 9,
					DataBaseHandler.PLACE_CODE,
					"Place 6 R3 C9",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));	


		Log.d("IPR4", "inserting places region 4 ..."); 
		
		// Inserting places for region 4 city 10
					
			databaseHandler.addAttraction (new Attraction(1, 4, 10,
					DataBaseHandler.PLACE_CODE,
					"Place 1 R4 C10",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
			databaseHandler.addAttraction (new Attraction(1, 4, 10,
					DataBaseHandler.PLACE_CODE,
					"Place 2 R4 C10",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
							
			// Inserting places for region 4 city 11
			databaseHandler.addAttraction (new Attraction(1, 4, 11,
					DataBaseHandler.PLACE_CODE,
					"Place 3 R4 C11",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
					
			databaseHandler.addAttraction (new Attraction(1, 4,11,
					DataBaseHandler.PLACE_CODE,
					"Place 4 R4 C11",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
															
			// Inserting attractions for region 4 city 12
			databaseHandler.addAttraction (new Attraction(1, 4, 12,
					DataBaseHandler.PLACE_CODE,
					"Place 5 R4 C12",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
						
			databaseHandler.addAttraction (new Attraction(1, 4, 12,
					DataBaseHandler.PLACE_CODE,
					"Place 6 R4 C12",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));	
	
			
/*=========================================INSERTING ENTERTAINMENTS=========================================================*/
			
			
			// Inserting entertainment for region 1 city 1

			Log.d("IEN1", "inserting entertainment region 1 ..."); 
			
			databaseHandler.addAttraction (new Attraction(1, 1, 1,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 1 R1 C1",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
			databaseHandler.addAttraction (new Attraction(1, 1, 1,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 2 R1 C1",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
					
			// Inserting Entertainment for region 1 city 2
			databaseHandler.addAttraction (new Attraction(1, 1, 2,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 3 R1 C2",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
			databaseHandler.addAttraction (new Attraction(1, 1, 2,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Place 4 R1 C2",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
													
			// Inserting Entertainment for region 1 city 3
			databaseHandler.addAttraction (new Attraction(1, 1, 3,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 5 R1 C3",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
					
			databaseHandler.addAttraction (new Attraction(1, 1, 3,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 6 R1 C3",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
					
			// Inserting places for region 2 city 4

			Log.d("IEN2", "inserting Entertainment region 2 ..."); 
					
			databaseHandler.addAttraction (new Attraction(1, 2, 4,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 1 R2 C4",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
			databaseHandler.addAttraction (new Attraction(1, 2, 4,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 2 R2 C4",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
							
			// Inserting Entertainment for region 2 city 5
			databaseHandler.addAttraction (new Attraction(1, 2, 5,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 3 R2 C5",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
					
			databaseHandler.addAttraction (new Attraction(1, 2, 5,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 4 R2 C5",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
			
															
			// Inserting Entertainment for region 2 city 6
			databaseHandler.addAttraction (new Attraction(1, 2, 6,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 5 R2 C6",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));
						
			databaseHandler.addAttraction (new Attraction(1, 2, 6,
					DataBaseHandler.ENTERTAINMENT_CODE,
					"Entertainment 6 R2 C6",
					"There are a lot of beaches to visit in the coast",
					"http://www.esl-languages.com/data/category/image2/518.jpg",
					"Description",
					"Monday to Friday  9:00 am - 16:00 pm",
					"556 24 de Mayo and Miraflores", 
					"MA444E",
					"www.attraction1.com",
					"+593 933444444"));							 
		
		
			// Inserting places for region 3 city 7

				Log.d("IEN3", "inserting Entertainment region 3 ..."); 
						
				databaseHandler.addAttraction (new Attraction(1, 3, 7,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 1 R3 C7",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
				
				databaseHandler.addAttraction (new Attraction(1, 3, 7,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 2 R3 C7",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
				
								
				// Inserting Entertainment for region 3 city 8
				databaseHandler.addAttraction (new Attraction(1, 3, 8,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 3 R3 C8",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
						
				databaseHandler.addAttraction (new Attraction(1, 3, 8,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 4 R3 C8",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
				
																
				// Inserting Entertainment for region 3 city 9
				databaseHandler.addAttraction (new Attraction(1, 3, 9,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 5 R3 C9",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
							
				databaseHandler.addAttraction (new Attraction(1, 3, 9,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 6 R3 C9",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));	



			Log.d("IEN4", "inserting places region 4 ..."); 
			
			// Inserting Entertainment for region 4 city 10
						
				databaseHandler.addAttraction (new Attraction(1, 4, 10,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 1 R4 C10",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
				
				databaseHandler.addAttraction (new Attraction(1, 4, 10,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 2 R4 C10",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
				
								
				// Inserting Entertainment for region 4 city 11
				databaseHandler.addAttraction (new Attraction(1, 4, 11,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 3 R4 C11",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
						
				databaseHandler.addAttraction (new Attraction(1, 4,11,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 4 R4 C11",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
				
																
				// Inserting Entertainment for region 4 city 12
				databaseHandler.addAttraction (new Attraction(1, 4, 12,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 5 R4 C12",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));
							
				databaseHandler.addAttraction (new Attraction(1, 4, 12,
						DataBaseHandler.ENTERTAINMENT_CODE,
						"Entertainment 6 R4 C12",
						"There are a lot of beaches to visit in the coast",
						"http://www.esl-languages.com/data/category/image2/518.jpg",
						"Description",
						"Monday to Friday  9:00 am - 16:00 pm",
						"556 24 de Mayo and Miraflores", 
						"MA444E",
						"www.attraction1.com",
						"+593 933444444"));	
			
			
		}
}
