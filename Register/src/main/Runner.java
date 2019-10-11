package main;

import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Country;



public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Runner");
		
		System.out.println("Country JSON: " + getCountry(2));
		
//		Gson gson = new Gson();
		
		
	}
	
	private static String getCountry(int countryId) {
		
	    EntityManager em =  Persistence.createEntityManagerFactory("Register").createEntityManager();  
	    //an alternative to using the query to getsingleResult we can just do a find
	    
	    Country country = em.find(Country.class, countryId);	
	    
	    Gson gson = new Gson();
	    Type type = new TypeToken<Country>() {}.getType();
	    
	    return gson.toJson(country, type);
	}

}
