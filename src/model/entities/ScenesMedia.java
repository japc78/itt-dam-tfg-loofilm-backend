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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp createDate;

	private String filename;

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

	public Scene getScene() {
		return this.scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}