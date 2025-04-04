package com.ehome.payload;

import java.util.List;

public class OrderDto {

    private String fullName;
    private String address;
    private String city;
    private Long postalCode;
    private String country;
    private List<Long> productIds; // Added to handle multiple product IDs
    private Integer userId;  // Add this field

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	// Getters and Setters
    public String getFullName() {
        return fullName;
    }

    @Override
	public String toString() {
		return "OrderDto [fullName=" + fullName + ", address=" + address + ", city=" + city + ", postalCode="
				+ postalCode + ", country=" + country + ", productIds=" + productIds + ", userId=" + userId + "]";
	}

	public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds2) {
        this.productIds = productIds2;
    }
}