package model;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import main.Runner;

public class ProvstateAdapter extends TypeAdapter<Provstate> {

	@Override
	public Provstate read(JsonReader in) throws IOException {

		// Create a new object
		Provstate provstate = new Provstate();
		
		// Read the opening curly-brace
		in.beginObject();
		
		// Loop through the tokens
		while(in.hasNext()) {
			
			switch(in.nextName()) {
			
			case "provStateCode":
				provstate.setProvStateCode(in.nextString());
				break;
				
			case "provStateName":
				provstate.setProvStateName(in.nextString());
				break;
				
			case "countryId":
				Country country = getCountry(in.nextInt());
				provstate.setCountry(country);
				break;
			}
			
		}
		
		// Read the closing curly-brace
		in.endObject();
		
		// Return the object
		return provstate;
	}
	
	// Retrieve a Country object from the database
	private Country getCountry(int countryId) {
		
		String jsonString = Runner.getCountry(countryId);
		
		if(jsonString != null) {
			Gson gson = new Gson();
			return gson.fromJson(jsonString, Country.class);
		}
		
		return null;
	}

	@Override
	public void write(JsonWriter out, Provstate provstate) throws IOException {

		// Write an open curly-brace to the JSON
		out.beginObject();
				
		// Write the object to JSON in name:value pairs 
		out.name("provStateCode").value(provstate.getProvStateCode());
		out.name("provStateName").value(provstate.getProvStateName());
		
		// Check if country is null
		if(provstate.getCountry() != null) {
			
			// Set the JSON value to the nested Country's ID
			out.name("countryId").value(provstate.getCountry().getCountryId());
		}
		
		// Write a closed curly-brace to the JSON
		out.endObject();
		out.close();		
	}
}
