package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the biltype database table.
 * 
 */
@Entity
@NamedQuery(name="Biltype.findAll", query="SELECT b FROM Biltype b")
public class Biltype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String typeid;

	private Integer dagspris;

	private String description;

	//bi-directional many-to-one association to Bil
	@OneToMany(mappedBy="biltype")
	private List<Bil> bils;

	public Biltype() {
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public Integer getDagspris() {
		return this.dagspris;
	}

	public void setDagspris(Integer dagspris) {
		this.dagspris = dagspris;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Bil> getBils() {
		return this.bils;
	}

	public void setBils(List<Bil> bils) {
		this.bils = bils;
	}

	

}