package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the locations_media database table.
 * 
 */
@Entity
@Table(name="locations_media")
@NamedQuery(name="LocationsMedia.findAll", query="SELECT l FROM LocationsMedia l")
public class LocationsMedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Object active;

	private Timestamp dateAdd;

	private String description;

	private Object type;

	//bi-directional many-to-one association to Location
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="locationId")
	private Location location;

	public LocationsMedia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getActive() {
		return this.active;
	}

	public void setActive(Object active) {
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

	public Object getType() {
		return this.type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}