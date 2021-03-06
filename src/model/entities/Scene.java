package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the scenes database table.
 *
 */
@Entity
@Table(name="scenes")
@NamedQuery(name="Scene.findAll", query="SELECT s FROM Scene s")
public class Scene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean active;

	private Timestamp createDate;

	private String name;

	private String description;

	private String video;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="locationId")
	private Location location;

	//bi-directional many-to-one association to Production
	@ManyToOne
	@JoinColumn(name="productionId")
	private Production production;

	//bi-directional many-to-one association to ScenesMedia
	@OneToMany(mappedBy="scene")
	private List<ScenesMedia> scenesMedias;

	// Contructores
	public Scene() {
	}

	/**
	 * @param location
	 * @param production
	 * @param name
	 * @param description
	 */
	public Scene(Location location, Production production, String name, String description, String video) {
		this.description = description;
		this.name = name;
		this.location = location;
		this.production = production;
		this.video = video;
		active = true;
	}

	/**
	 *
	 * @param id
	 * @param active
	 * @param location
	 * @param production
	 * @param name
	 * @param description
	 * @param video
	 */
	public Scene(int id, boolean active, Location location, Production production, String name, String description, String video) {
		this.id = id;
		this.active = active;
		this.description = description;
		this.name = name;
		this.location = location;
		this.production = production;
		this.video = video;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Production getProduction() {
		return this.production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public List<ScenesMedia> getScenesMedias() {
		return this.scenesMedias;
	}

	public void setScenesMedias(List<ScenesMedia> scenesMedias) {
		this.scenesMedias = scenesMedias;
	}

	public ScenesMedia addScenesMedia(ScenesMedia scenesMedia) {
		getScenesMedias().add(scenesMedia);
		scenesMedia.setScene(this);

		return scenesMedia;
	}

	public ScenesMedia removeScenesMedia(ScenesMedia scenesMedia) {
		getScenesMedias().remove(scenesMedia);
		scenesMedia.setScene(null);

		return scenesMedia;
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
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((production == null) ? 0 : production.hashCode());
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
		Scene other = (Scene) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (production == null) {
			if (other.production != null)
				return false;
		} else if (!production.equals(other.production))
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
		return "Scene [active=" + active + ", createDate=" + createDate + ", description=" + description + ", id=" + id
				+ ", location=" + location + ", name=" + name + ", production=" + production + ", scenesMedias="
				+ scenesMedias + "]";
	}
}