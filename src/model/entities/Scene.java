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

	private String description;

	private String name;

	//bi-directional many-to-one association to Location
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="locationId")
	private Location location;

	//bi-directional many-to-one association to Production
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="productionId")
	private Production production;

	//bi-directional many-to-one association to ScenesMedia
	@OneToMany(mappedBy="scene")
	private List<ScenesMedia> scenesMedias;

	public Scene() {
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

}