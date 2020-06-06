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

	private Timestamp createDate;

	private String filename;

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

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getUrl() {
		return this.filename;
	}

	public void setUrl(String url) {
		this.filename = url;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}