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
	
	private Iterable<Doctor>doctor;

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

	@Override
	public String updateorRegisterDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		Optional<Doctor> opt=doctorrepo.findById(doctor.getId());
		if(opt.isPresent()) {
			doctorrepo.save(doctor);
			return doctor.getId()+"doctor details are found and updated";
		}
		return "Doctor is saved with the id value "+doctorrepo.save(doctor).getId();
				}

	@Override
	public String deleteDoctorById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Doctor>opt=doctorrepo.findById(id);
		if(opt.isPresent()) {
			doctorrepo.deleteById(id);
			return id+" Doctor is deleted";
		}
		return id+"doctor is not found for this id";
	}

	@Override
	public String deleteDoctorEntity(Doctor doctor) {
		// TODO Auto-generated method stub
		Optional<Doctor> id= doctorrepo.findById(doctor.getId());
		if(id.isPresent()) {
			doctorrepo.delete(doctor);
			return "The Doctor with id"+doctor.getId()+" is deleted ";
		}
		return "There is no such record with the id"+doctor.getId();
	}

	@Override
	public String PartialUpdate(Doctor doctor) {
		// TODO Auto-generated method stub
		Optional<Doctor>opt=doctorrepo.findById(doctor.getId());
		if(opt.isPresent()) {
			doctor.setSpecilization("BHMS");
			Integer income = doctor.getIncome();
			doctor.setIncome(income);
			doctorrepo.save(doctor);
			return"The doctor with id"+doctor.getId()+" is updated and saved ";
		}
		return "No such doctor is found with the id"+doctor.getId();
	}

	@Override
	public String removeDoctorByids(List<Integer> ids) {
		// TODO Auto-generated method stub
		List<Doctor> doclist=(List<Doctor>) doctorrepo.findAllById(ids);
		if(doclist.size()>=1) {
			 doctorrepo.deleteAllById(ids);
			 return doclist.size()+"no of records deleted";
		}
		else
			return"Given ids are not found";
		
	}

	@Override
	public String deleteentity(List<Doctor> doctor) {
		
		List<Integer> ids = doctor.stream()
                .map(Doctor::getId)
                .toList();
		
		 List<Doctor> doclist= (List<Doctor>) doctorrepo.findAllById(ids);
		 if(doclist.size()>0) {
			 doctorrepo.deleteAll(doctor);
				return "all records are deleted";
		 }
		 else
			 return"No record found for deletion";
		
	}

//	@Override
//	public String updateorRegisterDoctor(Doctor doctor) {
//	    if (doctor.getId() != null && doctorrepo.existsById(doctor.getId())) {
//	        Doctor updated = doctorrepo.save(doctor);
//	        return "Doctor updated with id: " + updated.getId();
//	    } else {
//	        // id is null or does not exist → let JPA generate new one
//	        doctor.setId(null); 
//	        Doctor saved = doctorrepo.save(doctor);
//	        return "New Doctor registered with id: " + saved.getId();
//	    }
//	}
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
