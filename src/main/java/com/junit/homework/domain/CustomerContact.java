package com.junit.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="customer_contact")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String deliveryAddressLine1;
	private String deliveryAddressLine2;
	private String deliveryAddressCity;
	private String deliveryAddressState;
	private String deliveryAddressLZipCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveryAddressLine1() {
		return deliveryAddressLine1;
	}

	public void setDeliveryAddressLine1(String deliveryAddressLine1) {
		this.deliveryAddressLine1 = deliveryAddressLine1;
	}

	public String getDeliveryAddressLine2() {
		return deliveryAddressLine2;
	}

	public void setDeliveryAddressLine2(String deliveryAddressLine2) {
		this.deliveryAddressLine2 = deliveryAddressLine2;
	}

	public String getDeliveryAddressCity() {
		return deliveryAddressCity;
	}

	public void setDeliveryAddressCity(String deliveryAddressCity) {
		this.deliveryAddressCity = deliveryAddressCity;
	}

	public String getDeliveryAddressState() {
		return deliveryAddressState;
	}

	public void setDeliveryAddressState(String deliveryAddressState) {
		this.deliveryAddressState = deliveryAddressState;
	}

	public String getDeliveryAddressLZipCode() {
		return deliveryAddressLZipCode;
	}

	public void setDeliveryAddressLZipCode(String deliveryAddressLZipCode) {
		this.deliveryAddressLZipCode = deliveryAddressLZipCode;
	}
	

}
