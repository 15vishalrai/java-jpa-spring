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
	//@GeneratedValue(strategy=GenerationType.AUTO) //if we give id from our side and this generated value is enabled then 
	//optimistic locking failure exception
	private Integer id;
	
	@Column(name="doc_name")
	private String doctorName;
	
	
	private String specilization;
	
	
	private Integer income;

}
