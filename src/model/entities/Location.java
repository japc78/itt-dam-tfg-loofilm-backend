package model.entities;

import java.awt.Point;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Object active;

	private Timestamp createDate;

	private String description;

	private String email;

	private Point gps;

	private String name;

	private String phone;

	private String postalcode;

	private String street;

	private String web;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;

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

	public Point getGps() {
		return this.gps;
	}

	public void setGps(Point gps) {
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

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

}