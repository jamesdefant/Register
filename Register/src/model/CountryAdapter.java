package model;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class CountryAdapter extends TypeAdapter<Country> {

	@Override
	public Country read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		
		Country country = new Country();
		
		
		
		
		return country;
	}

	@Override
	public void write(JsonWriter out, Country country) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
