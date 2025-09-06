package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Doctor;
import com.nt.repository.IDoctorRepo;
@Service("doctorservice")

public class DoctorserviceMgmtImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepo doctorrepo;
	//here doctorrepo holds the object of proxyclass when implementation happened actually.
	private Optional<Doctor> byId;
	private Doctor dr;

	@Override
	public String registerDoctor(Iterable<Doctor> doctor) {
			//System.out.println("Doctor id before saving was "+doctor.getId());
		
			if(doctor !=null) {
				Iterable<Doctor> saveddr = doctorrepo.saveAll(doctor);
				int size = ((Collection) saveddr).size();
				List<Integer> id = (List<Integer>) ((Collection) saveddr).stream().map(d -> ((Doctor) d).getId()).collect(Collectors.toList());
				
				
				return size+" no of dr saved with the id values are"+id.toString();
				
				
			}
			else {
				throw new IllegalArgumentException("Invalid Doctor info");
			}
			
	}

	@Override
	public boolean isDoctorAvailable(Integer id) {
		// TODO Auto-generated method stub
		boolean flag = doctorrepo.existsById(id);
		return flag;
	}

	@Override
	public long fetchDoctors() {
		// TODO Auto-generated method stub
		long count= doctorrepo.count();
		return count;
	}

	@Override
	public Iterable<Doctor> findAllDoctors() {
		// TODO Auto-generated method stub
		Iterable<Doctor> doctors= doctorrepo.findAll();
		return doctors;
	}

	@Override
	public Doctor showDoctorById(int id) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor= doctorrepo.findById(id);
		if(doctor.isPresent()) {
			return doctor.get();
		}
		else {
			throw new IllegalArgumentException("Invalid doctor id");
		}
		
	}

	@Override
	public String updateDoctorByIncome(int id) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor =doctorrepo.findById(id);
		if(doctor.isPresent()) {
			dr = doctor.get(); // return with object with matching id
			int newIncome = dr.getIncome()+10000;
			dr.setIncome(newIncome);
			return doctorrepo.save(dr)+" is updated with new income "+newIncome;
			
		}
		else {
			return id+"doctor not found";
		}
	
		}

//	@Override
//	public Doctor showDoctorById(int id) {
//		// TODO Auto-generated method stub
//		
//		Doctor doctor= doctorrepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid doctor id"));		
//		return doctor;
//	}

//	@Override
//	public Doctor showDoctorById(int id) {
//		Doctor dutydoctor = new Doctor();
//		dutydoctor.setSpecilization("duty doctor"); // if nothing there return default one
//		// TODO Auto-generated method stub
//		Doctor doctor = doctorrepo.findById(id).orElse(dutydoctor);
//		return doctor;
//	}
	
	
	
	
	

}
