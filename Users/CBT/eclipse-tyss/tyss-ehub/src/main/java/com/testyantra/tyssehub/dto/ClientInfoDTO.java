package com.testyantra.tyssehub.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "ClientInfo")
@Data
@Valid
public class ClientInfoDTO {

	@Id
	@Column
	@GeneratedValue
	private int clientId;

	@Column
	private String bd;

	@Column
	@CreationTimestamp
	private Date cdate;
	
	@Size(min = 15, max = 15, message = "Client name must be between 6 and 80 characters")
	@Column
	private String gstin;

	@Column
	@NotBlank
	@Size(min = 6, max = 80, message = "Client name must be between 6 and 80 characters")
	private String clientName;
	@Column
	@Size(min = 3, max = 6, message = "Client Short Name must be between 3 to 6 character")
	private String clientShortName;
	@Column
	@Size(min = 6, max = 30, message = "Department name must be between 8 to 30 characters")
	private String department;
	@Column
	@NotBlank
	@Email
	private String email;
	@Column
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;
	@Column
	private String companyWebsite;
	@Column
	@Size(min = 3, max = 50, message = "city name must be between 3 to 50 characters")
	private String city;
	@Column
	@Size(min = 10, max = 100, message = "street name must be between 10 to 100 characters")
	private String streetAddress;
	@Column
	@Size(min = 3, max = 30, message = "state name must be between 3 to 100 characters")
	private String state;
	@Column
	@Min(value = 560000, message = "zipcode must contain 6 digits")
	@Max(value = 599999, message = "zipcode must contain 6 digits")
	private int zipCode;
	@Column
	private String country;

}
