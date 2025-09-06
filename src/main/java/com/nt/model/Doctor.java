package com.nt.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="Doctors_info")
@Data
public class Doctor {
	@Column(name="Doc_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Doc_Name")
	private String name;
	
	@Column(name="specilization")
	private String specilization;
	
	@Column(name="income")
	private Integer income;

}
