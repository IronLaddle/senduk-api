package net.sendukbesi.springbootrest.toilet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toilet")
public class ModelToilet implements Serializable {

	private static final long serialVersionUID = -4670311051532163468L;
	
	@Id
	@Column(name="TOILET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "TOILET_NAME", nullable = false)
	private String name;
	
	@Column(name = "TOILET_IMAGE")
	private String image;
	
	@Column(name = "TOILET_LOCATION", nullable = false)
	private String location;
	
	@Column(name = "TOILET_PRICE", nullable = false)
	private long price;
	
	@Column(name = "TOILET_USED")
	private long used;
	
	@Column(name = "TOILET_RATING")
	private long rating;
	
	@Column(name = "TOILET_DURATION", nullable = false)
	private long duration;
	
	@Column(name = "TOILET_DESCRIPTION", nullable = false)
	private String description;
	
//	@ManyToOne
//	@JoinColumn(name="TOILET_USER_ID")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private ModelToiletUser toiletUser;
	
	@Column(name = "TOILET_OWNER_ID", nullable = false)
	private long toiletOwnerID;
	
	
//	public ModelToilet(){}
//	
//	public ModelToilet(String name) {
//        this.name = name;
//    }
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getUsed() {
		return used;
	}

	public void setUsed(long used) {
		this.used = used;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getToiletOwnerID() {
		return toiletOwnerID;
	}

	public void setToiletOwnerID(long toiletOwnerID) {
		this.toiletOwnerID = toiletOwnerID;
	}

}
