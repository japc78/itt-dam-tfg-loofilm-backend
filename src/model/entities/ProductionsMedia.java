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

	private byte active;

	private Timestamp dateAdd;

	private String description;

	private int productionId;

	private byte type;

	public ProductionsMedia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Timestamp getDateAdd() {
		return this.dateAdd;
	}

	public void setDateAdd(Timestamp dateAdd) {
		this.dateAdd = dateAdd;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductionId() {
		return this.productionId;
	}

	public void setProductionId(int productionId) {
		this.productionId = productionId;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

}