package com.organization.tourism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "Tourism")
@Table(name = "tourism")
public class Tourism {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Name cannot be null")
	private String name;
	@Column(name = "from_location")
	@NotEmpty(message = "From-Location cannot be null")
	private String fromLocation;
	@Column(name = "to_location")
	@NotEmpty(message = "To-Location cannot be null")
	private String toLocation;
	@Column(name = "no_of_days")
	@NotNull(message = "no:of days cannot be null")
	@Min(value = 1, message = "minimum 1 day must be specified")
	@Max(value = 10, message = "tour cannot span more than 10 days")
	private Integer noOfDays;
	@NotNull(message = "price cannot be null")
	@Min(value = 1000, message = "Must have a minimum value of 1000")
	private Double price;
	
	public Tourism() {
		// TODO Auto-generated constructor stub
	}

	public Tourism(String name, String fromLocation, String toLocation, Integer noOfDays, Double price) {
		this.name = name;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.noOfDays = noOfDays;
		this.price = price;
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

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tourism [id=" + id + ", name=" + name + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation
				+ ", noOfDays=" + noOfDays + ", price=" + price + "]";
	}
	
}
