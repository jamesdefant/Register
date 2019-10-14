package main;

import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Country;
import model.Provstate;



public class Runner {

	public static void main(String[] args) {


		System.out.println("Runner");
		

		System.out.println("Country JSON: " + getCountry(1));
		
		Gson gson = new Gson();
		Country country = gson.fromJson(getCountry(1), Country.class);		
		
		System.out.println("Country object: " + country);
		
		
		System.out.println("ProvState JSON: " + getProvstate("AK"));
		
		gson = new Gson();
		Provstate provstate = gson.fromJson(getProvstate("AK"), Provstate.class);
		
		System.out.println("ProvState object: " + provstate);
	}
	
	public static String getCountry(int countryId) {
		
	    EntityManager em =  Persistence.createEntityManagerFactory("Register").createEntityManager();  
	    
	    Country country = em.find(Country.class, countryId);	
	    
	    Gson gson = new Gson();
	    Type type = new TypeToken<Country>() {}.getType();
	    
	    return gson.toJson(country, type);
	}
	
	private static String getProvstate(String provStateCode) {
		
	    EntityManager em =  Persistence.createEntityManagerFactory("Register").createEntityManager();  
	    
	    Provstate provstate = em.find(Provstate.class, provStateCode);	
	    
	    Gson gson = new Gson();
	    Type type = new TypeToken<Provstate>() {}.getType();
	    
	    return gson.toJson(provstate, type);
		
	}

}
