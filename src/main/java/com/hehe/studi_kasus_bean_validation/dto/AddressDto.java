package com.hehe.studi_kasus_bean_validation.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AddressDto {

	@NotBlank(message = "{address.street.notblank}")
	private String street;

	@NotBlank(message = "{address.city.notblank}")
	private String city;

	@NotBlank(message = "{address.country.notblank}")
	private String country;

	@Pattern(regexp = "\\d{5}", message = "{address.postalcode.invalid}")
	private String postalCode;

	public AddressDto() {
	}

	public AddressDto(String street, String city, String country, String postalCode) {
		this.street = street;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "AddressDto{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", postalCode='" + postalCode + '\'' +
				'}';
	}
}
