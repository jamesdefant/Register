package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the provstates database table.
 * 
 */
@Entity
@Table(name="provstates")
@NamedQuery(name="Provstate.findAll", query="SELECT p FROM Provstate p")
public class Provstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String provStateCode;

	private String provStateName;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="CountryId")
	private Country country;

	public Provstate() {
	}

	public String getProvStateCode() {
		return this.provStateCode;
	}

	public void setProvStateCode(String provStateCode) {
		this.provStateCode = provStateCode;
	}

	public String getProvStateName() {
		return this.provStateName;
	}

	public void setProvStateName(String provStateName) {
		this.provStateName = provStateName;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}