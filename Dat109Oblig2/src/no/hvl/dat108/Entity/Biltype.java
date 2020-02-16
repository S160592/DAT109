package no.hvl.dat108.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String description;

	public Biltype() {
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}