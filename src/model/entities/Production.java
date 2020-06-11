package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the productions database table.
 *
 */
@Entity
@Table(name="productions")
@NamedQuery(name="Production.findAll", query="SELECT p FROM Production p")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Timestamp createDate;
	private boolean active;
	private String name;
	private String description;
	private String cast;
	private int type;
	private int year;
	private String web;
	private String filename;

	//bi-directional many-to-one association to Scene
	@OneToMany(mappedBy="production", cascade={CascadeType.ALL})
	private List<Scene> scenes;

	// Constructores de la clase
	public Production() {
	}

	public Production(int id, boolean active, String name, int year, int type, String description, String cast, String web, String filename) {
		this.id = id;
		this.active = active;
		this.name = name;
		this.year = year;
		this.type = type;
		this.description = description;
		this.cast = cast;
		this.web = web;
		this.filename = filename;
	}

	public Production(String name, int year, int type, String description, String cast, String web, String filename) {
		this.name = name;
		this.year = year;
		this.type = type;
		this.description = description;
		this.cast = cast;
		this.web = web;
		this.filename = filename;
		active = true;
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

	public String getCast() {
		return this.cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
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

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<Scene> getScenes() {
		return this.scenes;
	}

	public void setScenes(List<Scene> scenes) {
		this.scenes = scenes;
	}

	public Scene addScene(Scene scene) {
		getScenes().add(scene);
		scene.setProduction(this);

		return scene;
	}

	public Scene removeScene(Scene scene) {
		getScenes().remove(scene);
		scene.setProduction(null);

		return scene;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + type;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Production other = (Production) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Production [active=" + active + ", cast=" + cast + ", createDate=" + createDate + ", description="
				+ description + ", id=" + id + ", name=" + name + ", productionsMedias=" + ", scenes=" + scenes + ", type=" + type + ", web=" + web + ", year=" + year + "]";
	}
}