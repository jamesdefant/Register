package model;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class CountryAdapter extends TypeAdapter<Country> {

	@Override
	public Country read(JsonReader in) throws IOException {
		
		// Create a new object
		Country country = new Country();
		
		// Read the opening curly-brace
		in.beginObject();
		
		// Loop through the tokens
		while(in.hasNext()) {
			
			switch(in.nextName()) {
			
			case "countryId":
				country.setCountryId(in.nextInt());
				break;
				
			case "countryName":
				country.setCountryName(in.nextString());
				break;
				
			case "age":
				country.setAge(in.nextInt());
				break;
			}
		}
		
		// Read the closing curly-brace
		in.endObject();
		
		// Return the object
		return country;
	}

	@Override
	public void write(JsonWriter out, Country country) throws IOException {
		
		// Write an open curly-brace to the JSON
		out.beginObject();
				
		// Write the object to JSON in name:value pairs 
		out.name("countryId").value(country.getCountryId());
		out.name("countryName").value(country.getCountryName());
		
		// Check if age is null
		if(country.getAge() != null) {
			out.name("age").value(country.getAge());
		}
		
		// Write a closed curly-brace to the JSON
		out.endObject();
		out.close();		
	}

}
