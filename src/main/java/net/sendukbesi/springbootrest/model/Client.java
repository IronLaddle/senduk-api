package net.sendukbesi.springbootrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable  {

	private static final long serialVersionUID = 1285898048905337576L;
	
	private long id;
	private String name;
	private long phoneNumber;
	
	public Client() {
		 
	}

    public Client(String name,long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phoneNumber", nullable = false)
    public long getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
