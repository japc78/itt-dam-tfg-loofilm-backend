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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean active;

	private Timestamp createDate;

	private boolean type;

	private String url;

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

	public boolean getType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}