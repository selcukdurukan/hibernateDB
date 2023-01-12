package com.ba.boost.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "user")
@NoArgsConstructor

@Entity
@Table(name = "contacts")
public class ContactInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private long oid;

	@Column(name = "email", length = 100, nullable = false)
	private String email;
	@Column(name = "phone_number", length = 100, nullable = true)
	private String phoneNumber;
	@Column(name = "address", length = 100, nullable = false)
	private String Address;

	@OneToMany(mappedBy = "contact")
	private List<User> user;

}
