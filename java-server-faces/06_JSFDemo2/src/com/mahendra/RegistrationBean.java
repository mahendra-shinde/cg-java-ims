package com.mahendra;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class RegistrationBean {
	private Map<String,String> genderOptions = null;
	private Map<String,String> favPlanetOptions = null;
	
	@PostConstruct
	public void init() {
		favPlanetOptions = new HashMap<>();
		favPlanetOptions.put("Earth", "E");
		favPlanetOptions.put("Mars","M");
		favPlanetOptions.put("Venus","V");
		
		genderOptions = new HashMap<>();
		genderOptions.put("Male", "M");
		genderOptions.put("Female","F");
	}
	
	private String firstName, lastName;
	private String gender;
	private String favPlanet;


	
	public Map<String, String> getGenderOptions() {
		return genderOptions;
	}
	public void setGenderOptions(Map<String, String> genderOptions) {
		this.genderOptions = genderOptions;
	}
	public Map<String, String> getFavPlanetOptions() {
		return favPlanetOptions;
	}
	public void setFavPlanetOptions(Map<String, String> favPlanetOptions) {
		this.favPlanetOptions = favPlanetOptions;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFavPlanet() {
		return favPlanet;
	}
	public void setFavPlanet(String favPlanet) {
		this.favPlanet = favPlanet;
	}
	
	
	
	
}
