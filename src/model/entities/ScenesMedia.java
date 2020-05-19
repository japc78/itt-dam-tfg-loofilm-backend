package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the scenes_media database table.
 *
 */
@Entity
@Table(name="scenes_media")
@NamedQuery(name="ScenesMedia.findAll", query="SELECT s FROM ScenesMedia s")
public class ScenesMedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Object active;

	private Timestamp createDate;

	private String description;

	private Object type;

	//bi-directional many-to-one association to Scene
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="sceneId")
	private Scene scene;

	public ScenesMedia() {
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

	public Object getType() {
		return this.type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public Scene getScene() {
		return this.scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}