package com.ba.boost.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "billing")

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private long oid;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "contact_id")
	private ContactInformation contact;

	@OneToMany(mappedBy = "accountHolder")
	private List<Billing> billing;
	
	@ManyToMany(mappedBy = "readers")
	private Set<Magazine> magazines;
	
	public void addMagazine(Magazine magazine) {
		if (this.magazines == null) {
			this.magazines = new HashSet<>();
		}
		this.magazines.add(magazine);
	}
	
	
	
}
