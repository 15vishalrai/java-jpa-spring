package com.nt.service;

import com.nt.model.Doctor;

public interface IDoctorService {
	//public String registerDoctor(Doctor doctor);

	String registerDoctor(Iterable<Doctor> doctor);
	
	public boolean isDoctorAvailable(Integer id);
	
	public long fetchDoctors();
	public Iterable<Doctor> findAllDoctors();
	public Doctor showDoctorById(int id);
	public String updateDoctorByIncome(int id);
	

	}
