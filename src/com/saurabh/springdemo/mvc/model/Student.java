package com.saurabh.springdemo.mvc.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.saurabh.springdemo.mvc.validation.CourseCode;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "is Required")
	@Size(min = 1, message = "is Required")
	@Column(name = "first_name")
	private String firstName;
	@NotNull(message = "is Required")
	@Size(min = 1, message = "is Required")
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "country_name")
	private String countryName;
	@Column(name = "favorite_language")
	private String favoriteLanguage;
//	private String[] favoriteOperatingSystem;
	@NotNull(message = "is Required")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	@Column(name = "free_passes")
	private Integer freePasses;
	@Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "only 6 char/digit")
	@Column(name = "postal_code")
	private String postalCode;
	@CourseCode(value = "SAU", message = "should start with SAU")
	@Column(name = "course_code")
	private String courseCode;
	@Transient
	private LinkedHashMap<String, String> countryOptions;

	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("IND", "India");
		countryOptions.put("IR", "Ireland");
		countryOptions.put("GER", "Germany");
		countryOptions.put("RUS", "Russia");
		countryOptions.put("USA", "United States of America");
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

//	public String[] getFavoriteOperatingSystem() {
//		return favoriteOperatingSystem;
//	}
//
//	public void setFavoriteOperatingSystem(String[] favoriteOperatingSystem) {
//		this.favoriteOperatingSystem = favoriteOperatingSystem;
//	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
