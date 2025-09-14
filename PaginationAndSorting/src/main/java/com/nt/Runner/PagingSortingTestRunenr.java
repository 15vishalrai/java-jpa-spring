package com.nt.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.model.Doctor;
import com.nt.service.DoctorServiceImpl;
@Component
public class PagingSortingTestRunenr implements CommandLineRunner {
	@Autowired
	DoctorServiceImpl service;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		service.showDoctorBySorting(true, "name").forEach(System.out::println);
//		System.out.println("--------------------------------------");
//		service.showDoctorBySorting(false,"income", "name").forEach(System.out::println);
		
		
//		System.out.println("FindAll(Pageable pageable");
//		
//		try {
//			Page<Doctor> page = service.showDoctorInfoByPageNo(0, 5, false, "income");
//			System.out.println("Page Number "+page.getNumber());
//			System.out.println("Page count "+page.getTotalPages());
//			System.out.println("is it the first page "+page.isFirst());
//			System.out.println("is it the last page "+page.isLast());
//			System.out.println("Page size "+page.getSize());
//			System.out.println("Page element count: "+page.getNumberOfElements());
//			
//			if(!page.isEmpty()) {
//				List<Doctor> list=page.getContent();  // here get content will give us list as return that's why took list
//				list.forEach(System.out::println);
//			}
//			else
//			{
//				System.out.println("No records are found");
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		service.showcustomerPageByPage(5,true,"income");
		
	
		

	}

}
