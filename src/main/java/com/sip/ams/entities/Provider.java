package com.sip.ams.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Provider {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String address;

	@Override
	public String toString() {
		return "Provider [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

	
	public Provider(String name, String email, String address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}
}
