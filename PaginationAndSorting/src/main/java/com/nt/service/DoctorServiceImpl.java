package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.Repository.IDoctorRepository;
import com.nt.model.Doctor;
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	IDoctorRepository doctorrepo;

	private Sort Sort ;

	 

	

	@Override
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String... props) { // here return type is doctor iterable
		// TODO Auto-generated method stub
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		
		Iterable<Doctor> it =doctorrepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props); // sorting on the given properties
		Pageable pageable = PageRequest.of(pageNo, pageSize,sort); // giving you records as per the page size and no.
		
		Page<Doctor> page = doctorrepo.findAll(pageable); // finding all from the db using repo and saving it into page
		return page;
	}

	@Override
	public void showcustomerPageByPage(int pageSize,boolean ascOrder, String props) {
		// TODO Auto-generated method stub
		long count = doctorrepo.count();  // repo will give count of objects saved
		long pageCount = count/pageSize;
		// will give us the total number of pages here
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		pageCount=(count%pageSize==0)?pageCount:++pageCount;  // this is because if total is 2.123 that means it is having 3 pages
		for(int i=0;i<pageCount;i++) {
			Pageable pageable = PageRequest.of(i, pageSize,sort); // i denotes here is which page number
			Page<Doctor> result= doctorrepo.findAll(pageable);
			result.forEach(System.out::println);
			System.out.println("-------"+((result.getNumber())+1)+ "/"+result.getTotalPages());
		}
		
		
	}

}
