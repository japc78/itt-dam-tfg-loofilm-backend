package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean active;

	private String cast;

	private Timestamp createDate;

	private String description;

	private String name;

	private boolean type;

	private String web;

	@Temporal(TemporalType.DATE)
	private Date year;

	//bi-directional many-to-one association to ProductionsMedia
	@OneToMany(mappedBy="production")
	private List<ProductionsMedia> productionsMedias;

	//bi-directional many-to-one association to Scene
	@OneToMany(mappedBy="production")
	private List<Scene> scenes;

	public Production() {
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

	public boolean getType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Date getYear() {
		return this.year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public List<ProductionsMedia> getProductionsMedias() {
		return this.productionsMedias;
	}

	public void setProductionsMedias(List<ProductionsMedia> productionsMedias) {
		this.productionsMedias = productionsMedias;
	}

	public ProductionsMedia addProductionsMedia(ProductionsMedia productionsMedia) {
		getProductionsMedias().add(productionsMedia);
		productionsMedia.setProduction(this);

		return productionsMedia;
	}

	public ProductionsMedia removeProductionsMedia(ProductionsMedia productionsMedia) {
		getProductionsMedias().remove(productionsMedia);
		productionsMedia.setProduction(null);

		return productionsMedia;
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

}