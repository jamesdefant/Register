package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@Table(name="countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int countryId;

	private int age;

	private String countryName;

	//bi-directional many-to-one association to Provstate
	@OneToMany(mappedBy="country")
	private List<Provstate> provstates;

	public Country() {
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Provstate> getProvstates() {
		return this.provstates;
	}

	public void setProvstates(List<Provstate> provstates) {
		this.provstates = provstates;
	}

	public Provstate addProvstate(Provstate provstate) {
		getProvstates().add(provstate);
		provstate.setCountry(this);

		return provstate;
	}

	public Provstate removeProvstate(Provstate provstate) {
		getProvstates().remove(provstate);
		provstate.setCountry(null);

		return provstate;
	}

}