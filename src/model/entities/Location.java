package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the locations database table.
 *
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "boolean default true")
	private boolean active;

	private Timestamp createDate;

	private String description;

	private String email;

	private String gps;

	private String name;

	private String phone;

	private String postalcode;

	private String street;

	private String web;

	//bi-directional many-to-one association to City
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="cityId")
	private City city;

	//bi-directional many-to-one association to LocationsMedia
	@OneToMany(mappedBy="location")
	private List<LocationsMedia> locationsMedias;

	//bi-directional many-to-one association to Scene
	@OneToMany(mappedBy="location")
	private List<Scene> scenes;

	//bi-directional many-to-one association to Visited
	@OneToMany(mappedBy="location")
	private List<Visited> visiteds;

	public Location() {
	}	

	public Location(String name, String description, String email, String gps,  String phone,
			String postalcode, String street, String web, City city) {
		super();
		this.active = true;
		this.description = description;
		this.email = email;
		this.gps = gps;
		this.name = name;
		this.phone = phone;
		this.postalcode = postalcode;
		this.street = street;
		this.web = web;
		this.city = city;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGps() {
		return this.gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<LocationsMedia> getLocationsMedias() {
		return this.locationsMedias;
	}

	public void setLocationsMedias(List<LocationsMedia> locationsMedias) {
		this.locationsMedias = locationsMedias;
	}

	public LocationsMedia addLocationsMedia(LocationsMedia locationsMedia) {
		getLocationsMedias().add(locationsMedia);
		locationsMedia.setLocation(this);

		return locationsMedia;
	}

	public LocationsMedia removeLocationsMedia(LocationsMedia locationsMedia) {
		getLocationsMedias().remove(locationsMedia);
		locationsMedia.setLocation(null);

		return locationsMedia;
	}

	public List<Scene> getScenes() {
		return this.scenes;
	}

	public void setScenes(List<Scene> scenes) {
		this.scenes = scenes;
	}

	public Scene addScene(Scene scene) {
		getScenes().add(scene);
		scene.setLocation(this);

		return scene;
	}

	public Scene removeScene(Scene scene) {
		getScenes().remove(scene);
		scene.setLocation(null);

		return scene;
	}

	public List<Visited> getVisiteds() {
		return this.visiteds;
	}

	public void setVisiteds(List<Visited> visiteds) {
		this.visiteds = visiteds;
	}

	public Visited addVisited(Visited visited) {
		getVisiteds().add(visited);
		visited.setLocation(this);

		return visited;
	}

	public Visited removeVisited(Visited visited) {
		getVisiteds().remove(visited);
		visited.setLocation(null);

		return visited;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Location [active=" + active + ", city=" + city + ", createDate=" + createDate + ", description="
				+ description + ", email=" + email + ", gps=" + gps + ", id=" + id + ", name=" + name + ", phone="
				+ phone + ", postalcode=" + postalcode + ", street=" + street + ", web=" + web + "]";
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
		result = prime * result + ((gps == null) ? 0 : gps.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postalcode == null) ? 0 : postalcode.hashCode());
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
		Location other = (Location) obj;
		if (gps == null) {
			if (other.gps != null)
				return false;
		} else if (!gps.equals(other.gps))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postalcode == null) {
			if (other.postalcode != null)
				return false;
		} else if (!postalcode.equals(other.postalcode))
			return false;
		return true;
	}
}