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
	@ManyToOne
	@JoinColumn(name="locationId")
	private Location location;

	public LocationsMedia() {
	}

	/**
	 * @param filename
	*/
	public LocationsMedia(String filename, Location location) {
		this.location = location;
		this.filename = filename;
	}

	/**
	 * @param filename
	*/
	public LocationsMedia(String filename) {
		this.filename = filename;
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

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationsMedia other = (LocationsMedia) obj;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "LocationsMedia [createDate=" + createDate + ", filename=" + filename + ", id=" + id + ", location="
				+ location + "]";
	}
}