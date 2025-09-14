package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.model.Doctor;

public interface IDoctorService {
	//public String registerDoctor(Doctor doctor);

	String registerDoctor(Iterable<Doctor> doctor);
	
	public boolean isDoctorAvailable(Integer id);
	
	public long fetchDoctors();
	public Iterable<Doctor> findAllDoctors();
	public Doctor showDoctorById(int id);
	public String updateDoctorByIncome(int id);
	public String updateorRegisterDoctor(Doctor doctor);
	public String deleteDoctorById(Integer id);
	public String deleteDoctorEntity(Doctor doctor);
	public String PartialUpdate(Doctor doctor);
	public String removeDoctorByids(List<Integer>ids);
	public String deleteentity(List<Doctor> doctor);



	}
