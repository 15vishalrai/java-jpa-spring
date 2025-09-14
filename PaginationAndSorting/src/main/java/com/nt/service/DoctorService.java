package com.nt.service;


import org.springframework.data.domain.Page;

import com.nt.model.Doctor;

public interface DoctorService {
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String...props);
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean ascOrder,String props);
	public void showcustomerPageByPage(int pageSize,boolean ascOrder, String props);
	

}
