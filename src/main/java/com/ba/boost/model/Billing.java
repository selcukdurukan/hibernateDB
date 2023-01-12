package com.ba.boost.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name= "Billings")
public class Billing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private long oid;
	
	@Column(name = "account_no" , nullable = false, unique = true)
	private long accountNo;
	
	@Column(name = "account_type" , nullable = false)
	private String accountType;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User accountHolder;

	public Billing(long accountNo, String accountType, User accountHolder) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountHolder = accountHolder;
	}

  
	

}
