package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the productions_media database table.
 *
 */
@Entity
@Table(name="productions_media")
@NamedQuery(name="ProductionsMedia.findAll", query="SELECT p FROM ProductionsMedia p")
public class ProductionsMedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean active;

	private Timestamp createDate;

	private String description;

	private boolean isFilm;

	//bi-directional many-to-one association to Production
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="productionId")
	private Production production;

	public ProductionsMedia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsFilm() {
		return this.isFilm;
	}

	public void setIsFilm(boolean isFilm) {
		this.isFilm = isFilm;
	}

	public Production getProduction() {
		return this.production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

}