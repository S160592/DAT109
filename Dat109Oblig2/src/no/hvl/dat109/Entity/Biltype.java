package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the biltype database table.
 * 
 */
@Entity
@Table(name = "Biltype", schema = "borgar")
@NamedQuery(name="Biltype.findAll", query="SELECT b FROM Biltype b")
public class Biltype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String typeid;

	private Integer dagspris;

	private String description;

	//bi-directional many-to-one association to Bil
	@OneToMany(mappedBy="biltype")
	private List<BilDB> bils;

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

	public List<BilDB> getBils() {
		return this.bils;
	}

	public void setBils(List<BilDB> bils) {
		this.bils = bils;
	}

	public BilDB addBil(BilDB bil) {
		getBils().add(bil);
		bil.setBiltype(this);

		return bil;
	}

	public BilDB removeBil(BilDB bil) {
		getBils().remove(bil);
		bil.setBiltype(null);

		return bil;
	}

}