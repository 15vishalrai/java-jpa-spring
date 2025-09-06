package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

}
//custom repository IDoctorRepo extending CrudRepository with 12+ methods which dont need to 
// be implemented. spring data jpa will take care of its implementation by inmemory proxy class