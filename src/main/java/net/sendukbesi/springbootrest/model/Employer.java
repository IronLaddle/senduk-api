package net.sendukbesi.springbootrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employer")
public class Employer implements Serializable {
	
	private static final long serialVersionUID = -6014432210655470399L;
	
	private long id;
	private String name;
	private long salary;
	private long age;
	private String gender;
	private String department;
	
	 public Employer() {
		 
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
    
    @Column(name = "salary", nullable = false)
	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	@Column(name = "age", nullable = false)
	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}
	
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "department", nullable = false)
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
}
