package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.client.ClientApp;
import com.nt.model.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class SpringbootDataJpaFirstappApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringbootDataJpaFirstappApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(SpringbootDataJpaFirstappApplication.class, args);
		// get service class obj

		IDoctorService service = ctx.getBean("doctorservice", IDoctorService.class);

		try {
			Doctor doctor = new Doctor();
			doctor.setName("Vishal rai");
			doctor.setSpecilization("ortho");
			doctor.setIncome(200000);

			Doctor doctor1 = new Doctor();
			doctor1.setName("Shubham rai");
			doctor1.setSpecilization("neuro");
			doctor1.setIncome(5000000);
			// String result = service.registerDoctor(doctor);
			// System.out.println(result);

			String result = service.registerDoctor(List.of(doctor, doctor1));
			System.out.println(result);

		} catch (Exception e) {

			e.printStackTrace();

		}

		try { // handling the unchecked exception, otherwise program crashes |
				// unchecked exception are not catched by jvm and not force you to write try
				// catch or throws for this
				// but it is better to handle unchecked exceptions also
			boolean flag = service.isDoctorAvailable(1);
			if (flag) {
				System.out.println("Customer Available");
			} else {
				System.out.println("customer not available");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		long count = service.fetchDoctors();
		System.out.println("Total numbers of record are " + count);
		
		System.out.println("_______________________");
		
		Iterable<Doctor> result =service.findAllDoctors(); 
//		for(Doctor dr:result) {  // for-each loop or enhanced for loop
//			System.out.println(dr);  1st way to iterate over element in collectioin
//		}
		
		// result.forEach(doc->{System.out.println(doc);}); 
		//2nd way using foreach and lambda here consumer is the functional interface
		
		
		//result.forEach(doc->System.out.println(doc)); // more clean way of lamda foreach
		
		result.forEach(System.out::println); // static method reference for iteration (simplest)
		
		System.out.println("-----------");
		try {
			Doctor doctor=service.showDoctorById(20);
			System.out.println(doctor);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		try {
			String updatedDoctor =service.updateDoctorByIncome(2);
			System.out.println(updatedDoctor);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
		
		
		

		((ConfigurableApplicationContext) ctx).close();
	}

}
