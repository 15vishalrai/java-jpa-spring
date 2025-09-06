package com.nt.client;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class ClientApp {
	public static void main(String[] args) {
		
		//ioc container
		ApplicationContext ctx = SpringApplication.run(ClientApp.class, args);
		//get service class obj
		
		 IDoctorService service = ctx.getBean("doctorservice",IDoctorService.class);
		 
		try {
			Doctor doctor = new Doctor();
			doctor.setName("Vishal rai"); doctor.setSpecilization("ortho"); doctor.setIncome(200000);
			
			Doctor doctor1 = new Doctor();
			doctor1.setName("Shubham rai"); doctor1.setSpecilization("neuro"); doctor1.setIncome(5000000);
			//String result = service.registerDoctor(doctor);
			//System.out.println(result);
			
			service.registerDoctor(List.of(doctor,doctor1));
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();
		 
	}

}
