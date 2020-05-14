package model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the visited database table.
 * 
 */
@Embeddable
public class VisitedPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int userId;

	@Column(insertable=false, updatable=false)
	private int locationId;

	public VisitedPK() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLocationId() {
		return this.locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VisitedPK)) {
			return false;
		}
		VisitedPK castOther = (VisitedPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.locationId == castOther.locationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.locationId;
		
		return hash;
	}
}