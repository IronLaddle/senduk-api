package net.sendukbesi.springbootrest.toilet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toiletuser")
public class ModelToiletUser implements Serializable {

	private static final long serialVersionUID = 1820446284939458910L;
	
	
	@Id
	@Column(name="TOILET_USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "TOILET_USER_NAME", nullable = false)
	private String name;
	
	@Column(name = "TOILET_USER_EMAIL", nullable = false)
	private String email;
	
	@Column(name = "TOILET_USER_PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "TOILET_USER_PHONE", nullable = false)
	private long phoneNumber;
	
	@Column(name = "TOILET_USER_WALLET", nullable = false)
	private long wallet;
	
	@Column(name = "TOILET_USER_IMAGE")
	private String image;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "toiletUser")
//	private List<ModelToilet> modelToilet;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getWallet() {
		return wallet;
	}

	public void setWallet(long wallet) {
		this.wallet = wallet;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


//	public List<ModelToilet> getModelToilet() {
//		return modelToilet;
//	}
//
//	public void setModelToilet(List<ModelToilet> modelToilet) {
//		this.modelToilet = modelToilet;
//	}
//	

}
