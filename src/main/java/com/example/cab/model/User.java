package com.example.cab.model;
import jakarta.persistence.*;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int id;
	String name;
	String email;
	String phno;
	String password;
	
	@Enumerated(EnumType.STRING)
	Role role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String phno, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
