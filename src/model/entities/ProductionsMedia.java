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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Boolean active;

	private Timestamp createDate;

	private String description;

	private Boolean isFilm;

	private int productionId;

	public ProductionsMedia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
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

	public Boolean getIsFilm() {
		return this.isFilm;
	}

	public void setIsFilm(Boolean isFilm) {
		this.isFilm = isFilm;
	}

	public int getProductionId() {
		return this.productionId;
	}

	public void setProductionId(int productionId) {
		this.productionId = productionId;
	}

}