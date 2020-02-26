package no.hvl.dat109.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import no.hvl.dat109.Interfaces.Biltype;
import no.hvl.dat109.Superclasses.BiltypeSuper;


/**
 * The persistent class for the biltype database table.
 * 
 */
@Entity(name = "Biltype")
@Table(name = "Biltype", schema = "borgar")
@NamedQuery(name="Biltype.findAll", query="SELECT b FROM Biltype b")
public class BiltypeDB extends BiltypeSuper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String typeid;

	private Integer dagspris;

	private String description;

	public BiltypeDB() {
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

	

}