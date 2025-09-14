package com.nt.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Doctor;

public interface IDoctorRepository extends PagingAndSortingRepository<Doctor, Integer>,CrudRepository<Doctor, Integer> {
	

}
