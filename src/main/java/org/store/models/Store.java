package org.store.models;

public class Store {
	private Long id = null;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}	
}